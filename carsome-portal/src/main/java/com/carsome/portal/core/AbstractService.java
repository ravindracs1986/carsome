
package com.carsome.portal.core;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@EnableTransactionManagement(mode = AdviceMode.PROXY, proxyTargetClass = true)
@Transactional
public abstract class AbstractService<S extends AbstractEntity, id> implements SimpleDataAccess<S> {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	protected static final String HEADER_MESSAGE_ID = "X-Message-Id";
	protected static final String HEADER_AUTHORIZATION = "Authorization";

	@Autowired
	protected Mapper dozerMapper;

	@Autowired
	protected PlatformTransactionManager transactionManager;

	public abstract GenericRepository<S> primaryDao();

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public <T extends AbstractEntity> S create(S s) {
		try {
			this.primaryDao().save(s);
			return s;
		} catch (Throwable e) {
			logger.error("create Exception", e);
			return null;
		}
	}

	@Modifying(clearAutomatically = true)
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public <T extends AbstractEntity> S update(S s) {
		try {
			this.primaryDao().saveAndFlush(s);
			return s;
		} catch (Throwable e) {
			logger.error("update Exception", e);
			return null;
		}
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public <T extends AbstractEntity> S find(java.lang.Integer id) {
		try {
			return this.primaryDao().findOne(id);
		} catch (Throwable e) {
			logger.error("find Exception", e);
			return null;
		}
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public <T extends AbstractEntity> List<S> findAll() {
		try {
			return this.primaryDao().findAll();
		} catch (Throwable e) {
			logger.error("findAll Exception", e);
			return null;
		}
	}

	@Modifying(clearAutomatically = true)
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public boolean delete(java.lang.Integer id) {
		try {
			this.primaryDao().delete(id);
			return true;
		} catch (Throwable e) {
			logger.error("delete Exception", e);
			return false;
		}
	}

	protected Timestamp getSQLTimestamp() {
		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		return currentTimestamp;
	}

}