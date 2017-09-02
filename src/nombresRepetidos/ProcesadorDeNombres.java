package nombresRepetidos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProcesadorDeNombres
{
	private TreeMap<String, Integer> arbol;
	private int numDeNombres;

	public ProcesadorDeNombres(File archivo) throws FileNotFoundException
	{
		Scanner sc = new Scanner(archivo);
		sc.useLocale(Locale.ENGLISH);

		int cant = sc.nextInt();
		numDeNombres = sc.nextInt();
		arbol = new TreeMap<String, Integer>();

		// cargar arbol
		sc.nextLine();
		for (int i = 0; i < cant; i++)
		{
			String nombre = sc.nextLine();
			if (arbol.containsKey(nombre))
				arbol.put(nombre, ((Integer) arbol.get(nombre)).intValue() + 1);
			else
				arbol.put(nombre, new Integer(1));
		}
		sc.close();
	}

	public Nodo[] obtenerMax()
	{
		Nodo[] arregloNodos = new Nodo[numDeNombres];
		
		for (int i = 0; i < numDeNombres; i++)
		{
			Map.Entry<String, Integer> maxEntry = null;
			for (Map.Entry<String, Integer> entry : arbol.entrySet())
			{
				if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
					maxEntry = entry;
			}
			
			if (maxEntry != null)
			{
				arregloNodos[i] = new Nodo(maxEntry.getKey(), maxEntry.getValue());
				arbol.remove(maxEntry.getKey());
			}
		}
		
		return arregloNodos;
	}

}
