package in.mk.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.mk.binding.Contact;

public interface ContactRepo extends JpaRepository<Contact, Integer> {

}
