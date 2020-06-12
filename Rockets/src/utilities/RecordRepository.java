package utilities;

import java.security.InvalidParameterException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import domain.Record;

public class RecordRepository {
	
	public static void storeRecord(Record record) throws Exception {
		try {
			ConnectionBBDD connection = ConnectionRepository.getConnection();
			
			String sql = "Insert into REDCORDS (TRACK, ROCKET, TIME) VALUES (?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, record.getTrackName());
			pst.setString(2, record.getRocketName());
			pst.setInt(3, record.getTime());
			
			if(pst.executeUpdate() != 1) {
				throw new InvalidParameterException();
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static Record getRecord(String idRecord) throws Exception {
		ConnectionBBDD connection = ConnectionRepository.getConnection();
		
		try {
			String sql = "SELECT * FROM RECORDS WHERE TRACK=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.clearParameters();
			preparedStatement.setString(1, idRecord);
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				String id = rs.getString("TRACK");
				int recordURL = rs.getInt("TIME");
				String name = rs.getString("ROCKET");
				return new Record(id, name, recordURL);
			}
			throw new Exception();
		}catch(SQLException e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	public static void updateRecord(Record record) throws Exception {
		ConnectionBBDD connection = ConnectionRepository.getConnection();
		
		try {
			String sql = "UPDATE RECORDS SET TRACK=?, ROCKET=?, TIME=? WHERE TRACK=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			
			pst.setString(1, record.getTrackName());
			pst.setString(2, record.getRocketName());
			pst.setInt(3, record.getTime());
			
			if(pst.executeUpdate() != 1) {
				throw new Exception();
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
	
}
