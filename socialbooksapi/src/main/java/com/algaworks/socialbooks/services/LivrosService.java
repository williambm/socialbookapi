package com.algaworks.socialbooks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.socialbooks.domain.Livro;
import com.algaworks.socialbooks.repository.LivrosRepository;
import com.algaworks.socialbooks.services.exceptions.LivroNaoEncontradoException;

@Service
public class LivrosService {

	@Autowired
	private LivrosRepository livrosRepository;	
	
	public List<Livro> listar(){
		return livrosRepository.findAll();
	}
	
	public Livro buscar(Long id) {
		Livro livro = livrosRepository.findById(id).orElse(null);
		
		if(livro==null) {
			throw new LivroNaoEncontradoException("O livro não pôde ser encontrado.");
		}
		
		return livro;
	}
	
	public Livro salvar(Livro livro) {
		livro.setId(null);
		return livrosRepository.save(livro);				
	}
	
	public void deletar(Long id) {
		try {
			livrosRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new LivroNaoEncontradoException("O livro não pôde ser encontrado.");
		}		
	}
	
	public void atualizar(Livro livro) {
		verificarExistencia(livro);
		livrosRepository.save(livro);
	}
	
	/**
	 * Método interno do Service que auxilia na atualização de um livro
	 * criado para tornar o código mais legivel
	 * @param livro
	 */
	private void verificarExistencia(Livro livro) {
		buscar(livro.getId());		
	}
}