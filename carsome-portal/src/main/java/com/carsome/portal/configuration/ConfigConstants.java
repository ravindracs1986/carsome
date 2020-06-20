
package com.carsome.portal.configuration;

import java.io.File;

/**
 * 
 * @author Ravindra kumar
 * @email rv.kumar1401@gmail.com
 *
 */
public interface ConfigConstants {

	
	public static final String PATH_CATALINA_HOME			= "catalina.home";
	public static final String PATH_CATALINA_BASE			= "catalina.base";
	public static final String PROPERTY_FILENAME			= "carsome-portal";
	
	public static final String PROPERTIES_EXT				= ".properties";
	public static final String FILE_SYS_RESOURCE			= File.separator + PROPERTY_FILENAME + PROPERTIES_EXT;
	public static final String PROPERTY_CLASSPATH			= "classpath:" + PROPERTY_FILENAME;
	public static final String FILE_PFX						= "file:";
	
	public static final String DB_CONF_DRIVER				= "mysql.db.driver";
	public static final String DB_CONF_URL					= "mysql.db.url";
	public static final String DB_CONF_UNAME				= "mysql.db.uname";
	public static final String DB_CONF_PWORD				= "mysql.db.pword";
	public static final String CRON_JOB_SCHEDULER			= "batch.job.schedular";
	
	public static final String WEEKDAY_SLOTS="weekdays.inspection.slot";
	public static final String SATDAY_SLOTS="saturday.inspection.slot";
	public static final String DIVIDENT_TIME="divident.time";
	
	
	
}
