package ru.mrchebik.service.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mrchebik.model.TelephoneNumber;
import ru.mrchebik.repository.TelephoneNumberRepository;
import ru.mrchebik.service.TelephoneNumberService;

import java.util.List;

/**
 * Created by mrchebik on 18.09.16.
 */
@Service
@Repository
@Transactional
public class TelephoneNumberServiceImpl implements TelephoneNumberService {
    @Autowired
    private TelephoneNumberRepository telephoneNumberRepository;

    @Override
    public String update(TelephoneNumber telephoneNumber) {
        try {
            telephoneNumberRepository.save(telephoneNumber);
            return "OK";
        } catch (Exception e) {
            return "ERROR";
        }
    }

    @Override
    public List<TelephoneNumber> getAll() {
        return Lists.newArrayList(telephoneNumberRepository.findAll());
    }
}
