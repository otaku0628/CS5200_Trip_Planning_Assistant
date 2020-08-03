package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDao {

  protected ConnectionManager connectionManager;

  private static UserDao instance = null;
  protected UserDao() {
    connectionManager = new ConnectionManager();
  }
  public static UserDao getInstance() {
    if(instance == null) {
      instance = new UserDao();
    }
    return instance;
  }

  public User create(User user) throws SQLException {
    String insertUser =
            "INSERT INTO user(user_id, email, password, name, member_since, review_count, useful) " +
            "VALUES(?,?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertUser);
      insertStmt.setString(1, user.getUserId());
      insertStmt.setString(2, user.getEmail());
      insertStmt.setString(3, user.getPassword());
      insertStmt.setString(4, user.getName());
      insertStmt.setTimestamp(5, Timestamp.from(user.getMemberSince()));
      insertStmt.setInt(6, user.getReviewCount());
      insertStmt.setInt(7, user.getUseful());
      insertStmt.executeUpdate();
      return user;
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

  public User getUserById(String userId) throws SQLException {
    String selectUser =
            "SELECT user_id,email,password,name,member_since,review_count,useful " +
            "FROM user WHERE user_id=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectUser);
      selectStmt.setString(1, userId);
      results = selectStmt.executeQuery();
      if(results.next()) {
        String resultUserId = results.getString("user_id");
        String email = results.getString("email");
        String password = results.getString("password");
        String name = results.getString("name");
        Instant memberSince = results.getTimestamp("member_since").toInstant();
        Integer reviewCount = results.getInt("review_count");
        Integer useful = results.getInt("useful");
        User user = new User(resultUserId, email, password, name, memberSince, reviewCount, useful);
        return user;
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

  public List<User> getUsersByName(String name) throws SQLException {
    List<User> users = new ArrayList<>();
    String selectUsers =
            "SELECT user_id,email,password,name,member_since,review_count,useful " +
            "FROM user WHERE name=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectUsers);
      selectStmt.setString(1, name);
      results = selectStmt.executeQuery();
      while(results.next()) {
        String userId = results.getString("user_id");
        String email = results.getString("email");
        String password = results.getString("password");
        String resultName = results.getString("name");
        Instant memberSince = results.getTimestamp("member_since").toInstant();
        Integer reviewCount = results.getInt("review_count");
        Integer useful = results.getInt("useful");
        User user = new User(userId, email, password, resultName, memberSince, reviewCount, useful);
        users.add(user);
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
    return users;
  }

  public User updatePassword(User user, String newPassword) throws SQLException {
    String updateUser = "UPDATE user SET password=? WHERE user_id=?;";
    Connection connection = null;
    PreparedStatement updateStmt = null;
    try {
      connection = connectionManager.getConnection();
      updateStmt = connection.prepareStatement(updateUser);
      updateStmt.setString(1, newPassword);
      updateStmt.setString(2, user.getUserId());
      updateStmt.executeUpdate();
      user.setPassword(newPassword);
      return user;
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if(connection != null) {
        connection.close();
      }
      if(updateStmt != null) {
        updateStmt.close();
      }
    }
  }

  public User delete(User user) throws SQLException {
    String deleteUser = "DELETE FROM user WHERE user_id=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteUser);
      deleteStmt.setString(1, user.getUserId());
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
