package io.wjehovah.github.myspingboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("io.wjehovah.github.myspingboot")
public class MySpingbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpingbootApplication.class, args);
    }
}
