package com.ebac.modulo34.model;
import com.ebac.modulo34.dto.Telefono;
import java.sql.SQLException;

public class TelefonoModel implements OperacionesCRUD<Telefono> {

    @Override
    public Telefono save(Telefono telefono) {
        return null;
    }

    @Override
    public Telefono updateById(Telefono telefono) {
        return null;
    }

    @Override
    public int deleteById(int id) {
        return 0;
    }

    @Override
    public Telefono getById(int id) throws SQLException {
        return null;
    }
    
}
