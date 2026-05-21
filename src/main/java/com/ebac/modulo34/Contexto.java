package com.ebac.modulo34;

import com.ebac.modulo33.MysqlConnection;
import java.sql.Connection;
import java.sql.SQLException;
import com.ebac.modulo34.dto.Usuario;
import com.ebac.modulo34.model.UsuarioModel;

public class Contexto {
    static Connection connection;
    public static void main(String[] args) throws SQLException{
        String url = "jdbc:mysql://localhost:3306/modulo33";
        String user = "root";
        String password = "root";

        MysqlConnection mysqlConnection = new MysqlConnection();
        connection = mysqlConnection.getConnection(url, user, password);

        operacionConUsuarios();

        connection.close();
    }

    public static void operacionConUsuarios() throws SQLException {
        System.out.println("------------------Operación con usuarios------------------");
        Usuario usuarioMaria = crearUsuario("Maria", 25);
        Usuario usuarioJuan = crearUsuario("Juan", 30);

        UsuarioModel usuarioModel = new UsuarioModel(connection);
        Usuario maria = usuarioModel.save(usuarioMaria);
        Usuario juan = usuarioModel.save(usuarioJuan);

        System.out.println(maria);
        System.out.println(juan);
        System.out.println("------------------------------------------------------------");

        Usuario usuario1EnDB = usuarioModel.getById(1);
        System.out.println(usuario1EnDB);
        Usuario usuario2EnDB = usuarioModel.getById(2);
        System.out.println(usuario2EnDB);
        System.out.println("------------------------------------------------------------");

        Usuario usuarioInexistente = usuarioModel.getById(3);
        System.out.println(usuarioInexistente);
        System.out.println("------------------------------------------------------------");

        usuarioModel.deleteById(2);
        Usuario usuario2Eliminado = usuarioModel.getById(2);
        System.out.println(usuario2Eliminado);
    }

    private static Usuario crearUsuario(String nombre,int edad){
        Usuario usuario = new Usuario();
        usuario.setName(nombre);
        usuario.setEdad(edad);
        return usuario;
    }
}
