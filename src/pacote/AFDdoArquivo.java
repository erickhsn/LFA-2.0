package pacote;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AFDdoArquivo 
{
	private ArrayList<Estado> estado = new ArrayList<Estado>();
	private ArrayList<String> alfabeto = new ArrayList<String>();
	//private ArrayList<String[]> transicoes = new ArrayList<String[]>();
	private ArrayList<Estado> estadoInicial = new ArrayList<Estado>();
	private ArrayList<Estado> estadoFinal = new ArrayList<Estado>();
	
	private FileInputStream stream;
	private InputStreamReader reader;
	private BufferedReader br;
	
	private boolean controle = false;
	
	public AFDdoArquivo(String caminho)throws IOException
	{	
		int i = 0;
		stream = new FileInputStream(caminho);
		reader = new InputStreamReader(stream);
		br = new BufferedReader(reader);
		
		String linha;
		
		linhaEstados(br.readLine());
		linhaAlfabeto(br.readLine());
		linha = br.readLine();
		if(linha == " ")linha = br.readLine();
		while(linha != " ")
		{
			this.estado.get(i).setTransicoes(linhaTransicoes(linha));
			linha = br.readLine();
			i++;
			if(this.controle)break;
		}
		//linha = br.readLine();
		if(linha.equals(" "))linha = br.readLine();
		linhaEstadoInicial(linha);
		
		for(i = 0; i < this.estado.size(); i++)
			for(int j = 0; j < this.estadoInicial.size(); j++)
				if(this.estado.get(i).getNomeDoEstado().equals(this.estadoInicial.get(j)))
				{
						this.estado.get(i).seteInicial(true);
						this.estadoInicial.get(j).setTransicoes(this.estado.get(i).getTransicoes());
				}
		
		
		linhaEstadoFinal(br.readLine());
		
		for(i = 0; i < this.estado.size(); i++)
		{
			for(int j = 0; j < this.estadoFinal.size(); j++)
			{
				if(this.estado.get(i).getNomeDoEstado().equals(this.estadoFinal.get(j).getNomeDoEstado()))
				{
						this.estado.get(i).seteFinal(true);
						this.estadoFinal.get(j).setTransicoes(this.estado.get(i).getTransicoes());
				}
			}
		}
		//System.out.println(this.estadoFinal.toString());
	
	}
	
	private void linhaEstados(String linha)
	{
		String[] linhaSplit;
		linhaSplit = linha.split(" ");
		for(int i = 0; i < linha.length(); i++)
		{
			if(linhaSplit[i].equals(";") || linhaSplit[i].equals(","))
			{
				break;
			}
			this.estado.add(new Estado(linhaSplit[i]));
		}
	}
	
	private void linhaAlfabeto(String linha)
	{
		String[] linhaSplit;
		linhaSplit = linha.split(" ");
		for(int i = 0; i < linha.length(); i++)
		{
			if(linhaSplit[i].equals(";") || linhaSplit[i].equals(","))
			{
				break;
			}
			this.alfabeto.add(linhaSplit[i]);
		}
	}
	
	private String[] linhaTransicoes(String linha)
	{
		String[] linhaSplit;
		String[] s = new String[2];
		linhaSplit = linha.split(" ");
		s[0] = linhaSplit[0];
		s[1] = linhaSplit[1];
	
		if(linhaSplit[2].equals(";"))
			this.controle = true;
		return s;
	}
	
	private void linhaEstadoInicial(String linha)
	{
		String[] linhaSplit;
		linhaSplit = linha.split(" ");
		for(int i = 0; i < linha.length(); i++)
		{
			if(linhaSplit[i].equals(";") || linhaSplit[i].equals(","))
			{
				break;
			}
			this.estadoInicial.add(new Estado(linhaSplit[i],true));
		}
	}
	
	private void linhaEstadoFinal(String linha)
	{
		String[] linhaSplit;
		linhaSplit = linha.split(" ");
		for(int i = 0; i < linha.length(); i++)
		{
			if(linhaSplit[i].equals(";") || linhaSplit[i].equals(","))
			{
				break;
			}
			this.estadoFinal.add(new Estado(true, linhaSplit[i]));
		}
	}
	
	public ArrayList<String> getAlfabeto() {
		return alfabeto;
	}

	public void setAlfabeto(ArrayList<String> alfabeto) {
		this.alfabeto = alfabeto;
	}


	public ArrayList<Estado> getEstado() {
		return estado;
	}

	public void setEstado(ArrayList<Estado> estado) {
		this.estado = estado;
	}

	public FileInputStream getStream() {
		return stream;
	}

	public void setStream(FileInputStream stream) {
		this.stream = stream;
	}

	public InputStreamReader getReader() {
		return reader;
	}

	public void setReader(InputStreamReader reader) {
		this.reader = reader;
	}

	public BufferedReader getBr() {
		return br;
	}

	public void setBr(BufferedReader br) {
		this.br = br;
	}

	public boolean isControle() {
		return controle;
	}

	public void setControle(boolean controle) {
		this.controle = controle;
	}

	public ArrayList<Estado> getEstadoInicial() {
		return estadoInicial;
	}

	public void setEstadoInicial(ArrayList<Estado> estadoInicial) {
		this.estadoInicial = estadoInicial;
	}

	public ArrayList<Estado> getEstadoFinal() {
		return estadoFinal;
	}

	public void setEstadoFinal(ArrayList<Estado> estadoFinal) {
		this.estadoFinal = estadoFinal;
	}

	
}

