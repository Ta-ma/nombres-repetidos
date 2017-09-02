package nombresRepetidos;

public class Nodo
{
	private String nombre;
	private int cant;
	
	public Nodo (String str, int num)
	{
		this.nombre = str;
		this.cant = num;
	}
	
	@Override
	public String toString()
	{
		return "Nodo [nombre=" + nombre + ", cant=" + cant + "]";
	}

	public String getNombre()
	{
		return nombre;
	}
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	public int getCant()
	{
		return cant;
	}
	public void setCant(int cant)
	{
		this.cant = cant;
	}
	
}
