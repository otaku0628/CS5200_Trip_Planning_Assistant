package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.BusinessAttribute;

public class BusinessAttributeDao {

  protected ConnectionManager connectionManager;

  private static BusinessAttributeDao instance = null;
  protected BusinessAttributeDao() {
    connectionManager = new ConnectionManager();
  }
  public static BusinessAttributeDao getInstance() {
    if(instance == null) {
      instance = new BusinessAttributeDao();
    }
    return instance;
  }

  public BusinessAttribute create(BusinessAttribute businessAttribute) throws SQLException {
    String insertBusinessAttribute =
            "INSERT INTO business_attribute(uuid, business_id, attribute_name, attribute_value) " +
            "VALUES(?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertBusinessAttribute);
      insertStmt.setString(1, businessAttribute.getUuid());
      insertStmt.setString(2, businessAttribute.getBusinessId());
      insertStmt.setString(3, businessAttribute.getAttributeName());
      insertStmt.setString(4, businessAttribute.getAttributeValue());
      insertStmt.executeUpdate();
      return businessAttribute;
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

  public BusinessAttribute getBusinessAttributeById(String uuid) throws SQLException {
    String selectBusinessAttribute =
            "SELECT uuid, business_id, attribute_name, attribute_value " +
            "FROM business_attribute WHERE uuid=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectBusinessAttribute);
      selectStmt.setString(1, uuid);
      results = selectStmt.executeQuery();
      if(results.next()) {
        String resultUuid = results.getString("uuid");
        String businessId = results.getString("business_id");
        String attributeName = results.getString("attribute_name");
        String attributeValue = results.getString("attribute_value");
        BusinessAttribute businessAttribute = new BusinessAttribute(resultUuid, businessId,
                attributeName, attributeValue);
        return businessAttribute;
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

  public BusinessAttribute delete(BusinessAttribute businessAttribute) throws SQLException {
    String deleteBusinessAttribute = "DELETE FROM business_attribute WHERE uuid=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteBusinessAttribute);
      deleteStmt.setString(1, businessAttribute.getUuid());
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
