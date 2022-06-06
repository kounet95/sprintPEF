package org.banque.gestion.metier;

import java.util.Date;
import java.util.List;

import org.banque.gestion.entities.Client;
import org.banque.gestion.entities.Compte;
import org.banque.gestion.entities.Employe;
import org.banque.gestion.entities.Groupe;
import org.banque.gestion.entities.Operation;
import org.banque.gestion.entities.Retrait;
import org.banque.gestion.entities.Versement;
import org.banque.gestion.springmvcsecurity.dao.IBanqueDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class BanqueMetierImpl implements IBanqueMetier {

	private IBanqueDao dao;


	public void setDao(IBanqueDao dao) {
	this.dao = dao;
}

	@Override
	public Client addClient(Client c) {
		return dao.addClient(c);
		
	}

	@Override
	public Employe addEmpolye(Employe e, Long codeSup) {
		// TODO Auto-generated method stub
		return dao.addEmpolye(e, codeSup);
	}

	@Override
	public Groupe addGroupe(Groupe g) {
		// TODO Auto-generated method stub
		return dao.addGroupe(g);
	}

	@Override
	public void addEmployeToGroupe(Long codeEmp, Long codeGr) {
		dao.addEmployeToGroupe(codeEmp, codeGr);
		
	}

	@Override
	public Compte addCompte(Compte cp, Long codeCli, Long codeEmp) {
		// TODO Auto-generated method stub
		return dao.addCompte(cp, codeCli, codeEmp);
	}

	@Override
	public void verser(double mt, String codeCpte, Long codeEmp) {
		dao.addOperation(new Versement(new Date(),mt), codeCpte, codeEmp);
		Compte cp = dao.consulterCompte(codeCpte);
		cp.setSolde(cp.getSolde()+mt);
		
	}

	@Override
	public void retirer(double mt, String codeCpte, Long codeEmp) {
		dao.addOperation(new Retrait(new Date(),mt), codeCpte, codeEmp);
		Compte cp = dao.consulterCompte(codeCpte);
		cp.setSolde(cp.getSolde()-mt);
		
	}

	@Override
	public void virement(double mt, String cpte1, String cpte2, Long codeEmp) {
		retirer(mt,cpte1,codeEmp);
		verser(mt,cpte2,codeEmp);
		
	}

	@Override
	public Compte consulterCompte(String codeCpte) {
		// TODO Auto-generated method stub
		return dao.consulterCompte(codeCpte);
	}

	@Override
	public List<Operation> consulterOperations(String codeCpte) {
		// TODO Auto-generated method stub
		return dao.consulterOperations(codeCpte);
	}

	@Override
	public Client consulterClient(Long codeCli) {
		// TODO Auto-generated method stub
		return dao.consulterClient(codeCli);
	}

	@Override
	public List<Client> consulterClients(String mc) {
		// TODO Auto-generated method stub
		return dao.consulterClients(mc);
	}

	@Override
	public List<Compte> getComptesByClient(Long codeCli) {
		// TODO Auto-generated method stub
		return dao.getComptesByClient(codeCli);
	}

	@Override
	public List<Compte> getComptesByEmploye(Long codeEmp) {
		// TODO Auto-generated method stub
		return dao.getComptesByEmploye(codeEmp);
	}

	@Override
	public List<Employe> getEmployes() {
		// TODO Auto-generated method stub
		return dao.getEmployes();
	}

	@Override
	public List<Groupe> getGroupes() {
		// TODO Auto-generated method stub
		return dao.getGroupes();
	}

	@Override
	public List<Employe> getEmployeByGroupe(Long codeGr) {
		// TODO Auto-generated method stub
		return dao.getEmployeByGroupe(codeGr);
	}

	@Override
	public Employe find(String username, String password) {
		// TODO Auto-generated method stub
		return dao.find(username, password);
	}

	@Override
	public List<Compte> getAllCompte() {
		return dao.getAllCompte();
	}

}
