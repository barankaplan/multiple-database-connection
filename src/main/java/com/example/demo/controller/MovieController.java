package com.example.demo.controller;

import com.example.demo.dto.MovieDTO;
import com.example.demo.service.MovieService;
import com.kaplan.project1.data.exception.ErrorInfo;

import org.csystem.util.data.service.DataServiceException;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.csystem.util.exception.ExceptionUtil.subscribe;

@RestController
@RequestMapping("api/movie")
@Scope("prototype")
public class MovieController {
    private final MovieService m_movieService;

    public MovieController(MovieService movieService)
    {
        m_movieService = movieService;
    }

    @GetMapping("/all")
    public List<MovieDTO> findAll()
    {
        return subscribe(m_movieService::findAllMovies, ex -> new ArrayList<>());
    }

    @GetMapping("/info")
    public List<MovieDTO> findMovieByYear(@RequestParam("year") int year)
    {
        return subscribe(() -> m_movieService.findMoviesByYear(year), ex -> new ArrayList<>());
    }

    @GetMapping("/infos")
    public List<MovieDTO> findMovieByYear(@RequestParam("year") String yearStr)
    {
        return subscribe(() -> m_movieService.findMoviesByYear(Integer.parseInt(yearStr)), ex -> new ArrayList<>());
    }

    @GetMapping("/infosre")
    public ResponseEntity<List<MovieDTO>> findMovieByYearResponseEntity(@RequestParam("year") String yearStr)
    {
        ResponseEntity<List<MovieDTO>> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(m_movieService.findMoviesByYear(Integer.parseInt(yearStr)));
        }
        catch (DataServiceException|NumberFormatException ex) {
            //...
        }

        return responseEntity;
    }


    @GetMapping("/count")
    public long count()
    {
        return subscribe(m_movieService::countMovies, ex -> -1L);
    }

    @PostMapping("/save")
    public ResponseEntity<Object> saveMovie(@RequestBody MovieDTO movieDTO)
    {
        return subscribe(() -> ResponseEntity.ok(m_movieService.saveMovie(movieDTO)),
                ex -> new ResponseEntity<>(new ErrorInfo(ex.getMessage(), null), HttpStatus.BAD_REQUEST));
    }


}
