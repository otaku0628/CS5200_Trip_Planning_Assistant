package model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * CREATE TABLE IF NOT EXISTS `trip_planning_assistant`.`airbnb_host` (
 *   `host_id` VARCHAR(255) NOT NULL,
 *   `host_url` VARCHAR(255) NOT NULL,
 *   `name` VARCHAR(255) NULL,
 *   `since` DATE NULL,
 *   `location` VARCHAR(255) NULL,
 *   `about` TEXT NULL,
 *   `response_time` VARCHAR(255) NULL,
 *   `response_rate` DECIMAL(5,2) NULL,
 *   `listing_count` INT NULL,
 *   `verification` VARCHAR(255) NULL,
 *   PRIMARY KEY (`host_id`))
 */
public class AirbnbHost {

  private String hostId;
  private String hostUrl;
  private String name;
  private LocalDate since;
  private String location;
  private String about;
  private String responseTime;
  private BigDecimal responseRate;
  private Integer listingCount;
  private String verification;

  public AirbnbHost(String hostId) {
    this.hostId = hostId;
  }

  public AirbnbHost(String hostId, String hostUrl, String name, LocalDate since, String location, String about, String responseTime, BigDecimal responseRate, Integer listingCount, String verification) {
    this.hostId = hostId;
    this.hostUrl = hostUrl;
    this.name = name;
    this.since = since;
    this.location = location;
    this.about = about;
    this.responseTime = responseTime;
    this.responseRate = responseRate;
    this.listingCount = listingCount;
    this.verification = verification;
  }

  public String getHostId() {
    return hostId;
  }

  public void setHostId(String hostId) {
    this.hostId = hostId;
  }

  public String getHostUrl() {
    return hostUrl;
  }

  public void setHostUrl(String hostUrl) {
    this.hostUrl = hostUrl;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDate getSince() {
    return since;
  }

  public void setSince(LocalDate since) {
    this.since = since;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getAbout() {
    return about;
  }

  public void setAbout(String about) {
    this.about = about;
  }

  public String getResponseTime() {
    return responseTime;
  }

  public void setResponseTime(String responseTime) {
    this.responseTime = responseTime;
  }

  public BigDecimal getResponseRate() {
    return responseRate;
  }

  public void setResponseRate(BigDecimal responseRate) {
    this.responseRate = responseRate;
  }

  public Integer getListingCount() {
    return listingCount;
  }

  public void setListingCount(Integer listingCount) {
    this.listingCount = listingCount;
  }

  public String getVerification() {
    return verification;
  }

  public void setVerification(String verification) {
    this.verification = verification;
  }

  @Override
  public String toString() {
    return "AirbnbHost{" +
            "hostId='" + hostId + '\'' +
            ", hostUrl='" + hostUrl + '\'' +
            ", name='" + name + '\'' +
            ", since=" + since +
            ", location='" + location + '\'' +
            ", about='" + about + '\'' +
            ", responseTime='" + responseTime + '\'' +
            ", responseRate=" + responseRate +
            ", listingCount=" + listingCount +
            ", verification='" + verification + '\'' +
            '}';
  }
}
