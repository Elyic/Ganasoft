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
public class Parto {

    /**
     * @return the ID_PARTO
     */
    public int getID_PARTO() {    
        return ID_PARTO;
    }

    /**
     * @param ID_PARTO the ID_PARTO to set
     */
    public void setID_PARTO(int ID_PARTO) {
        this.ID_PARTO = ID_PARTO;
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
     * @return the FECHA_PARTO
     */
    public String getFECHA_PARTO() {
        return FECHA_PARTO;
    }

    /**
     * @param FECHA_PARTO the FECHA_PARTO to set
     */
    public void setFECHA_PARTO(String FECHA_PARTO) {
        this.FECHA_PARTO = FECHA_PARTO;
    }

    /**
     * @return the ESTADO
     */
    public String getESTADO() {
        return ESTADO;
    }

    /**
     * @param ESTADO the ESTADO to set
     */
    public void setESTADO(String ESTADO) {
        this.ESTADO = ESTADO;
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
private int ID_PARTO;
private String ID_ANIMAL;
private String FECHA_PARTO;
private String ESTADO;
private String OBSERVACIONES;    
}
