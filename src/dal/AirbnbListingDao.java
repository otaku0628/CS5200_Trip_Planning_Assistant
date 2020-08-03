package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.AirbnbListing;

public class AirbnbListingDao {

  protected ConnectionManager connectionManager;

  private static AirbnbListingDao instance = null;
  protected AirbnbListingDao() {
    connectionManager = new ConnectionManager();
  }
  public static AirbnbListingDao getInstance() {
    if(instance == null) {
      instance = new AirbnbListingDao();
    }
    return instance;
  }

  public AirbnbListing create(AirbnbListing airbnbListing) throws SQLException {
    String insertAirbnbListing =
            "INSERT INTO airbnb_listing(listing_id, host_id, name, summary, space, description, " +
                    "neighborhood_overview, notes, transit, access, interaction, house_rules) " +
            "VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertAirbnbListing);
      insertStmt.setString(1, airbnbListing.getListingId());
      insertStmt.setString(2, airbnbListing.getHostId());
      insertStmt.setString(3, airbnbListing.getName());
      insertStmt.setString(4, airbnbListing.getSummary());
      insertStmt.setString(5, airbnbListing.getSpace());
      insertStmt.setString(6, airbnbListing.getDescription());
      insertStmt.setString(7, airbnbListing.getNeighborhoodOverview());
      insertStmt.setString(8, airbnbListing.getNotes());
      insertStmt.setString(9, airbnbListing.getTransit());
      insertStmt.setString(10, airbnbListing.getAccess());
      insertStmt.setString(11, airbnbListing.getInteraction());
      insertStmt.setString(12, airbnbListing.getHouseRules());
      insertStmt.executeUpdate();
      return airbnbListing;
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

  public AirbnbListing getAirbnbListingById(String listingId) throws SQLException {
    String selectAirbnbListing =
            "SELECT listing_id, host_id, name, summary, space, description, neighborhood_overview, " +
                    "notes, transit, access, interaction, house_rules " +
            "FROM airbnb_listing WHERE listing_id=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectAirbnbListing);
      selectStmt.setString(1, listingId);
      results = selectStmt.executeQuery();
      if(results.next()) {
        String resultListingId = results.getString("listing_id");
        String hostId = results.getString("host_id");
        String name = results.getString("name");
        String summary = results.getString("summary");
        String space = results.getString("space");
        String description = results.getString("description");
        String neighborhoodOverview = results.getString("neighborhood_overview");
        String notes = results.getString("notes");
        String transit = results.getString("transit");
        String access = results.getString("access");
        String interaction = results.getString("interaction");
        String house_rules = results.getString("house_rules");
        AirbnbListing airbnbListing = new AirbnbListing(resultListingId, hostId, name, summary,
                space, description, neighborhoodOverview, notes, transit, access, interaction, house_rules);
        return airbnbListing;
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

  public AirbnbListing delete(AirbnbListing airbnbListing) throws SQLException {
    String deleteAirbnbListing = "DELETE FROM airbnb_listing WHERE listing_id=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteAirbnbListing);
      deleteStmt.setString(1, airbnbListing.getListingId());
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
