package com.projetoGerenciamento.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	private String nome;
	
	@NotNull
	@NotBlank
	@Size (min=8 ,message= "Escreva seu numero corretamente")
	private String telefone;
	
	@NotNull
	@NotBlank
	@Size (min=11 ,message= "Escreva seu cpf corretamente")
	private String cpf;
	
	@NotNull
	@NotBlank
	@Size (min=12 ,message= "Escreva seu rg corretamente")
	private String rg;
	
	@NotNull
	@NotBlank
	private String endereco;
}