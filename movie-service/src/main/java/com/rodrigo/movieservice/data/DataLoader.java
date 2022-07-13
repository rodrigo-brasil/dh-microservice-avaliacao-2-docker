package com.rodrigo.movieservice.data;


import com.rodrigo.movieservice.model.Movie;
import com.rodrigo.movieservice.repository.MovieRepository;
import com.rodrigo.movieservice.service.MovieService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

	private MovieService service;

	public DataLoader (MovieService service) {
		this.service = service;
	}

	@Override
	public void run (ApplicationArguments args) throws Exception {
		service.save(new Movie(1L, "filme", "terror", "what"));
		service.save(new Movie(2L, "borboleta", "terror", "what"));
		service.save(new Movie(3L, "adedonha", "terror", "what"));
		service.save(new Movie(4L, "pajero", "terror", "what"));
		service.save(new Movie(5L, "dakar", "acao", "what"));
		service.save(new Movie(6L, "shadow", "acao", "what"));
		service.save(new Movie(7L, "boné", "romance", "what"));
		service.save(new Movie(8L, "xícara", "romance", "what"));
	}
}
