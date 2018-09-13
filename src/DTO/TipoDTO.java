/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Bena
 */
public class TipoDTO {
    private int id;
    private String codTipo;
    private String nombre;
    private TipoCategoriaDTO categoria;
    
    public TipoDTO(){
        this.id = -1;
        this.nombre = "";
        this.codTipo = "";
        this.categoria = null;
        
    }
    
    public TipoDTO(int id, String codTipo, String nombre){
        this.id = id;
        this.codTipo = codTipo;
        this.nombre = nombre;
        this.categoria = null;
    }
    public TipoDTO(int id, String codTipo, String nombre, TipoCategoriaDTO categoria){
        this.id = id;
        this.codTipo = codTipo;
        this.nombre = nombre;
        this.categoria = categoria;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * @return the codTipo
     */
    public String getCodTipo() {
        return codTipo;
    }

    /**
     * @param codTipo the codTipo to set
     */
    public void setCodTipo(String codTipo) {
        this.codTipo = codTipo;
    }
    /**
     * @return the categoria
     */
    public TipoCategoriaDTO getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(TipoCategoriaDTO categoria) {
        this.categoria = categoria;
    }

    
    @Override
    public String toString(){
        String str = this.getNombre();
        return str;
    }
   
    
}
