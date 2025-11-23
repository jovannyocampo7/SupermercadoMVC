/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.Cargo;
import modelo.CargoDAO;
import modelo.Empleado;
import modelo.EmpleadoDAO;
import vista.FrmEmpleados;

public class EmpleadoControlador implements ActionListener {

    private FrmEmpleados vista;
    private CargoDAO cargoDAO;
    private EmpleadoDAO empleadoDAO;

    public EmpleadoControlador(FrmEmpleados vista) {
        this.vista = vista;
        cargoDAO = new CargoDAO();
        empleadoDAO = new EmpleadoDAO();

        // Cargar los cargos en el combo
        cargarCargos();

        // Escuchar botón
        this.vista.btnConsultar.addActionListener(this);
    }

    private void cargarCargos() {
        List<Cargo> lista = cargoDAO.listarCargos();
        for (Cargo c : lista) {
            vista.cmbCargo.addItem(c.getNombreCargo());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnConsultar) {
            consultarEmpleados();
        }
    }

    private void consultarEmpleados() {
        String cargoSeleccionado = (String) vista.cmbCargo.getSelectedItem();

        if (cargoSeleccionado == null) {
            System.out.println("No hay cargos disponibles.");
            return;
        }

        // Convertir nombre del cargo a ID
        List<Cargo> listaCargos = cargoDAO.listarCargos();
        int idCargo = -1;

        for (Cargo c : listaCargos) {
            if (c.getNombreCargo().equals(cargoSeleccionado)) {
                idCargo = c.getIdCargo();
                break;
            }
        }

        if (idCargo == -1) {
            System.out.println("Error: ID de cargo no encontrado.");
            return;
        }

        // Consultar empleados
        List<Empleado> lista = empleadoDAO.listarPorCargo(idCargo);

        // Llenar tabla
        DefaultTableModel modeloTabla = (DefaultTableModel) vista.tblEmpleados.getModel();
        modeloTabla.setRowCount(0); // limpiar tabla

        for (Empleado emp : lista) {
            modeloTabla.addRow(new Object[]{
                emp.getIdEmpleado(),
                emp.getNombre(),
                emp.getDocumento(),
                emp.getEmail(),
                emp.getCargo().getNombreCargo()
            });
        }
    }
}
