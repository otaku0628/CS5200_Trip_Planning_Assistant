package servlet.listing.model;

import java.math.BigDecimal;

public class RecommendationCard {

  private final BigDecimal distance;
  private final String businessId;
  private final String name;
  private final String address;
  private final String city;
  private final String state;
  private final String postalCode;
  private final BigDecimal stars;
  private final Integer reviewCount;
  private final Boolean isOpen;
  private final String categories;

  public RecommendationCard(BigDecimal distance, String businessId, String name, String address,
                            String city, String state, String postalCode, BigDecimal stars,
                            Integer reviewCount, Boolean isOpen, String categories) {
    this.distance = distance;
    this.businessId = businessId;
    this.name = name;
    this.address = address;
    this.city = city;
    this.state = state;
    this.postalCode = postalCode;
    this.stars = stars;
    this.reviewCount = reviewCount;
    this.isOpen = isOpen;
    this.categories = categories;
  }

  public BigDecimal getDistance() {
    return distance;
  }

  public String getBusinessId() {
    return businessId;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public String getCity() {
    return city;
  }

  public String getState() {
    return state;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public BigDecimal getStars() {
    return stars;
  }

  public Integer getReviewCount() {
    return reviewCount;
  }

  public Boolean getOpen() {
    return isOpen;
  }

  public String getCategories() {
    return categories;
  }

  @Override
  public String toString() {
    return "RecommendationCard{" +
            "distance=" + distance +
            ", businessId='" + businessId + '\'' +
            ", name='" + name + '\'' +
            ", address='" + address + '\'' +
            ", city='" + city + '\'' +
            ", state='" + state + '\'' +
            ", postalCode='" + postalCode + '\'' +
            ", stars=" + stars +
            ", reviewCount=" + reviewCount +
            ", isOpen=" + isOpen +
            ", categories='" + categories + '\'' +
            '}';
  }
}
