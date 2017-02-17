/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id: VentanaComprar.java,v 1.1 2005/12/07 20:36:54 k-marcos Exp $ 
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_transporte
 * Autor: Pablo Barvo - Nov 18, 2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.transporte.interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * Ventana para la compra de un cami�n
 */
public class VentanaComprar extends JFrame
{
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Ventana principal
     */
    private InterfazTransporte principal;

    /**
     * Numero de cami�n a comprar
     */
    private int camion;

    /**
     * Panel con los datos de comprar
     */
    private PanelComprar panelComprar;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Constructor de la ventana.
     * @param laPrincipal Ventana principal
     * @param elCamion Numero de cami�n a comprar
     */
    public VentanaComprar( InterfazTransporte laPrincipal, int elCamion )
    {
        principal = laPrincipal;
        camion = elCamion;

        setTitle( "Compra de Cami�n" );
        setLayout( new BorderLayout( ) );

        //Crea los elementos
        panelComprar = new PanelComprar( this );
        add( panelComprar );
        pack( );
    }

    //-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------

    /**
     * Compra un cami�n
     * @param matricula Matr�cula del nuevo cami�n. matricula != null.
     * @param capacidad Capacidad en Kg. del nuevo cami�n. capacidad > 0.
     * @param consumo Consumo de galones de gasolina del cami�n por kil�metro. consumo > 0.
     */
    public void comprar( String matricula, int capacidad, double consumo )
    {
        //Realiza la compra
        principal.comprar( camion, matricula, capacidad, consumo );
        dispose( );
    }

    /**
     * Cancela la compra de un cami�n
     */
    public void cancelar( )
    {
        dispose( );
    }

}
