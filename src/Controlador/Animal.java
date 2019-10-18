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
public class Animal {

    /**
     * @return the RAZA
     */
    public int getRAZA() {
        return RAZA;
    }

    /**
     * @param RAZA the RAZA to set
     */
    public void setRAZA(int RAZA) {
        this.RAZA = RAZA;
    }

    /**
     * @return the FOTO
     */
    public String getFOTO() {
        return FOTO;
    }

    /**
     * @param FOTO the FOTO to set
     */
    public void setFOTO(String FOTO) {
        this.FOTO = FOTO;
    }

    /**
     * @return the SEXO
     */
    public String getSEXO() {
        return SEXO;
    }

    /**
     * @param SEXO the SEXO to set
     */
    public void setSEXO(String SEXO) {
        this.SEXO = SEXO;
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
     * @return the DESCRIPCION
     */
    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    /**
     * @param DESCRIPCION the DESCRIPCION to set
     */
    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }


    /**
     * @return the TIPO
     */
    public String getTIPO() {
        return TIPO;
    }

    /**
     * @param TIPO the TIPO to set
     */
    public void setTIPO(String TIPO) {
        this.TIPO = TIPO;
    }

    /**
     * @return the FECHA_NACIMIENTO
     */
    public String getFECHA_NACIMIENTO() {
        return FECHA_NACIMIENTO;
    }

    /**
     * @param FECHA_NACIMIENTO the FECHA_NACIMIENTO to set
     */
    public void setFECHA_NACIMIENTO(String FECHA_NACIMIENTO) {
        this.FECHA_NACIMIENTO = FECHA_NACIMIENTO;
    }

    /**
     * @return the EDAD
     */
    public String getEDAD() {
        return EDAD;
    }

    /**
     * @param EDAD the EDAD to set
     */
    public void setEDAD(String EDAD) {
        this.EDAD = EDAD;
    }

    /**
     * @return the NO_LOTE
     */
    public String getNO_LOTE() {
        return NO_LOTE;
    }

    /**
     * @param NO_LOTE the NO_LOTE to set
     */
    public void setNO_LOTE(String NO_LOTE) {
        this.NO_LOTE = NO_LOTE;
    }

    /**
     * @return the PROCEDENCIA
     */
    public String getPROCEDENCIA() {
        return PROCEDENCIA;
    }

    /**
     * @param PROCEDENCIA the PROCEDENCIA to set
     */
    public void setPROCEDENCIA(String PROCEDENCIA) {
        this.PROCEDENCIA = PROCEDENCIA;
    }

    /**
     * @return the CATEGORIA
     */
    public int getCATEGORIA() {
        return CATEGORIA;
    }

    /**
     * @param CATEGORIA the CATEGORIA to set
     */
    public void setCATEGORIA(int CATEGORIA) {
        this.CATEGORIA = CATEGORIA;
    }

    /**
     * @return the NO_HIJOS
     */
    public int getNO_HIJOS() {
        return NO_HIJOS;
    }

    /**
     * @param NO_HIJOS the NO_HIJOS to set
     */
    public void setNO_HIJOS(int NO_HIJOS) {
        this.NO_HIJOS = NO_HIJOS;
    }

    /**
     * @return the PESO
     */
    public float getPESO() {
        return PESO;
    }

    /**
     * @param PESO the PESO to set
     */
    public void setPESO(float PESO) {
        this.PESO = PESO;
    }

    /**
     * @return the PADRE
     */
    public String getPADRE() {
        return PADRE;
    }

    /**
     * @param PADRE the PADRE to set
     */
    public void setPADRE(String PADRE) {
        this.PADRE = PADRE;
    }

    /**
     * @return the MADRE
     */
    public String getMADRE() {
        return MADRE;
    }

    /**
     * @param MADRE the MADRE to set
     */
    public void setMADRE(String MADRE) {
        this.MADRE = MADRE;
    }

    /**
     * @return the FECHA_MUERTE
     */
    public String getFECHA_MUERTE() {
        return FECHA_MUERTE;
    }

    /**
     * @param FECHA_MUERTE the FECHA_MUERTE to set
     */
    public void setFECHA_MUERTE(String FECHA_MUERTE) {
        this.FECHA_MUERTE = FECHA_MUERTE;
    }

    /**
     * @return the UBICACION
     */
    public String getUBICACION() {
        return UBICACION;
    }

    /**
     * @param UBICACION the UBICACION to set
     */
    public void setUBICACION(String UBICACION) {
        this.UBICACION = UBICACION;
    }

    /**
     * @return the PRECIO_COMPRA
     */
    public float getPRECIO_COMPRA() {
        return PRECIO_COMPRA;
    }

    /**
     * @param PRECIO_COMPRA the PRECIO_COMPRA to set
     */
    public void setPRECIO_COMPRA(float PRECIO_COMPRA) {
        this.PRECIO_COMPRA = PRECIO_COMPRA;
    }

    /**
     * @return the PRECIO_VENTA
     */
    public float getPRECIO_VENTA() {
        return PRECIO_VENTA;
    }

    /**
     * @param PRECIO_VENTA the PRECIO_VENTA to set
     */
    public void setPRECIO_VENTA(float PRECIO_VENTA) {
        this.PRECIO_VENTA = PRECIO_VENTA;
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
private String ID_ANIMAL;
private String DESCRIPCION;
private int RAZA;
private String TIPO;
private String FECHA_NACIMIENTO;
private String EDAD;
private String NO_LOTE;
private String PROCEDENCIA;
private int CATEGORIA;
private int NO_HIJOS;
private float PESO;
private String PADRE;
private String MADRE;
private String FECHA_MUERTE;
private String UBICACION;
private float PRECIO_COMPRA;
private float PRECIO_VENTA;
private String ESTADO;
private String SEXO;
private String FOTO;
}
