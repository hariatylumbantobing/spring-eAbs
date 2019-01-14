package com.projectK5.pabwe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectK5.pabwe.model.Kelas;
import com.projectK5.pabwe.services.KelasService;

@Service
public class KelasDao implements KelasService {

//	private EntityManagerFactory emf;
	private EntityManager em;

	@Autowired
	public void setEmf(EntityManagerFactory emf) {
//		this.emf = emf;
		em = emf.createEntityManager();
	}

	@Override
	public List<Kelas> listKelas() {
		// TODO Auto-generated method stub
//		EntityManager em = emf.createEntityManager();
		return em.createQuery("from Kelas", Kelas.class).getResultList();
	}

	@Override
	public Kelas saveOrUpdate(Kelas kelas) {
		// TODO Auto-generated method stub
//		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Kelas saved = em.merge(kelas);
		em.getTransaction().commit();
		return saved;
	}

	@Override
	public Kelas getKelasByIdKelas(long id_kelas) {
		// TODO Auto-generated method stub
//		EntityManager em = emf.createEntityManager();
		return em.find(Kelas.class, id_kelas);
	}

	@Override
	public void delete(long id_kelas) {
		// TODO Auto-generated method stub
//		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Kelas.class, id_kelas));
		em.getTransaction().commit();
	}
}
