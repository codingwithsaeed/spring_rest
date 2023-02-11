package com.ltp.contacts.web;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ltp.contacts.GenericResponse;
import com.ltp.contacts.pojo.Contact;
import com.ltp.contacts.service.ContactService;

@RestController
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping("/contact/all")
    public ResponseEntity<Object> getContacts() {
        List<Contact> contacts = contactService.getContacts();
        var response = new GenericResponse<>(true, contacts, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/contact/{id}")

    public ResponseEntity<Object> getContact(@PathVariable String id) {
        Contact contact = contactService.getContactById(id);
        var response = new GenericResponse<>(true, contact, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/contact")
    public ResponseEntity<Object> createContact(@Valid @RequestBody Contact contact) {
        contactService.saveContact(contact);
        var response = new GenericResponse<>(true, null, null);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/contact/{id}")
    public ResponseEntity<Object> updateContact(@PathVariable String id, @Valid @RequestBody Contact contact) {
        contactService.updateContact(id, contact);
        var response = new GenericResponse<>(true, contactService.getContactById(id), null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/contact/{id}")
    public ResponseEntity<Object> deleteContact(@PathVariable String id) {
        contactService.deleteContact(id);
        var response = new GenericResponse<>(true, null, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}