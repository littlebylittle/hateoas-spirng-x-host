package home.demo.controller;

import home.demo.dto.CsvDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CsvController {

    @GetMapping(value = "/csv/{csvId}")
    public ResponseEntity<CsvDto> getCsv(@PathVariable("csvId") long csvId) {
        CsvDto csvDto = new CsvDto(csvId, "/path/blhablha/" + csvId, "some owner");
        return ResponseEntity.ok(csvDto);
    }
}
