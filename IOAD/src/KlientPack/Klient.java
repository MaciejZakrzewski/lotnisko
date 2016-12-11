package KlientPack;

import java.util.List;

import com.j256.ormlite.field.DatabaseField;
import Model.Rezerwacje;
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

  private List<Rezerwacje> listaRezerwacji;

  public Klient() {
		
	}

  public Klient(int id, String imie, String nazwisko, Identyfikator identyfikator) {
    this.id = id;
    this.imie = imie;
    this.nazwisko = nazwisko;
    this.identyfikator = identyfikator;
  }

  public Integer getId() {
    return (Integer)id;
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
  
  public List<Rezerwacje> getListaRezerwacji() {
    return listaRezerwacji;
  }

  public void setListaRezerwacji(List<Rezerwacje> listaRezerwacji) {
    this.listaRezerwacji = listaRezerwacji;
  }

  @Override
  public String toString() {
    return "Klient [id=" + id + ", imie=" + imie + ", nazwisko=" + nazwisko + ", identyfikator=" + identyfikator
        + ", listaRezerwacji=" + listaRezerwacji + "]";
  }

}
