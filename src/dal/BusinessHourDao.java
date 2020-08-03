package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;

import model.BusinessHour;

public class BusinessHourDao {

  protected ConnectionManager connectionManager;

  private static BusinessHourDao instance = null;
  protected BusinessHourDao() {
    connectionManager = new ConnectionManager();
  }
  public static BusinessHourDao getInstance() {
    if(instance == null) {
      instance = new BusinessHourDao();
    }
    return instance;
  }

  public BusinessHour create(BusinessHour businessHour) throws SQLException {
    String insertBusinessHour =
            "INSERT INTO business_hour(uuid, business_id, day_of_week, open_time, close_time) " +
            "VALUES(?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertBusinessHour);
      insertStmt.setString(1, businessHour.getUuid());
      insertStmt.setString(2, businessHour.getBusinessId());
      insertStmt.setString(3, businessHour.getDayOfWeek());
      insertStmt.setTime(4, Time.valueOf(businessHour.getOpenTime()));
      insertStmt.setTime(5, Time.valueOf(businessHour.getCloseTime()));
      insertStmt.executeUpdate();
      return businessHour;
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

  public BusinessHour getBusinessHourById(String uuid) throws SQLException {
    String selectBusinessHour =
            "SELECT uuid, business_id, day_of_week, open_time, close_time " +
            "FROM business_hour WHERE uuid=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectBusinessHour);
      selectStmt.setString(1, uuid);
      results = selectStmt.executeQuery();
      if(results.next()) {
        String resultUuid = results.getString("uuid");
        String businessId = results.getString("business_id");
        String dayOfWeek = results.getString("day_of_week");
        LocalTime openTime = results.getTime("open_time").toLocalTime();
        LocalTime closeTime = results.getTime("close_time").toLocalTime();
        BusinessHour businessHour = new BusinessHour(resultUuid, businessId, dayOfWeek, openTime, closeTime);
        return businessHour;
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

  public BusinessHour delete(BusinessHour businessHour) throws SQLException {
    String deleteBusinessHour = "DELETE FROM business_hour WHERE uuid=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteBusinessHour);
      deleteStmt.setString(1, businessHour.getUuid());
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
