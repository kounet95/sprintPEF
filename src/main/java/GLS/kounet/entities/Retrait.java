package org.banque.gestion.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="R")
public class Retrait extends Operation implements Serializable {
private double taux_ret;

	public Retrait() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Retrait(Date dateOperation, double montant) {
		super(dateOperation, montant);
		// TODO Auto-generated constructor stub
	}

	public Retrait(Date dateOperation, double montant, double taux_ret) {
		super(dateOperation, montant);
		this.taux_ret = taux_ret;
	}

	public double getTaux_ret() {
		return taux_ret;
	}

	public void setTaux_ret(double taux_ret) {
		this.taux_ret = taux_ret;
	}
	
	
	

}
