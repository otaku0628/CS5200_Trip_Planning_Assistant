package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;

import model.AirbnbReview;

public class AirbnbReviewDao {

  protected ConnectionManager connectionManager;

  private static AirbnbReviewDao instance = null;
  protected AirbnbReviewDao() {
    connectionManager = new ConnectionManager();
  }
  public static AirbnbReviewDao getInstance() {
    if(instance == null) {
      instance = new AirbnbReviewDao();
    }
    return instance;
  }

  public AirbnbReview create(AirbnbReview airbnbReview) throws SQLException {
    String insertAirbnbReview =
            "INSERT INTO airbnb_review(review_id, user_id, listing_id, comment, date) " +
            "VALUES(?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertAirbnbReview);
      insertStmt.setString(1, airbnbReview.getReviewId());
      insertStmt.setString(2, airbnbReview.getUserId());
      insertStmt.setString(3, airbnbReview.getListingId());
      insertStmt.setString(4, airbnbReview.getComment());
      insertStmt.setTimestamp(5, Timestamp.from(airbnbReview.getDate()));
      insertStmt.executeUpdate();
      return airbnbReview;
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

  public AirbnbReview getAirbnbReviewById(String reviewId) throws SQLException {
    String selectAirbnbReview =
            "SELECT review_id, user_id, listing_id, comment, date " +
            "FROM airbnb_review WHERE review_id=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectAirbnbReview);
      selectStmt.setString(1, reviewId);
      results = selectStmt.executeQuery();
      if(results.next()) {
        String resultReviewId = results.getString("review_id");
        String userId = results.getString("user_id");
        String listingId = results.getString("listing_id");
        String comment = results.getString("comment");
        Instant date = results.getTimestamp("date").toInstant();
        AirbnbReview airbnbReview = new AirbnbReview(resultReviewId, userId, listingId, comment, date);
        return airbnbReview;
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

  public AirbnbReview delete(AirbnbReview airbnbReview) throws SQLException {
    String deleteAirbnbReview = "DELETE FROM airbnb_review WHERE review_id=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteAirbnbReview);
      deleteStmt.setString(1, airbnbReview.getReviewId());
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
