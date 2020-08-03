package dal;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.BusinessOverview;

public class BusinessOverviewDao {

  protected ConnectionManager connectionManager;

  private static BusinessOverviewDao instance = null;
  protected BusinessOverviewDao() {
    connectionManager = new ConnectionManager();
  }
  public static BusinessOverviewDao getInstance() {
    if(instance == null) {
      instance = new BusinessOverviewDao();
    }
    return instance;
  }

  public BusinessOverview create(BusinessOverview businessOverview) throws SQLException {
    String insertBusinessOverview =
            "INSERT INTO business_overview(business_id, name, address, city, state, postal_code, " +
                    "latitude, longitude, stars, review_count, is_open, categories) " +
            "VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertBusinessOverview);
      insertStmt.setString(1, businessOverview.getBusinessId());
      insertStmt.setString(2, businessOverview.getName());
      insertStmt.setString(3, businessOverview.getAddress());
      insertStmt.setString(4, businessOverview.getCity());
      insertStmt.setString(5, businessOverview.getState());
      insertStmt.setString(6, businessOverview.getPostalCode());
      insertStmt.setBigDecimal(7, businessOverview.getLatitude());
      insertStmt.setBigDecimal(8, businessOverview.getLongitude());
      insertStmt.setBigDecimal(9, businessOverview.getStars());
      insertStmt.setInt(10, businessOverview.getReviewCount());
      insertStmt.setBoolean(11, businessOverview.getOpen());
      insertStmt.setString(12, businessOverview.getCategories());
      insertStmt.executeUpdate();
      return businessOverview;
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if(connection != null) {
        connection.close();
      }
      if(insertStmt != null) {
        insertStmt.close();
      }
    }
  }

  public BusinessOverview getBusinessOverviewById(String businessId) throws SQLException {
    String selectBusinessOverview =
            "SELECT business_id, name, address, city, state, postal_code, latitude, longitude, " +
                    "stars, review_count, is_open, categories " +
            "FROM business_overview WHERE business_id=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectBusinessOverview);
      selectStmt.setString(1, businessId);
      results = selectStmt.executeQuery();
      if(results.next()) {
        String resultBusinessId = results.getString("business_id");
        String name = results.getString("name");
        String address = results.getString("address");
        String city = results.getString("city");
        String state = results.getString("state");
        String postalCode = results.getString("postal_code");
        BigDecimal latitude = results.getBigDecimal("latitude");
        BigDecimal longitude = results.getBigDecimal("longitude");
        BigDecimal stars = results.getBigDecimal("stars");
        Integer reviewCount = results.getInt("review_count");
        Boolean isOpen = results.getBoolean("is_open");
        String categories = results.getString("categories");
        BusinessOverview businessOverview = new BusinessOverview(resultBusinessId, name, address,
                city, state, postalCode, latitude, longitude, stars, reviewCount, isOpen, categories);
        return businessOverview;
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if(connection != null) {
        connection.close();
      }
      if(selectStmt != null) {
        selectStmt.close();
      }
      if(results != null) {
        results.close();
      }
    }
    return null;
  }

  public BusinessOverview delete(BusinessOverview businessOverview) throws SQLException {
    String deleteBusinessOverview = "DELETE FROM business_overview WHERE business_id=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteBusinessOverview);
      deleteStmt.setString(1, businessOverview.getBusinessId());
      deleteStmt.executeUpdate();
      return null;
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if(connection != null) {
        connection.close();
      }
      if(deleteStmt != null) {
        deleteStmt.close();
      }
    }
  }
}
