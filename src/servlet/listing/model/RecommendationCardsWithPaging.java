package servlet.listing.model;

import java.util.List;

public class RecommendationCardsWithPaging {

  public static final int PAGE_SIZE = 50;

  private final List<RecommendationCard> recommendationCards;
  private final int currentPage;
  private final int totalPage;

  public RecommendationCardsWithPaging(List<RecommendationCard> recommendationCards, int currentPage,
                                       int totalPage) {
    this.recommendationCards = recommendationCards;
    this.currentPage = currentPage;
    this.totalPage = totalPage;
  }

  public List<RecommendationCard> getRecommendationCards() {
    return recommendationCards;
  }

  public int getCurrentPage() {
    return currentPage;
  }

  public int getTotalPage() {
    return totalPage;
  }

  @Override
  public String toString() {
    return "RecommendationCardsWithPaging{" +
            "recommendationCards=" + recommendationCards +
            ", currentPage=" + currentPage +
            ", totalPage=" + totalPage +
            '}';
  }
}
