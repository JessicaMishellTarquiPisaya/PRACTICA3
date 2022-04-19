package com.emergentes.modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class GestorCategorias {
    private ArrayList<Categorias> lista;
    
    public GestorCategorias()
    {
        lista = new ArrayList<Categorias>();
    }
    
    public ArrayList<Categorias> getLista(){
        return lista;
    }
    
    public void setLista(ArrayList<Categorias>Lista){
        this.lista = lista;
    }
    
   public void insertarCategorias(Categorias item)
   {
        lista.add(item);
   }
   
   public void modificarCategorias(int pos, Categorias item)
   {
       lista.set(pos,item);
   }
   
   public void eliminarCategorias(int pos)
   {
       lista.remove(pos);
   }
   
   public int obtieneId()
   {
       int idaux = 0;
       
       for (Categorias item : lista){
           idaux = item.getId();
       }
       return idaux + 1;
   }
   
   public int ubicarCategorias(int id)
   {
       int pos = -1;
       Iterator<Categorias> it = lista.iterator();
       
       while ( it.hasNext()){
       ++pos;
       Categorias aux = it.next();
       
            if(aux.getId() == id){
                break;
            }
        }
        return pos;
    }
}
