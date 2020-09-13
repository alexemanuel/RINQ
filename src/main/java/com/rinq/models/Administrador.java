package com.rinq.models;

import javax.persistence.Entity;

@Entity
public class Administrador extends Usuario{

	public Administrador() {}
	
	public Administrador(DataTransferObject OTD) {
		super(OTD);
	}

}
