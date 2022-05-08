package st.evora.engenharia.enums;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name = "distrito")
public enum Distrito {
	
	ÁGUA_GRANDE ("ÁGUA GRANDE"),
	MEZÓCHI ("MÉ-ZOCHI"),
	CANTAGALO ("CANTAGALO"),
	LEMBÁ ("LEMBÁ"),
	LOBATA ("LOBATA"),
	CAUÉ ("CAUÉ"),
	PAGUÉ ("PAGUÉ");
	
	private String displayValue;

	private Distrito(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}
	
	/*
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iddistrito;
	
	private String abreviatura;
	private String descricao;
	
	
	public Distrito() {
		super();
	}
	
	
	public Distrito(Long iddistrito, String abreviatura, String descricao) {
		super();
		this.iddistrito = iddistrito;
		this.abreviatura = abreviatura;
		this.descricao = descricao;
	}
	public Long getIddistrito() {
		return iddistrito;
	}
	public void setIddistrito(Long iddistrito) {
		this.iddistrito = iddistrito;
	}
	public String getAbreviatura() {
		return abreviatura;
	}
	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	*/
	
	
}
