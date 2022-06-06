package org.banque.gestion.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="V")
public class Versement  extends Operation implements Serializable{
	
private double taux_vers;
	public Versement() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Versement(Date dateOperation, double montant, double taux_vers) {
		super(dateOperation, montant);
		this.taux_vers = taux_vers;
	}


	public Versement(Date dateOperation, double montant) {
		super(dateOperation, montant);
		// TODO Auto-generated constructor stub
	}


	public double getTaux_vers() {
		return taux_vers;
	}


	public void setTaux_vers(double taux_vers) {
		this.taux_vers = taux_vers;
	}
	
	

}
