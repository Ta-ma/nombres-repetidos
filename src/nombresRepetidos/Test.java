package nombresRepetidos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Test
{

	public static void main(String[] args) throws IOException
	{
		long inicio = System.currentTimeMillis();
		BuscadorDeLotes buscador = new BuscadorDeLotes(".\\IN\\");
		File[] archivos = buscador.buscarLotes();
		
		for (File archivo : archivos)
		{
			PrintWriter salida = new PrintWriter(new FileWriter(".\\OUT\\" + archivo.getName().replaceFirst("[.][^.]+$", ".out")));
			ProcesadorDeNombres procesador = new ProcesadorDeNombres(archivo);
			Nodo[] nodos = procesador.obtenerMax();
			
			salida.println("Lote: " + archivo.getName());
			for (Nodo nodo : nodos)
				salida.println(nodo);
			salida.close();
		}
		
		/*PrintWriter salida = new PrintWriter(new FileWriter(".\\OUT\\stress.in"));
		salida.println("400000 600");
		for (int i = 0; i < 400000; i++)
		{
			salida.println("Nombre " + i);
		}
		salida.close();*/
		
		long fin = System.currentTimeMillis();
		System.out.println((fin - inicio) + " ms");
	}

}
