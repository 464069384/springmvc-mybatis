package cn.zcy.base.dao.annotation;


import org.apache.ibatis.type.JdbcType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Id {
	
	public String value() default "";
	
	public JdbcType jdbcType() default JdbcType.BIGINT;
	
	public boolean autoInc() default true;
}
