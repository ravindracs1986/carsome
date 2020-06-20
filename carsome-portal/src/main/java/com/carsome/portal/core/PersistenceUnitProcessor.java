
package com.carsome.portal.core;

import javax.persistence.spi.PersistenceUnitTransactionType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.jpa.persistenceunit.MutablePersistenceUnitInfo;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitPostProcessor;


public class PersistenceUnitProcessor implements PersistenceUnitPostProcessor {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo pui) {
		PersistenceUnitTransactionType puTransType = PersistenceUnitTransactionType.RESOURCE_LOCAL;
		pui.setTransactionType(puTransType);
		logger.info("Transaction Type : {} ", pui.getTransactionType().name());
	}
	
}
