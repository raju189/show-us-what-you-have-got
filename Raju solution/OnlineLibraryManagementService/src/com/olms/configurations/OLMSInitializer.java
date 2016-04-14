package com.olms.configurations;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class OLMSInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
		 
	    @Override
	    protected Class<?>[] getRootConfigClasses() {
	        return new Class[] { OLMSConfiguration.class };
	    }
	  
	    @Override
	    protected Class<?>[] getServletConfigClasses() {
	        return null;
	    }
	  
	    @Override
	    protected String[] getServletMappings() {
	        return new String[] { "/" };
	    }
	    
	    @Override
	    protected Filter[] getServletFilters() {
	    	return null;
		}
	 
	}