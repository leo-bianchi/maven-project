package br.com.fiap.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import br.com.fiap.model.CategoriaModel;
import br.com.fiap.model.ProdutoModel;

@Component
public class CategoriaRepository {
	
	private static final String GET_ALL = "SELECT * FROM TB_CATEGORIA";
	private static final String GET = "SELECT * FROM TB_CATEGORIA WHERE ID_CATEGORIA = ?";
	private static final String SAVE = "INSERT INTO TB_CATEGORIA (NOME_CATEGORIA) VALUES (?)";
	private static final String UPDATE = "UPDATE TB_CATEGORIA SET NOME_CATEGORIA = ? WHERE ID_CATEGORIA = ?";
	private static final String DELETE = "DELETE FROM TB_CATEGORIA WHERE ID_CATEGORIA = ?";

	
	private static final String GET_CATEGORIAS_PRODUTOS = "SELECT " + 
															"    C.ID_CATEGORIA, " + 
															"    C.NOME_CATEGORIA, " + 
															"    P.ID, " + 
															"    P.NOME " + 
															"FROM " + 
															"    TB_CATEGORIA C INNER JOIN TB_PRODUTO P ON P.ID_CATEGORIA = C.ID_CATEGORIA " + 
															"ORDER BY " + 
															"    C.NOME_CATEGORIA ";

	@Autowired
	public JdbcTemplate jdbcTemplate;

	public CategoriaRepository() {
	}
	
	public List<CategoriaModel> getAll() {

		List<CategoriaModel> categorias = this.jdbcTemplate.query(GET_ALL, new BeanPropertyRowMapper<CategoriaModel>(CategoriaModel.class));
		return categorias;
	}

	public CategoriaModel get(long id) {

		CategoriaModel categoria = this.jdbcTemplate.queryForObject(GET, new BeanPropertyRowMapper<CategoriaModel>(CategoriaModel.class), id);
		return categoria;
	}

	public void save(CategoriaModel categoriaModel) {
		this.jdbcTemplate.update(SAVE, 
				categoriaModel.getNomeCategoria());
	}

	public void update(CategoriaModel categoriaModel) {
		this.jdbcTemplate.update(UPDATE, 
				categoriaModel.getNomeCategoria(),
				categoriaModel.getIdCategoria());
	}

	public void delete(long id) {
		this.jdbcTemplate.update(DELETE, id);
	}

	public List<CategoriaModel> getProductsByCategories() {
		List<CategoriaModel> categorias = jdbcTemplate.query(GET_CATEGORIAS_PRODUTOS,
				new ResultSetExtractor<List<CategoriaModel>>() {

					public List<CategoriaModel> extractData(ResultSet rs) throws SQLException {
						Map<Long, CategoriaModel> categorias = new HashMap<Long, CategoriaModel>();

						while (rs.next()) {
							Long categoriaId = rs.getLong("ID_CATEGORIA");

							CategoriaModel categoriaModel = categorias.get(categoriaId);
							if (categoriaModel == null) {
								categoriaModel = new CategoriaModel(categoriaId, rs.getString("NOME_CATEGORIA"), new ArrayList<ProdutoModel>());
								categorias.put(categoriaId, categoriaModel);
							}

							ProdutoModel produtoModel = new ProdutoModel(rs.getLong("id"), rs.getString("nome"));

							categoriaModel.getProdutos().add(produtoModel);
						}

						return new ArrayList<CategoriaModel>(categorias.values());
					}
				});

		return categorias;
	}

}
