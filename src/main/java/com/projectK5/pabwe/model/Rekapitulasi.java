package com.projectK5.pabwe.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
//@Table(name="rekapitulasi")
public class Rekapitulasi {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id_rekapitulasi;
	 
	
	@ManyToOne
	@JoinColumn(name="nis_rekap")
	private Siswa siswa;
	
	@OneToMany(mappedBy="rekapitulasi", cascade=CascadeType.ALL)
	private Set <Absensi> absensi = new HashSet<>();
	

	private Integer tahun;
	
	private String semester;
	
	private Integer hadir;
	
	private String sakit;
	
	private String alpa;
	
	private String izin;
	
	private float persentasi;
	
	public Integer getId_rekapitulasi() {
		return id_rekapitulasi;
	}

	public void setId_rekapitulasi(Integer id_rekapitulasi) {
		this.id_rekapitulasi = id_rekapitulasi;
	}

	public Integer getTahun() {
		return tahun;
	}

	public void setTahun(Integer tahun) {
		this.tahun = tahun;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public Integer getHadir() {
		return hadir;
	}

	public void setHadir(Integer hadir) {
		this.hadir = hadir;
	}

	public String getSakit() {
		return sakit;
	}

	public void setSakit(String sakit) {
		this.sakit = sakit;
	}

	public String getAlpa() {
		return alpa;
	}

	public void setAlpa(String alpa) {
		this.alpa = alpa;
	}

	public String getIzin() {
		return izin;
	}

	public void setIzin(String izin) {
		this.izin = izin;
	}

	public float getPersentasi() {
		return persentasi;
	}

	public void setPersentasi(float persentasi) {
		this.persentasi = persentasi;
	}

	
	public Siswa getSiswa() {
		return siswa;
	}

	public void setSiswa(Siswa siswa) {
		this.siswa = siswa;
	}

	public Set<Absensi> getAbsensi() {
		return absensi;
	}

	public void setAbsensi(Set<Absensi> absensi) {
		this.absensi = absensi;
	}
	
	
	

}
