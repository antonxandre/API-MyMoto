package br.edu.ifal.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotEmpty(message = "Nome vazio")
	private String nome;
	@NotEmpty(message = "Login vazio")
	private String login;
	@NotEmpty(message = "Email vazio")
	@Email
	@Column(name = "email", unique = true)
	private String email;
	@Column(name = "tokenUid", unique = true)
	private String tokenUid;
	private String telefone;
	@NotEmpty(message = "Senha vazio")
	@Size(min = 6, max = 50, message = "A senha deve ter mais de 6 caracteres")
	private String senha;

	@OneToOne(cascade = CascadeType.ALL)
	private Moto moto;

	@CreationTimestamp
	private LocalDateTime dataDeCriacao;

	@UpdateTimestamp
	private LocalDateTime dataDeAlteracao;

	public Usuario() {

	}

	public Usuario(final long id, final String nome, final String email) {
		this.id = id;
		this.nome = nome;
		this.email = email;

	}

	// getter setters

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(final String login) {
		this.login = login;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(final String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(final String senha) {
		this.senha = senha;
	}

	public LocalDateTime getDataDeCriacao() {
		return dataDeCriacao;
	}

	public void setDataDeCriacao(final LocalDateTime dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}

	public LocalDateTime getDataDeAlteracao() {
		return dataDeAlteracao;
	}

	public void setDataDeAlteracao(final LocalDateTime dataDeAlteracao) {
		this.dataDeAlteracao = dataDeAlteracao;
	}

	public Moto getMoto() {
		return moto;
	}

	public void setMoto(final Moto moto) {
		this.moto = moto;
	}

}
