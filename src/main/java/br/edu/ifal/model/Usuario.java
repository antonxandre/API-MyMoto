package br.edu.ifal.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nome;
	private String login;
	@Column(name = "email", unique = true)
	private String email;
	private String telefone;
	private String senha;
	@OneToMany
	private List<Moto> motos;

	@CreationTimestamp
	private LocalDateTime dataDeCriacao;

	@UpdateTimestamp
	private LocalDateTime dataDeAlteracao;

	public Usuario() {

	}

	public Usuario(long id, String nome, String email) {
		this.id = id;
		this.nome = nome;
		this.email = email;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Moto> getMotos() {
		return motos;
	}

	public void setMotos(List<Moto> motos) {
		this.motos = motos;
	}

	public LocalDateTime getDataDeCriacao() {
		return dataDeCriacao;
	}

	public void setDataDeCriacao(LocalDateTime dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}

	public LocalDateTime getDataDeAlteracao() {
		return dataDeAlteracao;
	}

	public void setDataDeAlteracao(LocalDateTime dataDeAlteracao) {
		this.dataDeAlteracao = dataDeAlteracao;
	}

}
