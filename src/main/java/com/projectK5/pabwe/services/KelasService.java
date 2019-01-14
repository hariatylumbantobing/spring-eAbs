package com.projectK5.pabwe.services;

import java.util.List;

import com.projectK5.pabwe.model.Kelas;

public interface KelasService {

	List<Kelas> listKelas();
	
	Kelas saveOrUpdate(Kelas kelas);

	Kelas getKelasByIdKelas(long id_kelas);
	
	void delete(long id_kelas);
}
