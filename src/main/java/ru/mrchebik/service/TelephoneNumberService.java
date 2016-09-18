package ru.mrchebik.service;

import ru.mrchebik.model.TelephoneNumber;

import java.util.List;

/**
 * Created by mrchebik on 18.09.16.
 */
public interface TelephoneNumberService {
    List<TelephoneNumber> getAll();
    String update(TelephoneNumber telephoneNumber);
}
