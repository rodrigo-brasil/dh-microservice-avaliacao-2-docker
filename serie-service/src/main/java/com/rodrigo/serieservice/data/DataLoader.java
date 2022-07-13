package com.rodrigo.serieservice.data;

import com.rodrigo.serieservice.model.Chapter;
import com.rodrigo.serieservice.model.Season;
import com.rodrigo.serieservice.model.Serie;
import com.rodrigo.serieservice.service.SerieService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class DataLoader implements ApplicationRunner {

    private SerieService service;

    public DataLoader(SerieService service) {
        this.service = service;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {


        Set<Chapter> chaptersList1 =  Set.of(
                new Chapter("Capítulo 1", 1L, "url"),
                new Chapter("Capítulo 2", 2L, "url"),
                new Chapter("Capítulo 3", 3L, "url")
        );

        Season season1 = new Season(1L, chaptersList1);

        service.save(new Serie(null, "Game of Thrones", "acao",  Set.of(season1)));

    }
}
