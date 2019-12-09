package com.picc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Administrator on 2019/9/29.
 */
@SpringBootApplication
@EnableTransactionManagement//事务支持
@MapperScan({"com.picc.*.mapper","com.picc.*.*.mapper"})
public class RuleApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(RuleApplication.class).run(args);
    }
}

