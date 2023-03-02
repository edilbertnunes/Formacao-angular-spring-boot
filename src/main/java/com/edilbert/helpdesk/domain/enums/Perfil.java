package com.edilbert.helpdesk.domain.enums;

public enum Perfil {
	ADMIN(0,"ROLE_ADMIN"), 
	CLIENTE(1,"ROLE_CLIENTE"), 
	TECNICO (2, "ROLE_TECNICO");
	
	private Integer codigo;
	private String descircao;
	
	private Perfil(Integer codigo, String descircao) {
		this.codigo = codigo;
		this.descircao = descircao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescircao() {
		return descircao;
	}
	
	public static Perfil toEnum (Integer cod) {
		if(cod == null) {
			return null;
		}
		for (Perfil x : Perfil.values()) {
			if(cod.equals(x.getCodigo())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Perfil inválido");
	}

}
