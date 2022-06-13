package com.pfa.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PfaProject2022 extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(PfaProject2022.class, args);
    }

    @Override
    protected SpringApplicationBuilder
    configure(SpringApplicationBuilder application) {
//        TimeZone.setDefault(TimeZone.getTimeZone("France/Par"));
        return application.sources(
                PfaProject2022.class);
    }

}
