package com.algaworks.socialbooks.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.algaworks.socialbooks.domain.DetalhesErro;
import com.algaworks.socialbooks.services.exceptions.AutorExistenteException;
import com.algaworks.socialbooks.services.exceptions.AutorNaoEncontradoException;
import com.algaworks.socialbooks.services.exceptions.LivroNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(LivroNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleLivroNaoEncontradoException
		(LivroNaoEncontradoException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("O livro não pôde ser encontrado");
		//dentro de um portal de documetação ter area Destianda para erros e possíveis soluções (Boas práticas)
		erro.setMensagemDesenvolvedor("http://portaldeerrosdaAPI.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		erro.setDataFormatada(erro.formataData(erro.getTimestamp()));
			
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);		
	}
	
	@ExceptionHandler(AutorExistenteException.class)
	public ResponseEntity<DetalhesErro> handleAutorExistenteException
		(AutorExistenteException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("Autor já existênte");
		//dentro de um portal de documetação ter area Destianda para erros e possíveis soluções (Boas práticas)
		erro.setMensagemDesenvolvedor("http://portaldeerrosdaAPI.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		erro.setDataFormatada(erro.formataData(erro.getTimestamp()));
			
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);		
	}
	
	@ExceptionHandler(AutorNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleLivroNaoEncontradoException
		(AutorNaoEncontradoException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("Este autor não pôde ser localizado");
		//dentro de um portal de documetação ter area Destianda para erros e possíveis soluções (Boas práticas)
		erro.setMensagemDesenvolvedor("http://portaldeerrosdaAPI.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		erro.setDataFormatada(erro.formataData(erro.getTimestamp()));
			
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);		
	}
		
		@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<DetalhesErro> handleDataIntegrityViolationException
		(DataIntegrityViolationException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(400l);
		erro.setTitulo("Requisição Inválida");
		//dentro de um portal de documetação ter area Destianda para erros e possíveis soluções (Boas práticas)
		erro.setMensagemDesenvolvedor("http://portaldeerrosdaAPI.com/400");
		erro.setTimestamp(System.currentTimeMillis());
		erro.setDataFormatada(erro.formataData(erro.getTimestamp()));
			
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);		
	}
}
