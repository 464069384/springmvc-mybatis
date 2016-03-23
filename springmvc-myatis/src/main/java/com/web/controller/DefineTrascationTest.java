package com.web.controller;

import javax.annotation.Resource;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**编程式事物*/
public class DefineTrascationTest {

	
	@Resource(name="transactionManager")
	private PlatformTransactionManager txManager;


	public void doRefreash(){
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = txManager.getTransaction(def);
		try {
			//数据库等需事物管理的操作
		}
		catch (Exception ex) {
			//回滚
			txManager.rollback(status);
			throw ex;
		}
		//提交
		txManager.commit(status);
	}
}