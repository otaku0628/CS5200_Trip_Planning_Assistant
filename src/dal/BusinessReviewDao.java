package dal;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;

import model.BusinessReview;

public class BusinessReviewDao {

  protected ConnectionManager connectionManager;

  private static BusinessReviewDao instance = null;
  protected BusinessReviewDao() {
    connectionManager = new ConnectionManager();
  }
  public static BusinessReviewDao getInstance() {
    if(instance == null) {
      instance = new BusinessReviewDao();
    }
    return instance;
  }

  public BusinessReview create(BusinessReview businessReview) throws SQLException {
    String insertBusinessReview =
            "INSERT INTO business_review(review_id, user_id, business_id, stars, useful, text, date) " +
            "VALUES(?,?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertBusinessReview);
      insertStmt.setString(1, businessReview.getReviewId());
      insertStmt.setString(2, businessReview.getUserId());
      insertStmt.setString(3, businessReview.getBusinessId());
      insertStmt.setBigDecimal(4, businessReview.getStars());
      insertStmt.setInt(5, businessReview.getUseful());
      insertStmt.setString(6, businessReview.getText());
      insertStmt.setTimestamp(7, Timestamp.from(businessReview.getDate()));
      insertStmt.executeUpdate();
      return businessReview;
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

  public BusinessReview getBusinessReviewById(String reviewId) throws SQLException {
    String selectBusinessReview =
            "SELECT review_id, user_id, business_id, stars, useful, text, date " +
            "FROM business_review WHERE review_id=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectBusinessReview);
      selectStmt.setString(1, reviewId);
      results = selectStmt.executeQuery();
      if(results.next()) {
        String resultReviewId = results.getString("review_id");
        String userId = results.getString("user_id");
        String businessId = results.getString("business_id");
        BigDecimal stars = results.getBigDecimal("stars");
        Integer useful = results.getInt("useful");
        String text = results.getString("text");
        Instant date = results.getTimestamp("date").toInstant();
        BusinessReview businessReview = new BusinessReview(resultReviewId, userId, businessId,
                stars, useful, text, date);
        return businessReview;
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

  public BusinessReview delete(BusinessReview businessReview) throws SQLException {
    String deleteBusinessReview = "DELETE FROM business_review WHERE review_id=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteBusinessReview);
      deleteStmt.setString(1, businessReview.getReviewId());
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
