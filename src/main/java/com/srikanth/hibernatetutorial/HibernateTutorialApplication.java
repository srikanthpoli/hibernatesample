package com.srikanth.hibernatetutorial;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan("com.srikanth")
@Configuration
@EnableAspectJAutoProxy
public class HibernateTutorialApplication {

    private static final Logger LOGGER = LogManager.getLogger(HibernateTutorialApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(HibernateTutorialApplication.class, args);
        LOGGER.info("Info level log message");
        LOGGER.debug("Debug level log message");
        LOGGER.error("Error level log message");
    }


}
