package com.example.eksamensprojekt_24_timers.config;

import com.example.eksamensprojekt_24_timers.model.Commune;
import com.example.eksamensprojekt_24_timers.model.Parish;
import com.example.eksamensprojekt_24_timers.repository.CommuneRepository;
import com.example.eksamensprojekt_24_timers.repository.ParishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    ParishRepository parishRepository;

    @Autowired
    CommuneRepository communeRepository;

    @Override
    public void run(String... args) throws Exception {
        communes();
        parishes();
    }

    public void communes(){
        try {
            File dataFile = new File("src/main/java/com/example/eksamensprojekt_24_timers/config/Communes");
            Scanner reader = new Scanner(dataFile);
            while (reader.hasNext()){
                String[] data = reader.nextLine().split(": ");
                Commune commune = new Commune(data[1], data[0]);
                communeRepository.save(commune);
            }
            reader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Could not find communes data file=" + e.getMessage());
        }
    }

    public void parishes(){
        Parish parish1 = new Parish(215, "Sogn123", communeRepository.getCommuneByCode("101").get(), 1.1f, LocalDate.of(2021, 6, 10));
        Parish parish2 = new Parish(356, "Sogn123", communeRepository.getCommuneByCode("101").get(), 1.2f, LocalDate.of(2021, 6, 10));
        Parish parish3 = new Parish(865, "Sogn123", communeRepository.getCommuneByCode("101").get(), 0.8f, LocalDate.of(2021, 6, 10));
        Parish parish4 = new Parish(851, "Sogn123", communeRepository.getCommuneByCode("151").get(), 1.3f, LocalDate.of(2021, 6, 10));
        Parish parish5 = new Parish(153, "Sogn123", communeRepository.getCommuneByCode("159").get(), 0.6f, LocalDate.of(2021, 6, 10));
        Parish parish6 = new Parish(684, "Sogn123", communeRepository.getCommuneByCode("410").get(), 1.1f, LocalDate.of(2021, 6, 10));
        Parish parish7 = new Parish(965, "Sogn123", communeRepository.getCommuneByCode("350").get(), 1.1f, LocalDate.of(2021, 6, 10));
        Parish parish8 = new Parish(156, "Sogn123", communeRepository.getCommuneByCode("360").get(), 1.2f, LocalDate.of(2021, 6, 10));
        Parish parish9 = new Parish(469, "Sogn123", communeRepository.getCommuneByCode("461").get(), 1.0f, LocalDate.of(2021, 6, 10));
        Parish parish10 = new Parish(365, "Sogn123", communeRepository.getCommuneByCode("461").get(), 0.9f, LocalDate.of(2021, 6, 10));
        Parish parish11 = new Parish(274, "Sogn123", communeRepository.getCommuneByCode("461").get(), 1.1f, LocalDate.of(2021, 6, 10));
        Parish parish12 = new Parish(714, "Sogn123", communeRepository.getCommuneByCode("461").get(), 1.2f, LocalDate.of(2021, 6, 10));
        Parish parish13 = new Parish(312, "Sogn123", communeRepository.getCommuneByCode("461").get(), 0.7f, LocalDate.of(2021, 6, 10));
        Parish parish14 = new Parish(587, "Sogn123", communeRepository.getCommuneByCode("461").get(), 1.5f, LocalDate.of(2021, 6, 10));

        parishRepository.save(parish1);
        parishRepository.save(parish2);
        parishRepository.save(parish3);
        parishRepository.save(parish4);
        parishRepository.save(parish5);
        parishRepository.save(parish6);
        parishRepository.save(parish7);
        parishRepository.save(parish8);
        parishRepository.save(parish9);
        parishRepository.save(parish10);
        parishRepository.save(parish11);
        parishRepository.save(parish12);
        parishRepository.save(parish13);
        parishRepository.save(parish14);
    }
}
