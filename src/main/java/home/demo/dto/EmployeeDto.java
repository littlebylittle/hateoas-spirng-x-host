package home.demo.dto;


import lombok.NonNull;

import java.net.URI;

public record EmployeeDto(@NonNull String name, long id, URI linkToCsv) {
}
