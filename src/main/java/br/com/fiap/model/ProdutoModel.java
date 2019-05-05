package br.com.fiap.model;

import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class ProdutoModel {

	private long id;
	private String nome;
	private String sku;
	private String descricao;
	private double preco;
	private String caracteristicas;
	private Date dataLancamento;
	private CategoriaModel categoriaModel;

	public ProdutoModel() {
	}

	public ProdutoModel(long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	

	public ProdutoModel(long id, String nome, String sku, String descricao, double preco, String caracteristicas,
			Date dataLancamento, CategoriaModel categoriaModel) {
		super();
		this.id = id;
		this.nome = nome;
		this.sku = sku;
		this.descricao = descricao;
		this.preco = preco;
		this.caracteristicas = caracteristicas;
		this.dataLancamento = dataLancamento;
		this.categoriaModel = categoriaModel;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@NotNull(message = "Nome obrigatório")
	@Size(min = 2, max = 50, message = "NOME deve ser entre 2 e 50 caracteres")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@NotNull(message = "Sku obrigatório")
	@Size(min = 2, max = 40, message = "SKU deve ser entre 2 e 50 caracteres")
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	@NotNull(message = "Descrição obrigatório")
	@Size(min = 10, max = 400, message = "DESCRIÇÃO deve ser entre 10 e 400 caracteres")
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@DecimalMin(value = "0.01", message = "PRECO deve ser acima de 0.01")
	@NumberFormat(style = Style.CURRENCY)
	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Size(min = 10, max = 400, message = "CARACTERÍSTICAS deve ser entre 10 e 400 caracteres")
	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	@NotNull(message = "Data obrigatória no formato dia/mês/ano, exemplo: 10/06/2019")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	@Override
	public String toString() {
		return "ProdutoModel [id=" + id + ", nome=" + nome + ", sku=" + sku + ", descricao=" + descricao + ", preco="
				+ preco + ", caracteristicas=" + caracteristicas + ", dataLancamento=" + dataLancamento + "]";
	}

	public CategoriaModel getCategoriaModel() {
		return categoriaModel;
	}

	public void setCategoriaModel(CategoriaModel categoriaModel) {
		this.categoriaModel = categoriaModel;
	}

}
