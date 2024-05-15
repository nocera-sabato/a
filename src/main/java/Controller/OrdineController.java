package Controller;

import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Ordine;
import model.OrdineModel;
import model.game;

public class OrdineController implements OrdineModel {

	private  static final String Table_Ordini = "ordini";

	@Override
	public boolean doDelete(String code) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Ordine> doRetrieveByGame(String Games) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Ordine> SortAll(String client) throws SQLException {
		Connection connection = null; PreparedStatement preparedStatement = null;
		String selectSQL= null;
		  Collection<Ordine> products = new LinkedList<Ordine>();
		 
		 			selectSQL= "SELECT * FROM " + "gamemarket.ordini where nome_utente='"+client+"'"; 
		 		
		 
		  //String selectSQL = "SELECT * FROM " + "gamemarket.ordini where nome_utente='"+cliente+"'"; 
		  
		  try { connection = DriverManagerConnectionPool.getConnection();
		  preparedStatement = connection.prepareStatement(selectSQL);
		  
		  ResultSet rs = preparedStatement.executeQuery();
		  
		  while (rs.next()) { 
			  Ordine product = new Ordine(null, null, null, 0, 0, 0, null);
			
			  product.setNomeUtente(rs.getString("nome_utente")); 
			  product.setGame(rs.getString("nome"));
			  product.setDate(rs.getString("buyed")); 
			  product.setTotale(rs.getFloat("totale"));
			  product.setIva(rs.getInt("iva"));
			  product.setQuant(rs.getInt("quantita"));
			  product.setFattura((rs.getString("fatturaNUmero")));
			  products.add(product); }
		  
		  } finally { try { if (preparedStatement != null) preparedStatement.close(); }
		  finally { DriverManagerConnectionPool.releaseConnection(connection); } }
		  return products;
	}

	@Override
	public Collection<Ordine> RetrieveAllOrders() throws SQLException {
		Connection connection = null; PreparedStatement preparedStatement = null;
		
		  Collection<Ordine> products = new LinkedList<Ordine>();
		 
		  String selectSQL = "SELECT * FROM " + "gamemarket.ordini order by buyed asc";
		  
		  try { connection = DriverManagerConnectionPool.getConnection();
		  preparedStatement = connection.prepareStatement(selectSQL);
		  
		  ResultSet rs = preparedStatement.executeQuery();
		  
		  while (rs.next()) { 
			  Ordine product = new Ordine(null, null, null, 0, 0, 0, null);
			
			  product.setNomeUtente(rs.getString("nome_utente")); 
			  product.setGame(rs.getString("nome"));
			  product.setDate(rs.getString("buyed")); 
			  product.setTotale(rs.getFloat("totale"));
			  product.setIva(rs.getInt("iva"));
			  product.setQuant(rs.getInt("quantita"));
			  product.setFattura((rs.getString("fatturaNUmero")));
			  products.add(product); }
		  
		  } finally { try { if (preparedStatement != null) preparedStatement.close(); }
		  finally { DriverManagerConnectionPool.releaseConnection(connection); } }
		  return products;
	}

	@Override
	public Collection<Ordine> RetrieveAllOrders(String sort,String action,String sort2) throws SQLException {
		Connection connection = null; PreparedStatement preparedStatement = null;
		String selectSQL= null;
		  Collection<Ordine> products = new LinkedList<Ordine>();
		 switch(action) {
		 		case "NU":
		 			selectSQL= "SELECT * FROM " + "gamemarket.ordini where nome_utente='"+sort+"'"; 
		 		break;
		 		case "NG":
		 			 selectSQL = "SELECT * FROM " + "gamemarket.ordini where nome='"+sort+"'"; 
		 		break;
		 		case "Totale":
		 			 selectSQL = "SELECT * FROM " + "gamemarket.ordini where totale='"+sort+"'"; 
		 		break;
		 		case "Quant":
		 			 selectSQL = "SELECT * FROM " + "gamemarket.ordini where quantita='"+sort+"'"; 
		 		break;
		 		case "Date":
		 			 selectSQL = "SELECT * FROM " + "gamemarket.ordini where buyed='"+sort+"'"; 
		 		break;
		 		case "Iva":
		 			 selectSQL = "SELECT * FROM " + "gamemarket.ordini where iva='"+sort+"'"; 
		 		break;
		 		case "Fattura":
		 			 selectSQL = "SELECT * FROM " + "gamemarket.ordini where fatturaNUmero='"+sort+"'"; 
		 		break;
		 		case "Special":
		 				sort= sort.replace("-", "/");
		 				sort2= sort2.replace("-", "/");
		 			 selectSQL = "SELECT * FROM " + "gamemarket.ordini WHERE buyed BETWEEN '"+sort +"' AND '"+sort2+"'";
		 			 
		 		break;
		 		default : selectSQL = "SELECT * FROM " + "gamemarket.ordini order by "+sort+" DESC"; 
		 }
		  //String selectSQL = "SELECT * FROM " + "gamemarket.ordini where nome_utente='"+cliente+"'"; 
		  
		  try { connection = DriverManagerConnectionPool.getConnection();
		  preparedStatement = connection.prepareStatement(selectSQL);
		  
		  ResultSet rs = preparedStatement.executeQuery();
		  
		  while (rs.next()) { 
			  Ordine product = new Ordine(null, null, null, 0, 0, 0, null);
			
			  product.setNomeUtente(rs.getString("nome_utente")); 
			  product.setGame(rs.getString("nome"));
			  product.setDate(rs.getString("buyed")); 
			  product.setTotale(rs.getFloat("totale"));
			  product.setIva(rs.getInt("iva"));
			  product.setQuant(rs.getInt("quantita"));
			  product.setFattura((rs.getString("fatturaNUmero")));
			  products.add(product); }
		  
		  } finally { try { if (preparedStatement != null) preparedStatement.close(); }
		  finally { DriverManagerConnectionPool.releaseConnection(connection); } }
		  return products;
	}

	@Override
	public void doSave(Ordine fattura) throws SQLException {
		
		  Connection connection = null;
		  PreparedStatement preparedStatement = null;
		  
		  String insertSQL = "INSERT INTO " + OrdineController.Table_Ordini +
		  " (nome_utente, totale, iva,quantita,nome,fatturaNUmero,buyed) VALUES ( ?, ?, ?,?, ?, ?, ?)";
		  
		  try { connection = DriverManagerConnectionPool.getConnection();
		  preparedStatement = connection.prepareStatement(insertSQL);
		  preparedStatement.setString(1, fattura.getNomeUtente());
		  preparedStatement.setFloat(2, fattura.getTotale());
		  preparedStatement.setInt(3, fattura.getIva());
		  preparedStatement.setInt(4, fattura.getQuant());
		  preparedStatement.setString(5, fattura.getNomeGame());
		  preparedStatement.setString(6, fattura.getFattura());
		  preparedStatement.setString(7, fattura.getDate());
		  preparedStatement.executeUpdate();
		  

		  } finally {
			  try { if (preparedStatement != null)
				  	preparedStatement.close(); 
			  } finally {
		  DriverManagerConnectionPool.releaseConnection(connection); } }
		 
		
	}

	@Override
	public Collection<Ordine> doRetrieveByDate(String inizio, String fine) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
