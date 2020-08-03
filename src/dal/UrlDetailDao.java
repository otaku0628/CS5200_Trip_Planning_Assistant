package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.UrlDetail;

public class UrlDetailDao {

  protected ConnectionManager connectionManager;

  private static UrlDetailDao instance = null;
  protected UrlDetailDao() {
    connectionManager = new ConnectionManager();
  }
  public static UrlDetailDao getInstance() {
    if(instance == null) {
      instance = new UrlDetailDao();
    }
    return instance;
  }

  public UrlDetail create(UrlDetail urlDetail) throws SQLException {
    String insertUrlDetail =
            "INSERT INTO url_detail(listing_id, listing_url, thumbnail_url, medium_url, " +
                    "picture_url, xl_picture_url) " +
            "VALUES(?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertUrlDetail);
      insertStmt.setString(1, urlDetail.getListingId());
      insertStmt.setString(2, urlDetail.getListingUrl());
      insertStmt.setString(3, urlDetail.getThumbnailUrl());
      insertStmt.setString(4, urlDetail.getMediumUrl());
      insertStmt.setString(5, urlDetail.getPictureUrl());
      insertStmt.setString(6, urlDetail.getXlPictureUrl());
      insertStmt.executeUpdate();
      return urlDetail;
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

  public UrlDetail getUrlDetailById(String listingId) throws SQLException {
    String selectUrlDetail =
            "SELECT listing_id, listing_url, thumbnail_url, medium_url, picture_url, xl_picture_url " +
            "FROM url_detail WHERE listing_id=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectUrlDetail);
      selectStmt.setString(1, listingId);
      results = selectStmt.executeQuery();
      if(results.next()) {
        String resultListingId = results.getString("listing_id");
        String listingUrl = results.getString("listing_url");
        String thumbnailUrl = results.getString("thumbnail_url");
        String mediumUrl = results.getString("medium_url");
        String pictureUrl = results.getString("picture_url");
        String xlPictureUrl = results.getString("xl_picture_url");
        UrlDetail urlDetail = new UrlDetail(resultListingId, listingUrl, thumbnailUrl, mediumUrl,
                pictureUrl, xlPictureUrl);
        return urlDetail;
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

  public UrlDetail delete(UrlDetail urlDetail) throws SQLException {
    String deleteUrlDetail = "DELETE FROM url_detail WHERE listing_id=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteUrlDetail);
      deleteStmt.setString(1, urlDetail.getListingId());
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
