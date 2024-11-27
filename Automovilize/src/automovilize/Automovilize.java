/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package automovilize;

import DataBase.Conexion;
import Views.menuPrincipal;

/**
 *
 * @author Cetecom
 */
public class Automovilize {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexion cx = new Conexion();
        cx.conectar();
        menuPrincipal menu = new menuPrincipal();
        menu.setVisible(true);
    }
    
}
