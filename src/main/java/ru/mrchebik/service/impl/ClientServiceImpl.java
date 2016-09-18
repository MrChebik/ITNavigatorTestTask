package ru.mrchebik.service.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mrchebik.model.Client;
import ru.mrchebik.repository.ClientRepository;
import ru.mrchebik.service.ClientService;

import java.util.List;

/**
 * Created by mrchebik on 18.09.16.
 */
@Service
@Repository
@Transactional
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAll() {
        return Lists.newArrayList(clientRepository.findAll());
    }
}
