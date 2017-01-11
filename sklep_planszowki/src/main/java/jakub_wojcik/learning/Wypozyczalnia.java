package jakub_wojcik.learning;

import java.util.ArrayList;
import jakub_wojcik.learning.GraPlanszowa;

public class Wypozyczalnia{
	//ATRIBUTES -> BEGIN
	private int maksymalnaIloscMiejsc;
	private String opis;
	private String komunikat;
	public int indeksWyszukanejGry;
	private ArrayList<GraPlanszowa> magazyn;
	private ArrayList<GraPlanszowa> wypozyczone;
	//ATRIBUTES -> END
	//-------------------------------------------------------------
	//CONSTRUCTOR -> BEGIN
	public Wypozyczalnia(int maksymalnaIloscMiejsc){
		this.maksymalnaIloscMiejsc=maksymalnaIloscMiejsc;
		this.magazyn=new ArrayList<GraPlanszowa>();
		this.wypozyczone=new ArrayList<GraPlanszowa>();
	}//CONSTRUCTON -> END
	//-------------------------------------------------------------
	//GETTERS -> BEGIN
	public int getMaksymalnaIloscMiejsc(){
		return this.maksymalnaIloscMiejsc;
	}
	public String getOpis(){
		return this.opis;
	}
	public String getKomunikat(){
		return this.komunikat;
	}
	public ArrayList<GraPlanszowa> getMagazyn(){
		return this.magazyn;
	}
	public ArrayList<GraPlanszowa> getWypozyczone(){
		return this.wypozyczone;
	}
	//GETTERS -> END
	//-------------------------------------------------------------
	//SETTERS -> BEGIN
	public void setMaksymalnaIloscMiejsc(int maksymalnaIloscMiejsc){
		this.maksymalnaIloscMiejsc=maksymalnaIloscMiejsc;
	}
	public void setOpis(String opis){
		this.opis=opis;
	}
	public void setKomunikat(String komunikat){
		this.komunikat=komunikat;
	}
	//SETTERS -> END
	
	//LOGIKA WYSZUKIWANIA -> BEGIN
	public GraPlanszowa wyszukajGreMagazyn(int identyfikator){
		GraPlanszowa graTemp=null;
		for(GraPlanszowa gra : magazyn){
			if(gra.getIdentyfikator()==identyfikator){
				indeksWyszukanejGry=magazyn.indexOf(gra);//zapisanie indeksu wyszukanej gry
				graTemp=gra;
				break;
			}
		}
		return graTemp;//je�eli metoda zwraca NULL, to gry o podanym ID nie ma na magazynie
	}
	public GraPlanszowa wyszukajGreWypozyczone(int identyfikator){
		GraPlanszowa graTemp=null;
		for(GraPlanszowa gra : wypozyczone){
			if(gra.getIdentyfikator()==identyfikator){
				indeksWyszukanejGry=wypozyczone.indexOf(gra);//zapisanie indeksu wyszukanej wypozyczonej gry
				graTemp=gra;
				break;
			}
		}
		return graTemp;//je�eli metoda zwraca NULL, to gry o podanym ID nie ma na magazynie
	}
	public String przejrzyj(ArrayList<GraPlanszowa> lista){//przejrzyj magazyn lub wypozyczone
		String wynikPrzegladania=null;
		for(GraPlanszowa gra : lista){
			wynikPrzegladania+="----------------------";
			wynikPrzegladania+=("Nazwa gry: " + gra.getNazwa() + "\n");
			wynikPrzegladania+=("Identyfikator: " + gra.getIdentyfikator() + "\n");
			wynikPrzegladania+=("Koszt wypo�yczenia za dzie�: " + gra.getKosztWypozyczeniaZaDzien() + "\n");
			wynikPrzegladania+=("Opis: " + gra.getOpis() + "\n");
			
		}
		return wynikPrzegladania;
	}
	//LOGIKA WYSZUKIWANIA -> END
	//-------------------------------------------------------------
	//LOGIKA WYPO�YCZANIA -> BEGIN
	public void dodajGreDoMagazynu(GraPlanszowa gra){
		if(magazyn.size()<this.maksymalnaIloscMiejsc){
			magazyn.add(gra);
		}else this.komunikat="Osi�gni�to maksymaln� ilo�� miejsc w magazynie";
	}
	public void wypozyczGre(int identyfikatorGry){
		GraPlanszowa graTemp=wyszukajGreMagazyn(identyfikatorGry);
		if(graTemp!=null){
			magazyn.remove(indeksWyszukanejGry);
			wypozyczone.add(graTemp);
			this.komunikat="Pomy�lnie wypo�yczono gr� o indentyfikatorze: " + graTemp.getIdentyfikator();
		}else{
			this.komunikat="W magazynie nie ma gry o podanym identyfikatorze!";
		}
	}
	public void zwrocGre(int identyfikatorGry){
		GraPlanszowa graTemp=wyszukajGreWypozyczone(identyfikatorGry);
		if(graTemp!=null){
			wypozyczone.remove(indeksWyszukanejGry);
			magazyn.add(graTemp);
			this.komunikat="Pomy�lnie zwr�cono gr� do magazynu!";
		}else{
			this.komunikat="Gra o podanym identyfikatorze nie zosta�a zarejstrowana jako wypo�yczona!";
		}
	}
	//LOGIKA WYPO�YCZANIA -> END
	//-------------------------------------------------------------
}

