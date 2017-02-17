/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: EmpresaTransporte.java,v 1.0 2017/02/17 08:09 lacobo Exp $
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas - Facultad de Ingeniería
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Ejercicio: Empresa de transporte
 * Autor: Luis Cobo - Feb 17, 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package ean.programacionavanzada.transporte.mundo;

/**
 * Empresa de transporte poseedora de 4 camiones.
 */
public class EmpresaTransporte {
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Camión 1 de la empresa
     */
    private Camion camion1;

    //TODO
    //Declarar los atributos para modelar los demás camiones

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Crea una nueva empresa de transporte sin camiones
     */
    public EmpresaTransporte() {
        //Al crear la empresa no se tiene ningún camión comprado
    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Compra un camión y lo ubica en su posición. El camión se compra sólo si no existe
     * uno en la posición dada. <br>
     * <b>post: </b> El camión está disponible con toda su información definida. Si el camión
     * del número indicado ya existía no se hace ningún cambio.
     *
     * @param numeroCamion Número del camión a comprar. 1 <= numeroCamion <=4.
     * @param matricula    Matricula del camión. matricula != null.
     * @param capacidad    Capacidad (en Kg.) del camión. capacidad > 0.
     * @param consumo      Consumo de gasolina (en gasolina/kilómetro). consumo > 0.
     */
    public void comprarCamion(int numeroCamion, String matricula, int capacidad, double consumo) {
        //TODO
        //Completar el método según la documentación
    }

    /**
     * Vende un camión dado su número. <br>
     * <b>post: </b> El camión del número dado deja de estar disponible.
     *
     * @param numeroCamion Número del camión a vender. 1 <= numeroCamion <=4.
     */
    public void venderCamion(int numeroCamion) {
        //TODO
        //Completar el método según la documentaci�n
    }

    /**
     * Devuelve el camión 1
     *
     * @return camión 1
     */
    public Camion darCamion1() {
        return this.camion1;
    }

    /**
     * Devuelve el segundo camión
     *
     * @return camión 2
     */
    public Camion darCamion2() {
        return null;
    }

    /**
     * Devuelve el camión 3
     *
     * @return camión 3
     */
    public Camion darCamion3() {
        return null;
    }

    /**
     * Devuelve el camión 4
     *
     * @return camión 4
     */
    public Camion darCamion4() {
        return null;
    }

    /**
     * Retorna la suma de las capacidades de carga de los camiones de la empresa
     *
     * @return suma de los pesos de los camiones. suma >= 0.
     */
    public int darCapacidadTotal() {
        //TODO
        //Completar el método según la documentación
        return 0;
    }

    /**
     * Devuelve el número del mejor camión para transportar la carga especificada
     *
     * @param peso Peso de la carga a transportar
     * @return número del camión ideal para llevar la carga. Si no encuentra uno
     * adecuado retorna -1.
     */
    public int darMejorCamion(int peso) {
        //TODO
        //Completar el método según la documentación
        return 0;
    }

    //-----------------------------------------------------------------
    // Puntos de Extensión
    //-----------------------------------------------------------------

    /**
     * Método para la extensión 1
     *
     * @return respuesta1
     */
    public String metodo1() {
        return "respuesta1";
    }

    /**
     * Método para la extensión2
     *
     * @return respuesta2
     */
    public String metodo2() {
        return "respuesta2";
    }

}