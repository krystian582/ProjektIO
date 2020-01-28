package edu.uph.ii.platformy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"edu.uph.ii.platformy","edu.uph.ii.platformy.services"})
public class SpringBootPrjApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootPrjApplication.class, args);
    }

}
