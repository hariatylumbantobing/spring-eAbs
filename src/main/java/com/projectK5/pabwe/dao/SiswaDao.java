package com.projectK5.pabwe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectK5.pabwe.model.Siswa;
import com.projectK5.pabwe.services.SiswaService;

@Service
public class SiswaDao implements SiswaService {

//	private EntityManagerFactory emf;
	private EntityManager em;

	@Autowired
	public void setEmf(EntityManagerFactory emf) {
//		this.emf = emf;
		em = emf.createEntityManager();
	}

	@Override
	public List<Siswa> listSiswa() {
		// TODO Auto-generated method stub
//		EntityManager em = emf.createEntityManager();
		return em.createQuery("from Siswa", Siswa.class).getResultList();
	}

	@Override
	public Siswa saveOrUpdate(Siswa siswa) {
		// TODO Auto-generated method stub
//		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Siswa saved = em.merge(siswa);
		em.getTransaction().commit();
		return saved;
	}

	@Override
	public Siswa getSiswaByNis(int nis) {
		// TODO Auto-generated method stub
//		EntityManager em = emf.createEntityManager();
		return em.find(Siswa.class, nis);
	}

	@Override
	public void delete(int nis) {
		// TODO Auto-generated method stub
//		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Siswa.class, nis));
		em.getTransaction().commit();
	}

	//@Override
	//public Siswa getSiswaById_kelas(int id_kelas) {
		// TODO Auto-generated method stub
//		EntityManager em = emf.createEntityManager();
	//	return em.find(Siswa.class, id_kelas);
	//}

	
}
