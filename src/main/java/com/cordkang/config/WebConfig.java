package com.cordkang.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		// TODO Auto-generated method stub
		return new Class[] {RootConfig.class, SecurityConfig.class}; //, SecurityConfig.class
//		return new Class[] {RootConfig.class}; //, SecurityConfig.class
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {ServletConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

	@Override
	protected void customizeRegistration(Dynamic registration) {
		MultipartConfigElement configElement = new MultipartConfigElement("c:/newfo/tmp");
		registration.setMultipartConfig(configElement);
	}

//	@Override
//	protected Filter[] getServletFilters() {
//	//	DelegatingFilterProxy delegatingFilterProxy = new DelegatingFilterProxy();
//		CharacterEncodingFilter filter = new CharacterEncodingFilter("utf-8", true);
//		return new Filter[] {filter} ;//, delegatingFilterProxy
//	}
	
  
}
