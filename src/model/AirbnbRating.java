package model;

import java.time.Instant;

/**
 * CREATE TABLE IF NOT EXISTS `trip_planning_assistant`.`airbnb_rating` (
 *   `rating_id` VARCHAR(255) NOT NULL,
 *   `user_id` VARCHAR(255) NULL,
 *   `listing_id` VARCHAR(255) NOT NULL,
 *   `rating_score` INT NOT NULL,
 *   `accuracy_score` INT NULL,
 *   `cleanliness_score` INT NULL,
 *   `checkin_score` INT NULL,
 *   `communication_score` INT NULL,
 *   `location_score` INT NULL,
 *   `value_score` INT NULL,
 *   `date` TIMESTAMP NULL,
 *   PRIMARY KEY (`rating_id`),
 *   CONSTRAINT `fk_airbnb_review_user10`
 *     FOREIGN KEY (`user_id`)
 *     REFERENCES `trip_planning_assistant`.`user` (`user_id`)
 *     ON DELETE SET NULL
 *     ON UPDATE CASCADE,
 *   CONSTRAINT `fk_airbnb_review_airbnb_listing10`
 *     FOREIGN KEY (`listing_id`)
 *     REFERENCES `trip_planning_assistant`.`airbnb_listing` (`listing_id`)
 *     ON DELETE CASCADE
 *     ON UPDATE CASCADE)
 */
public class AirbnbRating {

  private String ratingId;
  private String userId;
  private String listingId;
  private Integer ratingScore;
  private Integer accuracyScore;
  private Integer cleanlinessScore;
  private Integer checkinScore;
  private Integer communicationScore;
  private Integer locationScore;
  private Integer valueScore;
  private Instant date;

  public AirbnbRating(String ratingId) {
    this.ratingId = ratingId;
  }

  public AirbnbRating(String ratingId, String userId, String listingId, Integer ratingScore, Integer accuracyScore, Integer cleanlinessScore, Integer checkinScore, Integer communicationScore, Integer locationScore, Integer valueScore, Instant date) {
    this.ratingId = ratingId;
    this.userId = userId;
    this.listingId = listingId;
    this.ratingScore = ratingScore;
    this.accuracyScore = accuracyScore;
    this.cleanlinessScore = cleanlinessScore;
    this.checkinScore = checkinScore;
    this.communicationScore = communicationScore;
    this.locationScore = locationScore;
    this.valueScore = valueScore;
    this.date = date;
  }

  public String getRatingId() {
    return ratingId;
  }

  public void setRatingId(String ratingId) {
    this.ratingId = ratingId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getListingId() {
    return listingId;
  }

  public void setListingId(String listingId) {
    this.listingId = listingId;
  }

  public Integer getRatingScore() {
    return ratingScore;
  }

  public void setRatingScore(Integer ratingScore) {
    this.ratingScore = ratingScore;
  }

  public Integer getAccuracyScore() {
    return accuracyScore;
  }

  public void setAccuracyScore(Integer accuracyScore) {
    this.accuracyScore = accuracyScore;
  }

  public Integer getCleanlinessScore() {
    return cleanlinessScore;
  }

  public void setCleanlinessScore(Integer cleanlinessScore) {
    this.cleanlinessScore = cleanlinessScore;
  }

  public Integer getCheckinScore() {
    return checkinScore;
  }

  public void setCheckinScore(Integer checkinScore) {
    this.checkinScore = checkinScore;
  }

  public Integer getCommunicationScore() {
    return communicationScore;
  }

  public void setCommunicationScore(Integer communicationScore) {
    this.communicationScore = communicationScore;
  }

  public Integer getLocationScore() {
    return locationScore;
  }

  public void setLocationScore(Integer locationScore) {
    this.locationScore = locationScore;
  }

  public Integer getValueScore() {
    return valueScore;
  }

  public void setValueScore(Integer valueScore) {
    this.valueScore = valueScore;
  }

  public Instant getDate() {
    return date;
  }

  public void setDate(Instant date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "AirbnbRating{" +
            "ratingId='" + ratingId + '\'' +
            ", userId='" + userId + '\'' +
            ", listingId='" + listingId + '\'' +
            ", ratingScore='" + ratingScore + '\'' +
            ", accuracyScore='" + accuracyScore + '\'' +
            ", cleanlinessScore='" + cleanlinessScore + '\'' +
            ", checkinScore='" + checkinScore + '\'' +
            ", communicationScore='" + communicationScore + '\'' +
            ", locationScore='" + locationScore + '\'' +
            ", valueScore='" + valueScore + '\'' +
            ", date=" + date +
            '}';
  }
}
