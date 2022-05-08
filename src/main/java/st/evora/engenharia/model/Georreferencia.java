package st.evora.engenharia.model;

import st.evora.engenharia.enums.Localizacao;

public class Georreferencia {

	private String nome;
	private Localizacao localizacao;
	
	public Georreferencia() {
	}

	public Georreferencia(String nome, Localizacao localizacao) {
		super();
		this.nome = nome;
		this.localizacao = localizacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}
}
