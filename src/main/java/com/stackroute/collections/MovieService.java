package com.stackroute.collections;

import java.time.LocalDate;
import java.util.*;
import java.util.Map.Entry;

/*
This class contains a property called movieMap of type Map
This class contains methods for adding key-value pairs of Movie and its rating to HashMap and
various methods for accessing the keys and values based on some conditions
 */
public class MovieService {
	
	Map<Movie, Integer> movieMap= new LinkedHashMap<>() ;
	

    /**
     * Constructor to create movieMap as an empty  LinkedHashMap object
     */
    public MovieService() {
   
    }
    
    

    /*
    Returns the movieMap object
     */
    public Map<Movie, Integer> getMovieMap() {
    	
        return movieMap;
    }

    
    
    /*
    Add key-value pairs of Movie-Integer type and returns Set of Map.Entry
     */
    public Set<Map.Entry<Movie, Integer>> addKeyValuePairsToMap(Movie movie, Integer rating) {
    	
    	movieMap.put(movie, rating);
    	Set set= movieMap.entrySet();
    	
        return set;
    }

    /*
    Return Set of movie names having rating greater than or equal to given rating
     */
    public List<String> getHigherRatedMovieNames(int rating) {
    	
    	List<String> list= new ArrayList<>();
    	for(Map.Entry<Movie,Integer> m : movieMap.entrySet()){  
    		int i = (int)m.getValue();
    	   if(i>=rating)
    	   {
    		   Movie mo=(Movie) m.getKey();
    		   String str= mo.getMovieName();
    		   list.add(str);
    	   }
    	}
        return list;
    
    }

    /*
    Return Set of movie names belonging to specific genre
     */
    public List<String> getMovieNamesOfSpecificGenre(String genre) {
 
    	List<String> list= new ArrayList<>();
    	for(Map.Entry<Movie,Integer> m : movieMap.entrySet()){  
    		Movie mo= (Movie) m.getKey();
    		String str= mo.getGenre();	
	    	   if(str.equals(genre)) {
	    	   String str1= mo.getMovieName();
	    	   list.add(str1);
	    	   }
    	}
    	return list;
    }

   /*
   Return Set of movie names which are released after Specific releaseDate and having rating less than or equal to 3
    */

    public List<String> getMovieNamesReleasedAfterSpecificDateAndRatingLesserThanThree(LocalDate releaseDate) {
    	
    	List<String> list= new ArrayList<>();
    	for(Map.Entry<Movie,Integer> m : movieMap.entrySet()){  
    		Movie mo= (Movie) m.getKey();
    		LocalDate ld=mo.getReleaseDate();
    		int i=(int) m.getValue();
    		
    		if((ld.compareTo(releaseDate)>0) && i<=3)
    		{
    			String str=mo.getMovieName();
    			list.add(str);
    		}
    	}
    	return list;
    }

    /*
    Return set of movies sorted by release dates in ascending order.
    Hint: Use TreeMap
     */
    public List<Movie> getSortedMovieListByReleaseDate() {
    	
    	List<Movie> list= new ArrayList<>();
    	
    	for(Map.Entry<Movie, Integer> e: movieMap.entrySet()) {
			list.add(e.getKey());
		}
    	
    	Comparator<Movie> valueComparator = new Comparator<Movie>() {

			@Override
			public int compare(Movie o1, Movie o2) {
				  LocalDate v1 = o1.getReleaseDate();
	              LocalDate v2 = o2.getReleaseDate();
	                return v1.compareTo(v2);
			}
    	};
			Collections.sort(list, valueComparator);

        return list;
    }

    /*
   Return set of movies sorted by rating.
   Hint: Use Comparator and LinkedHashMap
    */
    public Map<Movie, Integer> getSortedMovieListByRating() {
    	
    	ArrayList<Map.Entry<Movie, Integer>> list= new ArrayList<>();
    	Map<Movie,Integer> linkedMap=new LinkedHashMap<>();
    	
    	for(Map.Entry<Movie, Integer> e: movieMap.entrySet()) {
			list.add(e);
		}
    	
    		Comparator<Map.Entry<Movie, Integer>> valueComparator = new Comparator<Map.Entry<Movie, Integer>>() {

			@Override
			public int compare(Map.Entry<Movie, Integer> o1, Map.Entry<Movie, Integer> o2) {
				  Integer v1 = o1.getValue();
	              Integer v2 = o2.getValue();
	                return v1.compareTo(v2);
			}
    	};
			Collections.sort(list, valueComparator);
			
			for(Map.Entry<Movie, Integer> e: list) {
				linkedMap.put(e.getKey(), e.getValue());
			}
        return linkedMap;
    }
}
