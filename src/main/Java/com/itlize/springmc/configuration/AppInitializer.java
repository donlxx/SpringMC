package com.itlize.springmc.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	//Inherited AbstractAnnotationConfigDispatcherServletInitializer class here,
	// to automatically configure the Dispatcher Servlet and Spring context (the traditional way is in the web.
	// In the XML configuration DispatcherServlet)Inherited AbstractAnnotationConfigDispatcherServletInitializer class here,
	// to automatically configure the Dispatcher Servlet and Spring context
	// (the traditional way is in the web. In the XML configuration DispatcherServlet)

//	    @Override
	//public void onStartup(ServletContext servletContext) throws ServletException {
//	    WebApplicationContext context = getContext();
//	    servletContext.addListener(new ContextLoaderListener(context));
//	    ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
//	    dispatcher.setLoadOnStartup(1);
//	    dispatcher.addMapping("/*");
	//}
	//
//	    private AnnotationConfigWebApplicationContext getContext() {
//	        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//	        context.setConfigLocation("eu.kielczewski.example.config");
//	        return context;
//	    }

	    @Override
	    protected Class<?>[] getRootConfigClasses() {
	       return new Class<?>[] { DbConfig.class,WebSecurityConfig.class };

	    }
	    
	    

	    @Override
	    protected Class<?>[] getServletConfigClasses() {
	        return new Class<?>[] { AppConfig.class};
	    }

	    @Override
	    protected String[] getServletMappings() {
	        return new String[] { "/" };
	    }

	}