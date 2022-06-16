//package com.example.bookstore.controllers;
//
//import com.example.bookstore.dao.PublisherEntity;
//import com.example.bookstore.mapper.PublisherToEntityMapper;
//import com.example.bookstore.model.Publisher;
//import com.example.bookstore.repository.PublisherRepository;
//import com.example.bookstore.service.PublisherService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController()
//@RequestMapping("/publisher")
//@RequiredArgsConstructor
//public class PublisherController {
//
//
//    private final PublisherToEntityMapper mapper;
//    private final PublisherService publisherService;
//
//    @GetMapping("/{id}")
//    public Client getClientById(@PathVariable Long id) {
//        return clientService.getClientById(id);
//    }
//
//    @PostMapping(path = "/add")
//    public @ResponseBody
//    String addClient(@RequestParam String username, @RequestParam String email) {
//        ClientEntity n = new ClientEntity();
//        n.setEmail(email);
//        n.setUsername(username);
//        clientRepository.save(n);
//        return "Saved";
//    }
//
//    @GetMapping
//    public List<Client> getAllClients(@RequestParam(required = false) String username) {
//        if (username != null)
//            return clientService.findByUsername(username);
//
//        return clientService.getAllClients();
//    }
//
//    @PostMapping("/{id}/remove")
//    public String deleteClient(@PathVariable(value = "id") long id) {
//        ClientEntity client = clientRepository.findById(id).orElseThrow();
//        clientRepository.delete(client);
//        return "redirect:/";
//    }
//}
