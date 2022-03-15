package com.cg.movie.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Movie {
	@Id
	private int movieId;
	
	@NotNull(message="Name must not be null")
	private String movieName;
	
	@NotNull(message="genre must not be null")
	private String genre;
	
	@NotNull(message="releaseDate must not be null")
	private Date releaseDate;
	
	@NotNull(message="language must not be null")
	private String language;
}
