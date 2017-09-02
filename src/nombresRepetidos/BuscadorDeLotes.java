package nombresRepetidos;

import java.io.File;
import java.io.FilenameFilter;

public class BuscadorDeLotes
{
	private String directorio;
	
	public BuscadorDeLotes (String dir)
	{
		this.directorio = dir;
	}
	
	public File[] buscarLotes()
	{
		File dir = new File(directorio);
		
		return dir.listFiles(new FilenameFilter()
		{
			public boolean accept(File dir, String nombreArchivo)
			{
				return nombreArchivo.endsWith(".in");
			}
		});
	}
}