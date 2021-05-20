package com.jayaraj.sm.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.jayaraj"})
public class StudentAppConfig implements WebMvcConfigurer{
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/view/");
		vr.setSuffix(".jsp");
		return vr;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourse());
		return jdbcTemplate;
	}
	
	@Bean
	public DataSource dataSourse() {
		DriverManagerDataSource dataSourse = new DriverManagerDataSource();
		dataSourse.setUsername("root");
		dataSourse.setPassword("AaBb33@@");
		dataSourse.setUrl("jdbc:mysql://localhost:3306/studentmanagement?useSSL=false");
		dataSourse.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return dataSourse;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/URLToReachResoursesFolder/**").addResourceLocations("/resourses/");
	}
}
