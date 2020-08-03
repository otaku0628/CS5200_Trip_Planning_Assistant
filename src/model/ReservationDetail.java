package model;

import java.math.BigDecimal;

/**
 * CREATE TABLE IF NOT EXISTS `trip_planning_assistant`.`reservation_detail` (
 *   `listing_id` VARCHAR(255) NOT NULL,
 *   `daily_price` DECIMAL(11,2) NULL,
 *   `weekly_price` DECIMAL(11,2) NULL,
 *   `monthly_price` DECIMAL(11,2) NULL,
 *   `deposit` DECIMAL(11,2) NULL,
 *   `cleaning_fee` DECIMAL(11,2) NULL,
 *   `minimum_nights` INT NULL,
 *   `maximum_nights` INT NULL,
 *   `cancellation_policy` VARCHAR(255) NOT NULL,
 *   PRIMARY KEY (`listing_id`),
 *   CONSTRAINT `fk_reservation_detail_airbnb_listing1`
 *     FOREIGN KEY (`listing_id`)
 *     REFERENCES `trip_planning_assistant`.`airbnb_listing` (`listing_id`)
 *     ON DELETE CASCADE
 *     ON UPDATE CASCADE)
 */
public class ReservationDetail {

  private String listingId;
  private BigDecimal dailyPrice;
  private BigDecimal weeklyPrice;
  private BigDecimal monthlyPrice;
  private BigDecimal deposit;
  private BigDecimal cleaningFee;
  private Integer minimumNights;
  private Integer maximumNights;
  private String cancellationPolicy;

  public ReservationDetail(String listingId) {
    this.listingId = listingId;
  }

  public ReservationDetail(String listingId, BigDecimal dailyPrice, BigDecimal weeklyPrice, BigDecimal monthlyPrice, BigDecimal deposit, BigDecimal cleaningFee, Integer minimumNights, Integer maximumNights, String cancellationPolicy) {
    this.listingId = listingId;
    this.dailyPrice = dailyPrice;
    this.weeklyPrice = weeklyPrice;
    this.monthlyPrice = monthlyPrice;
    this.deposit = deposit;
    this.cleaningFee = cleaningFee;
    this.minimumNights = minimumNights;
    this.maximumNights = maximumNights;
    this.cancellationPolicy = cancellationPolicy;
  }

  public String getListingId() {
    return listingId;
  }

  public void setListingId(String listingId) {
    this.listingId = listingId;
  }

  public BigDecimal getDailyPrice() {
    return dailyPrice;
  }

  public void setDailyPrice(BigDecimal dailyPrice) {
    this.dailyPrice = dailyPrice;
  }

  public BigDecimal getWeeklyPrice() {
    return weeklyPrice;
  }

  public void setWeeklyPrice(BigDecimal weeklyPrice) {
    this.weeklyPrice = weeklyPrice;
  }

  public BigDecimal getMonthlyPrice() {
    return monthlyPrice;
  }

  public void setMonthlyPrice(BigDecimal monthlyPrice) {
    this.monthlyPrice = monthlyPrice;
  }

  public BigDecimal getDeposit() {
    return deposit;
  }

  public void setDeposit(BigDecimal deposit) {
    this.deposit = deposit;
  }

  public BigDecimal getCleaningFee() {
    return cleaningFee;
  }

  public void setCleaningFee(BigDecimal cleaningFee) {
    this.cleaningFee = cleaningFee;
  }

  public Integer getMinimumNights() {
    return minimumNights;
  }

  public void setMinimumNights(Integer minimumNights) {
    this.minimumNights = minimumNights;
  }

  public Integer getMaximumNights() {
    return maximumNights;
  }

  public void setMaximumNights(Integer maximumNights) {
    this.maximumNights = maximumNights;
  }

  public String getCancellationPolicy() {
    return cancellationPolicy;
  }

  public void setCancellationPolicy(String cancellationPolicy) {
    this.cancellationPolicy = cancellationPolicy;
  }

  @Override
  public String toString() {
    return "ReservationDetail{" +
            "listingId='" + listingId + '\'' +
            ", dailyPrice=" + dailyPrice +
            ", weeklyPrice=" + weeklyPrice +
            ", monthlyPrice=" + monthlyPrice +
            ", deposit=" + deposit +
            ", cleaningFee=" + cleaningFee +
            ", minimumNights=" + minimumNights +
            ", maximumNights=" + maximumNights +
            ", cancellationPolicy='" + cancellationPolicy + '\'' +
            '}';
  }
}
