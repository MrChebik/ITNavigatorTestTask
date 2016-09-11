package ru.mrchebik.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mrchebik.data.TelephoneNumberRepository;
import ru.mrchebik.model.TelephoneNumber;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by mrchebik on 05.09.16.
 */
@Service
@Transactional
public class TelephoneNumberDAO extends DAO implements TelephoneNumberRepository {
    @Override
    public List<TelephoneNumber> findTelephoneNumbers() {
        begin();
        try {
            Query query = getSession().createQuery("select TN.number, TN.type, TN.comment from ru.mrchebik.model.TelephoneNumber TN");
            List<TelephoneNumber> numbers = new ArrayList<TelephoneNumber>();
            Iterator itr = query.list().iterator();
            while (itr.hasNext()) {
                Object[] objects = (Object[]) itr.next();

                String number = String.valueOf(objects[0]);
                String type = String.valueOf(objects[1]);
                String comment = String.valueOf(objects[2]);

                numbers.add(new TelephoneNumber(number, type, comment));
            }
            return numbers;
        } finally {
            commit();
            close();
        }
    }

    @Override
    public String editNumber(final String type, final String data, final long id) {

        begin();
        try {
            getSession().createQuery("update ru.mrchebik.model.TelephoneNumber set " + type + " = :data where id = :id").setString("data", data).setLong("id", id).executeUpdate();
            return "OK";
        } catch (Exception e) {
            return "ERROR";
        } finally {
            commit();
            close();
        }
    }
}
