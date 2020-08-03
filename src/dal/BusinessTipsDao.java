package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;

import model.BusinessTips;

public class BusinessTipsDao {

  protected ConnectionManager connectionManager;

  private static BusinessTipsDao instance = null;
  protected BusinessTipsDao() {
    connectionManager = new ConnectionManager();
  }
  public static BusinessTipsDao getInstance() {
    if(instance == null) {
      instance = new BusinessTipsDao();
    }
    return instance;
  }

  public BusinessTips create(BusinessTips businessTips) throws SQLException {
    String insertBusinessTips =
            "INSERT INTO business_tips(uuid, user_id, business_id, text, date, compliment_count) " +
            "VALUES(?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertBusinessTips);
      insertStmt.setString(1, businessTips.getUuid());
      insertStmt.setString(2, businessTips.getUserId());
      insertStmt.setString(3, businessTips.getBusinessId());
      insertStmt.setString(4, businessTips.getText());
      insertStmt.setTimestamp(5, Timestamp.from(businessTips.getDate()));
      insertStmt.setInt(6, businessTips.getComplimentCount());
      insertStmt.executeUpdate();
      return businessTips;
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

  public BusinessTips getBusinessTipsById(String uuid) throws SQLException {
    String selectBusinessTips =
            "SELECT uuid, user_id, business_id, text, date, compliment_count " +
            "FROM business_tips WHERE uuid=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectBusinessTips);
      selectStmt.setString(1, uuid);
      results = selectStmt.executeQuery();
      if(results.next()) {
        String resultUuid = results.getString("uuid");
        String userId = results.getString("user_id");
        String businessId = results.getString("business_id");
        String text = results.getString("text");
        Instant date = results.getTimestamp("date").toInstant();
        Integer complimentCount = results.getInt("compliment_count");
        BusinessTips businessTips = new BusinessTips(resultUuid, userId, businessId, text, date, complimentCount);
        return businessTips;
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

  public BusinessTips delete(BusinessTips businessTips) throws SQLException {
    String deleteBusinessTips = "DELETE FROM business_tips WHERE uuid=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteBusinessTips);
      deleteStmt.setString(1, businessTips.getUuid());
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
