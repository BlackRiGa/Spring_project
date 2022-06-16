package com.example.bookstore.controllers;

import com.example.bookstore.mapper.ClientToEntityMapper;
import com.example.bookstore.model.Client;
import com.example.bookstore.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @PostMapping(path="/add")
    public @ResponseBody String addClient (@RequestBody Client client) {
        clientService.addClient(client);
        return "Saved";
    }

    @GetMapping
    public List<Client> getAllClients(@RequestParam(required = false) String username) {
        if (username != null)
            return clientService.findByUsername(username);

        return clientService.getAllClients();
    }

    @PostMapping("/{id}/remove")
    public void deleteClient(@PathVariable(value="id") long id) {
        clientService.deleteClient(id);
    }
}
