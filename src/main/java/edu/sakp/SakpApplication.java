package edu.sakp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
// 开启注解事务管理
@EnableTransactionManagement
@MapperScan("edu.sakp.mapper")
public class SakpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SakpApplication.class, args);
    }

}
