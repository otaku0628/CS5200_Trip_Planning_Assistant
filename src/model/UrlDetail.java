package model;

/**
 * CREATE TABLE IF NOT EXISTS `trip_planning_assistant`.`url_detail` (
 *   `listing_id` VARCHAR(255) NOT NULL,
 *   `listing_url` VARCHAR(255) NOT NULL,
 *   `thumbnail_url` VARCHAR(255) NULL,
 *   `medium_url` VARCHAR(255) NULL,
 *   `picture_url` VARCHAR(255) NULL,
 *   `xl_picture_url` VARCHAR(255) NULL,
 *   PRIMARY KEY (`listing_id`),
 *   CONSTRAINT `fk_url_detail_airbnb_listing1`
 *     FOREIGN KEY (`listing_id`)
 *     REFERENCES `trip_planning_assistant`.`airbnb_listing` (`listing_id`)
 *     ON DELETE CASCADE
 *     ON UPDATE CASCADE)
 */
public class UrlDetail {

  private String listingId;
  private String listingUrl;
  private String thumbnailUrl;
  private String mediumUrl;
  private String pictureUrl;
  private String xlPictureUrl;

  public UrlDetail(String listingId) {
    this.listingId = listingId;
  }

  public UrlDetail(String listingId, String listingUrl, String thumbnailUrl, String mediumUrl, String pictureUrl, String xlPictureUrl) {
    this.listingId = listingId;
    this.listingUrl = listingUrl;
    this.thumbnailUrl = thumbnailUrl;
    this.mediumUrl = mediumUrl;
    this.pictureUrl = pictureUrl;
    this.xlPictureUrl = xlPictureUrl;
  }

  public String getListingId() {
    return listingId;
  }

  public void setListingId(String listingId) {
    this.listingId = listingId;
  }

  public String getListingUrl() {
    return listingUrl;
  }

  public void setListingUrl(String listingUrl) {
    this.listingUrl = listingUrl;
  }

  public String getThumbnailUrl() {
    return thumbnailUrl;
  }

  public void setThumbnailUrl(String thumbnailUrl) {
    this.thumbnailUrl = thumbnailUrl;
  }

  public String getMediumUrl() {
    return mediumUrl;
  }

  public void setMediumUrl(String mediumUrl) {
    this.mediumUrl = mediumUrl;
  }

  public String getPictureUrl() {
    return pictureUrl;
  }

  public void setPictureUrl(String pictureUrl) {
    this.pictureUrl = pictureUrl;
  }

  public String getXlPictureUrl() {
    return xlPictureUrl;
  }

  public void setXlPictureUrl(String xlPictureUrl) {
    this.xlPictureUrl = xlPictureUrl;
  }

  @Override
  public String toString() {
    return "UrlDetail{" +
            "listingId='" + listingId + '\'' +
            ", listingUrl='" + listingUrl + '\'' +
            ", thumbnailUrl='" + thumbnailUrl + '\'' +
            ", mediumUrl='" + mediumUrl + '\'' +
            ", pictureUrl='" + pictureUrl + '\'' +
            ", xlPictureUrl='" + xlPictureUrl + '\'' +
            '}';
  }
}
