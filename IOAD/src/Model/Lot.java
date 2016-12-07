package Model;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "loty")
public class Lot {
	@DatabaseField(columnName = "id", canBeNull = false)
	private int id;

	@DatabaseField(columnName = "miejsce_wylotu", canBeNull = false)
	private String miejsceWylotu;
	
	@DatabaseField(columnName = "miejsce_przylotu", canBeNull = false)
	private String miejscePrzylotu;
	
	@DatabaseField(columnName = "data_odlotu", canBeNull = false)
	private Date dataWylotu;
	
	@DatabaseField(columnName = "data_przylotu", canBeNull = false)
	private Date dataPrzylotu;
	
	@DatabaseField(columnName = "id_samolotu", canBeNull = false)
	private int idSamolotu;
	
	@DatabaseField(columnName = "bramka", canBeNull = false)
	private int bramka;
	
	@DatabaseField(columnName = "stan", canBeNull = false)
	private int stan;

	public Lot(){
		
	}
	
	public Lot(int id, String miejsceWylotu, String miejscePrzylotu,
			Date dataWylotu, Date dataPrzylotu, int idSamolotu, int bramka,
			int stan) {
		super();
		this.id = id;
		this.miejsceWylotu = miejsceWylotu;
		this.miejscePrzylotu = miejscePrzylotu;
		this.dataWylotu = dataWylotu;
		this.dataPrzylotu = dataPrzylotu;
		this.idSamolotu = idSamolotu;
		this.bramka = bramka;
		this.stan = stan;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMiejsceWylotu() {
		return miejsceWylotu;
	}

	public void setMiejsceWylotu(String miejsceWylotu) {
		this.miejsceWylotu = miejsceWylotu;
	}

	public String getMiejscePrzylotu() {
		return miejscePrzylotu;
	}

	public void setMiejscePrzylotu(String miejscePrzylotu) {
		this.miejscePrzylotu = miejscePrzylotu;
	}

	public Date getDataWylotu() {
		return dataWylotu;
	}

	public void setDataWylotu(Date dataWylotu) {
		this.dataWylotu = dataWylotu;
	}

	public Date getDataPrzylotu() {
		return dataPrzylotu;
	}

	public void setDataPrzylotu(Date dataPrzylotu) {
		this.dataPrzylotu = dataPrzylotu;
	}

	public int getIdSamolotu() {
		return idSamolotu;
	}

	public void setIdSamolotu(int idSamolotu) {
		this.idSamolotu = idSamolotu;
	}

	public int getBramka() {
		return bramka;
	}

	public void setBramka(int bramka) {
		this.bramka = bramka;
	}

	public int getStan() {
		return stan;
	}

	public void setStan(int stan) {
		this.stan = stan;
	}

	@Override
	public String toString() {
		return "Lot [id=" + id + ", miejsceWylotu=" + miejsceWylotu
				+ ", miejscePrzylotu=" + miejscePrzylotu + ", dataWylotu="
				+ dataWylotu + ", dataPrzylotu=" + dataPrzylotu
				+ ", idSamolotu=" + idSamolotu + ", bramka=" + bramka
				+ ", stan=" + stan + "]";
	}
	
	
	
}
