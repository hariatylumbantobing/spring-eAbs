package com.projectK5.pabwe.model;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="absensi")
public class Absensi {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id_absensi;
	
	private Integer tanggal;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	private int status;

//	private Integer hadir;
//
//	private Integer sakit;
//
//	private Integer izin;
//
//	private Integer alpha;
	
	@ManyToOne
	@JoinColumn(name="nis_absensi")
	private Siswa siswa;
	
	@ManyToOne
	@JoinColumn(name ="rekap_absen")
	private Rekapitulasi rekapitulasi;

	@ManyToOne
	@JoinColumn(name="id_kelas")
	private Kelas kelas;

	public Absensi() {
		
	}

	public Kelas getKelas() {       
		return kelas;
	}

	public void setKelas(Kelas kelas) {
		this.kelas = kelas;
	}

//	public Absensi(MataPelajaran matapelajaran, Integer hadir, Integer sakit, Integer izin, Integer alpha) {
//		this.matapelajaran = matapelajaran;
//		this.hadir = hadir;
//		this.sakit  = sakit;
//		this.izin = izin;
//		this.alpha = alpha;
//	}



//	public Integer getHadir() {
//		return hadir;
//	}
//
//	public void setHadir(Integer hadir) {
//		this.hadir = hadir;
//	}
//
//	public Integer getSakit() {
//		return sakit;
//	}
//
//	public void setSakit(Integer sakit) {
//		this.sakit = sakit;
//	}
//
//	public Integer getIzin() {
//		return izin;
//	}
//
//	public void setIzin(Integer izin) {
//		this.izin = izin;
//	}
//
//	public Integer getAlpha() {
//		return alpha;
//	}
//
//	public void setAlpha(Integer alpha) {
//		this.alpha = alpha;
//	}

	public Integer getTanggal() {
		return tanggal;
	}

	public void setTanggal(Integer tanggal) {
		this.tanggal = tanggal;
	}

	public Integer getId_absensi() {
		return id_absensi;
	}

	public void setId_absensi(Integer id_absensi) {
		this.id_absensi = id_absensi;
	}

	public Siswa getSiswa() {
		return siswa;
	}

	public void setSiswa(Siswa siswa) {
		this.siswa = siswa;
	}

	public Rekapitulasi getRekapitulasi() {
		return rekapitulasi;
	}

	public void setRekapitulasi(Rekapitulasi rekapitulasi) {
		this.rekapitulasi = rekapitulasi;
	}
	

 
}