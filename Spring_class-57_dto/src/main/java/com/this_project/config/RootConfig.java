package com.this_project.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.this_project.dao", "com.this_project.dao_impl"})
public class RootConfig {

}
