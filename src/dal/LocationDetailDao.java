package dal;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.LocationDetail;

public class LocationDetailDao {

  protected ConnectionManager connectionManager;

  private static LocationDetailDao instance = null;
  protected LocationDetailDao() {
    connectionManager = new ConnectionManager();
  }
  public static LocationDetailDao getInstance() {
    if(instance == null) {
      instance = new LocationDetailDao();
    }
    return instance;
  }

  public LocationDetail create(LocationDetail locationDetail) throws SQLException {
    String insertLocationDetail =
            "INSERT INTO location_detail(listing_id, street, city, state, zip_code, country_code, " +
                    "country, latitude, longitude) " +
            "VALUES(?,?,?,?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertLocationDetail);
      insertStmt.setString(1, locationDetail.getListingId());
      insertStmt.setString(2, locationDetail.getStreet());
      insertStmt.setString(3, locationDetail.getCity());
      insertStmt.setString(4, locationDetail.getState());
      insertStmt.setString(5, locationDetail.getZipCode());
      insertStmt.setString(6, locationDetail.getCountryCode());
      insertStmt.setString(7, locationDetail.getCountry());
      insertStmt.setBigDecimal(8, locationDetail.getLatitude());
      insertStmt.setBigDecimal(9, locationDetail.getLongitude());
      insertStmt.executeUpdate();
      return locationDetail;
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

  public LocationDetail getLocationDetailById(String listingId) throws SQLException {
    String selectLocationDetail =
            "SELECT listing_id, street, city, state, zip_code, country_code, country, " +
                    "latitude, longitude " +
            "FROM location_detail WHERE listing_id=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectLocationDetail);
      selectStmt.setString(1, listingId);
      results = selectStmt.executeQuery();
      if(results.next()) {
        String resultListingId = results.getString("listing_id");
        String street = results.getString("street");
        String city = results.getString("city");
        String state = results.getString("state");
        String zipCode = results.getString("zip_code");
        String countryCode = results.getString("country_code");
        String country = results.getString("country");
        BigDecimal latitude = results.getBigDecimal("latitude");
        BigDecimal longitude = results.getBigDecimal("longitude");
        LocationDetail locationDetail = new LocationDetail(resultListingId, street, city, state,
                zipCode, countryCode, country, latitude, longitude);
        return locationDetail;
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

  public LocationDetail delete(LocationDetail locationDetail) throws SQLException {
    String deleteLocationDetail = "DELETE FROM location_detail WHERE listing_id=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteLocationDetail);
      deleteStmt.setString(1, locationDetail.getListingId());
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
