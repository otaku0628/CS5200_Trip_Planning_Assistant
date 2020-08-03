package servlet.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dal.UserDao;
import model.User;


@WebServlet("/userupdate")
public class UserUpdate extends HttpServlet {

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

		req.getRequestDispatcher("user/UserUpdate.jsp").forward(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Map for storing messages.
		Map<String, String> messages = new HashMap<>();
		req.setAttribute("messages", messages);
		messages.put("showToast", "true");

		// Retrieve user and validate.
		String userId = req.getParameter("userId");
		if (userId == null || userId.trim().isEmpty()) {
			messages.put("resultMessage", "Please enter a valid userId.");
		} else {
			try {
				User user = userDao.getUserById(userId);
				if(user == null) {
					messages.put("resultMessage", "userId does not exist. No update to perform.");
				} else {
					String newPassword = req.getParameter("password");
					if (newPassword == null || newPassword.trim().isEmpty()) {
						messages.put("resultMessage", "Please enter a valid password.");
					} else {
						user = userDao.updatePassword(user, newPassword);
						messages.put("resultMessage", "Successfully updated: " + userId);
					}
				}
				req.setAttribute("user", user);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
		}

		req.getRequestDispatcher("user/UserUpdate.jsp").forward(req, resp);
	}
}
