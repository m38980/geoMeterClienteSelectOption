package st.evora.engenharia.enums;

public enum Energia {
	
	SELECIONE ("SELECIONE"),
	PÓS_PAGO ("PÓS-PAGO"),
	PRÉ_PAGO ("PRÉ-PAGO");
	
	private String descricao;

	private Energia() {
	}

	private Energia(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
