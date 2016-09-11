package ru.mrchebik.data;

import ru.mrchebik.model.TelephoneNumber;

import java.util.List;

/**
 * Created by mrchebik on 05.09.16.
 */
public interface TelephoneNumberRepository {
    List<TelephoneNumber> findTelephoneNumbers();
    String editNumber(final String type, final String data, final long id);
}
