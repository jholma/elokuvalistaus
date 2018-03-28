package swd.harjoitustyo1.ElokuvaListaus.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import swd.harjoitustyo1.ElokuvaListaus.domain.Genre;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	private int year;
	private String comment;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="genreid")
	private Genre genre;
	
	public Movie() {
		super();
	}

	public Movie(Long id, String title, int year, Genre genre, String comment) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.comment=comment;
	}
	public Movie(String title, int year, Genre genre, String comment) {
		super();
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.comment= comment;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
}
