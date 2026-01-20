package com.azahartech.eventdev.servicio;

import com.azahartech.eventdev.datos.RepositorioGenerico;
import com.azahartech.eventdev.modelo.Usuario;

import java.util.ArrayList;
import java.util.HashMap;

public class ServicioUsuario {
    //private ArrayList<Usuario> listaUsuarios;
    private RepositorioGenerico<Usuario> repositorio = new RepositorioGenerico<>();
    private HashMap<String, Usuario> mapaUsuarios;

    public ServicioUsuario() {
        this.mapaUsuarios = new HashMap<>();
    }

    public void registrarUsuario(Usuario usuario) {
        if (mapaUsuarios.containsKey(usuario.getEmail())){
            System.err.println("ERROR: ESTE EMAIL YA SE ESTA USANDO EN OTRO USUARIO");
        } else {
            mapaUsuarios.put(usuario.getEmail(), usuario);
        }
    }
    public Usuario buscarUsuarioPorEmail(String email) {
        return this.mapaUsuarios.get(email);
    }
    public Usuario buscarUsuarioPorNombre(String nombre) {
            return mapaUsuarios.values()
                    .stream()
                    .filter(u -> u.getNombreUsuario().equals(nombre))
                    .findFirst()
                    .orElse(null);
    }

    public void imprimirNombresUsuariosVip() {
        repositorio.listar()
                .stream().filter(usuario -> usuario.getEsVip() == true)
                .map(usuario -> usuario.getNombreUsuario())
                .forEach(nombre -> System.out.println(nombre));
    }
}
