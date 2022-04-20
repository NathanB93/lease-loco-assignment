package com.leaseloco.leaselocoassignment;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableEncryptableProperties
public class LeaseLocoAssignmentApplication {

    public static void main(String[] args) throws Exception {
        //System.exit(SpringApplication.exit(SpringApplication.run(LeaseLocoAssignmentApplication.class, args)));
        SpringApplication.run(LeaseLocoAssignmentApplication.class, args);
    }
}
