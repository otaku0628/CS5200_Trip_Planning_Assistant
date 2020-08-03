package servlet.listing.model;

import java.math.BigDecimal;

public class ListingCard {

  private final String listingId;
  private final String name;
  private final String city;
  private final String roomType;
  private final Integer accommodates;
  private final Integer bathroomCount;
  private final Integer bedroomCount;
  private final Integer bedCount;
  private final String features;
  private final BigDecimal dailyPrice;
  private final Integer ratingScore;
  private final Integer reviewCount;
  private final String thumbnailUrl;
  private final BigDecimal listingLongitude;
  private final BigDecimal listingLatitude;
  private final String listingUrl;

  public ListingCard(String listingId, String name, String city, String roomType,
                     Integer accommodates, Integer bathroomCount, Integer bedroomCount,
                     Integer bedCount, String features, BigDecimal dailyPrice,
                     Integer ratingScore, Integer reviewCount, String thumbnailUrl,
                     BigDecimal listingLongitude, BigDecimal listingLatitude,
                     String listingUrl) {

    this.listingId = listingId;
    this.name = name;
    this.city = city;
    this.roomType = roomType;
    this.accommodates = accommodates;
    this.bathroomCount = bathroomCount;
    this.bedroomCount = bedroomCount;
    this.bedCount = bedCount;
    this.features = features;
    this.dailyPrice = dailyPrice;
    this.ratingScore = ratingScore;
    this.reviewCount = reviewCount;
    this.thumbnailUrl = thumbnailUrl;
    this.listingLongitude = listingLongitude;
    this.listingLatitude = listingLatitude;
    this.listingUrl = listingUrl;
  }

  public String getListingId() {
    return listingId;
  }

  public String getName() {
    return name;
  }

  public String getCity() {
    return city;
  }

  public String getRoomType() {
    return roomType;
  }

  public Integer getAccommodates() {
    return accommodates;
  }

  public Integer getBathroomCount() {
    return bathroomCount;
  }

  public Integer getBedroomCount() {
    return bedroomCount;
  }

  public Integer getBedCount() {
    return bedCount;
  }

  public String getFeatures() {
    return features;
  }

  public BigDecimal getDailyPrice() {
    return dailyPrice;
  }

  public Integer getRatingScore() {
    return ratingScore;
  }

  public Integer getReviewCount() {
    return reviewCount;
  }

  public String getThumbnailUrl() {
    return thumbnailUrl;
  }

  public BigDecimal getListingLongitude() {
    return listingLongitude;
  }

  public BigDecimal getListingLatitude() {
    return listingLatitude;
  }

  public String getListingUrl() {
    return listingUrl;
  }

  @Override
  public String toString() {
    return "ListingCard{" +
            "listingId='" + listingId + '\'' +
            ", name='" + name + '\'' +
            ", city='" + city + '\'' +
            ", roomType='" + roomType + '\'' +
            ", accommodates=" + accommodates +
            ", bathroomCount=" + bathroomCount +
            ", bedroomCount=" + bedroomCount +
            ", bedCount=" + bedCount +
            ", features='" + features + '\'' +
            ", dailyPrice=" + dailyPrice +
            ", ratingScore=" + ratingScore +
            ", reviewCount=" + reviewCount +
            ", thumbnailUrl='" + thumbnailUrl + '\'' +
            ", listingLongitude=" + listingLongitude +
            ", listingLatitude=" + listingLatitude +
            ", listingUrl='" + listingUrl + '\'' +
            '}';
  }
}
