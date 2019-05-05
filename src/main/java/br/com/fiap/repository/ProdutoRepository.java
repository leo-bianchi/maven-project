package br.com.fiap.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import br.com.fiap.model.ProdutoModel;

@Component
public class ProdutoRepository {

	private static final String GET_ALL = "SELECT * FROM TB_PRODUTO P INNER JOIN TB_CATEGORIA C ON C.ID_CATEGORIA = P.ID_CATEGORIA ORDER BY P.ID";
	private static final String GET = "SELECT * FROM TB_PRODUTO P INNER JOIN TB_CATEGORIA C ON C.ID_CATEGORIA = P.ID_CATEGORIA AND P.ID = ?";
	private static final String SAVE = "INSERT INTO TB_PRODUTO (NOME, SKU, DESCRICAO, CARACTERISTICAS, PRECO, DATA_LANCAMENTO, ID_CATEGORIA) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE = "UPDATE TB_PRODUTO SET NOME = ?, SKU = ?, DESCRICAO = ?, CARACTERISTICAS = ?, PRECO = ?, DATA_LANCAMENTO = ? WHERE ID = ?";
	private static final String DELETE = "DELETE FROM TB_PRODUTO WHERE ID = ?";
	
	@Autowired
	public JdbcTemplate jdbcTemplate;

	public ProdutoRepository() {
	}

	public List<ProdutoModel> getAll() {

		List<ProdutoModel> produtos = this.jdbcTemplate.query(GET_ALL, new ProdutoRowMapper());
		return produtos;
	}

	public ProdutoModel get(long id) {

		ProdutoModel produto = this.jdbcTemplate.queryForObject(GET, new ProdutoRowMapper(), id);
		return produto;
	}

	public void save(ProdutoModel produtoModel) {
		this.jdbcTemplate.update(SAVE, 
				produtoModel.getNome(), 
				produtoModel.getSku(), 
				produtoModel.getDescricao(),
				produtoModel.getCaracteristicas(), 
				produtoModel.getPreco(), 
				produtoModel.getDataLancamento(),
				produtoModel.getCategoriaModel().getIdCategoria());
	}

	public void update(ProdutoModel produtoModel) {
		this.jdbcTemplate.update(UPDATE, 
				produtoModel.getNome(), 
				produtoModel.getSku(), 
				produtoModel.getDescricao(),
				produtoModel.getCaracteristicas(), 
				produtoModel.getPreco(), 
				produtoModel.getDataLancamento(),
				produtoModel.getId());
	}

	public void delete(long id) {
		this.jdbcTemplate.update(DELETE, id);
	}

}
