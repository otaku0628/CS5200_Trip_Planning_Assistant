package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.RoomDetail;

public class RoomDetailDao {

  protected ConnectionManager connectionManager;

  private static RoomDetailDao instance = null;
  protected RoomDetailDao() {
    connectionManager = new ConnectionManager();
  }
  public static RoomDetailDao getInstance() {
    if(instance == null) {
      instance = new RoomDetailDao();
    }
    return instance;
  }

  public RoomDetail create(RoomDetail roomDetail) throws SQLException {
    String insertRoomDetail =
            "INSERT INTO room_detail(listing_id, property_type, room_type, accommodates, " +
                    "bathroom_count, bedroom_count, bed_count, bed_type, amenities, features) " +
            "VALUES(?,?,?,?,?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertRoomDetail);
      insertStmt.setString(1, roomDetail.getListingId());
      insertStmt.setString(2, roomDetail.getPropertyType());
      insertStmt.setString(3, roomDetail.getRoomType());
      insertStmt.setInt(4, roomDetail.getAccommodates());
      insertStmt.setInt(5, roomDetail.getBathroomCount());
      insertStmt.setInt(6, roomDetail.getBedroomCount());
      insertStmt.setInt(7, roomDetail.getBedCount());
      insertStmt.setString(8, roomDetail.getBedType());
      insertStmt.setString(9, roomDetail.getAmenities());
      insertStmt.setString(10, roomDetail.getFeatures());
      insertStmt.executeUpdate();
      return roomDetail;
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

  public RoomDetail getRoomDetailById(String listingId) throws SQLException {
    String selectRoomDetail =
            "SELECT listing_id, property_type, room_type, accommodates, bathroom_count, " +
                    "bedroom_count, bed_count, bed_type, amenities, features " +
            "FROM room_detail WHERE listing_id=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectRoomDetail);
      selectStmt.setString(1, listingId);
      results = selectStmt.executeQuery();
      if(results.next()) {
        String resultListingId = results.getString("listing_id");
        String propertyType = results.getString("property_type");
        String roomType = results.getString("room_type");
        Integer accommodates = results.getInt("accommodates");
        Integer bathroomCount = results.getInt("bathroom_count");
        Integer bedroomCount = results.getInt("bedroom_count");
        Integer bedCount = results.getInt("bed_count");
        String bedType = results.getString("bed_type");
        String amenities = results.getString("amenities");
        String features = results.getString("features");
        RoomDetail roomDetail = new RoomDetail(resultListingId, propertyType, roomType,
                accommodates, bathroomCount, bedroomCount, bedCount, bedType, amenities, features);
        return roomDetail;
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

  public RoomDetail delete(RoomDetail roomDetail) throws SQLException {
    String deleteRoomDetail = "DELETE FROM room_detail WHERE listing_id=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteRoomDetail);
      deleteStmt.setString(1, roomDetail.getListingId());
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
