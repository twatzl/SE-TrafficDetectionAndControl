package at.twatzl.tdc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TdcApplication {

	public static void main(String[] args) {
		SpringApplication.run(TdcApplication.class, args);
	}

}

