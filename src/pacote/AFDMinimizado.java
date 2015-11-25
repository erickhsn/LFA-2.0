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
					//System.out.println("tste "+c.getConjuntoEstado().get(0).getTransicoes());
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
					//System.out.println(c.getConjuntoEstado().size());
				}while(c.getConjuntoEstado().size() > 0);
				//System.out.println("auiq");
			}
		
		}while(R.equals(S));
		System.out.println(R.equals(S));
		for (int i = 0; i < R.size(); i++) {
			System.out.println(R.get(i));
			for (int j = 0; j < R.get(i).getConjuntoEstado().size(); j++) {
				System.out.println(R.get(i).getConjuntoEstado().get(j).getNomeDoEstado());
			}
		}
	}
	
	public ConjuntoEstado menosLista(ConjuntoEstado a1, ConjuntoEstado a2)
	{
		ConjuntoEstado temp = new ConjuntoEstado();
		boolean control = true;
		
		for (int i = 0; i < a1.getConjuntoEstado().size(); i++, control = true) 
		{
			for (int j = 0; j < a2.getConjuntoEstado().size(); j++) 
			{
				if(a1.getConjuntoEstado().get(i).getNomeDoEstado().equals(a2.getConjuntoEstado().get(j).getNomeDoEstado()))
					control = false;
			}
			if(control == true)
				temp.getConjuntoEstado().add(a1.getConjuntoEstado().get(i));
		}
		
		//System.out.println("TEmp"+temp.getConjuntoEstado().size());
		/*for(int i = 0; i < a1.getConjuntoEstado().size(); i++)
			for(int j = 0; j < a2.getConjuntoEstado().size(); j++)
			{
				if(!a1.getConjuntoEstado().get(i).getNomeDoEstado().equals(a2.getConjuntoEstado().get(j).getNomeDoEstado()))
					temp.getConjuntoEstado().add(a1.getConjuntoEstado().get(i));
				System.out.println("I: " + i + " J: " + j);
			}
		*/
		return temp;
	}
}
