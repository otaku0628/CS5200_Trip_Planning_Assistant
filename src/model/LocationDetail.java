package model;

import java.math.BigDecimal;

/**
 * CREATE TABLE IF NOT EXISTS `trip_planning_assistant`.`location_detail` (
 *   `listing_id` VARCHAR(255) NOT NULL,
 *   `street` VARCHAR(255) NULL,
 *   `city` VARCHAR(255) NULL,
 *   `state` VARCHAR(255) NULL,
 *   `zip_code` VARCHAR(255) NULL,
 *   `country_code` VARCHAR(255) NULL,
 *   `country` VARCHAR(255) NULL,
 *   `latitude` DECIMAL(12,9) NULL,
 *   `longitude` DECIMAL(12,9) NULL,
 *   PRIMARY KEY (`listing_id`),
 *   CONSTRAINT `fk_location_detail_airbnb_listing1`
 *     FOREIGN KEY (`listing_id`)
 *     REFERENCES `trip_planning_assistant`.`airbnb_listing` (`listing_id`)
 *     ON DELETE CASCADE
 *     ON UPDATE CASCADE)
 */
public class LocationDetail {

  private String listingId;
  private String street;
  private String city;
  private String state;
  private String zipCode;
  private String countryCode;
  private String country;
  private BigDecimal latitude;
  private BigDecimal longitude;

  public LocationDetail(String listingId) {
    this.listingId = listingId;
  }

  public LocationDetail(String listingId, String street, String city, String state, String zipCode, String countryCode, String country, BigDecimal latitude, BigDecimal longitude) {
    this.listingId = listingId;
    this.street = street;
    this.city = city;
    this.state = state;
    this.zipCode = zipCode;
    this.countryCode = countryCode;
    this.country = country;
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public String getListingId() {
    return listingId;
  }

  public void setListingId(String listingId) {
    this.listingId = listingId;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
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

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
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

  @Override
  public String toString() {
    return "LocationDetail{" +
            "listingId='" + listingId + '\'' +
            ", street='" + street + '\'' +
            ", city='" + city + '\'' +
            ", state='" + state + '\'' +
            ", zipCode='" + zipCode + '\'' +
            ", countryCode='" + countryCode + '\'' +
            ", country='" + country + '\'' +
            ", latitude=" + latitude +
            ", longitude=" + longitude +
            '}';
  }
}
