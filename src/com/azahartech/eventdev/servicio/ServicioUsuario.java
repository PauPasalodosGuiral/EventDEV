package com.azahartech.eventdev.servicio;

import com.azahartech.eventdev.modelo.Usuario;

import java.util.ArrayList;

public class ServicioUsuario {
    private ArrayList<Usuario> listaUsuarios;

    public ServicioUsuario() {
        this.listaUsuarios =new ArrayList<>();
    }

    public void registrarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }
    public Usuario buscarUsuarioPorEmail(String email) {
        Usuario usuarioTemporal = new Usuario(null,null,null);
        boolean validacion = false;
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getEmail().equals(email)) {
                usuario = usuarioTemporal;
            }
        }
        if (validacion) {
            return usuarioTemporal;
        } else {
            return null;
        }
    }
}
