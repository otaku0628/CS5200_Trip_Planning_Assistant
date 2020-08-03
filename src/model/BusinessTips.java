package model;

import java.time.Instant;

/**
 * CREATE TABLE IF NOT EXISTS `trip_planning_assistant`.`business_tips` (
 *   `uuid` VARCHAR(255) NOT NULL,
 *   `user_id` VARCHAR(255) NULL,
 *   `business_id` VARCHAR(255) NOT NULL,
 *   `text` VARCHAR(255) NOT NULL,
 *   `date` TIMESTAMP NOT NULL,
 *   `compliment_count` INT NOT NULL,
 *   PRIMARY KEY (`uuid`),
 *   CONSTRAINT `fk_business_tips_yelp_buisness1`
 *     FOREIGN KEY (`business_id`)
 *     REFERENCES `trip_planning_assistant`.`business_overview` (`business_id`)
 *     ON DELETE CASCADE
 *     ON UPDATE CASCADE,
 *   CONSTRAINT `fk_business_tips_user1`
 *     FOREIGN KEY (`user_id`)
 *     REFERENCES `trip_planning_assistant`.`user` (`user_id`)
 *     ON DELETE SET NULL
 *     ON UPDATE CASCADE)
 */
public class BusinessTips {

  private String uuid;
  private String userId;
  private String businessId;
  private String text;
  private Instant date;
  private Integer complimentCount;

  public BusinessTips(String uuid) {
    this.uuid = uuid;
  }

  public BusinessTips(String uuid, String userId, String businessId, String text, Instant date, Integer complimentCount) {
    this.uuid = uuid;
    this.userId = userId;
    this.businessId = businessId;
    this.text = text;
    this.date = date;
    this.complimentCount = complimentCount;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
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

  public Integer getComplimentCount() {
    return complimentCount;
  }

  public void setComplimentCount(Integer complimentCount) {
    this.complimentCount = complimentCount;
  }

  @Override
  public String toString() {
    return "BusinessTips{" +
            "uuid='" + uuid + '\'' +
            ", userId='" + userId + '\'' +
            ", businessId='" + businessId + '\'' +
            ", text='" + text + '\'' +
            ", date=" + date +
            ", complimentCount=" + complimentCount +
            '}';
  }
}
