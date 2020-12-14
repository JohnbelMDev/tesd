package cit285.book.config;

import java.io.PrintWriter;
import java.io.StringWriter;
import cit285.book.service.UserService;
import cit285.book.service.UserServiceAPI;

public class UserSystemConfig {
// the service objects in use, representing all lower layers to the app
	private static UserServiceAPI userService;

	// set up service API, data access objects
	public static void configureServices() throws Exception {
		try {
			userService = new UserService();
		} catch (Exception e) {
			// rethrow to notify caller (caller should print exception details)
			throw new Exception("Exception in configureServices", e);
		}
	}

	public static String exceptionReport(Exception e) {
		String message = e.toString(); // exception name + message
		if (e.getCause() != null) {
			message += "\n  cause: " + e.getCause();
			if (e.getCause().getCause() != null) {
				message += "\n    cause's cause: " + e.getCause().getCause();
			}
		}
		message += "\n Stack Trace: " + exceptionStackTraceString(e);
		return message;
	}

	private static String exceptionStackTraceString(Throwable e) {
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		return sw.toString();
	}

	public static UserServiceAPI getUserServices() {

		return userService;
	}
}
