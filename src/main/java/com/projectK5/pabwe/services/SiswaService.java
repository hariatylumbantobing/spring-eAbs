package com.projectK5.pabwe.services;

import java.util.List;

import com.projectK5.pabwe.model.Siswa;


public interface SiswaService {

	List<Siswa> listSiswa();
	
	Siswa saveOrUpdate(Siswa siswa);

	Siswa getSiswaByNis(int nis);
	
	void delete(int nis);

	//Siswa getSiswaById_kelas(int id_kelas);

}
