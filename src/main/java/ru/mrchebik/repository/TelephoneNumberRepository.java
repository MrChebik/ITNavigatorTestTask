package ru.mrchebik.repository;

import org.springframework.data.repository.CrudRepository;
import ru.mrchebik.model.TelephoneNumber;

/**
 * Created by mrchebik on 17.09.16.
 */
public interface TelephoneNumberRepository extends CrudRepository<TelephoneNumber, Long> {
}
