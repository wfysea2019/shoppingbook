package cn.edu.jxnu.dao.impl;

import cn.edu.jxnu.dao.ProductDAO;
import cn.edu.jxnu.domain.ProductDomain;
import cn.edu.jxnu.domain.ProductTypeDomain;
import cn.edu.jxnu.domain.PublishDomain;
import cn.edu.jxnu.util.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ImplProdutctDAO implements ProductDAO {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JdbcUtils.getDataSource());


    public class ProductDomainRowMapper implements RowMapper<ProductDomain>{
        @Override
        public ProductDomain mapRow(ResultSet rs, int rowNum) throws SQLException {

            ProductDomain productDomain=new ProductDomain();
            ProductTypeDomain productTypeDomain=new ProductTypeDomain();
            PublishDomain publishDomain=new PublishDomain();

            productDomain.setBookId(rs.getLong("book_id"));
            productDomain.setBookName(rs.getString("book_name"));
            productDomain.setBookImage(rs.getString("book_image"));
            productDomain.setBookIsbn(rs.getString("book_isbn"));
            productDomain.setPrice(rs.getFloat("price"));
            productDomain.setDiscount(rs.getFloat("discount"));
            productDomain.setBookAuthor(rs.getString("book_author"));
            productDomain.setBookPublishTime(rs.getDate("book_publish_time"));
            productDomain.setBookIntroduction(rs.getString("book_introduction"));

            productTypeDomain.setBookTypeId(rs.getInt("book_type_id"));
            productTypeDomain.setBookTypeName(rs.getString("book_type_name"));
            productDomain.setProductTypeDomain(productTypeDomain);

            publishDomain.setPublishingId(rs.getInt("publishing_id"));
            publishDomain.setPublishingName(rs.getString("publishing_name"));
            productDomain.setPublishDomain(publishDomain);


            return productDomain;
        }
    }
    @Override
    /**
     *  根据销售量显示记录
     */
    public List<ProductDomain> queryProductOrderSaleNum(int index, int pageSize) throws Exception {
        List<ProductDomain> productList =null;


            String sql="select  * \n" +
                    "from bookinfoview order by book_sale_num desc \n" +
                    "limit ?,?";

        productList=jdbcTemplate.query(sql, new BeanPropertyRowMapper<ProductDomain>(ProductDomain.class),index,pageSize);

        return  productList;
    }

    public List<ProductDomain> queryProductOrderID(int index, int pageSize) throws Exception{

        List<ProductDomain> productList =null;


        String sql="select  *\n" +
                "from bookinfoview order by book_id desc \n" +
                "limit ?,?";

        productList=jdbcTemplate.query(sql, new ProductDomainRowMapper(),index,pageSize);

        return  productList;
    }


    public List<ProductDomain> queryProductOrderRand(int index, int pageSize) throws Exception{
        List<ProductDomain> productList =null;


        String sql="select  * \n" +
                "from bookinfoview order by rand() desc \n" +
                "limit ?,?";

        productList=jdbcTemplate.query(sql, new BeanPropertyRowMapper<ProductDomain>(ProductDomain.class),index,pageSize);

        return  productList;
    }

    public List<ProductDomain> queryProductOrderSaleNum1(int index, int pageSize) throws Exception{
        List<ProductDomain> productList =null;


        String sql="select  * \n" +
                "from bookinfoview order by book_sale_num desc \n" +
                "limit ?,?";

        productList=jdbcTemplate.query(sql, new ProductDomainRowMapper(),index,pageSize);

        return  productList;
    }

    /**
     * 统计图书总的数量
     * @return 总数量
     * @throws Exception
     */
    @Override
    public int countProductsNumber() throws Exception {
        String sql="select count(*) from  book_table;";
        Integer cnt=jdbcTemplate.queryForObject(sql,Integer.class);
        return cnt.intValue();
    }

    @Override
    public int countProductsNumber(String bookName) throws Exception {
        String sql="select count(*) from  book_table where book_name like ?;";
        Integer cnt=jdbcTemplate.queryForObject(sql,Integer.class,"%"+bookName+"%");
        return cnt.intValue();
    }

    @Override
    public List<ProductDomain> queryProductOrderID(int index, int pageSize, String bookName) throws Exception {
        List<ProductDomain> productList =null;


        String sql="select  *\n" +
                "from bookinfoview where book_name like ?" +
                "order by book_id desc \n" +
                "limit ?,?";

        productList=jdbcTemplate.query(sql, new ProductDomainRowMapper(),"%"+bookName+"%",index,pageSize);

        return  productList;
    }
}
