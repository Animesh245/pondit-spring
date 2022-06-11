package com.this_project.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.multipart.support.MultipartFilter;
import org.springframework.web.servlet.DispatcherServlet;


import javax.servlet.*;

public class AppInitializer implements WebApplicationInitializer {


    @Override
    public void onStartup(ServletContext servletContext) {

//        Root Config
        AnnotationConfigWebApplicationContext rootConfig = new AnnotationConfigWebApplicationContext();
        rootConfig.register(RootConfig.class, DbConfig.class);
        rootConfig.refresh();
        servletContext.addListener(new ContextLoaderListener(rootConfig));

//        Servlet Config
        AnnotationConfigWebApplicationContext servletConfig = new AnnotationConfigWebApplicationContext();
        servletConfig.register(ServletConfig.class);


        // Multipart Config
        ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("servlet", new DispatcherServlet(servletConfig));
        servletRegistration.setMultipartConfig(new MultipartConfigElement("/tmp", 2097152, 4194304, 50));

        FilterRegistration.Dynamic multipartFilter = servletContext.addFilter("multipartFilter", MultipartFilter.class);
        multipartFilter.addMappingForUrlPatterns(null, true, "/*");

        // Load on StartUp
        servletRegistration.setLoadOnStartup(1);

        // mapping
        servletRegistration.addMapping("/");
    }
}
