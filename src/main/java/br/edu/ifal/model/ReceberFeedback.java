package br.edu.ifal.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "feedback")
public class ReceberFeedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String mensagemDoUsuario;
	private String informacoesDoAparelho;
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getInformacoesDoAparelho() {
		return informacoesDoAparelho;
	}
	public void setInformacoesDoAparelho(String informacoesDoAparelho) {
		this.informacoesDoAparelho = informacoesDoAparelho;
	}
	
	
}
