package com.example.eksamensprojekt_24_timers.config;

import com.example.eksamensprojekt_24_timers.model.Commune;
import com.example.eksamensprojekt_24_timers.model.Parish;
import com.example.eksamensprojekt_24_timers.service.CommuneService;
import com.example.eksamensprojekt_24_timers.service.ParishService;
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
    ParishService parishService;

    @Autowired
    CommuneService communeService;

    @Override
    public void run(String... args) throws Exception {
        communes();
        parishes();
    }

    public void communes(){
        try {
            File dataFile = new File("src/main/java/com/example/eksamensprojekt_24_timers/config/commune_data");
            Scanner reader = new Scanner(dataFile);
            while (reader.hasNext()){
                String[] data = reader.nextLine().split(": ");
                Commune commune = new Commune(data[1], data[0]);
                communeService.save(commune);
            }
            reader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Could not find communes data file=" + e.getMessage());
        }
    }

    public void parishes(){
        Parish parish1 = new Parish(215, "Sogn123", communeService.getCommuneByCode("101").get(), 1.1f, LocalDate.of(2021, 6, 10), null);
        Parish parish2 = new Parish(356, "Sogn123", communeService.getCommuneByCode("101").get(), 1.2f, LocalDate.of(2021, 6, 10), null);
        Parish parish3 = new Parish(865, "Sogn123", communeService.getCommuneByCode("101").get(), 0.8f, null, null);
        Parish parish4 = new Parish(851, "Sogn123", communeService.getCommuneByCode("151").get(), 1.3f, LocalDate.of(2021, 6, 10), null);
        Parish parish5 = new Parish(153, "Sogn123", communeService.getCommuneByCode("159").get(), 0.6f, null, null);
        Parish parish6 = new Parish(684, "Sogn123", communeService.getCommuneByCode("410").get(), 1.1f, LocalDate.of(2021, 6, 10), null);
        Parish parish7 = new Parish(965, "Sogn123", communeService.getCommuneByCode("350").get(), 1.1f, LocalDate.of(2021, 6, 10), null);
        Parish parish8 = new Parish(156, "Sogn123", communeService.getCommuneByCode("360").get(), 1.2f, LocalDate.of(2021, 6, 10), null);
        Parish parish9 = new Parish(469, "Sogn123", communeService.getCommuneByCode("461").get(), 1.0f, LocalDate.of(2021, 6, 10), null);
        Parish parish10 = new Parish(365, "Sogn123", communeService.getCommuneByCode("461").get(), 0.9f, null, null);
        Parish parish11 = new Parish(274, "Sogn123", communeService.getCommuneByCode("461").get(), 1.1f, LocalDate.of(2021, 6, 10), null);
        Parish parish12 = new Parish(714, "Sogn123", communeService.getCommuneByCode("461").get(), 1.2f, LocalDate.of(2021, 6, 10), null);
        Parish parish13 = new Parish(312, "Sogn123", communeService.getCommuneByCode("461").get(), 0.7f, null, null);
        Parish parish14 = new Parish(587, "Sogn123", communeService.getCommuneByCode("461").get(), 1.5f, LocalDate.of(2021, 6, 10), null);

        parishService.save(parish1);
        parishService.save(parish2);
        parishService.save(parish3);
        parishService.save(parish4);
        parishService.save(parish5);
        parishService.save(parish6);
        parishService.save(parish7);
        parishService.save(parish8);
        parishService.save(parish9);
        parishService.save(parish10);
        parishService.save(parish11);
        parishService.save(parish12);
        parishService.save(parish13);
        parishService.save(parish14);
    }
}
