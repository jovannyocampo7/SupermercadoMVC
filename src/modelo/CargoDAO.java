/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CargoDAO {
    
    ConexionBD conexion = new ConexionBD();

    public List<Cargo> listarCargos() {
        List<Cargo> lista = new ArrayList<>();
        String sql = "SELECT * FROM cargo";

        try {
            Connection con = conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cargo c = new Cargo();
                c.setIdCargo(rs.getInt("id_cargo"));
                c.setNombreCargo(rs.getString("nombre_cargo"));
                lista.add(c);
            }

            con.close();
        } catch (Exception e) {
            System.out.println("Error al listar cargos: " + e.getMessage());
        }

        return lista;
    }
}
