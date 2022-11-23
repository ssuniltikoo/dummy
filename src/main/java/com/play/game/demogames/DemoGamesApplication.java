package com.play.game.demogames;



import com.play.game.demogames.domain.User;
import com.play.game.demogames.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class DemoGamesApplication {

	public static void main(String[] args) {
		final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DemoGamesApplication.class);
		log.info("application starting ");
		SpringApplication.run(DemoGamesApplication.class, args);
		log.info("application context load successfully ");
	}

	@Bean
	public CommandLineRunner run(UserRepository userRepository) throws Exception{
		return  (String[] args) -> {
			User user1 = new User("John", "john@domainin.com");
			User user2 = new User("John1", "john2@domainin.com");
			User user3 = new User("John2", "john1@domainin.com");
			log.info("in command line");
			userRepository.save(user1);
			userRepository.save(user2);
			userRepository.save(user3);
			log.info("users data is user1: {} user2:{} user3:{}", user1,user2,user3);
			userRepository.findAll().forEach(user -> System.out.println(user.toString()));
		};
	}


}
