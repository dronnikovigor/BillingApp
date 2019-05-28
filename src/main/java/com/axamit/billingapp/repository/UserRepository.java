package com.axamit.billingapp.repository;
import com.axamit.billingapp.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    Iterable<User> findByPhone(long phone);
}
