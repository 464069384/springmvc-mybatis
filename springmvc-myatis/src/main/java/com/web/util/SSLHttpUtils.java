package com.web.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description HTTPS工具
 * @author H.CAAHN
 */
public class SSLHttpUtils {
    private static final Logger logger           = LoggerFactory.getLogger(SSLHttpUtils.class);
    
    /** 最大重发次数 */
    private int                 maxCount         = 2;
    
    /** 重发间隔：毫秒 */
    private long                interval         = 500;
    
    private CloseableHttpClient httpclient;
    
    private static SSLHttpUtils instance         = new SSLHttpUtils();
    
    private SSLHttpUtils() {
        SSLContext sslcontext;
        try {
            sslcontext = SSLContext.getInstance("TLS");
            
            X509TrustManager tm = new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
                
                public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                }
                
                public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                }
            };
            sslcontext.init(null, new TrustManager[] {tm}, null); // SSL协议
            
            // Allow TLSv1 protocol only
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] {"TLSv1"}, null,
                    SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            // build httpclient
            logger.info("create httpclient ...");
            httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
            
        }
        catch (NoSuchAlgorithmException e) {
            logger.error("", e);
        }
        catch (KeyManagementException e) {
            logger.error("", e);
        }
    }
    
    public static SSLHttpUtils getInstance() {
        return instance;
    }
    
    public String httpsPostJson(String uri, Map<String, String> hm_header, String json) {
        if ("".equals(uri) || uri == null) {
            logger.error("https post url is null");
            return "";
        }
        
        logger.debug("url is " + uri);
        HttpPost httpPost = new HttpPost(uri); // 请求地址
        
        // http head
        if (hm_header != null) {
            Iterator<Entry<String, String>> its = hm_header.entrySet().iterator();
            while (its.hasNext()) {
                Entry<String, String> entry = (Entry<String, String>) its.next();
                logger.debug("header key " + entry.getKey().toString() + " value "
                        + hm_header.get(entry.getKey()).toString());
                httpPost.addHeader(entry.getKey().toString(), hm_header.get(entry.getKey()).toString());
            }
        }
        
        CloseableHttpResponse response = null;
        try {
            if (StringUtils.isNotBlank(json)) {
                StringEntity se = new StringEntity(json, ContentType.create("text/html", "UTF-8"));
                httpPost.setEntity(se);
            }
            
            logger.info("HttpResponse is opening ... ");
            int count = 1;// 第一次发送
            response = doExcute(httpPost, count);
            
            if (response != null) {
                HttpEntity entity = response.getEntity();
                String jsonStr = "";
                if (entity != null) {
                    jsonStr = EntityUtils.toString(entity);
                }
                EntityUtils.consume(entity); // 关闭entity
                return jsonStr;
            }
        }
        catch (UnsupportedEncodingException e) {
            logger.error("", e);
        }
        catch (ClientProtocolException e) {
            logger.error("", e);
        }
        catch (IOException e) {
            logger.error("", e);
        }
        finally {
            if (response != null) {
                // 关闭CloseableHttpResponse
                try {
                    response.close();
                    logger.info("HttpResponse closed ");
                }
                catch (IOException e) {
                    logger.error("", e);
                }
            }
        }
        return "";
    }
    
    private CloseableHttpResponse doExcute(HttpPost httpPost, int count) {
        if (count > maxCount) {
            return null;
        }
        try {
            return httpclient.execute(httpPost);
        }
        catch (Exception e) {
            logger.warn("httpClient exception happened. Count:" + count + " interval:" + interval + " ms. httpPost:"
                    + httpPost.toString(), e);
            try {
                Thread.sleep(interval);
            }
            catch (InterruptedException e1) {
            }
            return doExcute(httpPost, ++count);
        }
    }
}
