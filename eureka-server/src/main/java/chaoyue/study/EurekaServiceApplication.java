package chaoyue.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 项目启动后访问 http://localhost:8761/ 即可进入eureka控制台
 */
@SpringBootApplication
@EnableEurekaServer // 导入EurekaServerMarkerConfiguration自动配置类
public class EurekaServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceApplication.class, args);
    }
}
