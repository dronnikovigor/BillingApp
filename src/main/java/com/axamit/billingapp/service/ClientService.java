package com.axamit.billingapp.service;

import com.axamit.billingapp.model.Client;

import java.util.Optional;

public interface ClientService {
    Iterable<Client> findAll();
    Iterable<Client> findByPhone(long phone);
    Optional<Client> findById(Long id);
    void saveClient(Client client);
    void deleteById(Long id);
}
