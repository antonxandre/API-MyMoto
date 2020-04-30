package br.edu.ifal.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "modelos_motos")
public class MotoModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private String marca;
    private String modelo;
    private int cilindradas;
    private double km_max_troca_oleo;
    private double km_max_acelerador;
    private double km_max_vela;
    private double km_max_freio;
    private double km_max_embreagem;
    private double km_max_pneus;
    private double km_max_suspensao;
    

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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    public double getKm_max_troca_oleo() {
        return km_max_troca_oleo;
    }

    public void setKm_max_troca_oleo(double km_max_troca_oleo) {
        this.km_max_troca_oleo = km_max_troca_oleo;
    }

    public double getKm_max_acelerador() {
        return km_max_acelerador;
    }

    public void setKm_max_acelerador(double km_max_acelerador) {
        this.km_max_acelerador = km_max_acelerador;
    }

    public double getKm_max_vela() {
        return km_max_vela;
    }

    public void setKm_max_vela(double km_max_vela) {
        this.km_max_vela = km_max_vela;
    }

    public double getKm_max_freio() {
        return km_max_freio;
    }

    public void setKm_max_freio(double km_max_freio) {
        this.km_max_freio = km_max_freio;
    }

    public double getKm_max_embreagem() {
        return km_max_embreagem;
    }

    public void setKm_max_embreagem(double km_max_embreagem) {
        this.km_max_embreagem = km_max_embreagem;
    }

    public double getKm_max_pneus() {
        return km_max_pneus;
    }

    public void setKm_max_pneus(double km_max_pneus) {
        this.km_max_pneus = km_max_pneus;
    }

    public double getKm_max_suspensao() {
        return km_max_suspensao;
    }

    public void setKm_max_suspensao(double km_max_suspensao) {
        this.km_max_suspensao = km_max_suspensao;
    }
    
    //private String manual;

    // @CreationTimestamp
    // private LocalDateTime dataDeCriacao;

    // @UpdateTimestamp
    // private LocalDateTime dataDeAlteracao;

    
    

}
