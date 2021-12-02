package com.example.demo.data.dal;

import static org.csystem.util.data.DatabaseUtil.*;
import com.example.demo.data.entity.movie.Movie;
import com.example.demo.data.repository.movie.IMovieRepository;
import org.springframework.stereotype.Component;

@Component
public class MovieServiceApplicationDAL {
    private final IMovieRepository movieRepository;


    public MovieServiceApplicationDAL(IMovieRepository movieRepository)
    {
        this.movieRepository = movieRepository;

    }

    public long countMovies()
    {
        return doWorkForRepository(movieRepository::count, "MovieServiceApplicationDAL.countMovies");
    }

    public Iterable<Movie> findAllMovies()
    {
        return doWorkForRepository(movieRepository::findAll, "MovieServiceApplicationDAL.findAllMovies");
    }

    public Iterable<Movie> findMoviesByMonthYear(int month, int year)
    {
        return doWorkForRepository(() -> movieRepository.findMoviesByMonthYear(month, year),
                "MovieServiceApplicationDAL.findMoviesByMonthYear");
    }

    public Iterable<Movie> findMoviesByYear(int year)
    {
        return doWorkForRepository(() -> movieRepository.findMoviesByYear(year), "MovieServiceApplicationDAL.findByYear");
    }


    public Movie saveMovie(Movie movie)
    {
        return doWorkForRepository(() -> movieRepository.save(movie), "MovieServiceApplicationDAL.saveMovie");
    }


}
