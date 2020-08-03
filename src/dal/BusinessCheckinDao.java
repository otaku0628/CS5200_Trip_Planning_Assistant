package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;

import model.BusinessCheckin;

public class BusinessCheckinDao {

  protected ConnectionManager connectionManager;

  private static BusinessCheckinDao instance = null;
  protected BusinessCheckinDao() {
    connectionManager = new ConnectionManager();
  }
  public static BusinessCheckinDao getInstance() {
    if(instance == null) {
      instance = new BusinessCheckinDao();
    }
    return instance;
  }

  public BusinessCheckin create(BusinessCheckin businessCheckin) throws SQLException {
    String insertBusinessCheckin =
            "INSERT INTO business_checkin(uuid, user_id, business_id, checkin_time) " +
            "VALUES(?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertBusinessCheckin);
      insertStmt.setString(1, businessCheckin.getUuid());
      insertStmt.setString(2, businessCheckin.getUserId());
      insertStmt.setString(3, businessCheckin.getBusinessId());
      insertStmt.setTimestamp(4, Timestamp.from(businessCheckin.getCheckinTime()));
      insertStmt.executeUpdate();
      return businessCheckin;
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

  public BusinessCheckin getBusinessCheckinById(String uuid) throws SQLException {
    String selectBusinessCheckin =
            "SELECT uuid, user_id, business_id, checkin_time " +
            "FROM business_checkin WHERE uuid=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectBusinessCheckin);
      selectStmt.setString(1, uuid);
      results = selectStmt.executeQuery();
      if(results.next()) {
        String resultUuid = results.getString("uuid");
        String userId = results.getString("user_id");
        String businessId = results.getString("business_id");
        Instant checkinTime = results.getTimestamp("checkin_time").toInstant();
        BusinessCheckin businessCheckin = new BusinessCheckin(resultUuid, userId, businessId, checkinTime);
        return businessCheckin;
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

  public BusinessCheckin delete(BusinessCheckin businessCheckin) throws SQLException {
    String deleteBusinessCheckin = "DELETE FROM business_checkin WHERE uuid=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteBusinessCheckin);
      deleteStmt.setString(1, businessCheckin.getUuid());
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
