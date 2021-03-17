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

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
public class SecondCalculatorTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("Calculator2 returns JSON object with correct values")
    void testReturnsJSON() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/calculator/calculate2?input=1,2,3"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.maxOdd").doesNotHaveJsonPath())
                .andExpect(jsonPath("$.sum").doesNotHaveJsonPath())
                .andExpect(jsonPath("$.averageOfEven").value(2))
                .andExpect(jsonPath("$.positives").exists())
                .andExpect(jsonPath("$.positives", hasSize(3)))
                .andExpect(jsonPath("$.positives", hasItem(1)))
                .andExpect(jsonPath("$.positives", hasItem(2)))
                .andExpect(jsonPath("$.positives", hasItem(3)))
                .andExpect(jsonPath("$.absolutes").exists())
                .andExpect(jsonPath("$.absolutes", hasSize(3)))
                .andExpect(jsonPath("$.absolutes", hasItem(1)))
                .andExpect(jsonPath("$.absolutes", hasItem(2)))
                .andExpect(jsonPath("$.absolutes", hasItem(3)));
    }

    @Test
    @DisplayName("Calculator2 returns correct output for negative numbers")
    void testNegatives() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/calculator/calculate2?input=-11,-2,-3,-5,-1"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.maxOdd").doesNotHaveJsonPath())
                .andExpect(jsonPath("$.sum").doesNotHaveJsonPath())
                .andExpect(jsonPath("$.positives").doesNotHaveJsonPath())
                .andExpect(jsonPath("$.averageOfEven").value(-2))
                .andExpect(jsonPath("$.absolutes").exists())
                .andExpect(jsonPath("$.absolutes", hasSize(5)))
                .andExpect(jsonPath("$.absolutes", hasItem(11)))
                .andExpect(jsonPath("$.absolutes", hasItem(2)))
                .andExpect(jsonPath("$.absolutes", hasItem(3)))
                .andExpect(jsonPath("$.absolutes", hasItem(5)))
                .andExpect(jsonPath("$.absolutes", hasItem(1)));
    }

    @Test
    @DisplayName("Calculator2 returns correct output for mixed numbers")
    void testMixed() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/calculator/calculate2?input=11,-2,3,-5,-1"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.maxOdd").doesNotHaveJsonPath())
                .andExpect(jsonPath("$.sum").doesNotHaveJsonPath())
                .andExpect(jsonPath("$.averageOfEven").value(-2))
                .andExpect(jsonPath("$.positives").exists())
                .andExpect(jsonPath("$.positives", hasSize(2)))
                .andExpect(jsonPath("$.positives", hasItem(11)))
                .andExpect(jsonPath("$.positives", hasItem(3)))
                .andExpect(jsonPath("$.absolutes").exists())
                .andExpect(jsonPath("$.absolutes", hasSize(5)))
                .andExpect(jsonPath("$.absolutes", hasItem(11)))
                .andExpect(jsonPath("$.absolutes", hasItem(2)))
                .andExpect(jsonPath("$.absolutes", hasItem(3)))
                .andExpect(jsonPath("$.absolutes", hasItem(5)))
                .andExpect(jsonPath("$.absolutes", hasItem(1)));
    }

    @Test
    @DisplayName("Calculator2 returns error 400 when input is missing")
    void testNoParams() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/calculator/calculate2"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    @DisplayName("Calculator2 returns empty response when input is empty")
    void testNullValue() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/calculator/calculate1?input="))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$").doesNotExist());
    }


}
