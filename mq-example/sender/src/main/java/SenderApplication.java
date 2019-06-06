import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Eureka服务端
 * @author 小明不读书
 * @date 2019-03-22
 */
@EnableEurekaClient
@SpringBootApplication
public class SenderApplication {
	public static void main(String[] args) {
		SpringApplication.run(SenderApplication.class, args);
	}
}
