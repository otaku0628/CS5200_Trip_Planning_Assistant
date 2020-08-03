package servlet.listing.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dal.ConnectionManager;
import servlet.listing.model.RecommendationCard;

public class RecommendationDao {

  protected ConnectionManager connectionManager;

  private static RecommendationDao instance = null;
  protected RecommendationDao() {
    connectionManager = new ConnectionManager();
  }
  public static RecommendationDao getInstance() {
    if(instance == null) {
      instance = new RecommendationDao();
    }
    return instance;
  }

  public List<RecommendationCard> getRecommendationCards(BigDecimal listingLongitude,
                                                         BigDecimal listingLatitude,
                                                         BigDecimal distance) throws SQLException {

    List<RecommendationCard> recommendationCards = new ArrayList<>();
    String selectRecommendationCards =
            "SELECT distance, business_id, name, address, city, state, postal_code, stars, " +
                    "review_count, is_open, categories " +
            "FROM (" +
                "SELECT " +
                    "ST_Distance_Sphere(POINT(b.longitude, b.latitude), POINT(?, ?)) AS distance, " +
                    "b.* " +
                "FROM business_overview b " +
            ") business_with_distance " +
            "WHERE distance <= ? " +
            "ORDER BY distance ASC;";

    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectRecommendationCards);
      selectStmt.setBigDecimal(1, listingLongitude);
      selectStmt.setBigDecimal(2, listingLatitude);
      selectStmt.setBigDecimal(3, distance);
      results = selectStmt.executeQuery();
      while(results.next()) {
        BigDecimal resultDistance = results.getBigDecimal("distance");
        String businessId = results.getString("business_id");
        String name = results.getString("name");
        String address = results.getString("address");
        String city = results.getString("city");
        String state = results.getString("state");
        String postalCode = results.getString("postal_code");
        BigDecimal stars = results.getBigDecimal("stars");
        Integer reviewCount = results.getInt("review_count");
        Boolean isOpen = results.getBoolean("is_open");
        String categories = results.getString("categories");
        RecommendationCard recommendationCard =
                new RecommendationCard(resultDistance, businessId, name, address, city, state,
                        postalCode, stars, reviewCount, isOpen, categories);
        recommendationCards.add(recommendationCard);
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
    return recommendationCards;
  }
}
