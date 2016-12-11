package KlientPack;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "identyfikatory")
public class Identyfikator {

	@DatabaseField(columnName = "id_identyfikatora", generatedId = true)
	private Integer id;
	
	@DatabaseField(columnName = "typ", canBeNull = false)
	private String typ;

	@DatabaseField(columnName = "numer", canBeNull = false)
	private String wartosc;

	public Identyfikator() {

	}

	public Identyfikator(int id, String typ, String wartosc) {
		super();
		this.id = id;
		this.typ = typ;
		this.wartosc = wartosc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public String getWartosc() {
		return wartosc;
	}

	public void setWartosc(String wartosc) {
		this.wartosc = wartosc;
	}

	@Override
	public String toString() {
		return "Identyfikator [id=" + id + ", typ=" + typ + ", wartosc="
				+ wartosc + "]";
	}
	
	
	
}
