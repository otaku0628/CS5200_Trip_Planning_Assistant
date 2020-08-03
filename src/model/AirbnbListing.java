package model;

/**
 * CREATE TABLE IF NOT EXISTS `trip_planning_assistant`.`airbnb_listing` (
 *   `listing_id` VARCHAR(255) NOT NULL,
 *   `host_id` VARCHAR(255) NOT NULL,
 *   `name` VARCHAR(255) NULL,
 *   `summary` TEXT NULL,
 *   `space` TEXT NULL,
 *   `description` TEXT NULL,
 *   `neighborhood_overview` TEXT NULL,
 *   `notes` TEXT NULL,
 *   `transit` TEXT NULL,
 *   `access` TEXT NULL,
 *   `interaction` TEXT NULL,
 *   `house_rules` TEXT NULL,
 *   PRIMARY KEY (`listing_id`),
 *   CONSTRAINT `fk_airbnb_listing_airbnb_host1`
 *     FOREIGN KEY (`host_id`)
 *     REFERENCES `trip_planning_assistant`.`airbnb_host` (`host_id`)
 *     ON DELETE CASCADE
 *     ON UPDATE CASCADE)
 */
public class AirbnbListing {

  private String listingId;
  private String hostId;
  private String name;
  private String summary;
  private String space;
  private String description;
  private String neighborhoodOverview;
  private String notes;
  private String transit;
  private String access;
  private String interaction;
  private String houseRules;

  public AirbnbListing(String listingId) {
    this.listingId = listingId;
  }

  public AirbnbListing(String listingId, String hostId, String name, String summary, String space, String description, String neighborhoodOverview, String notes, String transit, String access, String interaction, String houseRules) {
    this.listingId = listingId;
    this.hostId = hostId;
    this.name = name;
    this.summary = summary;
    this.space = space;
    this.description = description;
    this.neighborhoodOverview = neighborhoodOverview;
    this.notes = notes;
    this.transit = transit;
    this.access = access;
    this.interaction = interaction;
    this.houseRules = houseRules;
  }

  public String getListingId() {
    return listingId;
  }

  public void setListingId(String listingId) {
    this.listingId = listingId;
  }

  public String getHostId() {
    return hostId;
  }

  public void setHostId(String hostId) {
    this.hostId = hostId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public String getSpace() {
    return space;
  }

  public void setSpace(String space) {
    this.space = space;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getNeighborhoodOverview() {
    return neighborhoodOverview;
  }

  public void setNeighborhoodOverview(String neighborhoodOverview) {
    this.neighborhoodOverview = neighborhoodOverview;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public String getTransit() {
    return transit;
  }

  public void setTransit(String transit) {
    this.transit = transit;
  }

  public String getAccess() {
    return access;
  }

  public void setAccess(String access) {
    this.access = access;
  }

  public String getInteraction() {
    return interaction;
  }

  public void setInteraction(String interaction) {
    this.interaction = interaction;
  }

  public String getHouseRules() {
    return houseRules;
  }

  public void setHouseRules(String houseRules) {
    this.houseRules = houseRules;
  }

  @Override
  public String toString() {
    return "AirbnbListing{" +
            "listingId='" + listingId + '\'' +
            ", hostId='" + hostId + '\'' +
            ", name='" + name + '\'' +
            ", summary='" + summary + '\'' +
            ", space='" + space + '\'' +
            ", description='" + description + '\'' +
            ", neighborhoodOverview='" + neighborhoodOverview + '\'' +
            ", notes='" + notes + '\'' +
            ", transit='" + transit + '\'' +
            ", access='" + access + '\'' +
            ", interaction='" + interaction + '\'' +
            ", houseRules='" + houseRules + '\'' +
            '}';
  }
}
