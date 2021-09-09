package fr.libonline.dao.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.libonline.dao.LivreDao;
import fr.libonline.model.Livre;
import fr.libonline.model.Livre;

public class LivreDaoSqlImpl extends DaoSql implements LivreDao{

	private static final String SELECT_ALL = "SELECT * FROM livre";
	
	private static final String SELECT_BY_ID = "SELECT * FROM livre WHERE LIV_ID = ?";

	private static final String SELECT_BY_AUTEUR = 	"SELECT * FROM livre " //
			+ "WHERE LIV_AUTEUR = ? " //
			+ "LIMIT 1"; //

	private static final String SELECT_BY_TITRE = "SELECT * FROM livre " //
			+ "WHERE LIV_TITRE = ? " //
			+ "LIMIT 1"; //
	
		// TODO
//	private static final String SELECT_BY_TITRE_AND_AUTEUR = "SELECT * FROM livre " //
//			+ "WHERE LIV_TITRE = ? AND LIV_AUTEUR = ? "//
//			+ "LIMIT 1"; //

	private static final String SELECT_ALL_PHOTOS = "SELECT * FROM livre " //
			+ "WHERE LIV_PHOTO = ? "; //
	
		// TODO
//	private static final String SELECT_PHOTOS_BY_AUTEUR = "SELECT * FROM livre " //
//			+ "WHERE LIV_AUTEUR = ? AND LIV_PHOTO = ?";//
	
	private static final String INSERT = "INSERT INTO livre (LIV_TITRE, LIV_AUTEUR, LIV_PRIX, LIV_PHOTO, LIV_RESUME) " //
	+ "VALUES (?,?,?,?,?)"; //
	
	private static final String UPDATE = "UPDATE livre " //
	+ "SET LIV_TITRE = ?, LIV_AUTEUR = ?, LIV_PRIX = ?, LIV_PHOTO = ?, LIV_RESUME = ?"//
	+ "WHERE LIV_ID = ?";//
	
	private static final String DELETE = "DELETE FROM livre WHERE LIV_ID = ?";

	@Override
	public List<Livre> findAll() {
		List<Livre> Livres = new ArrayList<Livre>();
		try {
			this.openConnection();
			Statement pstmt = this.connexionSql.createStatement();
			ResultSet rs = pstmt.executeQuery(SELECT_ALL);
			while (rs.next()) {
				Livres.add(mapResult(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			this.closeConnection();
		}
		return Livres;
	}

	@Override
	public Livre findById(int id) {
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


	@Override
	public Livre add(Livre entity) {
		try {
			this.openConnection();
			PreparedStatement pstmt = this.connexionSql.prepareStatement(INSERT);
			pstmt.setString(1, entity.getTitre());
			pstmt.setString(2, entity.getAuteur());
			pstmt.setDouble(3, entity.getPrix());
			pstmt.setString(4, entity.getPhoto());
			pstmt.setString(5, entity.getResume());
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
	public Livre save(Livre entity) {
		try {
			this.openConnection();
			PreparedStatement pstmt = this.connexionSql.prepareStatement(UPDATE);
			pstmt.setString(1, entity.getTitre());
			pstmt.setString(2, entity.getAuteur());
			pstmt.setDouble(3, entity.getPrix());
			pstmt.setString(4, entity.getPhoto());
			pstmt.setString(5, entity.getResume());
			pstmt.setInt(6, entity.getId());
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
	
	private Livre mapResult(ResultSet rs) throws SQLException {
		return new Livre()
					.id(rs.getInt("LIV_ID"))
					.titre(rs.getString("LIV_TITRE"))
					.auteur(rs.getString("LIV_AUTEUR"))
					.prix(rs.getDouble("LIV_PRIX"))
					.photo(rs.getString("LIV_PHOTO"))
					.resume(rs.getString("LIV_RESUME"));
	}
	
}
