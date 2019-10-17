/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author Elyic
 */
public class Vacunacion {

    /**
     * @return the ID_VACUNACION
     */
    public int getID_VACUNACION() {
        return ID_VACUNACION;    
    }

    /**
     * @param ID_VACUNACION the ID_VACUNACION to set
     */
    public void setID_VACUNACION(int ID_VACUNACION) {
        this.ID_VACUNACION = ID_VACUNACION;
    }

    /**
     * @return the ID_ANIMAL
     */
    public String getID_ANIMAL() {
        return ID_ANIMAL;
    }

    /**
     * @param ID_ANIMAL the ID_ANIMAL to set
     */
    public void setID_ANIMAL(String ID_ANIMAL) {
        this.ID_ANIMAL = ID_ANIMAL;
    }

    /**
     * @return the FECHA_VACUNACION
     */
    public String getFECHA_VACUNACION() {
        return FECHA_VACUNACION;
    }

    /**
     * @param FECHA_VACUNACION the FECHA_VACUNACION to set
     */
    public void setFECHA_VACUNACION(String FECHA_VACUNACION) {
        this.FECHA_VACUNACION = FECHA_VACUNACION;
    }

    /**
     * @return the MEDICINA
     */
    public String getMEDICINA() {
        return MEDICINA;
    }

    /**
     * @param MEDICINA the MEDICINA to set
     */
    public void setMEDICINA(String MEDICINA) {
        this.MEDICINA = MEDICINA;
    }

    /**
     * @return the CANTIDAD_MEDICINA
     */
    public String getCANTIDAD_MEDICINA() {
        return CANTIDAD_MEDICINA;
    }

    /**
     * @param CANTIDAD_MEDICINA the CANTIDAD_MEDICINA to set
     */
    public void setCANTIDAD_MEDICINA(String CANTIDAD_MEDICINA) {
        this.CANTIDAD_MEDICINA = CANTIDAD_MEDICINA;
    }

    /**
     * @return the OBSERVACIONES
     */
    public String getOBSERVACIONES() {
        return OBSERVACIONES;
    }

    /**
     * @param OBSERVACIONES the OBSERVACIONES to set
     */
    public void setOBSERVACIONES(String OBSERVACIONES) {
        this.OBSERVACIONES = OBSERVACIONES;
    }
private int ID_VACUNACION;
private String ID_ANIMAL;
private String FECHA_VACUNACION;
private String MEDICINA;
private String CANTIDAD_MEDICINA;
private String OBSERVACIONES;    
}
