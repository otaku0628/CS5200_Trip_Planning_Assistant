package servlet.listing.model;

import java.util.List;

public class ListingCardsWithPaging {

  public static final int PAGE_SIZE = 50;

  private final List<ListingCard> listingCards;
  private final int currentPage;
  private final int totalPage;

  public ListingCardsWithPaging(List<ListingCard> listingCards, int currentPage, int totalPage) {
    this.listingCards = listingCards;
    this.currentPage = currentPage;
    this.totalPage = totalPage;
  }

  public List<ListingCard> getListingCards() {
    return listingCards;
  }

  public int getCurrentPage() {
    return currentPage;
  }

  public int getTotalPage() {
    return totalPage;
  }

  @Override
  public String toString() {
    return "ListingCardsWithPaging{" +
            "listingCards=" + listingCards +
            ", currentPage=" + currentPage +
            ", totalPage=" + totalPage +
            '}';
  }
}
