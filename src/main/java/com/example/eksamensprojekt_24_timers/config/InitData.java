package com.example.eksamensprojekt_24_timers.config;

import com.example.eksamensprojekt_24_timers.model.Commune;
import com.example.eksamensprojekt_24_timers.repository.CommuneRepository;
import com.example.eksamensprojekt_24_timers.repository.ParishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
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

    }
}
