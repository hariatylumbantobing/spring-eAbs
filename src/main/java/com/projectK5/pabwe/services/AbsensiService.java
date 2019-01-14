package com.projectK5.pabwe.services;

import java.util.List;

import com.projectK5.pabwe.model.Absensi;

import com.projectK5.pabwe.model.Kelas;
import com.projectK5.pabwe.model.Siswa;

public interface AbsensiService {

    List<Absensi> listAbsensi();
    
    List<Kelas> listKelas();

    List<Siswa> listSiswa();

    Absensi saveOrUpdate(Absensi absensi);

    Absensi getAbsensiById(Integer id_absensi);

    void delete(Integer id_absensi);



}