package com.projectK5.pabwe.repository;

import org.springframework.data.repository.CrudRepository;

import com.projectK5.pabwe.model.Kelas;
import com.projectK5.pabwe.model.Siswa;

public interface SiswaRepository extends CrudRepository<Siswa, Integer> {
	
	Siswa findByKelas(Kelas id_kelas);

}
