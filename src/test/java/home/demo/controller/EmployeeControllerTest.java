package home.demo.controller;

import lombok.SneakyThrows;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ImportAutoConfiguration(classes = {
        ServletWebServerFactoryAutoConfiguration.class,
})
class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        assertNotNull(mockMvc);
    }

    @Test
    @SneakyThrows
    void getCsv() {
        mockMvc.perform(get("/employee/acc/1234")
//                        .header("X-Forwarded-Host", "some-crazy-host.com")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(CoreMatchers.containsString("")));
    }

}