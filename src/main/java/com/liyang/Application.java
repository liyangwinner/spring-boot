package com.liyang;

import com.liyang.filter.TestFilter;
import com.liyang.utils.VelocityUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableScheduling
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        // test velocity
        VelocityUtil.getVelocity();
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        List<String> urlPattern = new ArrayList<>();
        TestFilter testFilter = new TestFilter();
        urlPattern.add("/Blogs");
        filterRegistrationBean.setFilter(testFilter);
        filterRegistrationBean.setUrlPatterns(urlPattern);
        return filterRegistrationBean;
    }

}
