/**
 * 
 */
package cn.zcy.base.dao.dialect;

/**
 * @author kevin.yang
 *
 */
public interface LimitStringDialect {

	
	/**
	 * @param origsql 原始sql
	 * @return 分页查询sql
	 */
	public String getLimitString(String origsql);
}
