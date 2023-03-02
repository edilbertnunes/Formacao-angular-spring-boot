package com.edilbert.helpdesk.domain.enums;

public enum Prioridade {
	BAIXA (0,"BAIXA"), 
	MEDIA (1,"MEDIA"), 
	ALTA  (2, "ALTA");
	
	private Integer codigo;
	private String descircao;
	
	private Prioridade(Integer codigo, String descircao) {
		this.codigo = codigo;
		this.descircao = descircao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescircao() {
		return descircao;
	}
	
	public static Prioridade toEnum (Integer cod) {
		if(cod == null) {
			return null;
		}
		for (Prioridade x : Prioridade.values()) {
			if(cod.equals(x.getCodigo())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Prioridade inválida");
	}

}
