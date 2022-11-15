package libreria;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class LibreriaManager {
//Definicion de Variables y recursos varios
	public static Scanner teclado = new Scanner(System.in);
	public static PrintStream out = System.out;
	public static String ruta = "libros.tsv";
	public static Vector<Libro> vector = lecturaArchivo();

	public static Funcion<Libro> imprimir=new Funcion<Libro>(){
		@Override 
		public void funcion(Libro libro,Object parametros){
			out.println(libro);
			int[]contador=(int[])parametros;
			contador[0]++;
		}
	};
	
	public static Funcion<Libro> imprimirEnArchivo=new Funcion<Libro>(){
		@Override 
		public void funcion(Libro libro,Object parametros){
			PrintStream archivo=(PrintStream)parametros;
			archivo.print(libro.getISBN()+"\t");
			archivo.print(libro.getTitulo()+"\t");
			archivo.print(libro.getAutor()+"\t");
			archivo.print(libro.getEditorial()+"\t");
			archivo.print(libro.getEdicion()+"\t");
			archivo.print(libro.getAnno_de_publicacion()+"\n");
		}
	};

//Metodos auxiliares
	public static void pausar(String mensage) {
		out.print(mensage + "\nPresione <ENTER> para continuar . . . ");
		teclado.nextLine();
		out.println();
	}

	public static String leer_cadena(String mensaje) {
		out.print(mensaje + ": ");
		return teclado.nextLine();
	}

	public static int leer_entero(String mensaje) {
		try {
			return Integer.parseInt(leer_cadena(mensaje));
		} catch (NumberFormatException e) {
			out.print("N\u00FAmero incorrecto.");
			return leer_entero(mensaje);
		}
	}

	public static Vector<Libro> lecturaArchivo() {
		if (!System.getProperties().get("os.name").equals("Linux") && System.console() != null)
			try {
				out = new PrintStream(System.out, true, "CP850");
				teclado = new Scanner(System.in, "CP850");
			} catch (UnsupportedEncodingException e) {
			}
		
		Vector<Libro> vector = new Vector<Libro>();
		Libro libro;
		String[] campos;
		try {
			Scanner entrada = new Scanner(new FileReader(ruta));
			while (entrada.hasNextLine()) {
				campos = entrada.nextLine().split("\t");
				libro = new Libro();
				libro.setISBN(campos[0]);
				libro.setTitulo(campos[1]);
				libro.setAutor(campos[2]);
				libro.setEditorial(campos[3]);
				libro.setEdicion(Integer.parseInt(campos[4]));
				libro.setAnno_de_publicacion(Integer.parseInt(campos[5]));
				vector.add(libro);
			}
			entrada.close();
		} catch (FileNotFoundException e) {
		} // Lectura
		return vector;
	}

	public static void mostrarMenuPrincipal() {
		out.println("MEN\u00DA");
		out.println("1.- Altas");
		out.println("2.- Consultas");
		out.println("3.- Actualizaciones");
		out.println("4.- Bajas");
		out.println("5.- Ordenar registros");
		out.println("6.- Listar registros");
		out.println("7.- Salir");
	}

	public static void mostrarMenuUpdate() {
		out.println("Men\u00FA de modificaci\u00F3n de campos");
		out.println("1.- titulo");
		out.println("2.- autor");
		out.println("3.- editorial");
		out.println("4.- edicion");
		out.println("5.- anno de publicacion");
	}

	public static Libro darDeAlta(Libro libro) {
		int i = vector.indexOf(libro);
		if (i >= 0)
			return vector.get(i);
			
		vector.add(libro);
		grabarArchivo();
		
		return null;
	}

	public static Libro darDeBaja(Libro libro) {
		int i = vector.indexOf(libro);
		if (i < 0)
			return null;

		Libro libroBorrado = (Libro) (vector.get(i).clone());

		vector.remove(vector.get(i));
		grabarArchivo();

		return libroBorrado;
	}

	public static void modificar(int posLibro, int campoAModif, String txtAct) {
		Libro aActualizar = (Libro)(vector.get(posLibro).clone());
		vector.remove(posLibro);
		
		switch (campoAModif) {
		case 1:
			aActualizar.setTitulo(txtAct);
			break;
		case 2:
			aActualizar.setAutor(txtAct);
			break;
		case 3:
			aActualizar.setEditorial(txtAct);
			break;
		case 4:
			aActualizar.setEdicion(Integer.parseInt(txtAct));
			break;
		case 5:
			aActualizar.setAnno_de_publicacion(Integer.parseInt(txtAct));
			break;
		}
		
		vector.add(posLibro, aActualizar);
		grabarArchivo();
	}
	
	public static void actualizar(Libro dato, Vector<Libro> vector) {
		int subopcion, i;
		i = vector.indexOf(dato);
		vector.remove(i);
		do {
			subopcion = leer_entero("Seleccione un n\u00FAmero de campo a modificar");
			if (subopcion < 1 || subopcion > 5)
				out.println("Opci\u00F3n no v\u00E1lida.");
		} while (subopcion < 1 || subopcion > 5);
		switch (subopcion) {
		case 1:
			dato.setTitulo(leer_cadena("Ingrese el nuevo titulo"));
			break;
		case 2:
			dato.setAutor(leer_cadena("Ingrese el nuevo autor"));
			break;
		case 3:
			dato.setEditorial(leer_cadena("Ingrese el nuevo editorial"));
			break;
		case 4:
			dato.setEdicion(leer_entero("Ingrese el nuevo edicion"));
			break;
		case 5:
			dato.setAnno_de_publicacion(leer_entero("Ingrese el nuevo anno de publicacion"));
			break;
		}
		vector.add(dato);
		out.println("\nRegistro actualizado correctamente.");
	}
	
	public static Libro consultar(Libro libro) {
		int pos = posicionLibro(libro);
		if(pos < 0)
			return null;
			
		return vector.get(pos);	
	}

	public static void ordenarRegistros() {
		Collections.sort(vector);
		grabarArchivo();
	}
	
	public static String listar() {
		String lista="";
		
		int n = vector.size();
		for (int i = 0; i < n; i++) {
			lista += vector.get(i);
			lista += "\n\n";
		}
		
		return lista;
	}

	public static int posicionLibro(Libro libro) {
		return vector.indexOf(libro);
	}
	
	private static void grabarArchivo() {
		try {
			PrintStream salida = new PrintStream(ruta);
			int n = vector.size();
			for (int i = 0; i < n; i++)
				imprimirEnArchivo.funcion(vector.get(i), salida);
			salida.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static int obtenerOpcion() {
		int opcion;
		do {
			opcion = leer_entero("Seleccione una opci\u00F3n");
			if (opcion < 1 || opcion > 7)
				out.println("Opci\u00F3n no v\u00E1lida.");
		} while (opcion < 1 || opcion > 7);
		return opcion;
	}

	public static boolean esArchivoVacio() {
		return vector.isEmpty();
	}

	public static boolean verificarExistenciaRegistro(int opcion, Libro dato) {
		return (opcion == 1 && dato != null);
	}

	public static boolean verificarInexistenciaRegistro(int opcion, Libro dato) {
		return (opcion >= 2 && opcion <= 4 && dato == null);
	}

	public static boolean verificarOpcion(int opcion) {
		return (opcion < 7 && opcion >= 1);
	}

}
