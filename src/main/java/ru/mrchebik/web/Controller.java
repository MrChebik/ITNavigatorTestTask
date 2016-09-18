package ru.mrchebik.web;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.mrchebik.model.Client;
import ru.mrchebik.model.FullClient;
import ru.mrchebik.model.TelephoneNumber;
import ru.mrchebik.service.ClientService;
import ru.mrchebik.service.TelephoneNumberService;

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
    private ClientService clientService;
    private TelephoneNumberService telephoneNumberService;

    public Controller() {

    }

    @Autowired
    public Controller(ClientService clientService,
                      TelephoneNumberService telephoneNumberService) {
        this.clientService = clientService;
        this.telephoneNumberService = telephoneNumberService;
    }

    @RequestMapping(value = "/page", method = GET)
    public String page(Model model) {
        List<Client> clients = new ArrayList<>(clientService.getAll());
        List<TelephoneNumber> telephoneNumbers = new ArrayList<>(telephoneNumberService.getAll());
        List<FullClient> fullClients = new ArrayList<>();

        for (int i = 0; i < clients.size(); i++) {
            long id = clients.get(i).getId();
            String name = clients.get(i).getLastName() + " " + clients.get(i).getFirstName() + " " + clients.get(i).getMiddleName();
            String number = telephoneNumbers.get(i).getNumber();
            String type = telephoneNumbers.get(i).getType();
            String comment = telephoneNumbers.get(i).getComment();

            fullClients.add(new FullClient(id, name, number, type, comment));
        }

        model.addAttribute("fullClients", fullClients);

        return "page";
    }

    @RequestMapping(value = "/page", method = POST)
    @ResponseBody
    public String page(@RequestBody String data) {
        JSONObject jsonObject = new JSONObject(data);
        System.out.println(data);
        System.out.println(jsonObject.getLong("id") +
                jsonObject.getString("number") +
                jsonObject.getString("type") +
                jsonObject.getString("comment"));
        return telephoneNumberService.update(new TelephoneNumber(
                jsonObject.getLong("id"),
                jsonObject.getString("number"),
                jsonObject.getString("type"),
                jsonObject.getString("comment")));
    }
}
