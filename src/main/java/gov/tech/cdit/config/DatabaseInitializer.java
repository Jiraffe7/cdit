package gov.tech.cdit.config;

import gov.tech.cdit.entities.User;
import gov.tech.cdit.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
@Configuration
public class DatabaseInitializer {

    private String csvPath;
    private UserRepository userRepository;

    public DatabaseInitializer(
            @Value("${csv.path}") String csvPath,
            UserRepository userRepository
    ) {
        this.csvPath = csvPath;
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void init() {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(csvPath));
                CSVParser csvParser = new CSVParser(
                        reader,
                        CSVFormat.DEFAULT
                            .withFirstRecordAsHeader()
                );
        ) {
            for (CSVRecord csvRecord : csvParser) {
                String name = csvRecord.get(0);
                double salary = Double.parseDouble(csvRecord.get(1));
                userRepository.save(new User(name, salary));
            }
        } catch (IOException e) {
            log.error("Error initializing database", e);
        }
    }
}
