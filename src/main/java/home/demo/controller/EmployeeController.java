package home.demo.controller;

import home.demo.dto.EmployeeDto;
import lombok.val;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    @GetMapping(value = "acc/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") long employeeId) {
        val webMvcLinkBuilder = linkTo(
                methodOn(CsvController.class).getCsv(1_000_000L + employeeId));


        EmployeeDto employeeDto = new EmployeeDto("Hazbulah!", employeeId,
                webMvcLinkBuilder.toUri()
        );
        return ResponseEntity.ok(employeeDto);
    }
}
