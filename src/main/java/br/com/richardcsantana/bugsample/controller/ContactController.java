package br.com.richardcsantana.bugsample.controller;

import br.com.richardcsantana.bugsample.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author richardsantana
 */
@Slf4j
@RestController
@RequestMapping(path = "/contact")
public class ContactController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contact save(@Valid @RequestBody Contact contact){
      log.info("contact: {} saved",contact);
      return contact;
    }
}
