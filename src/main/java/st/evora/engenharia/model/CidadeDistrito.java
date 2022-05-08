package st.evora.engenharia.model;

import st.evora.engenharia.enums.Cidade;
import st.evora.engenharia.enums.Distrito;

public class CidadeDistrito {
	private String nome;
	private Cidade cidade;
	private Distrito distrito;
	
	public CidadeDistrito() {
	}
	
	public CidadeDistrito(String nome, Cidade cidade, Distrito distrito) {
		super();
		this.nome = nome;
		this.cidade = cidade;
		this.distrito = distrito;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public Distrito getDistrito() {
		return distrito;
	}
	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	@Override
	public String toString() {
		return "CidaddeDistrito [nome=" + nome + ", cidade=" + cidade + ", distrito=" + distrito + "]";
	}
}
