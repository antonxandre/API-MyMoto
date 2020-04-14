package br.edu.ifal.model;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "motos")
public class Moto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nome;
    private String modelo;
    private String marca;
    private double cilindradas;

    @OneToOne
    private Usuario usuario;

    private double id_usuario;

    @CreationTimestamp
    private LocalDateTime dataDeCriacao;

    @UpdateTimestamp
    private LocalDateTime dataDeAlteracao;

    public Moto() {

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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(double cilindradas) {
        this.cilindradas = cilindradas;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public double getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(double id_usuario) {
        this.id_usuario = id_usuario;
    }

}