package in.mk.service;
import org.springframework.stereotype.Service;

import in.mk.binding.Contact;
import in.mk.repo.ContactRepo;

import java.util.List;

@Service
public class ContactService {
    private final ContactRepo repository;

    public ContactService(ContactRepo repository) {
        this.repository = repository;
    }
    
    public Contact getContactById(Integer id) {
        return repository.findById(id).orElse(null);
    }
    public List<Contact> getAllContacts() {
        return repository.findAll();
    }
    public Contact createContact(Contact contact) {
        return repository.save(contact);
    }
    public Contact updateContact(Integer id, Contact contact) {
        Contact existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setContactName(contact.getContactName());
            existing.setContactEmail(contact.getContactEmail());
            existing.setContactPhone(contact.getContactPhone());
            return repository.save(existing);
        }
        return null;
    }

    public void deleteContact(Integer id) {
        repository.deleteById(id);
    }


}