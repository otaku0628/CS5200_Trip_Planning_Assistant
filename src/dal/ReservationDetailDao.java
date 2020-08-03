package dal;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ReservationDetail;

public class ReservationDetailDao {

  protected ConnectionManager connectionManager;

  private static ReservationDetailDao instance = null;
  protected ReservationDetailDao() {
    connectionManager = new ConnectionManager();
  }
  public static ReservationDetailDao getInstance() {
    if(instance == null) {
      instance = new ReservationDetailDao();
    }
    return instance;
  }

  public ReservationDetail create(ReservationDetail reservationDetail) throws SQLException {
    String insertReservationDetail =
            "INSERT INTO reservation_detail(listing_id, daily_price, weekly_price, monthly_price, " +
                    "deposit, cleaning_fee, minimum_nights, maximum_nights, cancellation_policy) " +
            "VALUES(?,?,?,?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertReservationDetail);
      insertStmt.setString(1, reservationDetail.getListingId());
      insertStmt.setBigDecimal(2, reservationDetail.getDailyPrice());
      insertStmt.setBigDecimal(3, reservationDetail.getWeeklyPrice());
      insertStmt.setBigDecimal(4, reservationDetail.getMonthlyPrice());
      insertStmt.setBigDecimal(5, reservationDetail.getDeposit());
      insertStmt.setBigDecimal(6, reservationDetail.getCleaningFee());
      insertStmt.setInt(7, reservationDetail.getMinimumNights());
      insertStmt.setInt(8, reservationDetail.getMaximumNights());
      insertStmt.setString(9, reservationDetail.getCancellationPolicy());
      insertStmt.executeUpdate();
      return reservationDetail;
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

  public ReservationDetail getReservationDetailById(String listingId) throws SQLException {
    String selectReservationDetail =
            "SELECT listing_id, daily_price, weekly_price, monthly_price, deposit, cleaning_fee, " +
                    "minimum_nights, maximum_nights, cancellation_policy " +
            "FROM reservation_detail WHERE listing_id=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectReservationDetail);
      selectStmt.setString(1, listingId);
      results = selectStmt.executeQuery();
      if(results.next()) {
        String resultListingId = results.getString("listing_id");
        BigDecimal dailyPrice = results.getBigDecimal("daily_price");
        BigDecimal weeklyPrice = results.getBigDecimal("weekly_price");
        BigDecimal monthlyPrice = results.getBigDecimal("monthly_price");
        BigDecimal deposit = results.getBigDecimal("deposit");
        BigDecimal cleaningFee = results.getBigDecimal("cleaning_fee");
        Integer minimumNights = results.getInt("minimum_nights");
        Integer maximumNights = results.getInt("maximum_nights");
        String cancellationPolicy = results.getString("cancellation_policy");
        ReservationDetail reservationDetail = new ReservationDetail(resultListingId, dailyPrice,
                weeklyPrice, monthlyPrice, deposit, cleaningFee, minimumNights, maximumNights, cancellationPolicy);
        return reservationDetail;
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

  public ReservationDetail delete(ReservationDetail reservationDetail) throws SQLException {
    String deleteReservationDetail = "DELETE FROM reservation_detail WHERE listing_id=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteReservationDetail);
      deleteStmt.setString(1, reservationDetail.getListingId());
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
