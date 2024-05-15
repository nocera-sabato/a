package model;

public class User {
	  private String nome_utente;
	  private String pass;
	  private String role;
	  private float balance;
	  private String nome;
	  private String cognome;
	  private String data_nascita;
	  
	  public User(String a,String b, String c, float d, String e, String f,String g) {
		  this.nome_utente=a;
		  this.pass=b;
		  this.role=c;
		  this.balance=d;
		  this.nome=e;
		  this.cognome=f;
		  this.data_nascita=g;
	  }
	  	public String getLogin() {
			return nome_utente;
		}
	  	public String getPass() {
			return pass;
		}
		public float getQuantity() {
			return balance;
		}
		public String getRole() {
			return role;
		}
		public String getNome() {
			return nome;
		}
		public String getCognome() {
			return cognome;
		}
		public String getDataNascita() {
			return data_nascita;
		}
		
		
		public void setLogin(String a) {
			this.nome_utente=a;
		}
		public void setPass(String b) {
			this.pass=b;
		}
		public void setRole(String c) {
			this.role=c;
		}
		public void setBalance (float d) {
			this.balance=d;
		}
		public void setNome(String e) {
			this.nome=e;
		}
		public void setCognome(String f) {
			this.cognome=f;
		}
		public void setDataNascita(String g) {
			this.data_nascita=g;
		}
		
		public String toString(){
			return nome_utente + " " +role + "" +balance+ " " +nome+ " " +cognome+ " " +data_nascita;
			
		}  
	  }
