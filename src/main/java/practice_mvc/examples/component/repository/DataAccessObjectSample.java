package practice_mvc.examples.component.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import practice_mvc.examples.entity.ProductModel;

@Repository
public class DataAccessObjectSample {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public DataAccessObjectSample() {
    super();
  }

  @Transactional(readOnly = true)
  public ProductModel getProduct() {
    String sql = "SELECT id, name, price FROM t_product WHERE id = ?";
    String id = "bourbon";

    Object[] args = new Object[] { id };
    ProductModel productModel = this.jdbcTemplate.queryForObject(sql, args, new RowMapper4productModel());
    return productModel;
  }

  private static class RowMapper4productModel implements RowMapper<ProductModel> {
    public RowMapper4productModel() {
      super();
    }
    public ProductModel mapRow(ResultSet rs, int rowNum) throws SQLException {
      ProductModel productModel = new ProductModel();
      productModel.setId(rs.getString("id"));
      productModel.setName(rs.getString("name"));
      productModel.setPrice(rs.getInt("price"));
      return productModel;
    }
  }
}
