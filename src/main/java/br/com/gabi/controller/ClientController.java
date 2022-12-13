package br.com.gabi.controller;

import br.com.gabi.model.entity.Client;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    @GetMapping( "/anyone")
    public Client getClient() {
        return new Client(28, "Pedro", "123.456.789-00");
    }

    @GetMapping("/{id}")
    public Client getClientByIdPath(@PathVariable int id) {
        return new Client(id, "Teste", "123.456.789-00");
    }

    @GetMapping
    public Client getClientByIdRequest(@RequestParam(name = "id", defaultValue = "1") int id) {
        return new Client(id, "Teste2", "123.456.789-00");
    }
}
