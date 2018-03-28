package swd.harjoitustyo1.ElokuvaListaus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import swd.harjoitustyo1.ElokuvaListaus.domain.Genre;
import swd.harjoitustyo1.ElokuvaListaus.domain.GenreRepository;
import swd.harjoitustyo1.ElokuvaListaus.domain.Movie;
import swd.harjoitustyo1.ElokuvaListaus.domain.MovieRepository;
import swd.harjoitustyo1.ElokuvaListaus.domain.User;
import swd.harjoitustyo1.ElokuvaListaus.domain.UserRepository;

@SpringBootApplication
public class ElokuvaListausApplication {
	private static final Logger log = LoggerFactory.getLogger(ElokuvaListausApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ElokuvaListausApplication.class, args);
	}
	@Bean
	public CommandLineRunner bookDemo(MovieRepository mrepository, GenreRepository grepository, UserRepository urepository) {
		return (args) -> {
			log.info("Save few genres");
			grepository.save(new Genre("Action"));
			grepository.save(new Genre("Thriller"));
			grepository.save(new Genre("Comedy"));
			
			log.info("save a couple movies");
			mrepository.save(new Movie("Hobitit", 2009, grepository.findByName("Comedy").get(0), ""));
			mrepository.save(new Movie("Koirat", 2011, grepository.findByName("Action").get(0),""));
			mrepository.save(new Movie("Kissat", 2018, grepository.findByName("Thriller").get(0), ""));
			
			log.info("Create two users, admin and user");
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@testimaa.com", "USER");
			User user2 = new User("admin", "$2a$10$vI98WILVFgR75LHMTobaNORmpBfGkSO8ZRzbgvEXKJn2yZbm3G4lO", "admin@testimaa.com", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);

			log.info("fetch all movies");
			for (Movie movie : mrepository.findAll()) {
				log.info(movie.toString());
			}
		};
	}
}	