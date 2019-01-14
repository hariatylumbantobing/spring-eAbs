package com.projectK5.pabwe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectK5.pabwe.model.Absensi;
import com.projectK5.pabwe.model.Kelas;
import com.projectK5.pabwe.model.Siswa;
import com.projectK5.pabwe.services.AbsensiService;

@Service
public class AbsensiDao implements AbsensiService {

    //	private EntityManagerFactory emf;
    private EntityManager em;

    @Autowired
    public void setEmf(EntityManagerFactory emf) {
//		this.emf = emf;
        em = emf.createEntityManager();
    }

    @Override
    public List<Absensi> listAbsensi() {
        // TODO Auto-generated method stub
//		EntityManager em = emf.createEntityManager();
        return em.createQuery("from Absensi", Absensi.class).getResultList();
    }

    @Override
    public Absensi saveOrUpdate(Absensi absensi) {
        // TODO Auto-generated method stub
//		EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Absensi saved = em.merge(absensi);
        em.getTransaction().commit();
        return saved;
    }

    @Override
    public Absensi getAbsensiById(Integer id_absensi) {
        // TODO Auto-generated method stub
//		EntityManager em = emf.createEntityManager();
        return em.find(Absensi.class, id_absensi);
    }

    @Override
    public void delete(Integer id_absensi) {
        // TODO Auto-generated method stub
//		EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Absensi.class, id_absensi));
        em.getTransaction().commit();
    }

	@Override
	public List<Kelas> listKelas() {
		// TODO Auto-generated method stub
		return em.createQuery("from Kelas", Kelas.class).getResultList();
	}

    @Override
    public List<Siswa> listSiswa() {
        // TODO Auto-generated method stub
        return em.createQuery("from Siswa", Siswa.class).getResultList();
    }

//	@Override
//	public List<Kelas> listKelas() {
//		// TODO Auto-generated method stub
//		return em.createQuery("from Kelas", Kelas.class).getResultList();
//	}
}