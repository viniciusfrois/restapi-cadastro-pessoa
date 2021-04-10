package com.pessoa.apirest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pessoa.apirest.models.Pessoa;
import com.pessoa.apirest.repository.PessoaRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Pessoas")
@CrossOrigin(origins="*")
public class PessoaController {
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@GetMapping("/pessoas")
	@ApiOperation(value="Retorna uma lista com TODOS Cadastros")
	public List<Pessoa> listaPessoas(){
		return pessoaRepository.findAll();
	}
	
	@GetMapping("/pessoa/{id}")
	@ApiOperation(value="Retorna apenas um Cadastro atraves do ID")
	public Pessoa listaApenasUm(@PathVariable(value="id")long id){
		return pessoaRepository.findById(id);
	}
	
	@PostMapping("/pessoa")
	@ApiOperation(value="Inserir um novo Cadastro")
	public Pessoa salvaPessoa(@Valid @RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	@DeleteMapping("/pessoa")
	@ApiOperation(value="Deletar um Cadastro")
	public void deletaPessoa(@RequestBody Pessoa pessoa) {
		 pessoaRepository.delete(pessoa);
	}

	@PutMapping("/pessoa")
	@ApiOperation(value="Atualizar um Cadastro")
	public Pessoa atualizaPessoa(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}	
	
	
}
