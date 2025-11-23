/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package supermercadomvc3;

import controlador.EmpleadoControlador;
import vista.FrmEmpleados;

public class SupermercadoMVC3 {

    public static void main(String[] args) {
        FrmEmpleados vista = new FrmEmpleados();
        EmpleadoControlador controlador = new EmpleadoControlador(vista);
        vista.setVisible(true);
    }
}

