package servlet.user;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dal.UserDao;
import model.User;

@WebServlet("/usercreate")
public class UserCreate extends HttpServlet {

	private UserDao userDao;

	@Override
	public void init() throws ServletException {
		userDao = UserDao.getInstance();
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Map for storing messages.
		Map<String, String> messages = new HashMap<>();
		req.setAttribute("messages", messages);

		req.getRequestDispatcher("user/UserCreate.jsp").forward(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Map for storing messages.
		Map<String, String> messages = new HashMap<>();
		req.setAttribute("messages", messages);
		messages.put("showToast", "true");

		// Retrieve and validate userId.
		String userId = req.getParameter("userId");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		if (userId == null || userId.trim().isEmpty()
						|| email == null || email.trim().isEmpty()
						|| password == null || password.trim().isEmpty()
						|| name == null || name.trim().isEmpty()) {
				messages.put("resultMessage", "Please enter a valid input.");
		} else {
			// Create the User.
			Instant memberSince = Instant.now();
			Integer reviewCount = 0;
			Integer useful = 0;
			try {
				User user = new User(userId, email, password, name, memberSince, reviewCount, useful);
				user = userDao.create(user);
				messages.put("resultMessage", "Successfully created: " + userId);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
		}

		req.getRequestDispatcher("user/UserCreate.jsp").forward(req, resp);
	}
}
