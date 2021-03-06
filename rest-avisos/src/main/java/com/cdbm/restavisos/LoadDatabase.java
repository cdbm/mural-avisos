package com.cdbm.restavisos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(NoticeRepository repository){
        return args -> {
            log.info("Preloading " + repository.save(new Notice("Aviso 1", "Descrição 1", "", "")));
            log.info("Preloading " + repository.save(new Notice("Aviso 2", "Descrição 2", "", "")));
        };
    }
}
