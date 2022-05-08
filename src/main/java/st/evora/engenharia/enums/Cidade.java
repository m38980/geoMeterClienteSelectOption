package st.evora.engenharia.enums;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name = "cidade")
public enum Cidade {
	
	SÃOTOMÉ ("SÃO TOMÉ"),
	TRINDADE ("TRINDADE"),
	SANTANA ("SANTANA"),
	ANGOLARES ("ANGOLARES"),
	NEVES ("NEVES"),
	SANTO_ANTÓNIO_PRÍNCIPE ("SANTO ANTÓNIO"),
	GUADALUPE ("GUADALUPE");
	
	private final String displayValue;

	private Cidade(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}
	
	/*
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcidade;
	
	private String nome;
	private String descricao;
	
	public Cidade() {
		super();
	}
	
	
	public Cidade(Long idcidade, String nome, String descricao) {
		super();
		this.idcidade = idcidade;
		this.nome = nome;
		this.descricao = descricao;
	}
	public Long getIdcidade() {
		return idcidade;
	}
	public void setIdcidade(Long idcidade) {
		this.idcidade = idcidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	*/
}
