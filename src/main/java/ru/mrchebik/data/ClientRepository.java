package ru.mrchebik.data;

import ru.mrchebik.model.Client;

import java.util.List;

/**
 * Created by mrchebik on 05.09.16.
 */
public interface ClientRepository {
    List<Client> findClients();
}
