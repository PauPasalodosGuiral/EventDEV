package com.azahartech.eventdev.datos;

import javax.swing.*;
import java.util.ArrayList;

public class RepositorioGenerico<T> {
    private ArrayList<T> elementos = new ArrayList<>();

    public void guardar(T elemento) {
        elementos.add(elemento);
    }
    public ArrayList<T> listar() {
        return elementos;
    }
    public void eliminar(T elemento){
        elementos.remove(elemento);
    }
    public T obtener(int indice) {
        return elementos.get(indice);
    }
    public int tamaño() {
        return elementos.size();
    }
}
