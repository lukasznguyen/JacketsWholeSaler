package com.example.jacketwholesaler.models;

import com.example.jacketwholesaler.models.entities.Jacket;
import com.example.jacketwholesaler.models.enums.Color;
import com.example.jacketwholesaler.models.enums.Size;
import com.example.jacketwholesaler.repositories.JacketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class DatabaseDataSeeder implements CommandLineRunner {

    //Repositories
    private final JacketRepository jacketRepository;

    //DataFiles
    private final String jacketFile = "src/main/resources/static/dbseeder/jacket.txt";

    //Lists
    private List<Jacket> jackets = new ArrayList<>();

    //Others
    private final String delimiter = ";";
    private BufferedReader bfr;
    private String line;
    private String[] dividedLine;

    @Autowired
    public DatabaseDataSeeder(JacketRepository jacketRepository) {
        this.jacketRepository = jacketRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        FileReader jacketIS = new FileReader(jacketFile);
        loadJackets(jacketIS);
    }

    private void loadJackets(FileReader jacketIS) throws IOException {
        bfr = new BufferedReader(jacketIS);
        while((line = bfr.readLine()) != null) {
            dividedLine = line.split(delimiter);

            Size size;
            switch(dividedLine[1]) {
                case "S":
                    size = Size.S;
                    break;
                case "M":
                    size = Size.M;
                    break;
                case "L":
                    size = Size.L;
                    break;
                case "XL":
                    size = Size.XL;
                    break;
                default:
                    throw new RuntimeException("Undefined size value");
            }

            Color color;
            switch(dividedLine[2]) {
                case "red":
                    color = Color.RED;
                    break;
                case "black":
                    color = Color.BLACK;
                    break;
                case "blue":
                    color = Color.BLUE;
                    break;
                case "green":
                    color = Color.GREEN;
                    break;
                case "gray":
                    color = Color.GRAY;
                    break;
                case "pink":
                    color = Color.PINK;
                    break;
                default:
                    throw new RuntimeException("Undefined color value");
            }

            Jacket jacket = new Jacket(Long.parseLong(dividedLine[0]), size, color, Double.parseDouble(dividedLine[3]));
            jacketRepository.save(jacket);
            jackets.add(jacket);
        }
    }
}
