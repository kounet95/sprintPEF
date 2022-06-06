package org.banque.gestion.dao;

import java.util.List;


import org.banque.gestion.entities.Client;
import org.banque.gestion.entities.Compte;
import org.banque.gestion.entities.Employe;
import org.banque.gestion.entities.Groupe;
import org.banque.gestion.entities.Operation;

public interface IBanqueDao {

public Client addClient(Client c);
public Employe addEmpolye(Employe e,Long codeSup);
public Groupe addGroupe(Groupe g);
public void addEmployeToGroupe(Long codeEmp,Long codeGr);
public Compte addCompte(Compte cp,Long codeCli,Long codeEmp);
public Operation addOperation(Operation op, String codeCpte,Long codeEmp);


public Compte consulterCompte(String codeCpte);
public List<Operation> consulterOperations(String codeCpte);
public Client consulterClient(Long codeCli);
public List<Client> consulterClients(String mc);
public List<Compte> getComptesByClient(Long codeCli);
public List<Compte> getComptesByEmploye(Long codeEmp);
public List<Employe> getEmployes();
public List<Groupe> getGroupes();
public List<Employe> getEmployeByGroupe(Long codeGr);
public Employe find(String username, String password);
public List<Compte> getAllCompte();


}
