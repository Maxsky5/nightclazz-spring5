package com.zenika;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.zenika.config.CorsConfig;

/**
 * Spring reactive application bootstrap class.
 *
 * @author Guillaume DROUET
 */
@SpringBootApplication
@Import(CorsConfig.class)
public class WebfluxApplication {

    public static void main(final String[] args) {
        SpringApplication.run(WebfluxApplication.class, args);
    }

}
