package com.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	private Logger logger = LoggerFactory.getLogger(TestController.class);
	
	
	//注册转换器 请求时 会在处理请求方法前调用此方法
//	@InitBinder  
//    protected void initBinder(HttpServletRequest request,  
//        ServletRequestDataBinder binder) throws Exception {  
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
//        CustomDateEditor editor = new CustomDateEditor(df, false);  
//        binder.registerCustomEditor(Date.class, editor);  
//    }  
	
	@RequestMapping(value = "/testDateTimeFormat/{date}", method = RequestMethod.GET)
	@ResponseBody
	public Date testDateTimeFormat(@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
		logger.info("date:{}",date);
		return date;
	}
	
	
	/*使用@MatrixVariable  需开启 <mvc:annotation-driven enable-matrix-variables="true">需spring 版本3.2.5以上*/
	//  url:  GET /testMatriVariable/42;param=11;r=22-------->id == 42   param == 11
	@RequestMapping(value = "/testMatriVariable/id", method = RequestMethod.GET)
	public String testMatriVariable(@PathVariable String id, @MatrixVariable int param) {
		logger.info("id:{}",id);//
		logger.info("param:{}",param);
		return id + param;
	}	
	
	//params  必须是method
	//  url:  GET /testParams/42?method=add   -------->id == 42  
	@RequestMapping(value = "/testParams/{id}", method = RequestMethod.GET, params="method=add")
	@ResponseBody
	public String testParams(@PathVariable String id) {
		logger.info("id:{}",id);
		return id;
	}
	
/*	Host: localhost:8080
	User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64; rv:40.0) Gecko/20100101 Firefox/40.0
	Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*;q=0.8
	Accept-Language: zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3
	Accept-Encoding: gzip, deflate
	myHeader: myValue
	Referer: http://localhost:8080/springmvc-myatis/testHeaders/aaa
	Connection: keep-alive
*/
	@RequestMapping(value = "/testHeaders/{id}", method = RequestMethod.GET, headers="myHeader=myValue")
	@ResponseBody
	public String testHeaders(@PathVariable String id) {
		logger.info("id:{}",id);
		return id;
	}
	
	@RequestMapping("/something")
	public ResponseEntity<String> handle(HttpEntity<byte[]> requestEntity) throws
	UnsupportedEncodingException {
		
		String requestHeader = requestEntity.getHeaders().getFirst("MyRequestHeader");
		//可获得请求体
		byte[] requestBody = requestEntity.getBody();
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		//创建响应头  							响应体		,响应头			,状态码
		return new ResponseEntity<String>("Hello World", responseHeaders, HttpStatus.OK);
	}
	
	@RequestMapping("/testCookieValue")
	@ResponseBody
	public String displayHeaderInfo(@CookieValue("JSESSIONID") String cookie) {
		
		logger.info("JSESSIONID:{}",cookie);
		return cookie;
	}

/*	Host localhost:8080
	Accept text/html,application/xhtml+xml,application/xml;q=0.9
	Accept-Language fr,en-gb;q=0.7,en;q=0.3
	Accept-Encoding gzip,deflate
	Accept-Charset ISO-8859-1,utf-8;q=0.7,*;q=0.7
	Keep-Alive 300
*/	
	@RequestMapping("/testRequestHeader")
	public void testRequestHeader(@RequestHeader("Accept-Encoding") String encoding,
	@RequestHeader("Keep-Alive") long keepAlive) {
		logger.info("encoding:{}",encoding);
		logger.info("keepAlive:{}",keepAlive);
	}
	
	
//	public static void main(String[] args) throws ParseException {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		//严格限制
//		dateFormat.setLenient(false); 
//		Date date = dateFormat.parse("2015-10-500");
//		System.out.println(date.toLocaleString());
//	}
}
