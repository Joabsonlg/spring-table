package com.joabsonlg.additenstable.controller;

import com.joabsonlg.additenstable.Agreement;
import com.joabsonlg.additenstable.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
    @GetMapping
    public String index(Model model) {
        model.addAttribute("agreement", new Agreement());
        return "index";
    }

    @PostMapping("/client/add")
    public String addClient(Agreement agreement, String newClientName, Model model) {
        Client client = new Client();
        client.setName(newClientName);
        client.setId(agreement.getClients().size() + 1L);
        agreement.getClients().add(client);
        model.addAttribute("agreement", agreement);
        return "index :: listClient";
    }

    @PostMapping("/client/remove")
    public String removeClient(Agreement agreement, String clientToRemove, Model model) {
        agreement.getClients().removeIf(client -> client.getName().equals(clientToRemove));
        return "index :: listClient";
    }
}
