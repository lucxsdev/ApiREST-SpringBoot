package com.lucas.pdv.backend.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Venda implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer idProduto;
	private String  nomeProduto;
	private String  dataVenda;
	private Integer valorAvista;
	private Integer valorAprazo;
	private Integer valorUnitario;
	private Integer quantidade;
	private Integer valorParcial;
	private String  formaPagamento;
	private Integer valorPago;
	private Integer valorTroco;
	
	public Venda(){
		
	}

	
	public Venda(Integer id, Integer idProduto, String nomeProduto, String dataVenda, Integer valorAvista,
			Integer valorAprazo, Integer valorUnitario, Integer quantidade, Integer valorParcial, String formaPagamento,
			Integer valorPago, Integer valorTroco) {
		super();
		this.id = id;
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.dataVenda = dataVenda;
		this.valorAvista = valorAvista;
		this.valorAprazo = valorAprazo;
		this.valorUnitario = valorUnitario;
		this.quantidade = quantidade;
		this.valorParcial = valorParcial;
		this.formaPagamento = formaPagamento;
		this.valorPago = valorPago;
		this.valorTroco = valorTroco;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Integer getValorAvista() {
		return valorAvista;
	}

	public void setValorAvista(Integer valorAvista) {
		this.valorAvista = valorAvista;
	}

	public Integer getValorAprazo() {
		return valorAprazo;
	}

	public void setValorAprazo(Integer valorAprazo) {
		this.valorAprazo = valorAprazo;
	}

	public Integer getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Integer valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getValorParcial() {
		return valorParcial;
	}

	public void setValorParcial(Integer valorParcial) {
		this.valorParcial = valorParcial;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Integer getValorPago() {
		return valorPago;
	}

	public void setValorPago(Integer valorPago) {
		this.valorPago = valorPago;
	}

	public Integer getValorTroco() {
		return valorTroco;
	}

	public void setValorTroco(Integer valorTroco) {
		this.valorTroco = valorTroco;
	}
	
	public String getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(String dataVenda) {
		this.dataVenda = dataVenda;
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
		Venda other = (Venda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
