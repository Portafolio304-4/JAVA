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
public class TipoCategoriaDTO {
    
    private int id;
    private String codTipoCat;
    private String nombre;
    
    public TipoCategoriaDTO(){
        this.id = -1;
        this.codTipoCat = "";
        this.nombre = "";
    }
    public TipoCategoriaDTO(int id, String codTipoCat, String nombre){
        this.id = id;
        this.codTipoCat = codTipoCat;
        this.nombre = nombre;
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
     * @return the codTipoCat
     */
    public String getCodTipoCat() {
        return codTipoCat;
    }

    /**
     * @param codTipoCat the codTipoCat to set
     */
    public void setCodTipoCat(String codTipoCat) {
        this.codTipoCat = codTipoCat;
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
    
}
