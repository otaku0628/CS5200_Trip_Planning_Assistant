package dal;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import model.AirbnbHost;

public class AirbnbHostDao {

  protected ConnectionManager connectionManager;

  private static AirbnbHostDao instance = null;
  protected AirbnbHostDao() {
    connectionManager = new ConnectionManager();
  }
  public static AirbnbHostDao getInstance() {
    if(instance == null) {
      instance = new AirbnbHostDao();
    }
    return instance;
  }

  public AirbnbHost create(AirbnbHost airbnbHost) throws SQLException {
    String insertAirbnbHost =
            "INSERT INTO airbnb_host(host_id, host_url, name, since, location, about, " +
                    "response_time, response_rate, listing_count, verification) " +
            "VALUES(?,?,?,?,?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertAirbnbHost);
      insertStmt.setString(1, airbnbHost.getHostId());
      insertStmt.setString(2, airbnbHost.getHostUrl());
      insertStmt.setString(3, airbnbHost.getName());
      insertStmt.setDate(4, Date.valueOf(airbnbHost.getSince()));
      insertStmt.setString(5, airbnbHost.getLocation());
      insertStmt.setString(6, airbnbHost.getAbout());
      insertStmt.setString(7, airbnbHost.getResponseTime());
      insertStmt.setBigDecimal(8, airbnbHost.getResponseRate());
      insertStmt.setInt(9, airbnbHost.getListingCount());
      insertStmt.setString(10, airbnbHost.getVerification());
      insertStmt.executeUpdate();
      return airbnbHost;
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

  public AirbnbHost getAirbnbHostById(String hostId) throws SQLException {
    String selectAirbnbHost =
            "SELECT host_id, host_url, name, since, location, about, response_time, " +
                    "response_rate, listing_count, verification " +
            "FROM airbnb_host WHERE host_id=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectAirbnbHost);
      selectStmt.setString(1, hostId);
      results = selectStmt.executeQuery();
      if(results.next()) {
        String resultHostId = results.getString("host_id");
        String hostUrl = results.getString("host_url");
        String name = results.getString("name");
        LocalDate since = results.getDate("since").toLocalDate();
        String location = results.getString("location");
        String about = results.getString("about");
        String responseTime = results.getString("response_time");
        BigDecimal responseRate = results.getBigDecimal("response_rate");
        Integer listingCount = results.getInt("listing_count");
        String verification = results.getString("verification");
        AirbnbHost airbnbHost = new AirbnbHost(resultHostId, hostUrl, name, since, location,
                about, responseTime, responseRate, listingCount, verification);
        return airbnbHost;
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

  public AirbnbHost delete(AirbnbHost airbnbHost) throws SQLException {
    String deleteAirbnbHost = "DELETE FROM airbnb_host WHERE host_id=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteAirbnbHost);
      deleteStmt.setString(1, airbnbHost.getHostId());
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
