package Controller;
import model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

public class ProductModelDM implements ProductModel {

	private static final String TABLE_NAME = "games";
	

	@Override
	public synchronized void doSave(game product) throws SQLException {

		
		  Connection connection = null; 
		  PreparedStatement preparedStatement = null;
		  
		  String insertSQL = "INSERT INTO " + ProductModelDM.TABLE_NAME +
		  " (nome, years, added, imgGame,quantita,price,descrizione,genere,peg,iva) VALUES (?, ?, ?, ?,?, ?, ?, ?,?, ?)";
		  
		  try { connection = DriverManagerConnectionPool.getConnection();
		  preparedStatement = connection.prepareStatement(insertSQL);
		  preparedStatement.setString(1, product.getName());
		  preparedStatement.setString(2, product.getYears());
		  preparedStatement.setString(3, product.getAdded());
		  preparedStatement.setString(4, product.getImg());
		  preparedStatement.setInt(5,product.getQuantity());
		  preparedStatement.setFloat(6,product.getPrice());
		  preparedStatement.setString(7, product.getDesc());
		  preparedStatement.setString(8, product.getGenere());
		  preparedStatement.setInt(9,product.getPEG());
		  preparedStatement.setInt(10,product.getIva());
		  
		  preparedStatement.executeUpdate();
		  
		  
		  } 
		  finally { try {
			  if (preparedStatement != null)
		  preparedStatement.close(); 
			  } finally {
		  DriverManagerConnectionPool.releaseConnection(connection); } 
		  }
		 
	}

	@Override
	public synchronized game doRetrieveByKey(String name) throws SQLException {
		
		
		  Connection connection = null;
		  PreparedStatement preparedStatement = null;
		  
		  game bean = new game(name, null, null, null, null, 0, null, null, 0, null, 0);
		  
		  String selectSQL = "SELECT * FROM " + ProductModelDM.TABLE_NAME +
		  " WHERE nome = ?";
		  
		  try { connection = DriverManagerConnectionPool.getConnection();
		  preparedStatement = connection.prepareStatement(selectSQL);
		  preparedStatement.setString(1, name);
		  
		  ResultSet rs = preparedStatement.executeQuery();
		  
		  while (rs.next()) { 
			  bean.setName(rs.getString("nome")); 
			  bean.setQuantity(rs.getInt("quantita"));
			  bean.setYears(rs.getString("years")); 
			  bean.setAdded(rs.getString("added"));
			  bean.setImg(rs.getString("imgGame"));
			  bean.setPrice(rs.getFloat("price"));
			  bean.setDesc(rs.getString("descrizione"));
			  bean.setPEG(rs.getInt("peg"));
			  bean.setIva(rs.getInt("iva"));
			  bean.setGenere(rs.getString("genere"));
			  
		  }
		  
		  } finally { try { if (preparedStatement != null) preparedStatement.close(); }
		  finally { DriverManagerConnectionPool.releaseConnection(connection); } }
		  return bean;
		 
	}

	@Override
	public synchronized void doDelete(String name) throws SQLException {
		
		
		  Connection connection = null;
		  PreparedStatement preparedStatement = null;
		  
		  String deleteSQL = "DELETE FROM " + ProductModelDM.TABLE_NAME +
		  " WHERE nome = ?";
		  
		  try { 
			  connection = DriverManagerConnectionPool.getConnection();
		  preparedStatement = connection.prepareStatement(deleteSQL);
		  preparedStatement.setString(1, name);
		  
		   preparedStatement.executeUpdate();
		  
		  } finally { try { if (preparedStatement != null) preparedStatement.close(); }
		  finally { DriverManagerConnectionPool.releaseConnection(connection); } }
		  
		 
	}


	/*
	 * public synchronized Collection<ProductBean> doRetrieveAll(String order)
	 * throws SQLException {
	 * 
	 * Connection connection = null; PreparedStatement preparedStatement = null;
	 * 
	 * Collection<ProductBean> products = new LinkedList<ProductBean>();
	 * 
	 * String selectSQL = "SELECT * FROM " + ProductModelDM.TABLE_NAME;
	 * 
	 * if (order != null && !order.equals("")) { selectSQL += " ORDER BY " + order;
	 * }
	 * 
	 * try { connection = DriverManagerConnectionPool.getConnection();
	 * preparedStatement = connection.prepareStatement(selectSQL);
	 * 
	 * ResultSet rs = preparedStatement.executeQuery();
	 * 
	 * while (rs.next()) { ProductBean bean = new ProductBean();
	 * 
	 * bean.setCode(rs.getInt("CODE")); bean.setName(rs.getString("NAME"));
	 * bean.setDescription(rs.getString("DESCRIPTION"));
	 * bean.setPrice(rs.getInt("PRICE")); bean.setQuantity(rs.getInt("QUANTITY"));
	 * products.add(bean); }
	 * 
	 * } finally { try { if (preparedStatement != null) preparedStatement.close(); }
	 * finally { DriverManagerConnectionPool.releaseConnection(connection); } }
	 * return products;
	 * 
	 * }
	 */

	

	@Override
	public Collection<game> RetrieveAll() throws SQLException {
		Connection connection = null; 
		PreparedStatement preparedStatement = null;
		
		  Collection<game> products = new LinkedList<game>();
		 
		  String selectSQL = "SELECT * FROM " + ProductModelDM.TABLE_NAME + " order by added DESC";
		  
		  try { connection = DriverManagerConnectionPool.getConnection();
		  preparedStatement = connection.prepareStatement(selectSQL);
		  
		  ResultSet rs = preparedStatement.executeQuery();
		  
		  while (rs.next()) { 
			  game product = new game("",0,"","","",0,"",0,0, "",0);
			
		  product.setName(rs.getString("nome")); 
		  product.setQuantity(rs.getInt("quantita"));
		  product.setYears(rs.getString("years")); 
		  product.setAdded(rs.getString("added"));
		  product.setImg(rs.getString("imgGame"));
		  product.setPrice(rs.getFloat("price"));
		  product.setDesc(rs.getString("descrizione"));
		  product.setPEG(rs.getInt("peg"));
		  product.setIva(rs.getInt("iva"));
		  product.setGenere(rs.getString("genere"));
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
	public Collection<Ordine> RetrieveAllOrders(String cliente) throws SQLException {
		Connection connection = null; PreparedStatement preparedStatement = null;
		
		  Collection<Ordine> products = new LinkedList<Ordine>();
		 
		  String selectSQL = "SELECT * FROM " + "gamemarket.ordini where nome_utente='"+cliente+"'"; 
		  
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
	public Collection<game> SortAll(String order) throws SQLException {
		Connection connection = null; 
		PreparedStatement preparedStatement = null;
		
		  Collection<game> products = new LinkedList<game>();
		 
		  String selectSQL = "SELECT * FROM " + ProductModelDM.TABLE_NAME + " "+order;
		  
		  		  
		  try { connection = DriverManagerConnectionPool.getConnection();
		  preparedStatement = connection.prepareStatement(selectSQL);
		  
		  ResultSet rs = preparedStatement.executeQuery();
		  
		  while (rs.next()) { 
			  game product = new game("",0,"","","",0,"",0,0, "",0);
			
		  product.setName(rs.getString("nome")); 
		  product.setQuantity(rs.getInt("quantita"));
		  product.setYears(rs.getString("years")); 
		  product.setAdded(rs.getString("added"));
		  product.setImg(rs.getString("imgGame"));
		  product.setPrice(rs.getFloat("price"));
		  product.setDesc(rs.getString("descrizione"));
		  product.setPEG(rs.getInt("peg"));
		  product.setIva(rs.getInt("iva"));
		  product.setGenere(rs.getString("genere"));
		  products.add(product); }
		  
		  } finally { try { if (preparedStatement != null) preparedStatement.close(); }
		  finally { DriverManagerConnectionPool.releaseConnection(connection); } }
		  return products;
	}

	@Override
	public void doUpdate(String nomeGame,String campo,String valore) throws SQLException {
		Connection connection = null; 
		  PreparedStatement preparedStatement = null;
		  int p=0;
		  
		  String action;
		  double tmpD = Double.parseDouble(valore);
		  if(campo.compareTo("i")==0) {
			  action="iva";
			 //p = (int) k;
			  p = (int) tmpD;
		  }
		  else if(campo.compareTo("q")==0) {
			  action="quantita";
			  //p =(int) k;
			  p = (int) tmpD;
		  }
		  else action="price";
	  		Float k = (float) tmpD;
	  		String insertSQL = "UPDATE " + ProductModelDM.TABLE_NAME +" SET "+action+"=? where nome=?";
		  
		  
		  
		  try {
			  connection = DriverManagerConnectionPool.getConnection();
		  preparedStatement = connection.prepareStatement(insertSQL);
		  
		  if(campo.compareTo("p")==0) preparedStatement.setFloat(1, k);
		  else preparedStatement.setInt(1, p);
		  preparedStatement.setString(2, nomeGame);
		  
		  preparedStatement.executeUpdate();
		  
		  
		  } 
		  finally { try {
			  if (preparedStatement != null)
		  preparedStatement.close(); 
			  } finally {
		  DriverManagerConnectionPool.releaseConnection(connection); } 
		  }
		
	}

}