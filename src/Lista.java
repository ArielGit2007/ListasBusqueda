import java.util.ArrayList;
import java.util.List;
public class Lista {
    private List<Libro> libros;

    public Lista(){
        libros=new ArrayList<>();
    }

    /*public void agregarDatos(Libro dato) throws Exception {
        if(libros.isEmpty())
            libros.add(dato);
        else{
            if(dato.getCodigo()> libros.getLast().getCodigo())
                libros.add(dato);
            else
                throw new Exception("Datos no ordenados o duplicados");
        }
    }*/

    public void agregarDatos(Libro dato) throws Exception {
        if(unico(dato)) {
            libros.add(dato);
            ordenar();
        }else
            throw new Exception("No es unico");

    }

    public void ordenar(){
        Libro aux;
        for(int i=0; i<libros.size()-1;i++){
            for(int j= i+1;j<libros.size();j++){
                if(libros.get(i).getCodigo()>libros.get(j).getCodigo()){
                    aux=libros.get(i);
                    libros.set(i,libros.get(j));
                    libros.set(j,aux);
                }
            }
        }
    }

    public boolean unico(Libro dato){
        for(Libro aux : libros){
            if (aux.getCodigo()==dato.getCodigo())
                return false;
        }
        return true;
    }
    public ArrayList<Libro> buscar(String texto){
        ArrayList<Libro> resultado=new ArrayList<>();
        for(Libro aux:libros){
            if(aux.getTitulo().contains(texto))
                resultado.add(aux);
        }
        return resultado;
    }

    public Libro binario(int codigo) throws Exception {
        if(libros.isEmpty())
            throw new Exception("Lista vacia");
        /*if(codigo<libros.getFirst().getCodigo()||codigo>libros.getLast().getCodigo())
            throw new Exception("No existe libro con el codigo");*/
        int i=0;
        int s=libros.size()-1;
        while (i<=s){
            int c=(i+s)/2;
            int valor=libros.get(c).getCodigo();
            if(valor==codigo){
                return libros.get(c);
            }
            else if(codigo<valor){
                s=c-1;
            }
            else{
                i=c+1;
            }
        }
        throw new Exception("No existe libro con el codigo");
    }

    public ArrayList<Libro> getLibros(){
        return (ArrayList<Libro>) libros;
    }

}
