package com.rinq.models;

import javax.persistence.Entity;

@Entity
public class Administrador extends Usuario{
	
	private static final long serialVersionUID = 1L;

	public Administrador() {}
	
	public Administrador(DataTransferObject DTO) {
		super(DTO);
	}

}
