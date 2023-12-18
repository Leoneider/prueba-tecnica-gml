package com.alianza.test.Controller;

import com.alianza.test.Dto.ClientDto;
import com.alianza.test.Entity.Client;
import com.alianza.test.Services.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;


@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT})
public class ClientController {

    @Autowired
    private ClientService clientService;

    Logger log = LoggerFactory.getLogger(ClientController.class);

    @GetMapping("/client")
    public ResponseEntity<List<Client>> getClients(){

        log.info("ClientController.getClients");
        try{

           List<Client> clients = clientService.getClients();
            return new ResponseEntity<>(clients, HttpStatus.OK);
        } catch (Exception e){
            log.error("ClientController.getClients: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/client/{businessId}")
    public ResponseEntity<Client> getClientByBusinessId(@PathVariable String businessId){

            log.info("ClientController.getClientByBusinessId: {}", businessId);

            Client client = clientService.getClientBySharedKey(businessId);

            if(client == null) {
                log.info("Client not exist: {}", businessId);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(client, HttpStatus.OK);


    }


    @PostMapping("/client")
    public ResponseEntity<ClientDto> createClient(@RequestBody ClientDto client){

        log.info("ClientController.createClient: {}", client.toString());
        try{
            Client clientSave =  clientService.saveClient(client);
            ClientDto clientDto = new ClientDto();
            clientDto.setId(clientSave.getId());
            clientDto.setName(clientSave.getName());
            clientDto.setEmail(clientSave.getEmail());
            clientDto.setPhone(clientSave.getPhone());
            clientDto.setStartDate(clientSave.getStartDate());
            clientDto.setEndDate(clientSave.getEndDate());

            return new ResponseEntity<>(clientDto, HttpStatus.OK);
        } catch (Exception e){
            log.error("ClientController.createClient: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/client/{businessId}")
    public ResponseEntity<ClientDto> updateClient(@PathVariable Long businessId, @RequestBody ClientDto client){

        log.info("ClientController.updateClient: {}", client.toString());
        try{
            Client clientSave =  clientService.updateClient(businessId, client);
            ClientDto clientDto = new ClientDto();
            clientDto.setId(clientSave.getId());
            clientDto.setName(clientSave.getName());
            clientDto.setEmail(clientSave.getEmail());
            clientDto.setPhone(clientSave.getPhone());
            clientDto.setStartDate(clientSave.getStartDate());
            clientDto.setEndDate(clientSave.getEndDate());

            return new ResponseEntity<>(clientDto, HttpStatus.OK);
        } catch (Exception e){
            log.error("ClientController.updateClient: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
