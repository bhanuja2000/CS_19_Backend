package CS_19;

import CS_19.config.RSAKeyRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;


@SpringBootApplication
@Configuration
@EnableConfigurationProperties(RSAKeyRecord.class)
public class Cs19BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cs19BackendApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}





}



	


