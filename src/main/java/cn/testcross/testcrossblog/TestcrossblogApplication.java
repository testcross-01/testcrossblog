package cn.testcross.testcrossblog;



import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@MapperScan("cn.testcross.testcrossblog.mapper")
public class TestcrossblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestcrossblogApplication.class, args);
    }

}
