package org.banque.gestion.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.banque.gestion.entities.Client;
import org.banque.gestion.entities.Compte;
import org.banque.gestion.entities.Employe;
import org.banque.gestion.entities.Groupe;
import org.banque.gestion.entities.Operation;

public class BanqueDaoImpl implements IBanqueDao {
@PersistenceContext
private EntityManager em;
	@Override
	public Client addClient(Client c) {
		em.persist(c);
		return c;
	}

	@Override
	public Employe addEmpolye(Employe e, Long codeSup) {
		if(codeSup!=null){
			Employe sup=em.find(Employe.class, codeSup);
			e.setEmployeSup(sup);
		}
		em.persist(e);
		return e;
	}

	@Override
	public Groupe addGroupe(Groupe g) {
		em.persist(g);
		return g;
	}

	@Override
	public void addEmployeToGroupe(Long codeEmp, Long codeGr) {
		Employe e = em.find(Employe.class,codeEmp);
		Groupe  g = em.find(Groupe.class,codeGr);
		e.getGroupes().add(g);
		g.getEmployes().add(e);
	}

	@Override
	public Compte addCompte(Compte cp, Long codeCli, Long codeEmp) {
		Client cli=em.find(Client.class, codeCli);
		Employe emp=em.find(Employe.class, codeEmp);
		cp.setClient(cli);
		cp.setEmploye(emp);
		em.persist(cp);
		return cp;
	}

	@Override
	public Operation addOperation(Operation op, String codeCpte, Long codeEmp) {
		Compte cpte = em.find(Compte.class, codeCpte);
		Employe emp = em.find(Employe.class, codeEmp);
		op.setCompte(cpte);
		op.setEmploye(emp);
		em.persist(op);
		return op;
	}

	@Override
	public Compte consulterCompte(String codeCpte) {
		Compte cpte=em.find(Compte.class, codeCpte);
		if(cpte==null) throw new RuntimeException("Compte introuvable!");
		return cpte;
	}

	@Override
	public List<Operation> consulterOperations(String codeCpte) {
		Query req=em.createQuery
		("select o from Operation o where"
				+ " o.compte.codeCompte=:x");
		req.setParameter("x", codeCpte);
		
		return req.getResultList();
	}

	@Override
	public Client consulterClient(Long codeCli) {
		Client cli=em.find(Client.class, codeCli);
		if(cli==null) throw new RuntimeException("Client introuvable!");
		return cli;
	}

	@Override
	public List<Client> consulterClients(String mc) {
		Query req=em.createQuery("select c from Client c where c.nomClient like :x");
		req.setParameter("x","%"+ mc+"%");
		
		return req.getResultList();
	}

	@Override
	public List<Compte> getComptesByClient(Long codeCli) {
		Query req=em.createQuery("select c from Compte c where c.client.codeClient= :x");
		req.setParameter("x",codeCli);
		
		return req.getResultList();
	}

	@Override
	public List<Compte> getComptesByEmploye(Long codeEmp) {
		Query req=em.createQuery("select c from Compte c where c.employe.codeEmploye= :x");
		req.setParameter("x",codeEmp);
		
		return req.getResultList();
	}

	@Override
	public List<Employe> getEmployes() {
		Query req=em.createQuery("select e from Employe e");	
		return req.getResultList();
	}

	@Override
	public List<Groupe> getGroupes() {
		Query req=em.createQuery("select g from Groupe g");	
		return req.getResultList();
	}

	@Override
	public List<Employe> getEmployeByGroupe(Long codeGr) {
		/*Query req=em.createQuery("select e from Employe e fetch all properties where e.codeGroupe= :x");
		req.setParameter("x",codeGr);
		return req.getResultList();*/
		
	 Query req = 
em.createQuery("select e from Employe e "
		+ "JOIN e.groupes g where g.codeGroupe= :x");
	                        		
	        req.setParameter("x", codeGr);
	        return req.getResultList();
	    }

	@Override
	public Employe find(String username, String password) {
		Query req=em.createQuery
("select e from Employe e where e.username like :x and e.password like :y");
		req.setParameter("x",username);
		req.setParameter("y",password);
		Employe e= (Employe)req.getSingleResult();
		return e;
	}

	@Override
	public List<Compte> getAllCompte() {
		
		Query req=em.createQuery("select c from Compte c");	
		return req.getResultList();
	}

}
