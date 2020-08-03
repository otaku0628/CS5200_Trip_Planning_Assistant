package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;

import model.AirbnbRating;

public class AirbnbRatingDao {

  protected ConnectionManager connectionManager;

  private static AirbnbRatingDao instance = null;
  protected AirbnbRatingDao() {
    connectionManager = new ConnectionManager();
  }
  public static AirbnbRatingDao getInstance() {
    if(instance == null) {
      instance = new AirbnbRatingDao();
    }
    return instance;
  }

  public AirbnbRating create(AirbnbRating airbnbRating) throws SQLException {
    String insertAirbnbRating =
            "INSERT INTO airbnb_rating(rating_id, user_id, listing_id, rating_score, accuracy_score, " +
                    "cleanliness_score, checkin_score, communication_score, location_score, value_score, date) " +
            "VALUES(?,?,?,?,?,?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertAirbnbRating);
      insertStmt.setString(1, airbnbRating.getRatingId());
      insertStmt.setString(2, airbnbRating.getUserId());
      insertStmt.setString(3, airbnbRating.getListingId());
      insertStmt.setInt(4, airbnbRating.getRatingScore());
      insertStmt.setInt(5, airbnbRating.getAccuracyScore());
      insertStmt.setInt(6, airbnbRating.getCleanlinessScore());
      insertStmt.setInt(7, airbnbRating.getCheckinScore());
      insertStmt.setInt(8, airbnbRating.getCommunicationScore());
      insertStmt.setInt(9, airbnbRating.getLocationScore());
      insertStmt.setInt(10, airbnbRating.getValueScore());
      insertStmt.setTimestamp(11, Timestamp.from(airbnbRating.getDate()));
      insertStmt.executeUpdate();
      return airbnbRating;
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

  public AirbnbRating getAirbnbRatingById(String ratingId) throws SQLException {
    String selectAirbnbRating =
            "SELECT rating_id, user_id, listing_id, rating_score, accuracy_score, cleanliness_score, " +
                    "checkin_score, communication_score, location_score, value_score, date " +
            "FROM airbnb_rating WHERE rating_id=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectAirbnbRating);
      selectStmt.setString(1, ratingId);
      results = selectStmt.executeQuery();
      if(results.next()) {
        String resultRatingId = results.getString("rating_id");
        String userId = results.getString("user_id");
        String listingId = results.getString("listing_id");
        Integer ratingScore = results.getInt("rating_score");
        Integer accuracyScore = results.getInt("accuracy_score");
        Integer cleanlinessScore = results.getInt("cleanliness_score");
        Integer checkinScore = results.getInt("checkin_score");
        Integer communicationScore = results.getInt("communication_score");
        Integer locationScore = results.getInt("location_score");
        Integer valueScore = results.getInt("value_score");
        Instant date = results.getTimestamp("date").toInstant();
        AirbnbRating airbnbRating = new AirbnbRating(resultRatingId, userId, listingId,
                ratingScore, accuracyScore, cleanlinessScore, checkinScore, communicationScore,
                locationScore, valueScore, date);
        return airbnbRating;
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

  public AirbnbRating delete(AirbnbRating airbnbRating) throws SQLException {
    String deleteAirbnbRating = "DELETE FROM airbnb_rating WHERE rating_id=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteAirbnbRating);
      deleteStmt.setString(1, airbnbRating.getRatingId());
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
