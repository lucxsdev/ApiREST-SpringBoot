package com.lucas.pdv.backend.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Servico implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String  descricao;
	private double  valorCusto;
	private double  lucroAvista;
	private double  lucroAprazo;
	private double  valorAvista;
	private double  valorAprazo;
	private Integer quantidade = 1;
	private double  totalCusto;
	
	public Servico() {
		
	}

	public Servico(Integer id, String descricao, double valorCusto, double lucroAvista, double lucroAprazo,Integer quantidade) {
		super();
		
		this.id = id;
		this.descricao = descricao;
		this.valorCusto = valorCusto;
		this.lucroAvista = lucroAvista;
		this.lucroAprazo = lucroAprazo;
		this.setValorAvista(this.getValorCusto() * (this.getLucroAvista() / 100) + this.getValorCusto()); 
		this.setValorAprazo(this.getValorCusto() * (this.getLucroAprazo() / 100) + this.getValorCusto());
		this.quantidade = quantidade;
		this.setTotalCusto(this.getValorCusto() * this.getQuantidade());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValorCusto() {
		return valorCusto;
	}

	public void setValorCusto(double valorCusto) {
		this.valorCusto = valorCusto;
	}

	public double getLucroAvista() {
		return lucroAvista;
	}

	public void setLucroAvista(double lucroAvista) {
		this.lucroAvista = lucroAvista;
	}

	public double getLucroAprazo() {
		return lucroAprazo;
	}

	public void setLucroAprazo(double lucroAprazo) {
		this.lucroAprazo = lucroAprazo;
	}

	public double getValorAvista() {
		return valorAvista;
	}

	public void setValorAvista(double valorAvista) {
		this.valorAvista = valorAvista;
	}

	public double getValorAprazo() {
		return valorAprazo;
	}

	public void setValorAprazo(double valorAprazo) {
		this.valorAprazo = valorAprazo;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public double getTotalCusto() {
		return totalCusto;
	}

	public void setTotalCusto(double totalCusto) {
		this.totalCusto = totalCusto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servico other = (Servico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}

















