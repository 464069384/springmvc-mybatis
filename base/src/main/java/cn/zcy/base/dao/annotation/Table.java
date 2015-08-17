package cn.zcy.base.dao.annotation;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
	
	/**
	 * table名称
	 * @return
	 */
	public String value() default "";
}
