package cn.zcy.base.dao.annotation;


import org.apache.ibatis.type.JdbcType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
	
	/**
	 * 字段名称
	 * @return
	 */
	public String value() default "";
	
	public JdbcType jdbcType() default JdbcType.VARCHAR;
	
	public boolean key() default false;
	
}
