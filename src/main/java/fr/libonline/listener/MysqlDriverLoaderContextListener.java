package fr.libonline.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MysqlDriverLoaderContextListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("CREATION");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}