package ee.ttu.cs.team12jakarta.project2.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.lang.reflect.Array;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
public class FirstCalculatorTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("First mock test")
    void testRoot() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string("Hello from the other side"));
    }

    @Test
    @DisplayName("Calculator1 returns JSON object and with correct values")
    void testJSON() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/calculator/calculate1?input=1,2,3"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.maxOdd").value(3))
                .andExpect(jsonPath("$.sum").value(6))
                .andExpect(jsonPath("$.absolutes").exists())
                .andExpect(jsonPath("$.absolutes[*]").isArray())
                .andExpect(jsonPath("$.absolutes[0]").value(1))
                .andExpect(jsonPath("$.absolutes[1]").value(2))
                .andExpect(jsonPath("$.absolutes[2]").value(3));


    //          Need help with making the next line of code run or I'll just go mad
    //          .andExpect(jsonPath("$.absolutes[*]").value(List.of(1,2,3)));
    }
}
