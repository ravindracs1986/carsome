
package com.carsome.portal.configuration;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Ravindra kumar
 * @email rv.kumar1401@gmail.com
 *
 */
public class SessionListener implements HttpSessionListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(SessionListener.class);
	
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		LOGGER.info("Session is CREATED");
		event.getSession().setMaxInactiveInterval(30*60);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		LOGGER.info("Session is DESTROYED");
	}
	
}