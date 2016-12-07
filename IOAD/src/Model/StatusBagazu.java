package Model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "status_bagazu")
public class StatusBagazu {
	@DatabaseField(columnName = "id_statusu", canBeNull = false, id = true)
	private int idStatusu;

	@DatabaseField(columnName = "czy_bomba", canBeNull = false)
	private boolean czyBomba;
	
	@DatabaseField(columnName = "czy_dostarczony_do_samolotu", canBeNull = false)
	private boolean czyDostarczonyDoSamolotu;
	
	@DatabaseField(columnName = "czy_jest_w_samolocie", canBeNull = false)
	private boolean czyJestWSamolocie;
	
	@DatabaseField(columnName = "czy_na_tasmie", canBeNull = false)
	private boolean czyNaTasmie;
	
	@DatabaseField(columnName = "czy_zabrany_z_tasmy", canBeNull = false)
	private boolean czyZabranyZTasmy;
	
	public StatusBagazu(){
		
	}

	public StatusBagazu(int idStatusu, boolean czyBomba,
			boolean czyDostarczonyDoSamolotu, boolean czyJestWSamolocie,
			boolean czyNaTasmie, boolean czyZabranyZTasmy) {
		super();
		this.idStatusu = idStatusu;
		this.czyBomba = czyBomba;
		this.czyDostarczonyDoSamolotu = czyDostarczonyDoSamolotu;
		this.czyJestWSamolocie = czyJestWSamolocie;
		this.czyNaTasmie = czyNaTasmie;
		this.czyZabranyZTasmy = czyZabranyZTasmy;
	}

	public int getIdStatusu() {
		return idStatusu;
	}

	public void setIdStatusu(int idStatusu) {
		this.idStatusu = idStatusu;
	}

	public boolean isCzyBomba() {
		return czyBomba;
	}

	public void setCzyBomba(boolean czyBomba) {
		this.czyBomba = czyBomba;
	}

	public boolean isCzyDostarczonyDoSamolotu() {
		return czyDostarczonyDoSamolotu;
	}

	public void setCzyDostarczonyDoSamolotu(boolean czyDostarczonyDoSamolotu) {
		this.czyDostarczonyDoSamolotu = czyDostarczonyDoSamolotu;
	}

	public boolean isCzyJestWSamolocie() {
		return czyJestWSamolocie;
	}

	public void setCzyJestWSamolocie(boolean czyJestWSamolocie) {
		this.czyJestWSamolocie = czyJestWSamolocie;
	}

	public boolean isCzyNaTasmie() {
		return czyNaTasmie;
	}

	public void setCzyNaTasmie(boolean czyNaTasmie) {
		this.czyNaTasmie = czyNaTasmie;
	}

	public boolean isCzyZabranyZTasmy() {
		return czyZabranyZTasmy;
	}

	public void setCzyZabranyZTasmy(boolean czyZabranyZTasmy) {
		this.czyZabranyZTasmy = czyZabranyZTasmy;
	}

	@Override
	public String toString() {
		return "StatusBagazu [idStatusu=" + idStatusu + ", czyBomba="
				+ czyBomba + ", czyDostarczonyDoSamolotu="
				+ czyDostarczonyDoSamolotu + ", czyJestWSamolocie="
				+ czyJestWSamolocie + ", czyNaTasmie=" + czyNaTasmie
				+ ", czyZabranyZTasmy=" + czyZabranyZTasmy + "]";
	}

	
	
}
