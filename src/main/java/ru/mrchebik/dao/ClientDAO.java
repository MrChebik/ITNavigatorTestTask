package ru.mrchebik.dao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mrchebik.data.ClientRepository;
import ru.mrchebik.model.Client;

import java.util.List;

/**
 * Created by mrchebik on 05.09.16.
 */
@Service
@Transactional
public class ClientDAO extends DAO implements ClientRepository {
    @Override
    public List<Client> findClients() {
        begin();
        try {
            return getSession().createQuery("from ru.mrchebik.model.Client").list();
        } finally {
            commit();
            close();
        }
    }
}
