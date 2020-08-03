package model;

/**
 * CREATE TABLE IF NOT EXISTS `trip_planning_assistant`.`room_detail` (
 *   `listing_id` VARCHAR(255) NOT NULL,
 *   `property_type` VARCHAR(255) NULL,
 *   `room_type` VARCHAR(255) NULL,
 *   `accommodates` INT NULL,
 *   `bathroom_count` INT NULL,
 *   `bedroom_count` INT NULL,
 *   `bed_count` INT NULL,
 *   `bed_type` VARCHAR(255) NULL,
 *   `amenities` TEXT NULL,
 *   `features` TEXT NULL,
 *   PRIMARY KEY (`listing_id`),
 *   CONSTRAINT `fk_room_detail_airbnb_listing1`
 *     FOREIGN KEY (`listing_id`)
 *     REFERENCES `trip_planning_assistant`.`airbnb_listing` (`listing_id`)
 *     ON DELETE CASCADE
 *     ON UPDATE CASCADE)
 */
public class RoomDetail {

  private String listingId;
  private String propertyType;
  private String roomType;
  private Integer accommodates;
  private Integer bathroomCount;
  private Integer bedroomCount;
  private Integer bedCount;
  private String bedType;
  private String amenities;
  private String features;

  public RoomDetail(String listingId) {
    this.listingId = listingId;
  }

  public RoomDetail(String listingId, String propertyType, String roomType, Integer accommodates, Integer bathroomCount, Integer bedroomCount, Integer bedCount, String bedType, String amenities, String features) {
    this.listingId = listingId;
    this.propertyType = propertyType;
    this.roomType = roomType;
    this.accommodates = accommodates;
    this.bathroomCount = bathroomCount;
    this.bedroomCount = bedroomCount;
    this.bedCount = bedCount;
    this.bedType = bedType;
    this.amenities = amenities;
    this.features = features;
  }

  public String getListingId() {
    return listingId;
  }

  public void setListingId(String listingId) {
    this.listingId = listingId;
  }

  public String getPropertyType() {
    return propertyType;
  }

  public void setPropertyType(String propertyType) {
    this.propertyType = propertyType;
  }

  public String getRoomType() {
    return roomType;
  }

  public void setRoomType(String roomType) {
    this.roomType = roomType;
  }

  public Integer getAccommodates() {
    return accommodates;
  }

  public void setAccommodates(Integer accommodates) {
    this.accommodates = accommodates;
  }

  public Integer getBathroomCount() {
    return bathroomCount;
  }

  public void setBathroomCount(Integer bathroomCount) {
    this.bathroomCount = bathroomCount;
  }

  public Integer getBedroomCount() {
    return bedroomCount;
  }

  public void setBedroomCount(Integer bedroomCount) {
    this.bedroomCount = bedroomCount;
  }

  public Integer getBedCount() {
    return bedCount;
  }

  public void setBedCount(Integer bedCount) {
    this.bedCount = bedCount;
  }

  public String getBedType() {
    return bedType;
  }

  public void setBedType(String bedType) {
    this.bedType = bedType;
  }

  public String getAmenities() {
    return amenities;
  }

  public void setAmenities(String amenities) {
    this.amenities = amenities;
  }

  public String getFeatures() {
    return features;
  }

  public void setFeatures(String features) {
    this.features = features;
  }

  @Override
  public String toString() {
    return "RoomDetail{" +
            "listingId='" + listingId + '\'' +
            ", propertyType='" + propertyType + '\'' +
            ", roomType='" + roomType + '\'' +
            ", accommodates=" + accommodates +
            ", bathroomCount=" + bathroomCount +
            ", bedroomCount=" + bedroomCount +
            ", bedCount=" + bedCount +
            ", bedType='" + bedType + '\'' +
            ", amenities='" + amenities + '\'' +
            ", features='" + features + '\'' +
            '}';
  }
}
