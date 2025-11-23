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

public class EmpleadoDAO {

    ConexionBD conexion = new ConexionBD();

    public List<Empleado> listarPorCargo(int idCargo) {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT e.id_empleado, e.nombre, e.documento, e.email, c.id_cargo, c.nombre_cargo "
                   + "FROM empleado e "
                   + "INNER JOIN cargo c ON e.id_cargo = c.id_cargo "
                   + "WHERE c.id_cargo = ?";

        try {
            Connection con = conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCargo);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cargo c = new Cargo(rs.getInt("id_cargo"), rs.getString("nombre_cargo"));
                
                Empleado emp = new Empleado(
                        rs.getInt("id_empleado"),
                        rs.getString("nombre"),
                        rs.getString("documento"),
                        rs.getString("email"),
                        c
                );

                lista.add(emp);
            }

            con.close();
        } catch (Exception e) {
            System.out.println("Error al listar empleados: " + e.getMessage());
        }

        return lista;
    }
}
