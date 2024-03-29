package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Weights_dao {
private Connection connection;
private final String ADD_WEIGHT = "INSERT INTO weights (user_id, measureDate, weight) VALUES (?,?,?)";
private final String UPDATE_ENTRY = "UPDATE weights SET weight=? WHERE id=?";
	
	public Weights_dao() {
		connection = DBConnection.getInstance().getConnection();
	}
	
	public void enterNewWeight(int userId, String measureDate, String weight) throws SQLException{
		PreparedStatement ps = connection.prepareStatement(ADD_WEIGHT);
		ps.setInt(1, userId);
		ps.setString(2, measureDate);
		ps.setString(3, weight);
		ps.executeUpdate();
	}
	
	public void updateWeight(int id, String weight) throws SQLException{
		PreparedStatement ps = connection.prepareStatement(UPDATE_ENTRY);
		ps.setInt(1, id);
		ps.setString(2, weight);
		ps.executeUpdate();
	}
	
	public void close() {
		DBConnection.getInstance().closeConnection();
	}
	

	
}
