package ru.mrchebik.repository;

import org.springframework.data.repository.CrudRepository;
import ru.mrchebik.model.Client;

import java.util.List;

/**
 * Created by mrchebik on 16.09.16.
 */
public interface ClientRepository extends CrudRepository<Client, Long> {
    List<Client> findClientsWherePhoneLike(String phone);
}
