package model;

import java.time.LocalTime;

/**
 * CREATE TABLE IF NOT EXISTS `trip_planning_assistant`.`business_hour` (
 *   `uuid` VARCHAR(255) NOT NULL,
 *   `business_id` VARCHAR(255) NOT NULL,
 *   `day_of_week` VARCHAR(255) NOT NULL,
 *   `open_time` TIME NOT NULL,
 *   `close_time` TIME NOT NULL,
 *   PRIMARY KEY (`uuid`),
 *   CONSTRAINT `fk_business_hour_yelp_buisness1`
 *     FOREIGN KEY (`business_id`)
 *     REFERENCES `trip_planning_assistant`.`business_overview` (`business_id`)
 *     ON DELETE CASCADE
 *     ON UPDATE CASCADE)
 */
public class BusinessHour {

  private String uuid;
  private String businessId;
  private String dayOfWeek;
  private LocalTime openTime;
  private LocalTime closeTime;

  public BusinessHour(String uuid) {
    this.uuid = uuid;
  }

  public BusinessHour(String uuid, String businessId, String dayOfWeek, LocalTime openTime, LocalTime closeTime) {
    this.uuid = uuid;
    this.businessId = businessId;
    this.dayOfWeek = dayOfWeek;
    this.openTime = openTime;
    this.closeTime = closeTime;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getBusinessId() {
    return businessId;
  }

  public void setBusinessId(String businessId) {
    this.businessId = businessId;
  }

  public String getDayOfWeek() {
    return dayOfWeek;
  }

  public void setDayOfWeek(String dayOfWeek) {
    this.dayOfWeek = dayOfWeek;
  }

  public LocalTime getOpenTime() {
    return openTime;
  }

  public void setOpenTime(LocalTime openTime) {
    this.openTime = openTime;
  }

  public LocalTime getCloseTime() {
    return closeTime;
  }

  public void setCloseTime(LocalTime closeTime) {
    this.closeTime = closeTime;
  }

  @Override
  public String toString() {
    return "BusinessHour{" +
            "uuid='" + uuid + '\'' +
            ", businessId='" + businessId + '\'' +
            ", dayOfWeek='" + dayOfWeek + '\'' +
            ", openTime=" + openTime +
            ", closeTime=" + closeTime +
            '}';
  }
}
