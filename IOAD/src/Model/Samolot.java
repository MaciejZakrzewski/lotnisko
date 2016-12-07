package Model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "samoloty")
public class Samolot {
	@DatabaseField(columnName = "id_samolotu", canBeNull = false)
	private int idSamolotu;
	
    @DatabaseField(columnName = "id_modelu", foreign = true, foreignAutoRefresh = true)
	private ModeleSamolotow modelSamolotu;
	
	@DatabaseField(columnName = "status_samolotu", canBeNull = false)
	private int statusSamolotu;
	
	@DatabaseField(columnName = "miejsce_parkowania_samolotu", canBeNull = false)
	private String miejsceParkowaniaSamolotu;
	
	public Samolot(){
		
	}

	public Samolot(int idSamolotu, ModeleSamolotow modelSamolotu,
			int statusSamolotu, String miejsceParkowaniaSamolotu) {
		super();
		this.idSamolotu = idSamolotu;
		this.modelSamolotu = modelSamolotu;
		this.statusSamolotu = statusSamolotu;
		this.miejsceParkowaniaSamolotu = miejsceParkowaniaSamolotu;
	}

	public int getIdSamolotu() {
		return idSamolotu;
	}

	public void setIdSamolotu(int idSamolotu) {
		this.idSamolotu = idSamolotu;
	}

	public ModeleSamolotow getModelSamolotu() {
		return modelSamolotu;
	}

	public void setModelSamolotu(ModeleSamolotow modelSamolotu) {
		this.modelSamolotu = modelSamolotu;
	}

	public int getStatusSamolotu() {
		return statusSamolotu;
	}

	public void setStatusSamolotu(int statusSamolotu) {
		this.statusSamolotu = statusSamolotu;
	}

	public String getMiejsceParkowaniaSamolotu() {
		return miejsceParkowaniaSamolotu;
	}

	public void setMiejsceParkowaniaSamolotu(String miejsceParkowaniaSamolotu) {
		this.miejsceParkowaniaSamolotu = miejsceParkowaniaSamolotu;
	}

	@Override
	public String toString() {
		return "Samolot [idSamolotu=" + idSamolotu + ", modelSamolotu="
				+ modelSamolotu + ", statusSamolotu=" + statusSamolotu
				+ ", miejsceParkowaniaSamolotu=" + miejsceParkowaniaSamolotu
				+ "]";
	}
	
	
	
}
