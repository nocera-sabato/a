package model;

public class Ordine {
	 private String nome_utente;
	  private float totale;
	  private Integer iva;
	  private String gameName;
	  private Integer quantita;
	  private String fattura;
	  private String DateBuy;
	  
	  
	  public Ordine(String a,String b, String c, float d,int f,int q,String fat) {
		  this.nome_utente=a;
		  this.gameName=b;
		  this.DateBuy=c;
		  this.totale=d;
		  this.iva=f;
		  this.quantita=q;
		  this.fattura=fat;
	  }
	  public Ordine() {
		  
	  }
	  
	  public String getOrdine() {
			return (nome_utente+" "+gameName+" "+totale+" "+iva+" "+DateBuy+" "+quantita+" "+fattura);
		}
	  public String getNomeUtente() {
			return nome_utente;
		}
	  	public String getDate() {
			return DateBuy;
		}
	  	public String getNomeGame() {
			return gameName;
		}
		public float getTotale() {
			return totale;
		}
		public int getIva() {
			return iva;
		}
		public int getQuant() {
			return quantita;
		}
		public String getFattura() {
			return fattura;
		}
		
		public void setNomeUtente(String a) {
			this.nome_utente=a;
		}
		public void setGame(String b) {
			this.gameName=b;
		}
		public void setDate(String c) {
			this.DateBuy=c;
		}
		public void setTotale (float d) {
			this.totale=d;
		}
		public void setIva (int f) {
			this.iva=f;
		}
		public void setQuant(int g) {
			this.quantita=g;
		}
		public void setFattura(String fat) {
			this.fattura=fat;
		}
}
