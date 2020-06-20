
package com.carsome.portal.core;

import java.sql.Timestamp;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractRestController {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	protected Timestamp getSQLTimestamp() {
		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		return currentTimestamp;
	}

}