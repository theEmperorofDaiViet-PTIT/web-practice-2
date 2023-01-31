package ProductMaintenance.DB;

import ProductMaintenance.business.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductIO {
    public static Product search(String code){
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        Product p = null;
        PreparedStatement ps = null;
        ResultSet products = null;

        String preparedSQL = "SELECT PRODUCT_CODE, PRODUCT_DESCRIPTION, PRICE "
                            + "FROM PRODUCTS WHERE PRODUCT_CODE = ?";
        
        try {          
            ps = connection.prepareStatement(preparedSQL);
            ps.setString(1, code);
            products = ps.executeQuery();
            while(products.next()) {
                p = new Product(products.getString(1), products.getString(2), products.getDouble(3));
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            DBUtility.closeResultSet(products);
            DBUtility.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return p;
    }

    public static String display(){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        Statement statement = null;
        ResultSet products = null;

        String displayProducts = "";
        try {         
            statement = connection.createStatement();
            products = statement.executeQuery("SELECT * FROM PRODUCTS");
            displayProducts = SQLUtility.getHTMLTable(products);
        }
        catch(SQLException e){
            displayProducts = "<p>Error executing the SQL statement: </br>" + e.getMessage() + "</p>";
        }
        finally{
            DBUtility.closeResultSet(products);
            DBUtility.closeStatement(statement);
            pool.freeConnection(connection);
        }
        return displayProducts;
    }

    public static void edit(String value1, String value2, Double value3, String value4){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String preparedSQL = "UPDATE PRODUCTS SET PRODUCT_CODE = ?, PRODUCT_DESCRIPTION = ?, PRICE = ?"
                            + "WHERE PRODUCT_CODE = ?";

        try {
            ps = connection.prepareStatement(preparedSQL);
            ps.setString(1, value1);
            ps.setString(2, value2);
            ps.setDouble(3, value3);
            ps.setString(4, value4);
            ps.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            DBUtility.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static void add(String value1, String value2, Double value3){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String preparedSQL = "INSERT INTO PRODUCTS(PRODUCT_CODE, PRODUCT_DESCRIPTION, PRICE)"
                            + "VALUES(?, ?, ?)";

        try {
            ps = connection.prepareStatement(preparedSQL);
            ps.setString(1, value1);
            ps.setString(2, value2);
            ps.setDouble(3, value3);
            ps.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            DBUtility.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static void delete(String code){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String preparedSQL = "DELETE FROM PRODUCTS WHERE PRODUCT_CODE = ?";

        try {
            ps = connection.prepareStatement(preparedSQL);
            ps.setString(1, code);
            ps.executeUpdate();
        }
        catch(SQLException e){
           System.out.println(e);
        }
        finally{
            DBUtility.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}
