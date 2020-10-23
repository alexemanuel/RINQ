package com.rinq.models;

import javax.persistence.Entity;

import com.rinq.service.DTO.CadastroDTO;

@Entity
public class Administrador extends Usuario{
	
	private static final long serialVersionUID = 1L;

	private String siape;
	
	public Administrador() {}
	
	public Administrador(CadastroDTO DTO) {
		super(DTO);
		this.siape = DTO.getSiape();
	}

	public String getSiape() {
		return siape;
	}

	public void setSiape(String siape) {
		this.siape = siape;
	}
}
