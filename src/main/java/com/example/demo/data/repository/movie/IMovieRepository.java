package com.example.demo.data.repository.movie;

import com.example.demo.data.entity.movie.Movie;
import org.csystem.util.data.repository.ICrudRepository;

public interface IMovieRepository extends ICrudRepository<Movie, Long> {
    Iterable<Movie> findMoviesByYear(int year);
    Iterable<Movie> findMoviesByMonthYear(int month, int year);
}
