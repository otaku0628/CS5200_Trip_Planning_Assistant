package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ReviewDetail;

public class ReviewDetailDao {

  protected ConnectionManager connectionManager;

  private static ReviewDetailDao instance = null;
  protected ReviewDetailDao() {
    connectionManager = new ConnectionManager();
  }
  public static ReviewDetailDao getInstance() {
    if(instance == null) {
      instance = new ReviewDetailDao();
    }
    return instance;
  }

  public ReviewDetail create(ReviewDetail reviewDetail) throws SQLException {
    String insertReviewDetail =
            "INSERT INTO review_detail(listing_id, review_count, rating_score, accuracy_score, " +
                    "cleanliness_score, checkin_score, communication_score, location_score, value_score) " +
            "VALUES(?,?,?,?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertReviewDetail);
      insertStmt.setString(1, reviewDetail.getListingId());
      insertStmt.setInt(2, reviewDetail.getReviewCount());
      insertStmt.setInt(3, reviewDetail.getRatingScore());
      insertStmt.setInt(4, reviewDetail.getAccuracyScore());
      insertStmt.setInt(5, reviewDetail.getCleanlinessScore());
      insertStmt.setInt(6, reviewDetail.getCheckinScore());
      insertStmt.setInt(7, reviewDetail.getCommunicationScore());
      insertStmt.setInt(8, reviewDetail.getLocationScore());
      insertStmt.setInt(9, reviewDetail.getValueScore());
      insertStmt.executeUpdate();
      return reviewDetail;
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

  public ReviewDetail getReviewDetailById(String listingId) throws SQLException {
    String selectReviewDetail =
            "SELECT listing_id, review_count, rating_score, accuracy_score, cleanliness_score, " +
                    "checkin_score, communication_score, location_score, value_score " +
            "FROM review_detail WHERE listing_id=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectReviewDetail);
      selectStmt.setString(1, listingId);
      results = selectStmt.executeQuery();
      if(results.next()) {
        String resultListingId = results.getString("listing_id");
        Integer reviewCount = results.getInt("review_count");
        Integer ratingScore = results.getInt("rating_score");
        Integer accuracyScore = results.getInt("accuracy_score");
        Integer cleanlinessScore = results.getInt("cleanliness_score");
        Integer checkinScore = results.getInt("checkin_score");
        Integer communicationScore = results.getInt("communication_score");
        Integer locationScore = results.getInt("location_score");
        Integer valueScore = results.getInt("value_score");
        ReviewDetail reviewDetail = new ReviewDetail(resultListingId, reviewCount, ratingScore,
                accuracyScore, cleanlinessScore, checkinScore, communicationScore, locationScore,
                valueScore);
        return reviewDetail;
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

  public ReviewDetail delete(ReviewDetail reviewDetail) throws SQLException {
    String deleteReviewDetail = "DELETE FROM review_detail WHERE listing_id=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteReviewDetail);
      deleteStmt.setString(1, reviewDetail.getListingId());
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
