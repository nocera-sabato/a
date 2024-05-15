package model;

public class game {
	
	private String name;
	private Integer quantity;
	private String years;
	private String added;
	private String img;
	private float price;
	private String desc;
	private Integer peg;
	private Integer iva;
	private String genere;
	private Integer CartQuantity;
	
	public game(String a,Integer quantity,String b,String c,String d,float f,String g,Integer peg, Integer iva,String genere,Integer CartQuantity) {
		this.name=a;
		this.quantity=quantity;
		this.years=b;
		this.added=c;
		this.img=d;
		this.price=f;
		this.desc=g;
		this.peg=peg;
		this.iva=iva;
		this.genere=genere;
		this.CartQuantity=CartQuantity;
	}
	
	
	public game() {
		// TODO Auto-generated constructor stub
	}


	public String getName() {
		return name;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public String getYears() {
		return years;
	}
	public String getAdded() {
		return added;
	}
	public String getImg() {
		return img;
	}
	public float getPrice() {
		return price;
	}
	public String getDesc() {
		return desc;
	}
	public Integer getPEG() {
		return peg;
	}
	public Integer getIva() {
		return iva;
	}
	public Integer getCQ() {
		return CartQuantity;
	}
	public String getGenere() {
		return genere;
	}
	
	
	public void setName(String a) {
		this.name=a;
	}
	public void setQuantity(Integer quantity) {
		this.quantity=quantity;
	}public void setYears(String b) {
		this.years=b;
	}public void setAdded(String c) {
		this.added=c;
	}public void setImg(String d) {
		this.img=d;
	}public void setPrice (float a) {
		this.price=a;
	}public void setDesc (String e) {
		this.desc=e;
	}
	public void setPEG (Integer PEG) {
		this.peg= PEG;
	}
	public void setIva (Integer Iva) {
		this.iva= Iva;
	}
	public void setCQ(Integer CartQuantity) {
		this.CartQuantity= CartQuantity;
	}
	public void setGenere (String gen) {
		this.genere=gen;
	}
	
	
	public boolean equals(game obj) {
		if((this.getName().compareToIgnoreCase(obj.getName()))==0) {
			return true;
		}
		else return false;
	}
	
	
	public String toString(){
		return name + " " +quantity + "" +years+ " " +added+ " " +img+ " " +price+ " " +desc+ " " +peg+ " " +genere;
		
	}

}
