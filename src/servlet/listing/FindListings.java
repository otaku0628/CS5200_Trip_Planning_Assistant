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
import servlet.listing.model.ConstantValue;
import servlet.listing.model.ListingCard;

/**
 * FindUsers is the primary entry point into the application.
 *
 * Note the logic for doGet() and doPost() are almost identical. However, there is a difference:
 * doGet() handles the http GET request. This method is called when you put in the /findusers
 * URL in the browser.
 * doPost() handles the http POST request. This method is called after you click the submit button.
 *
 * To run:
 * 1. Run the SQL script to recreate your database schema: http://goo.gl/86a11H.
 * 2. Insert test data. You can do this by running blog.tools.Inserter (right click,
 *    Run As > JavaApplication.
 *    Notice that this is similar to Runner.java in our JDBC example.
 * 3. Run the Tomcat server at localhost.
 * 4. Point your browser to http://localhost:8080/BlogApplication/findusers.
 */
@WebServlet("/findlistings")
public class FindListings extends HttpServlet {

  private ListingDao listingDao;

  @Override
  public void init() throws ServletException {
    listingDao = ListingDao.getInstance();
  }

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // Map for storing messages.
    Map<String, String> messages = new HashMap<>();
    req.setAttribute("messages", messages);
    req.setAttribute("countryArray", ConstantValue.countryArray);
    req.setAttribute("roomTypeArray", ConstantValue.roomTypeArray);
    req.setAttribute("cancellationPolicyArray", ConstantValue.cancellationPolicyArray);

    req.getRequestDispatcher("listing/FindListings.jsp").forward(req, resp);
  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // Map for storing messages.
    Map<String, String> messages = new HashMap<>();
    req.setAttribute("messages", messages);
    messages.put("showToast", "true");
    req.setAttribute("countryArray", ConstantValue.countryArray);
    req.setAttribute("roomTypeArray", ConstantValue.roomTypeArray);
    req.setAttribute("cancellationPolicyArray", ConstantValue.cancellationPolicyArray);

    List<ListingCard> listingCards = new ArrayList<>();

    String name = req.getParameter("name");
    if (null != name && name.trim().isEmpty()) {
      name = null;
    }
    String zipCode = req.getParameter("zipCode");
    if (null != zipCode && zipCode.trim().isEmpty()) {
      zipCode = null;
    }
    String city = req.getParameter("city");
    String country = req.getParameter("country");
    String cancellationPolicy = req.getParameter("cancellationPolicy");
    if (null != cancellationPolicy && cancellationPolicy.trim().isEmpty()) {
      cancellationPolicy = null;
    }
    String roomType = req.getParameter("roomType");
    if (null != roomType && roomType.trim().isEmpty()) {
      roomType = null;
    }

    if (city == null || city.trim().isEmpty() || country == null || country.trim().isEmpty()) {
      messages.put("resultMessage", "Non empty country and city required.");
    } else {
      try {
        String maxPriceString = req.getParameter("maxPrice");
        BigDecimal maxPrice = null;
        if (null != maxPriceString && !maxPriceString.trim().isEmpty()) {
          maxPrice = new BigDecimal(maxPriceString);
        }
        String minPriceString = req.getParameter("minPrice");
        BigDecimal minPrice = null;
        if (null != minPriceString && !minPriceString.trim().isEmpty()) {
          minPrice = new BigDecimal(minPriceString);
        }
        String accommodatesString = req.getParameter("accommodates");
        Integer accommodates = null;
        if (null != accommodatesString && !accommodatesString.trim().isEmpty()) {
          accommodates = new Integer(accommodatesString);
        }
        String bathroomCountString = req.getParameter("bathroomCount");
        Integer bathroomCount = null;
        if (null != bathroomCountString && !bathroomCountString.trim().isEmpty()) {
          bathroomCount = new Integer(bathroomCountString);
        }
        String bedroomCountString = req.getParameter("bedroomCount");
        Integer bedroomCount = null;
        if (null != bedroomCountString && !bedroomCountString.trim().isEmpty()) {
          bedroomCount = new Integer(bedroomCountString);
        }
        String bedCountString = req.getParameter("bedCount");
        Integer bedCount = null;
        if (null != bedCountString && !bedCountString.trim().isEmpty()) {
          bedCount = new Integer(bedCountString);
        }

        listingCards = listingDao.getListingCards(name, zipCode, city, country, maxPrice, minPrice,
                cancellationPolicy, roomType, accommodates, bathroomCount, bedroomCount, bedCount);

        messages.put("resultMessage", "Displaying matching listing...");
      } catch (NumberFormatException e) {
        e.printStackTrace();
        messages.put("resultMessage", "NumberFormatException...");
      } catch (SQLException e) {
        e.printStackTrace();
        throw new IOException(e);
      }
    }
    req.setAttribute("listingCards", listingCards);

    req.getRequestDispatcher("listing/FindListings.jsp").forward(req, resp);
  }
}
