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

@WebServlet("/userdelete")
public class UserDelete extends HttpServlet {

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

		req.getRequestDispatcher("user/UserDelete.jsp").forward(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Map for storing messages.
		Map<String, String> messages = new HashMap<>();
		req.setAttribute("messages", messages);
		messages.put("showToast", "true");

		// Retrieve and validate userId.
		String userId = req.getParameter("userId");
		if (userId == null || userId.trim().isEmpty()) {
			messages.put("resultMessage", "Please enter a valid userId.");
		} else {
			// Delete the user.
			User user = new User(userId);
			try {
				user = userDao.delete(user);
				// Update the message.
				if (user == null) {
					messages.put("resultMessage", "Successfully deleted: " + userId);
				} else {
					messages.put("resultMessage", "Failed to delete: " + userId);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
		}

		req.getRequestDispatcher("user/UserDelete.jsp").forward(req, resp);
	}
}
