package ru.mrchebik.web;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.mrchebik.data.ClientRepository;
import ru.mrchebik.data.TelephoneNumberRepository;
import ru.mrchebik.model.Client;
import ru.mrchebik.model.TelephoneNumber;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by mrchebik on 05.09.16.
 */
@org.springframework.stereotype.Controller
@RequestMapping("/test")
public class Controller {
    private ClientRepository clientRepository;
    private TelephoneNumberRepository telephoneNumberRepository;

    public Controller() {

    }

    @Autowired
    public Controller(ClientRepository clientRepository,
                      TelephoneNumberRepository telephoneNumberRepository) {
        this.clientRepository = clientRepository;
        this.telephoneNumberRepository = telephoneNumberRepository;
    }

    @RequestMapping(value = "/page", method = GET)
    public String page(Model model) {
        List<Client> clients = new ArrayList<>(clientRepository.findClients());
        List<TelephoneNumber> numbers = new ArrayList<>(telephoneNumberRepository.findTelephoneNumbers());

        model.addAttribute("clients", clients);
        model.addAttribute("numbers", numbers);

        return "page";
    }

    @RequestMapping(value = "/page", method = POST)
    @ResponseBody
    public String page(@RequestBody String data) {
        JSONObject jsonObject = new JSONObject(data);
        return telephoneNumberRepository.editNumber(jsonObject.getString("type"), jsonObject.getString("data"), jsonObject.getLong("id"));
    }
}