package model;

/**
 * CREATE TABLE IF NOT EXISTS `trip_planning_assistant`.`business_attribute` (
 *   `uuid` VARCHAR(255) NOT NULL,
 *   `business_id` VARCHAR(255) NOT NULL,
 *   `attribute_name` VARCHAR(255) NOT NULL,
 *   `attribute_value` VARCHAR(255) NOT NULL,
 *   PRIMARY KEY (`uuid`),
 *   CONSTRAINT `fk_business_attribute_yelp_buisness`
 *     FOREIGN KEY (`business_id`)
 *     REFERENCES `trip_planning_assistant`.`business_overview` (`business_id`)
 *     ON DELETE CASCADE
 *     ON UPDATE CASCADE)
 */
public class BusinessAttribute {

  private String uuid;
  private String businessId;
  private String attributeName;
  private String attributeValue;

  public BusinessAttribute(String uuid) {
    this.uuid = uuid;
  }

  public BusinessAttribute(String uuid, String businessId, String attributeName, String attributeValue) {
    this.uuid = uuid;
    this.businessId = businessId;
    this.attributeName = attributeName;
    this.attributeValue = attributeValue;
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

  public String getAttributeName() {
    return attributeName;
  }

  public void setAttributeName(String attributeName) {
    this.attributeName = attributeName;
  }

  public String getAttributeValue() {
    return attributeValue;
  }

  public void setAttributeValue(String attributeValue) {
    this.attributeValue = attributeValue;
  }

  @Override
  public String toString() {
    return "BusinessAttribute{" +
            "uuid='" + uuid + '\'' +
            ", businessId='" + businessId + '\'' +
            ", attributeName='" + attributeName + '\'' +
            ", attributeValue='" + attributeValue + '\'' +
            '}';
  }
}
