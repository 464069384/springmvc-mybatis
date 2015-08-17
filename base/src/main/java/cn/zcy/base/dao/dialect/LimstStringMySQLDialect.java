package cn.zcy.base.dao.dialect;

public class LimstStringMySQLDialect implements LimitStringDialect {

	@Override
	public String getLimitString(String origsql) {		
		return origsql + " limit ?,?";
	}

}
