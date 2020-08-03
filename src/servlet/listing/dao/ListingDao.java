package servlet.listing.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dal.ConnectionManager;
import servlet.listing.model.ListingCard;

public class ListingDao {

  protected ConnectionManager connectionManager;

  private static ListingDao instance = null;
  protected ListingDao() {
    connectionManager = new ConnectionManager();
  }
  public static ListingDao getInstance() {
    if(instance == null) {
      instance = new ListingDao();
    }
    return instance;
  }

  public List<ListingCard> getListingCards(String name, String zipCode, String city, String country,
                                           BigDecimal maxPrice, BigDecimal minPrice,
                                           String cancellationPolicy, String roomType,
                                           Integer accommodates, Integer bathroomCount,
                                           Integer bedroomCount, Integer bedCount) throws SQLException {

    if (null != name) name = '%'+name+'%';
    if (null == accommodates) accommodates = 0;
    if (null == bathroomCount) bathroomCount = 0;
    if (null == bedroomCount) bedroomCount = 0;
    if (null == bedCount) bedCount = 0;

    List<ListingCard> listingCards = new ArrayList<>();
    String selectListingCards = 
            "SELECT listing_id, name, city, room_type, accommodates, bathroom_count, " +
                    "bedroom_count, bed_count, features, daily_price, review_count, " +
                    "rating_score, thumbnail_url, longitude, latitude, listing_url " +
            "FROM airbnb_listing " +
                    "INNER JOIN location_detail USING(listing_id) " + 
                    "INNER JOIN room_detail USING(listing_id) " +
                    "INNER JOIN reservation_detail USING(listing_id) " +
                    "INNER JOIN review_detail USING(listing_id) " +
                    "INNER JOIN url_detail USING(listing_id) " +
            "WHERE (? IS NULL OR LOWER(name) LIKE LOWER(?)) " +
                    "AND (? IS NULL OR zip_code = ?) " +
                    "AND (? IS NULL OR city = ?) " +
                    "AND (? IS NULL OR country = ?) " +
                    "AND (? IS NULL OR daily_price <= ?) " +
                    "AND (? IS NULL OR daily_price >= ?) " +
                    "AND (? IS NULL OR cancellation_policy = ?) " +
                    "AND (? IS NULL OR room_type = ?) " +
                    "AND (? IS NULL OR accommodates >= ?) " +
                    "AND (? IS NULL OR bathroom_count >= ?) " +
                    "AND (? IS NULL OR bedroom_count >= ?) " +
                    "AND (? IS NULL OR bed_count >= ?);";

    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectListingCards);
      selectStmt.setString(1, name);
      selectStmt.setString(2, name);
      selectStmt.setString(3, zipCode);
      selectStmt.setString(4, zipCode);
      selectStmt.setString(5, city);
      selectStmt.setString(6, city);
      selectStmt.setString(7, country);
      selectStmt.setString(8, country);
      selectStmt.setBigDecimal(9, maxPrice);
      selectStmt.setBigDecimal(10, maxPrice);
      selectStmt.setBigDecimal(11, minPrice);
      selectStmt.setBigDecimal(12, minPrice);
      selectStmt.setString(13, cancellationPolicy);
      selectStmt.setString(14, cancellationPolicy);
      selectStmt.setString(15, roomType);
      selectStmt.setString(16, roomType);
      selectStmt.setInt(17, accommodates);
      selectStmt.setInt(18, accommodates);
      selectStmt.setInt(19, bathroomCount);
      selectStmt.setInt(20, bathroomCount);
      selectStmt.setInt(21, bedroomCount);
      selectStmt.setInt(22, bedroomCount);
      selectStmt.setInt(23, bedCount);
      selectStmt.setInt(24, bedCount);
      results = selectStmt.executeQuery();
      while(results.next()) {
        String listingId = results.getString("listing_id");
        String resultName = results.getString("name");
        String resultCity = results.getString("city");
        String resultRoomType = results.getString("room_type");
        Integer resultAccommodates = results.getInt("accommodates");
        Integer resultBathroomCount = results.getInt("bathroom_count");
        Integer resultBedroomCount = results.getInt("bedroom_count");
        Integer resultBedCount = results.getInt("bed_count");
        String features = results.getString("features");
        BigDecimal dailyPrice = results.getBigDecimal("daily_price");
        Integer ratingScore = results.getInt("rating_score");
        Integer reviewCount = results.getInt("review_count");
        String thumbnailUrl = results.getString("thumbnail_url");
        BigDecimal longitude = results.getBigDecimal("longitude");
        BigDecimal latitude = results.getBigDecimal("latitude");
        String listingUrl = results.getString("listing_url");
        ListingCard listingCard =
                new ListingCard(listingId, resultName, resultCity, resultRoomType,
                        resultAccommodates, resultBathroomCount, resultBedroomCount,
                        resultBedCount, features, dailyPrice, ratingScore, reviewCount,
                        thumbnailUrl, longitude, latitude, listingUrl);
        listingCards.add(listingCard);
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
    return listingCards;
  }

  public ListingCard getListingCard(String listingId) throws SQLException {

    String selectListingCard =
            "SELECT listing_id, name, city, room_type, accommodates, bathroom_count, " +
                    "bedroom_count, bed_count, features, daily_price, review_count, " +
                    "rating_score, thumbnail_url, longitude, latitude, listing_url " +
                    "FROM airbnb_listing " +
                    "INNER JOIN location_detail USING(listing_id) " +
                    "INNER JOIN room_detail USING(listing_id) " +
                    "INNER JOIN reservation_detail USING(listing_id) " +
                    "INNER JOIN review_detail USING(listing_id) " +
                    "INNER JOIN url_detail USING(listing_id) " +
                    "WHERE listing_id = ?;";

    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectListingCard);
      selectStmt.setString(1, listingId);
      results = selectStmt.executeQuery();
      if(results.next()) {
        String resultListingId = results.getString("listing_id");
        String resultName = results.getString("name");
        String resultCity = results.getString("city");
        String resultRoomType = results.getString("room_type");
        Integer resultAccommodates = results.getInt("accommodates");
        Integer resultBathroomCount = results.getInt("bathroom_count");
        Integer resultBedroomCount = results.getInt("bedroom_count");
        Integer resultBedCount = results.getInt("bed_count");
        String features = results.getString("features");
        BigDecimal dailyPrice = results.getBigDecimal("daily_price");
        Integer ratingScore = results.getInt("rating_score");
        Integer reviewCount = results.getInt("review_count");
        String thumbnailUrl = results.getString("thumbnail_url");
        BigDecimal longitude = results.getBigDecimal("longitude");
        BigDecimal latitude = results.getBigDecimal("latitude");
        String listingUrl = results.getString("listing_url");
        ListingCard listingCard =
                new ListingCard(resultListingId, resultName, resultCity, resultRoomType,
                        resultAccommodates, resultBathroomCount, resultBedroomCount,
                        resultBedCount, features, dailyPrice, ratingScore, reviewCount,
                        thumbnailUrl, longitude, latitude, listingUrl);
        return listingCard;
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
}
