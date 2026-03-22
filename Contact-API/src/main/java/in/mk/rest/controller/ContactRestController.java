package in.mk.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.mk.binding.Contact;
import in.mk.service.ContactService;

@RestController
@CrossOrigin
public class ContactRestController {
	
    private  ContactService service;

    public ContactRestController(ContactService service) {
        this.service = service;
    }

    @GetMapping("/contacts")
    public List<Contact> getContacts() {
        return service.getAllContacts();
    }
    
    @GetMapping("/contact/{id}")
    public Contact getContact(@PathVariable Integer id) {
        return service.getContactById(id);
    }


    @PostMapping("/save")
    public Contact createContact(@RequestBody Contact contact) {
    	System.out.println("[ContactRestController :: createContact]");
        return service.createContact(contact);
    }
    @PutMapping("/{id}")
    public Contact updateContact(@PathVariable Integer id, @RequestBody Contact contact) {
        return service.updateContact(id, contact);
    }

    @DeleteMapping("/contact/{id}")
    public void deleteContact(@PathVariable Integer id) {
        service.deleteContact(id);
    }


}