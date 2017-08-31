package br.com.richardcsantana.bugsample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.awt.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BugSampleApplicationTests {
    @Autowired
    private MockMvc mvc;

    @Test
    public void sucessCase() throws Exception {
        String content = "{\"name\":\"teste\",\"telephone\":\"99999-9999\"}";
        this.mvc.perform(post("/contact").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(content).accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isCreated());
    }

    @Test
    public void nameBelowMinValidation() throws Exception {
        String content = "{\"name\":\"te\",\"telephone\":\"99999-9999\"}";
        this.mvc.perform(post("/contact").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(content).accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void nameAboveMaxValidation() throws Exception {
        String content = "{\"name\":\"testetestetestet\",\"telephone\":\"99999-9999\"}";
        this.mvc.perform(post("/contact").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(content).accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void telephoneAlphanumericValidation() throws Exception {
        String content = "{\"name\":\"teste\",\"telephone\":\"abscsods\"}";
        this.mvc.perform(post("/contact").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(content).accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void telephonePatternValidation() throws Exception {
        String content = "{\"name\":\"teste\",\"telephone\":\"999999999\"}";
        this.mvc.perform(post("/contact").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(content).accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isBadRequest());
    }
}
