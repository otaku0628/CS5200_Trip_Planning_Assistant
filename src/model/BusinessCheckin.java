package model;

import java.time.Instant;

/**
 * CREATE TABLE IF NOT EXISTS `trip_planning_assistant`.`business_checkin` (
 *   `uuid` VARCHAR(255) NOT NULL,
 *   `user_id` VARCHAR(255) NULL,
 *   `business_id` VARCHAR(255) NOT NULL,
 *   `checkin_time` TIMESTAMP NOT NULL,
 *   PRIMARY KEY (`uuid`),
 *   CONSTRAINT `fk_business_checkin_yelp_buisness1`
 *     FOREIGN KEY (`business_id`)
 *     REFERENCES `trip_planning_assistant`.`business_overview` (`business_id`)
 *     ON DELETE CASCADE
 *     ON UPDATE CASCADE,
 *   CONSTRAINT `fk_business_checkin_user1`
 *     FOREIGN KEY (`user_id`)
 *     REFERENCES `trip_planning_assistant`.`user` (`user_id`)
 *     ON DELETE SET NULL
 *     ON UPDATE CASCADE)
 */
public class BusinessCheckin {

  private String uuid;
  private String userId;
  private String businessId;
  private Instant checkinTime;

  public BusinessCheckin(String uuid) {
    this.uuid = uuid;
  }

  public BusinessCheckin(String uuid, String userId, String businessId, Instant checkinTime) {
    this.uuid = uuid;
    this.userId = userId;
    this.businessId = businessId;
    this.checkinTime = checkinTime;
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

  public Instant getCheckinTime() {
    return checkinTime;
  }

  public void setCheckinTime(Instant checkinTime) {
    this.checkinTime = checkinTime;
  }

  @Override
  public String toString() {
    return "BusinessCheckin{" +
            "uuid='" + uuid + '\'' +
            ", userId='" + userId + '\'' +
            ", businessId='" + businessId + '\'' +
            ", checkinTime=" + checkinTime +
            '}';
  }
}
