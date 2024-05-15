package model;

import java.sql.SQLException;
import java.util.Collection;

public interface UserModel {
	public void doSave(User utente) throws SQLException;

	public void doDelete(String login) throws SQLException;

	public User doRetrieveByKey(String login) throws SQLException;
	
	public Collection<User> doRetrieveAll(String order) throws SQLException;
	
	public boolean UserBuy(String nome,float saldo) throws SQLException;
	
	public void setManager(String id) throws SQLException;
	
	public void setAdmin(String id) throws SQLException;
	
	//public Collection<User> RetrieveAll() throws SQLException;
}
