package com.axamit.billingapp.controller;

import com.axamit.billingapp.model.Client;
import com.axamit.billingapp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClientController {

    private ClientService service;

    @Autowired
    public void setClientService(ClientService service) {
        this.service = service;
    }
    /**
     * Redirect to /clients if / requested.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        return "redirect:/clients";
    }
    /**
     * Load the new client page.
     *
     * @param model
     * @return
     */
    @GetMapping("client/new")
    public String newClient(Model model) {
        model.addAttribute("client", new Client());
        return "clientform";
    }

    /**
     * Create a new client.
     *
     * @param client
     * @param model
     * @return
     */
    @PostMapping("/client")
    public String createClient(Client client, Model model) {
        service.saveClient(client);
        return "redirect:/client/" + client.getId();
    }

    /**
     * Get a client by ID.
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/client/{id}")
    public String getClientById(@PathVariable Long id, Model model) {
        model.addAttribute("client", service.findById(id).orElse(new Client()));
        return "client";
    }

    /**
     * Get all clients.
     *
     * @param model
     * @return
     */
    @GetMapping("/clients")
    public String getClients(Model model) {
        model.addAttribute("clients", service.findAll());
        return "clients";
    }

    /**
     * Load the edit client page for the client with the specified ID.
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/client/edit/{id}")
    public String editClient(@PathVariable Long id, Model model) {
        model.addAttribute("client", service.findById(id).orElse(new Client()));
        return "clientform";
    }

    /**
     * Update a client.
     *
     * @param client
     * @return
     */
    @PostMapping("/client/{id}")
    public String updateClient(Client client) {
        service.saveClient(client);
        return "redirect:/client/" + client.getId();
    }

    /**
     * Delete a client by ID.
     *
     * @param id
     * @return
     */
    @GetMapping("/client/delete/{id}")
    public String deleteClient(@PathVariable long id) {
        service.deleteById(id);
        return "redirect:/clients";
    }

    /**
     * Search clients by Phone.
     *
     * @param phone
     * @param model
     * @return
     */
    @PostMapping("/clients/search")
    public String searchClientByPhone(@RequestParam(value="phone", required=false) Long phone, Model model) {
        if (phone != null) {
            Iterable<Client> clientList = service.findByPhone(phone);
            model.addAttribute("clients", clientList);
        }
        else
            model.addAttribute("clients", service.findAll());
        return "clients";
    }
}
