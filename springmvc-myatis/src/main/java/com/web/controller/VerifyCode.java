package com.web.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VerifyCode {

	private Logger logger = LoggerFactory.getLogger(VerifyCode.class);
	
	@RequestMapping(value = "/verifyCode")
	public ModelAndView handleVerifyCode(HttpServletRequest request,
			HttpServletResponse response) {
		BufferedImage img = new BufferedImage(68, 22,
				BufferedImage.TYPE_INT_RGB);

		// 得到该图片的绘图对象
		Graphics g = img.getGraphics();
		Random r = new Random();
		Color c = new Color(200, 150, 255);
		g.setColor(c);

		// 填充整个图片的颜色
		g.fillRect(0, 0, 68, 22);

		// 向图片中输出数字和字母
		StringBuffer sb = new StringBuffer();
		char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		int index, len = ch.length;
		for (int i = 0; i < 4; i++) {
			index = r.nextInt(len);
			g.setColor(new Color(r.nextInt(88), r.nextInt(188), r.nextInt(255)));
			g.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 22));// 输出的字体和大小
			g.drawString("" + ch[index], (i * 15) + 3, 18);// 写什么数字，在图片的什么位置画
			sb.append(ch[index]);
		}

//		request.getSession().setAttribute(BlogConstants.SESSION_ATTR_VERIFY_PIC,
//				sb.toString());
		try {
			ImageIO.write(img, "JPG", response.getOutputStream());
		} catch (IOException e) {
			logger.error("error occured:{}", e.getMessage(), e);
			new IllegalArgumentException("验证码参数错误!");
		}

		return null;
	}
}
