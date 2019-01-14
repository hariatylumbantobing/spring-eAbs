package com.projectK5.pabwe.services;

import java.util.List;

import com.projectK5.pabwe.model.Rekapitulasi;

public interface RekapitulasiService {

	List<Rekapitulasi> listRekapitulasi();
	
	Rekapitulasi saveOrUpdate(Rekapitulasi rekapitulasi);

	Rekapitulasi getRekapitulasiById(Integer id_rekapitulasi);
	
	void delete(Integer id_rekapitulasi);
}

