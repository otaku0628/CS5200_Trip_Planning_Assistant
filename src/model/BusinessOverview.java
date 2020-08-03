package model;

import java.math.BigDecimal;

/**
 * CREATE TABLE IF NOT EXISTS `trip_planning_assistant`.`business_overview` (
 *   `buisness_id` VARCHAR(255) NOT NULL,
 *   `name` VARCHAR(255) NOT NULL,
 *   `address` VARCHAR(255) NULL,
 *   `city` VARCHAR(255) NULL,
 *   `state` VARCHAR(255) NULL,
 *   `postal_code` VARCHAR(255) NULL,
 *   `latitude` DECIMAL(12,9) NULL,
 *   `longitude` DECIMAL(12,9) NULL,
 *   `stars` DECIMAL(3,2) NULL,
 *   `review_count` INT NULL,
 *   `is_open` TINYINT NULL,
 *   `categories` VARCHAR(255) NULL,
 *   PRIMARY KEY (`buisness_id`))
 */
public class BusinessOverview {

  private String businessId;
  private String name;
  private String address;
  private String city;
  private String state;
  private String postalCode;
  private BigDecimal latitude;
  private BigDecimal longitude;
  private BigDecimal stars;
  private Integer reviewCount;
  private Boolean isOpen;
  private String categories;

  public BusinessOverview(String businessId) {
    this.businessId = businessId;
  }

  public BusinessOverview(String businessId, String name, String address, String city, String state, String postalCode, BigDecimal latitude, BigDecimal longitude, BigDecimal stars, Integer reviewCount, Boolean isOpen, String categories) {
    this.businessId = businessId;
    this.name = name;
    this.address = address;
    this.city = city;
    this.state = state;
    this.postalCode = postalCode;
    this.latitude = latitude;
    this.longitude = longitude;
    this.stars = stars;
    this.reviewCount = reviewCount;
    this.isOpen = isOpen;
    this.categories = categories;
  }

  public String getBusinessId() {
    return businessId;
  }

  public void setBusinessId(String businessId) {
    this.businessId = businessId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public BigDecimal getLatitude() {
    return latitude;
  }

  public void setLatitude(BigDecimal latitude) {
    this.latitude = latitude;
  }

  public BigDecimal getLongitude() {
    return longitude;
  }

  public void setLongitude(BigDecimal longitude) {
    this.longitude = longitude;
  }

  public BigDecimal getStars() {
    return stars;
  }

  public void setStars(BigDecimal stars) {
    this.stars = stars;
  }

  public Integer getReviewCount() {
    return reviewCount;
  }

  public void setReviewCount(Integer reviewCount) {
    this.reviewCount = reviewCount;
  }

  public Boolean getOpen() {
    return isOpen;
  }

  public void setOpen(Boolean open) {
    isOpen = open;
  }

  public String getCategories() {
    return categories;
  }

  public void setCategories(String categories) {
    this.categories = categories;
  }

  @Override
  public String toString() {
    return "BusinessOverview{" +
            "businessId='" + businessId + '\'' +
            ", name='" + name + '\'' +
            ", address='" + address + '\'' +
            ", city='" + city + '\'' +
            ", state='" + state + '\'' +
            ", postalCode='" + postalCode + '\'' +
            ", latitude=" + latitude +
            ", longitude=" + longitude +
            ", stars=" + stars +
            ", reviewCount=" + reviewCount +
            ", isOpen=" + isOpen +
            ", categories='" + categories + '\'' +
            '}';
  }
}
