package libreria;

public class Libro implements Comparable<Libro>, Cloneable {
	
	private String ISBN;
    private String titulo;
    private String autor;
    private String editorial;
    private int edicion;
    private int anno_de_publicacion;
	

	public Libro() {
		// TODO Auto-generated constructor stub
	}

    @Override
    public boolean equals(Object libro) {
        return this==libro || (libro instanceof Libro && ISBN.equals(((Libro)libro).ISBN));
    }

    @Override
    public int compareTo(Libro libro) {
        return ISBN.compareTo(libro.ISBN);
    }
    
    @Override
    public Object clone() {
    	// TODO Auto-generated method stub
    	Object obj = null;
   
    	try{
            obj=super.clone();
        }catch(CloneNotSupportedException ex){
            ex.printStackTrace();
        }
        return obj;
    }
    
    @Override
    public String toString() {
        return
            "ISBN: " + ISBN + "\n" +
            "Título: " + titulo + "\n" +
            "Autor: " + autor + "\n" +
            "Editorial: " + editorial + "\n" +
            "Edición: " + edicion + "\n" +
            "Año de publicación: " + anno_de_publicacion + "\n";
    }

    public String getISBN() {
        return ISBN;
    }
    
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }
    
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getEdicion() {
        return edicion;
    }
    
    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public int getAnno_de_publicacion() {
        return anno_de_publicacion;
    }
    
    public void setAnno_de_publicacion(int anno_de_publicacion) {
        this.anno_de_publicacion = anno_de_publicacion;
    }

}
