package com.projetoGerenciamento.repository;
	
import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoGerenciamento.entities.Cliente;

		public interface ClienteRepository extends JpaRepository<Cliente, Long>{
			
		}
