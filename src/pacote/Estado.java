package pacote;

import java.util.ArrayList;

public class Estado {
	private String nomeDoEstado;
	private String[] transicoes;
	private boolean eInicial;
	private boolean eFinal;
	
	public Estado(String nomeDoEstado)
	{
		this.nomeDoEstado = nomeDoEstado;
	}
	
	public Estado(String nomeDoestado, boolean eInicial)
	{
		this.nomeDoEstado = nomeDoestado;
		this.eInicial = eInicial;
	}
	
	public Estado(boolean eFinal, String nomeDoestado)
	{
		this.nomeDoEstado = nomeDoestado;
		this.eFinal = eFinal;
	}
	
	public String getNomeDoEstado() {
		return nomeDoEstado;
	}
	public void setNomeDoEstado(String nomeDoEstado) {
		this.nomeDoEstado = nomeDoEstado;
	}
	public String[] getTransicoes() {
		return transicoes;
	}
	public void setTransicoes(String[] transicoes) {
		this.transicoes = transicoes;
	}
	public boolean iseInicial() {
		return eInicial;
	}
	public void seteInicial(boolean eInicial) {
		this.eInicial = eInicial;
	}
	public boolean iseFinal() {
		return eFinal;
	}
	public void seteFinal(boolean eFinal) {
		this.eFinal = eFinal;
	}
}
