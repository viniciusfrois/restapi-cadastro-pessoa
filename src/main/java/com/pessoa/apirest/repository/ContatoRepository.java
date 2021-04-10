package com.pessoa.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pessoa.apirest.models.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>{

	
}
