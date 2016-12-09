package KlientPack;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "klienci")
public class Klient {

	@DatabaseField(generatedId = true)
	private int id;
	
	@DatabaseField(columnName = "imie", canBeNull = false)
	private String imie;

	@DatabaseField(columnName = "nazwisko", canBeNull = false)
	private String nazwisko;

    @DatabaseField(columnName = "id_identyfikatora", foreign = true, foreignAutoRefresh = true)
	private Identyfikator identyfikator;
	
	
	public Klient() {
		
	}
	
	public Klient(int id, String imie, String nazwisko, Identyfikator identyfikator) {
		super();
		this.id = id;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.identyfikator = identyfikator;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public Identyfikator getIdentyfikator() {
		return identyfikator;
	}
	public void setIdentyfikator(Identyfikator identyfikator) {
		this.identyfikator = identyfikator;
	}



	@Override
	public String toString() {
		return "Klient [id=" + id + ", imie=" + imie + ", nazwisko=" + nazwisko
				+ ", identyfikator=" + identyfikator + "]";
	}
	
	
}
