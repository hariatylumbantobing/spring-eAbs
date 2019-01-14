package com.projectK5.pabwe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectK5.pabwe.model.Rekapitulasi;
import com.projectK5.pabwe.services.RekapitulasiService;

@Service
public class RekapitulasiDao implements RekapitulasiService {

//	private EntityManagerFactory emf;
	private EntityManager em;

	@Autowired
	public void setEmf(EntityManagerFactory emf) {
//		this.emf = emf;
		em = emf.createEntityManager();
	}

	@Override
	public List<Rekapitulasi> listRekapitulasi() {
		// TODO Auto-generated method stub
//		EntityManager em = emf.createEntityManager();
		return em.createQuery("from Rekapitulasi", Rekapitulasi.class).getResultList();
	}

	@Override
	public Rekapitulasi saveOrUpdate(Rekapitulasi rekapitulasi) {
		// TODO Auto-generated method stub
//		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Rekapitulasi saved = em.merge(rekapitulasi);
		em.getTransaction().commit();
		return saved;
	}

	@Override
	public Rekapitulasi getRekapitulasiById(Integer id_rekapitulasi) {
		// TODO Auto-generated method stub
//		EntityManager em = emf.createEntityManager();
		return em.find(Rekapitulasi.class, id_rekapitulasi);
	}

	@Override
	public void delete(Integer id_rekapitulasi) {
		// TODO Auto-generated method stub
//		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Rekapitulasi.class, id_rekapitulasi));
		em.getTransaction().commit();
	}
}