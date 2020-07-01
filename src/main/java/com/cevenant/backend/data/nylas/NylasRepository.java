package com.cevenant.backend.data.nylas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NylasRepository extends JpaRepository<Nylas, Long> {

}
