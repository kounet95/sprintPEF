package org.banque.gestion.entities;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte implements Serializable{
 private double taux;


 public CompteEpargne() {
	super();
	// TODO Auto-generated constructor stub
}

 
 
public CompteEpargne(String codeCompte, Date dateCreation, double solde, double taux) {
	super(codeCompte, dateCreation, solde);
	this.taux = taux;
}



public CompteEpargne(Date dateCreation, double solde, double taux) {
	super( dateCreation, solde);
	this.taux = taux;
}

public double getTaux() {
	return taux;
}

public void setTaux(double taux) {
	this.taux = taux;
}

public CompteEpargne(double taux) {
	super();
	this.taux = taux;
}
 
}
