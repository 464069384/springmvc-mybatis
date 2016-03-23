package com.web.convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public class StringConvertDate implements Converter<String, Date> {

	private SimpleDateFormat sdf= new SimpleDateFormat("YYYY-MM-dd");
	
	private Logger logger = LoggerFactory.getLogger(StringConvertDate.class);
	
	@Override
	public Date convert(String source) {
		Date date = null;
		try {
			sdf.parse(source);
		} catch (ParseException e) {
			logger.error("转换类型出错:{}",e.getMessage());
		}
		
		return date;
	}

}
