package com.projectK5.pabwe.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="siswa")
public class Siswa implements Serializable{

	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Integer nis;

	 @NotNull
	 @Size(max = 255)
	 @Column(name = "nama_siswa")
	 private String nama;

	 @NotNull
	 private String jk_siswa;

	 @NotNull
	 private String nama_ortu;

	 @NotNull
	 private String no_ortu;
	 
	 @ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	 @JoinColumn(name="id_kelas")
	 private Kelas kelas;
	 
	 @OneToMany(mappedBy="siswa", cascade=CascadeType.ALL, fetch = FetchType.LAZY )
	 private Set<Absensi> absensi= new HashSet<>();
	 
	 @OneToMany(mappedBy="siswa", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	 private Set<Rekapitulasi> rekapitulasi= new HashSet<>();
	 
	 
	 @Version
	 private Integer version;
	 
	 public Siswa() {
		 
	 }

	 public Siswa(int nis){
	 	this.nis = nis;
	 }

	 public Siswa (String nama, String jk_siswa, String nama_ortu, String no_ortu, Integer version) {
	        this.nama = nama;
	        this.jk_siswa = jk_siswa;
	        this.nama_ortu = nama_ortu;
	        this.no_ortu = no_ortu;
	        this.version = version;
	    } 
	 public Siswa (String nama, String jk_siswa, String nama_ortu, String no_ortu, Integer version, Kelas kelas, Set<Absensi> absensi) {
	        this.nama = nama;
	        this.jk_siswa = jk_siswa;
	        this.nama_ortu = nama_ortu;
	        this.no_ortu = no_ortu;
	        this.version = version;
	        this.kelas=kelas;
	        this.absensi=absensi;
	    } 
	 
	public Integer getNis() {
		return nis;
	}

	public void setNis(Integer nis) {
		this.nis = nis;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getJk_siswa() {
		return jk_siswa;
	}

	public void setJk_siswa(String jk_siswa) {
		this.jk_siswa = jk_siswa;
	}

	public String getNama_ortu() {
		return nama_ortu;
	}

	public void setNama_ortu(String nama_ortu) {
		this.nama_ortu = nama_ortu;
	}

	public String getNo_ortu() {
		return no_ortu;
	}

	public void setNo_ortu(String no_ortu) {
		this.no_ortu = no_ortu;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}


	public void setKelas(Kelas kelas) {
		this.kelas = kelas;
	}

	public Kelas getKelas() {
		return kelas;
	}

	public Set<Absensi> getAbsensi() {
		return absensi;
	}

	public void setAbsensi(Set<Absensi> absensi) {
		this.absensi = absensi;
	}

	public Set<Rekapitulasi> getRekapitulasi() {
		return rekapitulasi;
	}

	public void setRekapitulasi(Set<Rekapitulasi> rekapitulasi) {
		this.rekapitulasi = rekapitulasi;
	}

	
	
	
}