package br.edu.ifal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	public Usuario() {

	}

	public Usuario(long id, String nome, String email) {
		this.id = id;
		this.nome = nome;
		this.email = email;

	}
	// private String descricao;
	// private Date date;

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

	// public String getDescricao() {
	// return descricao;
	// }
	// public void setDescricao(String descricao) {
	// this.descricao = descricao;
	// }
	// public Date getDate() {
	// return date;
	// }
	// public void setDate(Date date) {
	// this.date = date;
	// }
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

}
