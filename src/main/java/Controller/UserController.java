package Controller;

import model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;



public class UserController implements UserModel{
	
	String OrderUsers = "gamemarket.utenti ";
	
	public UserController() {
		
	}
	//static UserModel UtenteC = new UserController();
	@Override
	public void doSave(User utente) throws SQLException {
		
		  Connection connection = null; 
		  PreparedStatement preparedStatement = null;
		  
		  String insertSQL = "INSERT INTO " + "gamemarket.utenti" +
		  " (nome_utente, passwrod, role, balance,nome,cognome,nascita) VALUES (?, ?, ?, ?,?, ?, ?)";
		  
		  try { connection = DriverManagerConnectionPool.getConnection();
		  preparedStatement = connection.prepareStatement(insertSQL);
		  preparedStatement.setString(1, utente.getLogin());
		  preparedStatement.setString(2, utente.getPass());
		  preparedStatement.setString(3, utente.getRole());
		  preparedStatement.setFloat(4, 50);
		  preparedStatement.setString(5, utente.getNome());
		  preparedStatement.setString(6, utente.getCognome());
		  preparedStatement.setString(7, utente.getDataNascita());
		  //preparedStatement.setString(2, product.getDescription());
		  //preparedStatement.setInt(3, product.getPrice()); preparedStatement.setInt(4,
		  
		  
		  preparedStatement.executeUpdate();
		   } 
		  finally {
			  try {
				  if (preparedStatement != null)
		  preparedStatement.close(); 
				  } finally {
		  DriverManagerConnectionPool.releaseConnection(connection); }
			  }
		 
	}

	@Override
	public void doDelete(String login) throws SQLException {
		User u = new User(null, null, null, 0, null, null, null);
		Connection connection = null; 
		PreparedStatement preparedStatement = null;
		 
		  
		  String deletetSQL = "DELETE FROM gamemarket.utenti WHERE nome_utente=?";
		  
		  try { connection = DriverManagerConnectionPool.getConnection();
		  preparedStatement = connection.prepareStatement(deletetSQL);
		  preparedStatement.setString(1, login);
		  preparedStatement.executeUpdate();
		   } 
		  finally {
			  try {
				  if (preparedStatement != null)
		  preparedStatement.close(); 
				  } finally {
		  DriverManagerConnectionPool.releaseConnection(connection); }
			  }
		
		
	}

	@Override
	public User doRetrieveByKey(String login) throws SQLException {
		User u = new User(null, null, null, 0, null, null, null);
		Connection connection = null; 
		PreparedStatement preparedStatement = null;
		 
		  
		  String selectSQL = "SELECT * FROM " + "gamemarket.utenti where nome_utente='"+login+"'";
		  
		  try {
			  connection = DriverManagerConnectionPool.getConnection();
			  preparedStatement = connection.prepareStatement(selectSQL);
			  
			  ResultSet rs = preparedStatement.executeQuery();
		  
		  while (rs.next()) { 
		  u.setLogin(rs.getString("nome_utente"));
		  u.setPass(rs.getString("passwrod"));
		  u.setNome(rs.getString("nome"));
		  u.setCognome(rs.getString("cognome"));
		  u.setDataNascita(rs.getString("nascita"));
		  u.setRole(rs.getString("role"));
		  u.setBalance(rs.getFloat("balance"));}
		  
		  } finally {
			  try {
				  if (preparedStatement != null) preparedStatement.close(); 
				  }
		  finally {
			  DriverManagerConnectionPool.releaseConnection(connection); 
			  } 
			  }
		  return u;
	}
	
	@Override
	public Collection<User> doRetrieveAll(String order) throws SQLException {
		Connection connection = null; PreparedStatement preparedStatement = null;
		
		  Collection<User> utenti = new LinkedList<User>();
		 
		  String selectSQL = "SELECT * FROM " + OrderUsers+order;
		  
		  try { connection = DriverManagerConnectionPool.getConnection();
		  preparedStatement = connection.prepareStatement(selectSQL);
		  
		  ResultSet rs = preparedStatement.executeQuery();
		  
		  while (rs.next()) { 
			  User getUser = new User(null, null, null, 0, null, null, null);
			
			  getUser.setLogin(rs.getString("nome_utente"));
			  getUser.setNome(rs.getString("nome"));
			  getUser.setCognome(rs.getString("cognome"));
			  getUser.setDataNascita(rs.getString("nascita"));
			  getUser.setRole(rs.getString("role"));
			  getUser.setBalance(rs.getFloat("balance"));
			  getUser.setPass(rs.getString("passwrod"));
			  utenti.add(getUser); }
		  
		  } finally {
			  try { 
				  if (preparedStatement != null) preparedStatement.close(); }
		  finally {
			  DriverManagerConnectionPool.releaseConnection(connection); } 
			  }
		  return utenti;
	}
	@Override
	public boolean UserBuy(String login, float saldo) throws SQLException {
			Connection connection = null; 
		  PreparedStatement preparedStatement = null;
		  
		  String updateSQL = "UPDATE utenti SET balance = ? where nome_utente = ?";
		 
		  
		  try { connection = DriverManagerConnectionPool.getConnection();
		  preparedStatement = connection.prepareStatement(updateSQL);
		  preparedStatement.setFloat(1, saldo);
		  preparedStatement.setString(2, login);
		  
		  
		  preparedStatement.executeUpdate();
		   } 
		  finally {
			  try {
				  if (preparedStatement != null)
		  preparedStatement.close(); 
				  } finally {
		  DriverManagerConnectionPool.releaseConnection(connection); }
			  }
		 
		
		return true;
	}
	public void setManager(String id) throws SQLException {
			Connection connection = null; 
		  PreparedStatement preparedStatement = null;
		  
		  String updatetSQL = "UPDATE gamemarket.utenti SET role = 'manag' WHERE nome_utente = ?";
		 
		  
		  try { connection = DriverManagerConnectionPool.getConnection();
		  preparedStatement = connection.prepareStatement(updatetSQL);
		  preparedStatement.setString(1, id);
		  
		  
		  preparedStatement.executeUpdate();
		   } 
		  finally {
			  try {
				  if (preparedStatement != null)
		  preparedStatement.close(); 
				  } finally {
		  DriverManagerConnectionPool.releaseConnection(connection); }
			  }
		
	}
	public void setAdmin(String id) throws SQLException  {
		Connection connection = null; 
		  PreparedStatement preparedStatement = null;
		  
		  String updatetSQL = "UPDATE gamemarket.utenti SET role = 'admin' WHERE nome_utente = ?";
		 
		  
		  try { connection = DriverManagerConnectionPool.getConnection();
		  preparedStatement = connection.prepareStatement(updatetSQL);
		  preparedStatement.setString(1, id);
		  
		  
		  preparedStatement.executeUpdate();
		   } 
		  finally {
			  try {
				  if (preparedStatement != null)
		  preparedStatement.close(); 
				  } finally {
		  DriverManagerConnectionPool.releaseConnection(connection); }
			  }
		
	}
	
}
