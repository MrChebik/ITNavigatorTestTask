package ru.mrchebik.service.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mrchebik.model.Client;
import ru.mrchebik.model.TelephoneNumber;
import ru.mrchebik.repository.ClientRepository;
import ru.mrchebik.service.ClientService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrchebik on 18.09.16.
 */
@Service
@Repository
@Transactional
public class ClientServiceImpl implements ClientService {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAll() {
        return Lists.newArrayList(clientRepository.findAll());
    }

    @Override
    public List<Client> findClientsWherePhoneLike(String phone) {
        List<Client> result = new ArrayList<>();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        //get telephones
        CriteriaQuery<TelephoneNumber> cq = cb.createQuery(TelephoneNumber.class);
        Root<TelephoneNumber> c = cq.from(TelephoneNumber.class);

        cq.select(c).where(cb.like(c.get("number"), phone));

        List<TelephoneNumber> resultTelephoneNumber = em.createQuery(cq).getResultList();
        //get client
        for (int i = 0; i < resultTelephoneNumber.size(); i++) {
            CriteriaQuery<Client> query = cb.createQuery(Client.class);
            Root<Client> root = query.from(Client.class);

            query.select(root).where(cb.equal(c.get("id"), resultTelephoneNumber.get(i).getId()));

            List<Client> resultClient = em.createQuery(query).getResultList();

            result.add(resultClient.get(0));
        }
        return result;
    }
}
