package model;

import java.sql.SQLException;
import java.util.Collection;

public interface OrdineModel {
	public void doSave(Ordine fattura) throws SQLException;

	public boolean doDelete(String code) throws SQLException;

	public Collection<Ordine> doRetrieveByGame(String Games) throws SQLException;
	
	public Collection<Ordine> doRetrieveByDate(String inizio, String fine) throws SQLException;
	
	public Collection<Ordine> SortAll(String order) throws SQLException;
	
	public Collection<Ordine> RetrieveAllOrders() throws SQLException;
	
	public Collection<Ordine> RetrieveAllOrders(String sort,String action,String arg2) throws SQLException;
}
