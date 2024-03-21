package com.minotore.Tools.csv;


import com.minotore.SpringBootMySql.model.Realm;
import com.minotore.SpringBootMySql.repository.RealmRepo;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.awt.print.Book;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/csv")
public class csvController {
    private final RealmRepo realmRepository;

    @Autowired
    public csvController(RealmRepo realmRepository) throws IOException, CsvValidationException {
        this.realmRepository = realmRepository;
    }

    void read_write() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, CsvValidationException {

        //Reading a CSV file

        Reader reader = new FileReader("example.csv");

        CSVReader csvReader = new CSVReader(reader);
        String[] line = csvReader.readNext();

        //Writing into a CSV file

        Writer writer = new FileWriter("example.csv");

        CSVWriter csvWriter = new CSVWriter(writer);
        csvWriter.writeNext(new String[]{"id", "name"});
        csvWriter.writeNext(new String[]{"1", "abc"});
    }

    void read_write_beanBased() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {   //Bean based reading
        Reader reader = new FileReader("example.csv");

        CsvToBean<Book> cb = new CsvToBeanBuilder<Book>(reader).withType(Book.class).build();
        List<Book> book = cb.parse();

        //Bean based writing
        Writer writer2 = new FileWriter("example.csv");
        List<Book> books = null;
        new StatefulBeanToCsvBuilder<Book>(writer2).build().write(books);

    }

    @GetMapping("/realmDetails")
    public ResponseEntity<StreamingResponseBody> downloadCsv() {

        StreamingResponseBody stream = outputStream -> {
            List<Realm> realms = realmRepository.findAll();
            try (Writer writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8)) {
//                try {
//                    new StatefulBeanToCsvBuilder<Realm>(writer)
//                            .build().write(realms);
//                } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
//                    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
//                }
            }
        };

        return ResponseEntity.ok().contentType(MediaType.parseMediaType("text/csv; charset=UTF-8")).header(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename=%s", "realm_details.csv")).header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, HttpHeaders.CONTENT_DISPOSITION).body(stream);
    }
}