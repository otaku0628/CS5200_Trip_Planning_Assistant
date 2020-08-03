package model;

import java.time.Instant;

/**
 * CREATE TABLE IF NOT EXISTS `trip_planning_assistant`.`airbnb_review` (
 *   `review_id` VARCHAR(255) NOT NULL,
 *   `user_id` VARCHAR(255) NULL,
 *   `listing_id` VARCHAR(255) NOT NULL,
 *   `comment` TEXT NOT NULL,
 *   `date` TIMESTAMP NOT NULL,
 *   PRIMARY KEY (`review_id`),
 *   CONSTRAINT `fk_airbnb_review_user1`
 *     FOREIGN KEY (`user_id`)
 *     REFERENCES `trip_planning_assistant`.`user` (`user_id`)
 *     ON DELETE SET NULL
 *     ON UPDATE CASCADE,
 *   CONSTRAINT `fk_airbnb_review_airbnb_listing1`
 *     FOREIGN KEY (`listing_id`)
 *     REFERENCES `trip_planning_assistant`.`airbnb_listing` (`listing_id`)
 *     ON DELETE CASCADE
 *     ON UPDATE CASCADE)
 */
public class AirbnbReview {

  private String reviewId;
  private String userId;
  private String listingId;
  private String comment;
  private Instant date;

  public AirbnbReview(String reviewId) {
    this.reviewId = reviewId;
  }

  public AirbnbReview(String reviewId, String userId, String listingId, String comment, Instant date) {
    this.reviewId = reviewId;
    this.userId = userId;
    this.listingId = listingId;
    this.comment = comment;
    this.date = date;
  }

  public String getReviewId() {
    return reviewId;
  }

  public void setReviewId(String reviewId) {
    this.reviewId = reviewId;
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

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Instant getDate() {
    return date;
  }

  public void setDate(Instant date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "AirbnbReview{" +
            "reviewId='" + reviewId + '\'' +
            ", userId='" + userId + '\'' +
            ", listingId='" + listingId + '\'' +
            ", comment='" + comment + '\'' +
            ", date=" + date +
            '}';
  }
}
