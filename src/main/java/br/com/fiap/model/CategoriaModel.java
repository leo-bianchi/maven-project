package br.com.fiap.model;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CategoriaModel {

	private long idCategoria;
	private String nomeCategoria;
	private List<ProdutoModel> produtos;

	public CategoriaModel() {
	}

	public CategoriaModel(long idCategoria, String nomeCategoria, List<ProdutoModel> produtos) {
		super();
		this.idCategoria = idCategoria;
		this.nomeCategoria = nomeCategoria;
		this.produtos = produtos;
	}

	public long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}

	@NotNull(message = "Nome obrigatório")
	@Size(min = 2, max = 50, message = "NOME deve ser entre 2 e 50 caracteres")
	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public List<ProdutoModel> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoModel> produtos) {
		this.produtos = produtos;
	}

	@Override
	public String toString() {
		return "CategoriaModel [idCategoria=" + idCategoria + ", nomeCategoria=" + nomeCategoria + "]";
	}

}
