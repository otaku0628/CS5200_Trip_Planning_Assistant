package model;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * CREATE TABLE IF NOT EXISTS `trip_planning_assistant`.`business_review` (
 *   `review_id` VARCHAR(255) NOT NULL,
 *   `user_id` VARCHAR(255) NULL,
 *   `business_id` VARCHAR(255) NOT NULL,
 *   `stars` DECIMAL(3,2) NOT NULL,
 *   `useful` INT NOT NULL,
 *   `text` TEXT NULL,
 *   `date` TIMESTAMP NOT NULL,
 *   PRIMARY KEY (`review_id`),
 *   CONSTRAINT `fk_business_review_yelp_buisness1`
 *     FOREIGN KEY (`business_id`)
 *     REFERENCES `trip_planning_assistant`.`business_overview` (`business_id`)
 *     ON DELETE CASCADE
 *     ON UPDATE CASCADE,
 *   CONSTRAINT `fk_business_review_user1`
 *     FOREIGN KEY (`user_id`)
 *     REFERENCES `trip_planning_assistant`.`user` (`user_id`)
 *     ON DELETE SET NULL
 *     ON UPDATE CASCADE)
 */
public class BusinessReview {

  private String reviewId;
  private String userId;
  private String businessId;
  private BigDecimal stars;
  private Integer useful;
  private String text;
  private Instant date;

  public BusinessReview(String reviewId) {
    this.reviewId = reviewId;
  }

  public BusinessReview(String reviewId, String userId, String businessId, BigDecimal stars, Integer useful, String text, Instant date) {
    this.reviewId = reviewId;
    this.userId = userId;
    this.businessId = businessId;
    this.stars = stars;
    this.useful = useful;
    this.text = text;
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

  public String getBusinessId() {
    return businessId;
  }

  public void setBusinessId(String businessId) {
    this.businessId = businessId;
  }

  public BigDecimal getStars() {
    return stars;
  }

  public void setStars(BigDecimal stars) {
    this.stars = stars;
  }

  public Integer getUseful() {
    return useful;
  }

  public void setUseful(Integer useful) {
    this.useful = useful;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Instant getDate() {
    return date;
  }

  public void setDate(Instant date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "BusinessReview{" +
            "reviewId='" + reviewId + '\'' +
            ", userId='" + userId + '\'' +
            ", businessId='" + businessId + '\'' +
            ", stars=" + stars +
            ", useful=" + useful +
            ", text='" + text + '\'' +
            ", date=" + date +
            '}';
  }
}
