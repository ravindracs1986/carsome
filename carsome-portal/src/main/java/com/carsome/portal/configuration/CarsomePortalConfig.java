package com.carsome.portal.configuration;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

/**
 * 
 * @author Ravindra kumar
 * @email rv.kumar1401@gmail.com
 *
 */

@Configuration
@EnableWebMvc
@EnableScheduling
@ComponentScan(basePackages = "com.carsome.portal")
public class CarsomePortalConfig extends WebMvcConfigurerAdapter {

	private static final Logger LOGGER = LoggerFactory.getLogger(CarsomePortalConfig.class);

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getResolver() throws IOException {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();

		// Set the maximum allowed size (in bytes) for each individual file.
		resolver.setMaxUploadSizePerFile(5242880);// 5MB

		// You may also set other available properties.

		return resolver;
	}

	/**
	 * Configure TilesConfigurer.
	 */
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions(new String[] { "/WEB-INF/views/**/tiles.xml" });
		tilesConfigurer.setCheckRefresh(true);
		return tilesConfigurer;
	}

	/**
	 * Configure ViewResolvers to deliver preferred views.
	 */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		TilesViewResolver viewResolver = new TilesViewResolver();
		registry.viewResolver(viewResolver);
	}

	/**
	 * Configure ResourceHandlers to serve static resources like CSS/ Javascript
	 * etc...
	 */

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
		registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

	@Bean(name = "messageSource")
	public ReloadableResourceBundleMessageSource getMessageSource() {
		ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
		resource.setBasename("classpath:messages");
		resource.setDefaultEncoding("UTF-8");
		return resource;
	}

	@Bean
	public Mapper dozerMapper() {
		return new DozerBeanMapper();
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		PropertySourcesPlaceholderConfigurer ppc = new PropertySourcesPlaceholderConfigurer();
		// FileSystemResource[] resources = new FileSystemResource[]{ new
		// FileSystemResource( getPropertyPath() + ConfigConstants.PROPERTIES_EXT )};
		// FileSystemResource[] resources = new FileSystemResource[]{ new
		// FileSystemResource( getPropertyPath() + ConfigConstants.PROPERTIES_EXT )};
		ppc.setLocations(new ClassPathResource("carsome-portal.properties"));
		ppc.setIgnoreUnresolvablePlaceholders(false);
		return ppc;
	}

	private static String propertyPath;

	public static String getPropertyPath() {
		if (!StringUtils.isEmpty(propertyPath)) {
			return propertyPath;
		}
		// Get from PROJECT CONFIGURATION server
		/*
		 * String propertyHome = System.getProperty(ConfigConstants.PATH_PROJ_CONFIG) !=
		 * null ? System.getProperty(ConfigConstants.PATH_PROJ_CONFIG) :
		 * System.getenv(ConfigConstants.PATH_PROJ_CONFIG);
		 * LOGGER.info("PROJECT CONFIGURATION HOME >> " + propertyHome); File file = new
		 * File(propertyHome + ConfigConstants.FILE_SYS_RESOURCE); if (!file.exists())
		 * propertyHome = null;
		 */

		// Get from TOMCAT server
		File file = null;
		String propertyHome = System.getProperty(ConfigConstants.PATH_CATALINA_HOME) != null
				? System.getProperty(ConfigConstants.PATH_CATALINA_HOME)
				: System.getProperty(ConfigConstants.PATH_CATALINA_BASE);
		if (!StringUtils.isEmpty(propertyHome)) {
			propertyHome = propertyHome + File.separator + "conf";
		}
		LOGGER.info("CATALINA HOME >> " + propertyHome);
		file = new File(propertyHome + ConfigConstants.FILE_SYS_RESOURCE);
		if (!file.exists())
			propertyHome = null;

		/*
		 * // Get from JBOSS server if(BaseUtil.isObjNull(propertyHome)) { propertyHome
		 * = System.getProperty(ConfigConstants.PROJ_JBOSS_HOME);
		 * if(!BaseUtil.isObjNull(propertyHome)) { propertyHome = propertyHome +
		 * File.separator + "configuration"; } LOGGER.info("JBOSS HOME >> " +
		 * propertyHome); file = new File(propertyHome +
		 * ConfigConstants.FILE_SYS_RESOURCE); if (!file.exists()) propertyHome = null;
		 * }
		 */

		if (!StringUtils.isEmpty(propertyHome)) {
			file = new File(propertyHome + ConfigConstants.FILE_SYS_RESOURCE);
			if (file.exists() && !file.isDirectory()) {
				propertyPath = propertyHome + File.separator + ConfigConstants.PROPERTY_FILENAME;
			} else {
				LOGGER.info("Missing properties file >> " + propertyHome + ConfigConstants.FILE_SYS_RESOURCE);
			}
		}

		// Get from Application CLASSPATH
		propertyPath = propertyPath != null ? propertyPath : ConfigConstants.PROPERTY_CLASSPATH;

		LOGGER.info("\n[Application Properties :: \n\tPath : " + propertyPath + "\n]");

		return propertyPath;
	}

	/*
	 * @Bean public YouTubeSchedularController bean() { return new
	 * YouTubeSchedularController(); }
	 */
}
