package Model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "modelesamolotow")
public class ModeleSamolotow {
	@DatabaseField(columnName = "id_modelu", canBeNull = false, id = true)
	private int idModelu;

	@DatabaseField(columnName = "calkowita_masa_podreczna", canBeNull = false)
	private int calkowitaMasaPodreczna;
	
	@DatabaseField(columnName = "calkowita_masa_bagazu", canBeNull = false)
	private int calkowitaMasaBagazu;
	
	@DatabaseField(columnName = "ilosc_miejsc", canBeNull = false)
	private int iloscMiejsc;
	
	@DatabaseField(columnName = "nazwa", canBeNull = false)
	private String nazwa;

	public ModeleSamolotow(){
		
	}
	
	public ModeleSamolotow(int idModelu, int calkowitaMasaPodreczna,
			int calkowitaMasaBagazu, int iloscMiejsc, String nazwa) {
		super();
		this.idModelu = idModelu;
		this.calkowitaMasaPodreczna = calkowitaMasaPodreczna;
		this.calkowitaMasaBagazu = calkowitaMasaBagazu;
		this.iloscMiejsc = iloscMiejsc;
		this.nazwa = nazwa;
	}

	public int getIdModelu() {
		return idModelu;
	}

	public void setIdModelu(int idModelu) {
		this.idModelu = idModelu;
	}

	public int getCalkowitaMasaPodreczna() {
		return calkowitaMasaPodreczna;
	}

	public void setCalkowitaMasaPodreczna(int calkowitaMasaPodreczna) {
		this.calkowitaMasaPodreczna = calkowitaMasaPodreczna;
	}

	public int getCalkowitaMasaBagazu() {
		return calkowitaMasaBagazu;
	}

	public void setCalkowitaMasaBagazu(int calkowitaMasaBagazu) {
		this.calkowitaMasaBagazu = calkowitaMasaBagazu;
	}

	public int getIloscMiejsc() {
		return iloscMiejsc;
	}

	public void setIloscMiejsc(int iloscMiejsc) {
		this.iloscMiejsc = iloscMiejsc;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	@Override
	public String toString() {
		return "ModeleSamolotow [idModelu=" + idModelu
				+ ", calkowitaMasaPodreczna=" + calkowitaMasaPodreczna
				+ ", calkowitaMasaBagazu=" + calkowitaMasaBagazu
				+ ", iloscMiejsc=" + iloscMiejsc + ", nazwa=" + nazwa + "]";
	}
	
	
}
