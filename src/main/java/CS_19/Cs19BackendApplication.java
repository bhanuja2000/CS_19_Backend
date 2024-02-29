package CS_19;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;

import CS_19.Entity.User;

@SpringBootApplication
@Configuration
public class Cs19BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cs19BackendApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}





}



	


