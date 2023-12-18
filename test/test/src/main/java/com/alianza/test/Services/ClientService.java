package com.alianza.test.Services;

import com.alianza.test.Dto.ClientDto;
import com.alianza.test.Entity.Client;
import com.alianza.test.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getClients() {
        List<Client> clients = clientRepository.findAll();
        return clients;
    }

    public Client getClientBySharedKey(String businessId) {
        Client client = clientRepository.findBySharedKey(businessId);
        return client;
    }

    public Client saveClient(ClientDto clientDto) {
        Client clientSave = new Client();


        clientSave.setName(clientDto.getName());
        clientSave.setEmail(clientDto.getEmail());
        clientSave.setPhone(clientDto.getPhone());
        clientSave.setStartDate(clientDto.getStartDate());
        clientSave.setEndDate(clientDto.getEndDate());
        clientSave.setSharedKey(clientDto.getName());
        clientSave.setBusinessId(clientDto.getName());



        Client client = clientRepository.save(clientSave);
        return client;
    }

    public Client updateClient(Long businessId, ClientDto clientDto) {

        Optional<Client> client = clientRepository.findById(businessId);

        if(!client.isPresent())
            return null;

        client.get().setName(clientDto.getName());
        client.get().setEmail(clientDto.getEmail());
        client.get().setPhone(clientDto.getPhone());
        client.get().setStartDate(clientDto.getStartDate());
        client.get().setEndDate(clientDto.getEndDate());
        client.get().setSharedKey(clientDto.getName());
        client.get().setBusinessId(clientDto.getName());

        Client clientSave = clientRepository.save(client.get());
        return clientSave;

    }

}
