package br.edu.ifal.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "feedback")
public class ReceberFeedback extends Usuario {
	
	private String mensagemDoUsuario;
	@CreationTimestamp
	private LocalDateTime dataDeEnvio;
	
	public String getMensagemDoUsuario() {
		return mensagemDoUsuario;
	}
	public void setMensagemDoUsuario(String mensagemDoUsuario) {
		this.mensagemDoUsuario = mensagemDoUsuario;
	}
	public LocalDateTime getDataDeEnvio() {
		return dataDeEnvio;
	}
	public void setDataDeEnvio(LocalDateTime dataDeEnvio) {
		this.dataDeEnvio = dataDeEnvio;
	}
	
	
	
}
