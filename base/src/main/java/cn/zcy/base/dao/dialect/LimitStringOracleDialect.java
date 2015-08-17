/**
 * 
 */
package cn.zcy.base.dao.dialect;

/**
 * @author kevin.yang
 *
 */
public class LimitStringOracleDialect implements LimitStringDialect {

	/* (non-Javadoc)
	 * @see cn.datek.base.dao.dialect.LimitStringDialect#getLimitString()
	 */
	@Override
	public String getLimitString(String origsql) {
		 String pagingsql = new StringBuilder()
		.append("select * from (select row_.*, rownum rownum_ from (").append(origsql).append(") row_) where rownum_>=? and rownum_< ?")
		.toString();
		 return pagingsql;
	}

}
