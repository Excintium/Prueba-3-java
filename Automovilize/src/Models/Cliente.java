/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Cetecom
 */
public class Cliente {
    private int rut;
    private String nombre;
    private int numero_contacto;
    private String direccion;
    private String tipo_cliente;

    public Cliente() {
    }

    public Cliente(int rut, String nombre, int numero_contacto, String direccion, String tipo_cliente) {
        this.rut = rut;
        this.nombre = nombre;
        this.numero_contacto = numero_contacto;
        this.direccion = direccion;
        this.tipo_cliente = tipo_cliente;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero_contacto() {
        return numero_contacto;
    }

    public void setNumero_contacto(int numero_contacto) {
        this.numero_contacto = numero_contacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo_cliente() {
        return tipo_cliente;
    }

    public void setTipo_cliente(String tipo_cliente) {
        this.tipo_cliente = tipo_cliente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "rut=" + rut + ", nombre=" + nombre + ", numero_contacto=" + numero_contacto + ", direccion=" + direccion + ", tipo_cliente=" + tipo_cliente + '}';
    }
    
    
   
    
}
