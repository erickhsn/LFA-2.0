package pacote;

import java.io.IOException;

import javax.annotation.processing.FilerException;

public class Principal {
	

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		try
		{
			AFDdoArquivo afdDoArquivo = new AFDdoArquivo("Arquivos/entrada2.txt");
			AFD afd = new AFD(afdDoArquivo);
			AFDMinimizado afdmin = new AFDMinimizado(afd);
			afdmin.minimizaEstados();
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}

}
