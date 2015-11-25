package pacote;

import java.util.ArrayList;

public class AFDMinimizado 
{
	private ArrayList<ConjuntoEstado> R = new ArrayList<ConjuntoEstado>();
	private ArrayList<ConjuntoEstado> S = new ArrayList<ConjuntoEstado>();
	
	private ConjuntoEstado conjuntoC = new ConjuntoEstado();
	private ConjuntoEstado conjuntoY = new ConjuntoEstado();
	private ConjuntoEstado conjuntoX = new ConjuntoEstado();
	
	private Estado e,d;
	
	private AFD afd;
	
	public AFDMinimizado(AFD afd)
	{
		this.afd = afd;
	}
	
	public void minimizaEstados()
	{
		boolean controle = true;
		this.R.add(menosLista(afd.getConjuntoEstado(), afd.getConjuntoEstadoFinal()));
		this.R.add(afd.getConjuntoEstadoFinal());
		
		do
		{
			this.S = this.R; 
			this.R = new ArrayList<ConjuntoEstado>();
			for (ConjuntoEstado c : this.S) 
			{
				do
				{
					controle = true;
					this.conjuntoY = new ConjuntoEstado();
					this.e = c.getConjuntoEstado().get(0);
					this.conjuntoY.getConjuntoEstado().add(this.e);
					for (Estado d : menosLista(c, this.conjuntoY).getConjuntoEstado()) 
					{
						for (int i = 0; i < e.getTransicoes().length; i++) 
						{
							if(d.getTransicoes()[i].equals(e.getTransicoes()[i]))controle = false;
						}
						if(controle)this.conjuntoY.getConjuntoEstado().add(d);
					}
					
					c = menosLista(c, this.conjuntoY);
					this.R.add(this.conjuntoY);
					System.out.println(c.getConjuntoEstado().size() + " " + this.conjuntoY.getConjuntoEstado().size());
				}while(c.getConjuntoEstado().size() > 0);
				
			}
		}while(R.equals(S));
		for(int i = 0; i < S.size(); i++)
			System.out.println(this.S.get(i));
	}
	
	public ConjuntoEstado menosLista(ConjuntoEstado a1, ConjuntoEstado a2)
	{
		ConjuntoEstado temp = new ConjuntoEstado();
		for(int i = 0; i < a1.getConjuntoEstado().size(); i++)
			for(int j = 0; j < a2.getConjuntoEstado().size(); j++)
				if(!a1.getConjuntoEstado().get(i).equals(a2.getConjuntoEstado().get(j)))
					temp.getConjuntoEstado().add(a1.getConjuntoEstado().get(i));
		return temp;
	}
}
