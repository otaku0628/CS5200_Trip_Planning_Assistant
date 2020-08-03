package model;

/**
 * CREATE TABLE IF NOT EXISTS `trip_planning_assistant`.`review_detail` (
 *   `listing_id` VARCHAR(255) NOT NULL,
 *   `review_count` INT NULL,
 *   `rating_score` INT NULL,
 *   `accuracy_score` INT NULL,
 *   `cleanliness_score` INT NULL,
 *   `checkin_score` INT NULL,
 *   `communication_score` INT NULL,
 *   `location_score` INT NULL,
 *   `value_score` INT NULL,
 *   PRIMARY KEY (`listing_id`),
 *   CONSTRAINT `fk_review_detail_airbnb_listing1`
 *     FOREIGN KEY (`listing_id`)
 *     REFERENCES `trip_planning_assistant`.`airbnb_listing` (`listing_id`)
 *     ON DELETE CASCADE
 *     ON UPDATE CASCADE)
 */
public class ReviewDetail {

  private String listingId;
  private Integer reviewCount;
  private Integer ratingScore;
  private Integer accuracyScore;
  private Integer cleanlinessScore;
  private Integer checkinScore;
  private Integer communicationScore;
  private Integer locationScore;
  private Integer valueScore;

  public ReviewDetail(String listingId) {
    this.listingId = listingId;
  }

  public ReviewDetail(String listingId, Integer reviewCount, Integer ratingScore, Integer accuracyScore, Integer cleanlinessScore, Integer checkinScore, Integer communicationScore, Integer locationScore, Integer valueScore) {
    this.listingId = listingId;
    this.reviewCount = reviewCount;
    this.ratingScore = ratingScore;
    this.accuracyScore = accuracyScore;
    this.cleanlinessScore = cleanlinessScore;
    this.checkinScore = checkinScore;
    this.communicationScore = communicationScore;
    this.locationScore = locationScore;
    this.valueScore = valueScore;
  }

  public String getListingId() {
    return listingId;
  }

  public void setListingId(String listingId) {
    this.listingId = listingId;
  }

  public Integer getReviewCount() {
    return reviewCount;
  }

  public void setReviewCount(Integer reviewCount) {
    this.reviewCount = reviewCount;
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

  @Override
  public String toString() {
    return "ReviewDetail{" +
            "listingId='" + listingId + '\'' +
            ", reviewCount=" + reviewCount +
            ", ratingScore=" + ratingScore +
            ", accuracyScore=" + accuracyScore +
            ", cleanlinessScore=" + cleanlinessScore +
            ", checkinScore=" + checkinScore +
            ", communicationScore=" + communicationScore +
            ", locationScore=" + locationScore +
            ", valueScore=" + valueScore +
            '}';
  }
}
