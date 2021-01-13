package anto;

import java.io.*;
public class GestioneFile {
	private String testo;
	private String percorso;
	private File fp;
	private char modo;
	private FileWriter fw;
	private BufferedWriter fbw;
	private FileReader fr;
	private BufferedReader fbr;
	
	public GestioneFile(String path, char mode)
	{
		this.percorso = path;
		this.modo = mode;
		this.fp = new File(this.percorso);
		try
		{
			if (this.modo == 'w')
			{
				this.fp.createNewFile();
				this.fw = new FileWriter(this.fp);
				this.fbw = new BufferedWriter(this.fw);
			}
			
			else if (this.modo == 'a')
			{
				this.fp.createNewFile();
				this.fw = new FileWriter(this.fp, true);
				this.fbw = new BufferedWriter(this.fw);
			}
			
			else
			{
				this.fr = new FileReader(this.fp);
				this.fbr = new BufferedReader(this.fr);
			}
		}
		catch(IOException eeeeee)
		{
			return;
		}
	}
	
	
	
	public void Scrivi(String text)
	{
		this.testo = text;
		try
		{
			this.fbw.write(this.testo);
		}
		catch(IOException eeeeee)
		{
			return;
		}
	}
	
	
	
	
	public String Leggi()
	{
		try
		{
			this.testo = this.fbr.readLine();
			
		}
		catch(IOException eeeeee)
		{
			return "error";
		}
		return this.testo;
	}
	
	
	public void LeggiStampa()
	{
		String verify;
		try
		{
			while (true)
			{
				verify = this.testo = this.fbr.readLine();
				if (verify == null)
				{
					break;
				}
				System.out.println(verify);
			}
			
		}
		catch(IOException eeeeee)
		{
			return;
		}
	}

	
	public void Chiudi()
	{
		try
		{
			if (this.modo == 'r')
			{
				this.fbr.close();
			}
			else
			{
				this.fbw.close();
			}
		}
		catch(IOException eeeeee)
		{
			return;
		}	
	}

}
