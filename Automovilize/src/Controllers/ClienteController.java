/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;
import Controller.HelperController;
import DataBase.Conexion;
import Models.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cetecom
 */
public class ClienteController {
    Conexion cx;
    HelperController helper = new HelperController();
    
    public ClienteController() {
        cx = new Conexion();
        cx.conectar();
        
    }
    
    public void agregarCliente(int rut,String nombre, int numeroContacto,String direccion, String tipoCliente){
        
        String query = "INSERT INTO cliente (rut, nombre,numero_contacto,direccion,tipo_cliente) VALUES (?,?,?,?,?)";
        
        try {
            PreparedStatement st = cx.getConnection().prepareStatement(query);
            st.setInt(1, rut);
            st.setString(2,nombre);
            st.setInt(3, numeroContacto);
            st.setString(4,direccion);
            st.setString(5, tipoCliente);
        } catch (Exception e) {
            helper.showError(e.getMessage());
        }
    }
    
    public List <Cliente> obtenerCliente(){
        List<Cliente> listaClientes = new ArrayList<>();
        //posible error aqui
        String query = "SELECT * FROM cliente";
        
        try {
            ResultSet rs = cx.EjecutarQuery(query);
            
            while(rs.next()){
                listaClientes.add(new Cliente(
                        rs.getInt("rut"),
                        rs.getString("nombre"),
                        rs.getInt("numero_contacto"),
                        rs.getString("direccion"),
                        rs.getString("tipo_cliente")
                ));
            }
        } catch (Exception e) {
            helper.showError(e.getMessage());
        }
        return listaClientes;
    }
    
    public Cliente buscarCliente(int rut){
        Cliente clienteBuscado = null;
        String query ="SELECT * FROM cliente WHERE rut = " + rut;
        
        try {
            ResultSet rs =cx.EjecutarQuery(query);
            
            if(rs.next()){
                clienteBuscado = new Cliente();
                clienteBuscado.setRut(rs.getInt("rut"));
                clienteBuscado.setNombre(rs.getString("nombre"));
                clienteBuscado.setNumero_contacto(rs.getInt("numero_contacto"));
                clienteBuscado.setDireccion(rs.getString("direccion"));
                clienteBuscado.setTipo_cliente(rs.getString("tipo_cliente"));
        }
        } catch (Exception e) {
            helper.showError(e.getMessage());
        }
        return clienteBuscado; 
    }
    
    public boolean editarCliente(int rut, String nombre, int numeroContacto, String direccion, String tipoCliente){
        String query = "UPDATE cliente SET nombre = '" + nombre +
                "', numero_contacto = " + numeroContacto + ", direccion = '" + direccion +
                "', tipo_cliente = '" + tipoCliente +
                "', WHERE rut = " + rut + ";";
        try {
            Cliente clienteEncontrado = buscarCliente(rut);
            
            if(clienteEncontrado != null){
                
                Statement st = cx.getConnection().createStatement();
                int filasAfectadas = st.executeUpdate(query);
                helper.showInformation("Cliente actualizado");
                return filasAfectadas > 0;
            }else{
                return false;
            }
        } catch (Exception e) {
            helper.showError(e.getMessage());
        }
        return false;
    }
        
        public void eliminarCliente(int rut){
            String query = "DELETE FROM cliente  WHERE rut = " + rut + ";";
            
            try {
                Cliente clienteEncontrado = buscarCliente(rut);
                
                if(clienteEncontrado != null){
                    Statement st =cx.getConnection().createStatement();
                    st.executeUpdate(query);
                    helper.showInformation("Cliente eliminado del sistema");
                }else{
                    helper.showInformation("Libro no encontrado");
                }
            } catch (Exception e) {
                helper.showError(e.getMessage());
            }
        }
    }

