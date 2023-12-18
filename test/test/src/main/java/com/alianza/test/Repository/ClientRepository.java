package com.alianza.test.Repository;

import com.alianza.test.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

    public Client findBySharedKey(String businessId);
}
