package com.edilbert.helpdesk.domain.enums;

public enum Status {
	ABERTO (0,"ABERTO"), 
	ANDAMENTO (1,"ANDAMENTO"), 
	ENCERRADO (2, "ENCERRADO");
	
	private Integer codigo;
	private String descircao;
	
	private Status(Integer codigo, String descircao) {
		this.codigo = codigo;
		this.descircao = descircao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescircao() {
		return descircao;
	}
	
	public static Status toEnum (Integer cod) {
		if(cod == null) {
			return null;
		}
		for (Status x : Status.values()) {
			if(cod.equals(x.getCodigo())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Status inválido");
	}

}
