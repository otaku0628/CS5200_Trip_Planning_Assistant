package servlet.listing;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.listing.dao.ListingDao;
import servlet.listing.dao.RecommendationDao;
import servlet.listing.model.ListingCard;
import servlet.listing.model.RecommendationCard;

@WebServlet("/recommendation")
public class Recommendation extends HttpServlet {

  private ListingDao listingDao;
  private RecommendationDao recommendationDao;

  @Override
  public void init() throws ServletException {
    listingDao = ListingDao.getInstance();
    recommendationDao = RecommendationDao.getInstance();
  }

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // Map for storing messages.
    Map<String, String> messages = new HashMap<>();
    req.setAttribute("messages", messages);

    String listingId = req.getParameter("listingId");
    if (listingId == null || listingId.trim().isEmpty()) {
      messages.put("resultMessage", "listingId required.");
    }

    try {
      ListingCard listingCard = listingDao.getListingCard(listingId);
      req.setAttribute("listingCard", listingCard);
    } catch (SQLException e) {
      e.printStackTrace();
      throw new IOException(e);
    }

    req.getRequestDispatcher("listing/Recommendation.jsp").forward(req, resp);
  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // Map for storing messages.
    Map<String, String> messages = new HashMap<>();
    req.setAttribute("messages", messages);
    messages.put("showToast", "true");

    List<RecommendationCard> recommendationCards = new ArrayList<>();

    String listingId = req.getParameter("listingId");
    if (listingId == null || listingId.trim().isEmpty()) {
      messages.put("resultMessage", "listingId required.");
    } else {
      try {
        ListingCard listingCard = listingDao.getListingCard(listingId);
        req.setAttribute("listingCard", listingCard);
        String distanceString = req.getParameter("distance");
        BigDecimal distance = null;
        if (null == distanceString || distanceString.trim().isEmpty()) {
          messages.put("resultMessage", "distance required.");
        } else {
          distance = new BigDecimal(distanceString);
          recommendationCards = recommendationDao.getRecommendationCards(
                  listingCard.getListingLongitude(), listingCard.getListingLatitude(), distance);
          messages.put("resultMessage", "Displaying matching recommendations...");
        }
      } catch (NumberFormatException e) {
        e.printStackTrace();
        messages.put("resultMessage", "NumberFormatException...");
      } catch (SQLException e) {
        e.printStackTrace();
        throw new IOException(e);
      }
    }
    req.setAttribute("recommendationCards", recommendationCards);

    req.getRequestDispatcher("listing/Recommendation.jsp").forward(req, resp);
  }
}
