package pacote;

import java.util.ArrayList;

public class Estados 
{
	private ArrayList<String> estados = new ArrayList<String>();
	
	public Estados(ArrayList<String> estados)
	{
		this.estados = estados;
	}

	public ArrayList<String> getEstados() {
		return estados;
	}

	public void setEstados(ArrayList<String> estados) {
		this.estados = estados;
	}
}
