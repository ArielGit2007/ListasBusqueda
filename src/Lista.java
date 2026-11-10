import java.util.ArrayList;
import java.util.List;
public class Lista {
    private List<Libro> libros;

    public Lista(){
        libros=new ArrayList<>();
    }

    public void agregarDatos(Libro dato) throws Exception {
        if(libros.isEmpty())
            libros.add(dato);
        else{
            if(dato.getCodigo()> libros.getLast().getCodigo())
                libros.add(dato);
            else
                throw new Exception("Datos no ordenados o duplicados");
        }
    }
    public ArrayList<Libro> buscar(String texto){
        ArrayList<Libro> resultado=new ArrayList<>();
        for(Libro aux:libros){
            if(aux.getTitulo().contains(texto))
                resultado.add(aux);
        }
        return resultado;
    }

}
