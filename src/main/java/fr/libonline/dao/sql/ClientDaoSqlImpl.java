package fr.libonline.dao.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.libonline.dao.ClientDao;
import fr.libonline.model.Client;

public class ClientDaoSqlImpl extends DaoSql implements ClientDao {

	private static final String SELECT_ALL = "SELECT * FROM client";
	
	private static final String SELECT_BY_ID = "SELECT * FROM client WHERE CL_ID = ?";
	
	private static final String SELECT_BY_LOGIN = 	"SELECT * FROM client " //
													+ "WHERE CL_LOGIN = ? " //
													+ "LIMIT 1"; //
	
	private static final String SELECT_BY_LOGIN_AND_PASSWORD = 	"SELECT * FROM client " //
																+ "WHERE CL_LOGIN = ? AND CL_PASSWORD = ? " //
																+ "LIMIT 1"; //
	
	private static final String INSERT = "INSERT INTO client (CL_NOM, CL_PRENOM, CL_ADRESSE, CL_LOGIN, CL_PASSWORD) " //
										+ "VALUES (?,?,?,?,?)"; //
	
	private static final String UPDATE = "UPDATE client " //
										+ "SET CL_NOM = ?, CL_PRENOM = ?, CL_ADRESSE = ?, CL_LOGIN = ? " //
										+ "WHERE CL_ID = ?"; //
	
	private static final String DELETE = "DELETE FROM client WHERE CL_ID = ?";

	@Override
	public List<Client> findAll() {
		List<Client> clients = new ArrayList<Client>();
		try {
			this.openConnection();
			Statement pstmt = this.connexionSql.createStatement();
			ResultSet rs = pstmt.executeQuery(SELECT_ALL);
			while (rs.next()) {
				clients.add(mapResult(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			this.closeConnection();
		}
		return clients;
	}

	@Override
	public Client findById(int id) {
		try {
			this.openConnection();
			PreparedStatement pstmt = this.connexionSql.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return mapResult(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			this.closeConnection();
		}
		return null;
	}
	
	public Client findByLoginAndPassword(String login, String password) {
		try {
			this.openConnection();
			PreparedStatement pstmt = this.connexionSql.prepareStatement(SELECT_BY_LOGIN_AND_PASSWORD);
			pstmt.setString(1, login);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return mapResult(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			this.closeConnection();
		}
		return null;
	}

	@Override
	public Client add(Client entity) {
		try {
			this.openConnection();
			PreparedStatement pstmt = this.connexionSql.prepareStatement(INSERT);
			pstmt.setString(1, entity.getNom());
			pstmt.setString(2, entity.getPrenom());
			pstmt.setString(3, entity.getAdresse());
			pstmt.setString(4, entity.getLogin());
			pstmt.setString(5, entity.getPassword());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			this.closeConnection();
		}
		return entity;
	}

	@Override
	public Client save(Client entity) {
		try {
			this.openConnection();
			PreparedStatement pstmt = this.connexionSql.prepareStatement(UPDATE);
			pstmt.setString(1, entity.getNom());
			pstmt.setString(2, entity.getPrenom());
			pstmt.setString(3, entity.getAdresse());
			pstmt.setString(4, entity.getLogin());
			pstmt.setInt(5, entity.getId());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			this.closeConnection();
		}
		return entity;
	}

	@Override
	public boolean deleteById(int id) {
		try {
			this.openConnection();
			PreparedStatement pstmt = this.connexionSql.prepareStatement(DELETE);
			pstmt.setInt(1, id);
			pstmt.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			this.closeConnection();
		}
	}
	

	public Client findByLogin(String login) {
		try {
			this.openConnection();
			PreparedStatement pstmt = this.connexionSql.prepareStatement(SELECT_BY_LOGIN);
			pstmt.setString(1, login);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return mapResult(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			this.closeConnection();
		}
		return null;
	}

	private Client mapResult(ResultSet rs) throws SQLException {
		return new Client()
					.id(rs.getInt("CL_ID"))
					.nom(rs.getString("CL_NOM"))
					.prenom(rs.getString("CL_PRENOM"))
					.adresse(rs.getString("CL_ADRESSE"))
					.login(rs.getString("CL_LOGIN"));
	}

}
