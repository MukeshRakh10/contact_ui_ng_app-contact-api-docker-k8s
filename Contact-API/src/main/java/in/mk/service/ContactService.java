package in.mk.service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
 @Transactional
    public Contact createContact(Contact contact) {

            Contact existing = repository.findById(contact.getContactId()).orElse(null);
        if (existing == null) {

                Contact obj = new Contact();

                obj.setContactName(contact.getContactName());
                obj.setContactEmail(contact.getContactEmail());
                obj.setContactPhone(contact.getContactPhone());
                return repository.save(obj);

        }else {

                existing.setContactName(contact.getContactName());
                existing.setContactEmail(contact.getContactEmail());
                existing.setContactPhone(contact.getContactPhone());

                return repository.save(existing);
       }

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
