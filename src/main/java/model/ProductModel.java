package model;
import java.sql.SQLException;
import java.util.Collection;

public interface ProductModel {
	public void doSave(game product) throws SQLException;
	
	public void doUpdate(String nomeGame,String campo,String valore) throws SQLException;

	public void doDelete(String code) throws SQLException;

	public game doRetrieveByKey(String code) throws SQLException;
	
	public Collection<game> SortAll(String order) throws SQLException;
	
	public Collection<game> RetrieveAll() throws SQLException;
	
	public Collection<Ordine> RetrieveAllOrders() throws SQLException;
	
	public Collection<Ordine> RetrieveAllOrders(String cliente) throws SQLException;
}
