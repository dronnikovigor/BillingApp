package com.axamit.billingapp.repository;
import com.axamit.billingapp.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
    Iterable<Client> findByPhone(long phone);
}
