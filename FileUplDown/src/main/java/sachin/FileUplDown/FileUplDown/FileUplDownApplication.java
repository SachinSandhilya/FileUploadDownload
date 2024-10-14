package sachin.FileUplDown.FileUplDown;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class FileUplDownApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileUplDownApplication.class, args);
	}

}
