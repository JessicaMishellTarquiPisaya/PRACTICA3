package com.emergentes.modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class GestorLibros {
    private ArrayList<Libros> lista;
    
    public GestorLibros()
    {
        lista = new ArrayList<Libros>();
    }
    
    public ArrayList<Libros> getLista(){
        return lista;
    }
    
    public void setLista(ArrayList<Libros>Lista){
        this.lista = lista;
    }
    
   public void insertarLibros(Libros item)
   {
        lista.add(item);
   }
   
   public void modificarLibros(int pos, Libros item)
   {
       lista.set(pos,item);
   }
   
   public void eliminarLibros(int pos)
   {
       lista.remove(pos);
   }
   
   public int obtieneId()
   {
       int idaux = 0;
       
       for (Libros item : lista){
           idaux = item.getId();
       }
       return idaux + 1;
   }
   
   public int ubicarLibros(int id)
   {
       int pos = -1;
       Iterator<Libros> it = lista.iterator();
       
       while ( it.hasNext()){
       ++pos;
       Libros aux = it.next();
       
            if(aux.getId() == id){
                break;
            }
        }
        return pos;
    }
}
