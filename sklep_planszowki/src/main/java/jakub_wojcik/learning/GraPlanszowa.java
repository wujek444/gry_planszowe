package jakub_wojcik.learning;
import jakub_wojcik.learning.KategoriaCenowa;

public class GraPlanszowa {
	//ATRIBUTES -> BEGIN
	private String nazwa;
	private KategoriaCenowa kategoriaCenowa;
	private int identyfikator;
	private String opis;
	private boolean czyWypozyczona;
	//ATRIBUTES -> END
	//CONSTRUCTOR -> BEGIN
	public GraPlanszowa(String nazwa, KategoriaCenowa kategoria, int id, String opis) {
		this.nazwa=nazwa;
		this.kategoriaCenowa=kategoria;
		this.identyfikator=id;
		this.opis=opis;
		this.czyWypozyczona=false;
	}//CONSTRUCTOR -> END
	//GETTERS -> BEGIN
	public String getNazwa(){
		return nazwa;
	}
	public KategoriaCenowa getKategoria(){
		return kategoriaCenowa;
	}
	public int getIdentyfikator(){
		return identyfikator;
	}
	public String getOpis(){
		return opis;
	}
	public boolean getCzyWypozyczona(){
		return czyWypozyczona;
	}//GETTERS -> END
	//SETTERS -> BEGIN
	public void setNazwa(String nazwa){
		this.nazwa=nazwa;
	}
	public void setKategoria(KategoriaCenowa kategoria){
		this.kategoriaCenowa=kategoria;
	}
	public void setIdentyfikator(int identyfikator){
		this.identyfikator=identyfikator;
	}
	public void setOpis(String opis){
		this.opis=opis;
	}
	public void setCzyWypozyczona(boolean czyWypozyczona){
		this.czyWypozyczona=czyWypozyczona;
	}//SETTERS - END
	public double getKosztWypozyczeniaZaDzien(){
		switch(getKategoria()){
		case A: return 10.0;
		case B: return 8.0;
		case C: return 5.0;
		default: return 0.0;
		}
	}
}
