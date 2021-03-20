package com.stackroute.collections;

import java.time.LocalDate;

/*
Movie class has four fields- movieId,movieName, genre and releaseDate
This class should be of Comparable type comparing movies based on releaseDate
 */
public class Movie implements Comparable<Movie>{
	
	private int movieId;
	private String movieName;
	private String genre;
	private LocalDate releaseDate;
	

    public Movie(int movieId, String movieName, String genre, LocalDate releaseDate) {
    	this.movieId=movieId;
    	this.movieName=movieName;
    	this.genre=genre;
    	this.releaseDate=releaseDate;
    	
    }

    public int getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getGenre() {
        return genre;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", genre=" + genre + ", releaseDate="
				+ releaseDate + "]";
	}


	@Override
	public int compareTo(Movie o) {
		
		return this.compareTo(o);
	}
    
	
    
    
}
