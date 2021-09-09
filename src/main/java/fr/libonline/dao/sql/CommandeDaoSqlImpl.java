package fr.libonline.dao.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.libonline.dao.CommandeDao;
import fr.libonline.model.Commande;

public class CommandeDaoSqlImpl extends DaoSql implements CommandeDao {

	private static final String SELECT_ALL = "SELECT * FROM commande";
	
	private static final String SELECT_BY_ID = "SELECT * FROM commande WHERE CMD_ID = ?";
	
	private static final String SELECT_BY_CLIENT_ID = "SELECT * FROM commande WHERE CMD_CLIENT_ID = ?";
	
	private static final String INSERT = "INSERT INTO commande (CMD_DATE, CMD_CLIENT_ID, CMD_MONTANT) " //
										+ "VALUES (?,?,?)"; //
	
	private static final String UPDATE = "UPDATE commande " //
										+ "CMD_DATE = ?, CMD_CLIENT_ID = ?, CMD_MONTANT = ? " //
										+ "WHERE CMD_ID = ?"; //
	
	private static final String DELETE = "DELETE FROM commande WHERE CMD_ID = ?";

	@Override
	public List<Commande> findAll() {
		List<Commande> commandes = new ArrayList<Commande>();
		try {
			this.openConnection();
			Statement pstmt = this.connexionSql.createStatement();
			ResultSet rs = pstmt.executeQuery(SELECT_ALL);
			while (rs.next()) {
				commandes.add(mapResult(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			this.closeConnection();
		}
		return commandes;
	}

	@Override
	public Commande findById(int id) {
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
	

	public List<Commande> findByClientId(int id) {
		List<Commande> commandes = new ArrayList<Commande>();
		try {
			this.openConnection();
			PreparedStatement pstmt = this.connexionSql.prepareStatement(SELECT_BY_CLIENT_ID);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				commandes.add(mapResult(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			this.closeConnection();
		}
		return commandes;
	}

	@Override
	public Commande add(Commande entity) {
		try {
			this.openConnection();
			PreparedStatement pstmt = this.connexionSql.prepareStatement(INSERT);
			pstmt.setDate(1, new java.sql.Date(entity.getDate().getTime()));
			pstmt.setInt(2, entity.getClientId());
			pstmt.setDouble(3, entity.getMontant());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		finally {
			this.closeConnection();
		}
		return entity;
	}

	@Override
	public Commande save(Commande entity) {
		try {
			this.openConnection();
			PreparedStatement pstmt = this.connexionSql.prepareStatement(UPDATE);
			pstmt.setDate(1, new java.sql.Date(entity.getDate().getTime()));
			pstmt.setInt(2, entity.getClientId());
			pstmt.setDouble(3, entity.getMontant());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
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

	private Commande mapResult(ResultSet rs) throws SQLException {
		return new Commande()
					.id(rs.getInt("CMD_ID"))
					.date(rs.getDate("CMD_DATE"))
					.clientId(rs.getInt("CMD_CLIENT_ID"))
					.montant(rs.getDouble("CMD_MONTANT"));
	}

}
