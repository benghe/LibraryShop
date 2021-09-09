package fr.libonline.dao.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DaoSql {
	protected Connection connexionSql;
	
	protected void openConnection() {
		try {
			this.connexionSql = DriverManager.getConnection("jdbc:mysql://localhost:8889/libo?serverTimezone=UTC", "root", "root");
//			this.connexionSql = DriverManager.getConnection("jdbc:mysql://192.168.64.2:3306/libo?serverTimezone=UTC", "root", "test");
			System.out.println("Connexion OK !");
		}
		//?serverTimezone=UTC
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
	protected void closeConnection() {
		try {
			this.connexionSql.close();
		}

		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}