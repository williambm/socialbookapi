package com.algaworks.socialbooks.domain;

import java.text.SimpleDateFormat;

public class DetalhesErro {

	private String titulo;
	
	private Long status;
	
	private Long timestamp;
	
	private String dataFormatada;
	
	public String getDataFormatada() {
		return dataFormatada;
	}

	public void setDataFormatada(String dataFormatada) {
		this.dataFormatada = dataFormatada;
	}

	private String mensagemDesenvolvedor;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getMensagemDesenvolvedor() {
		return mensagemDesenvolvedor;
	}

	public void setMensagemDesenvolvedor(String mensagemDesenvolvedor) {
		this.mensagemDesenvolvedor = mensagemDesenvolvedor;
	}
	
	public String formataData(Long timestamp) {
		String data = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(timestamp);		
		return data;
	}
	
}
