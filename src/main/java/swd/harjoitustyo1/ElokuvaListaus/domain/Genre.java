package swd.harjoitustyo1.ElokuvaListaus.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import swd.harjoitustyo1.ElokuvaListaus.domain.Movie;

@Entity
public class Genre {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	@OneToMany(cascade=CascadeType.ALL,mappedBy = "genre")
	private List<Movie> movies;
	
	public Genre(String name) {
		super();
		this.name = name;
		this.movies = null;
	}
	
	public Genre() {
		super();
		this.name = null;
		this.movies = null;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	
}
