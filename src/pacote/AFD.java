package pacote;

public class AFD 
{
	private ConjuntoEstado conjuntoEstado = new ConjuntoEstado();
	private ConjuntoEstado conjuntoEstadoFinal = new ConjuntoEstado();
	private ConjuntoEstado conjuntoEstadoInicial = new ConjuntoEstado();
	public AFD(AFDdoArquivo afdDoArquivo)
	{
		for(int i = 0; i < afdDoArquivo.getEstado().size(); i++)
			this.conjuntoEstado.getConjuntoEstado().add(afdDoArquivo.getEstado().get(i));
		
		for(int i = 0; i < afdDoArquivo.getEstadoFinal().size(); i++)
			this.conjuntoEstadoFinal.getConjuntoEstado().add(afdDoArquivo.getEstadoFinal().get(i));
		
		for(int i = 0; i < afdDoArquivo.getEstadoInicial().size(); i++)
			this.conjuntoEstadoInicial.getConjuntoEstado().add(afdDoArquivo.getEstadoInicial().get(i));
	}
	public ConjuntoEstado getConjuntoEstado() {
		return conjuntoEstado;
	}
	public void setConjuntoEstado(ConjuntoEstado conjuntoEstado) {
		this.conjuntoEstado = conjuntoEstado;
	}
	public ConjuntoEstado getConjuntoEstadoFinal() {
		return conjuntoEstadoFinal;
	}
	public void setConjuntoEstadoFinal(ConjuntoEstado conjuntoEstadoFinal) {
		this.conjuntoEstadoFinal = conjuntoEstadoFinal;
	}
	public ConjuntoEstado getConjuntoEstadoInicial() {
		return conjuntoEstadoInicial;
	}
	public void setConjuntoEstadoInicial(ConjuntoEstado conjuntoEstadoInicial) {
		this.conjuntoEstadoInicial = conjuntoEstadoInicial;
	}

}
