package ddd.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/** web服务
 * @author wulei
 */
@SpringBootApplication
@ComponentScan(basePackages = {"ddd.*"})
public class WebServerStarter {

    public static void main(String[] args) {
        SpringApplication.run(WebServerStarter.class, args);
    }
}
