package com.ebac.modulo34.model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.ebac.modulo34.dto.Usuario;
import java.sql.SQLException;
import java.sql.Connection;

public class UsuarioModel implements OperacionesCRUD<Usuario> {

    private Connection connection;

    public UsuarioModel(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Usuario save(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios(nombre, edad) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, usuario.getName());
        statement.setInt(2, usuario.getEdad());

        int elementosInsertados = statement.executeUpdate();
        if (elementosInsertados == 1) {
            return usuario;
        }
        throw new SQLException("Error al insertar el usuario en la base de datos");
    }

    @Override
    public Usuario updateById(Usuario usuario) throws SQLException {
        String sql = "UPDATE usuarios SET nombre = ?, edad = ? WHERE idUsuario = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, usuario.getName());
        statement.setInt(2, usuario.getEdad());
        statement.setInt(3, usuario.getIdUsuario());

        int elementosInsertados = statement.executeUpdate();
        if (elementosInsertados == 1) {
            return usuario;
        }
        throw new SQLException("Error al actualizar el usuario en la base de datos");
    }

    @Override
    public int deleteById(int id) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE idUsuario = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        return statement.executeUpdate();  
    }

    @Override
    public Usuario getById(int id) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE idUsuario = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        Usuario usuario = new Usuario();

        while(resultSet.next()) {
            usuario.setIdUsuario(resultSet.getInt("idUsuario"));
            usuario.setName(resultSet.getString("nombre"));
            usuario.setEdad(resultSet.getInt("edad"));
        }

        return usuario;
    }

}
