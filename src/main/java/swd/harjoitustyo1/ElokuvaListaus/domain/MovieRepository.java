package swd.harjoitustyo1.ElokuvaListaus.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import swd.harjoitustyo1.ElokuvaListaus.domain.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	List<Movie> findByTitle(String title);

}