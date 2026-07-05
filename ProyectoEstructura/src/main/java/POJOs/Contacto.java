/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJOs;

/**
 *
 * @author Usuario
 */
public class Contacto {
    
    private String telefono;
    private String correo;
    private Direccion direccion;

    public Contacto(String telefono, String correo, Direccion direccion) {
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
    }

    public Contacto() {
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Contacto{" + "telefono=" + telefono + ", correo=" + correo + ", direccion=" + direccion + '}';
    }
    
    
    
}
