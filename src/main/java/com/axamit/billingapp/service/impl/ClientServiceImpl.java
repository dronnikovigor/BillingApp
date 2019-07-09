package com.axamit.billingapp.service.impl;

import com.axamit.billingapp.model.Client;
import com.axamit.billingapp.repository.ClientRepository;
import com.axamit.billingapp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository repository;

    @Autowired
    public void setRepository(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Client> findAll() {
        return repository.findAll();
    }

    @Override
    public Iterable<Client> findByPhone(long phone) {
        return repository.findByPhone(phone);
    }

    @Override
    public Optional<Client> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void saveClient(Client client) {
        repository.save(client);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
