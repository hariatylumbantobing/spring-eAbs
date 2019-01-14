 package com.projectK5.pabwe.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Entity
@Table(name="kelas")

@EnableTransactionManagement
public class Kelas implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_kelas;
	
	private String nama_kelas;
	
	@Version
	private Integer version;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy ="kelas")
	private Set<Siswa> siswa = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kelas")
	private Set<Absensi> absensi = new HashSet<>();

	public Set<Absensi> getAbsensi() {
		return absensi;
	}

	public void setAbsensi(Set<Absensi> absensi) {
		this.absensi = absensi;
	}
	 
	public Kelas() {
		
	}
	
	
	public Kelas(String nama_kelas) {
        this.nama_kelas = nama_kelas;
    }
	
	
	public long getId_kelas() {
		return id_kelas;
	}


	public void setId_kelas(long id_kelas) {
		this.id_kelas = id_kelas;
	}

	public String getNama_kelas() {
		return nama_kelas;
	}

	public void setNama_kelas(String nama_kelas) {
		this.nama_kelas = nama_kelas;
	}

	public Integer getVersion() {
		return version;
	}


	public void setVersion(Integer version) {
		this.version = version;
	}


	public Set<Siswa> getSiswa() {
		return siswa;
	}


	public void setSiswa(Set<Siswa> siswa) {
		this.siswa = siswa;
	}
	
}
