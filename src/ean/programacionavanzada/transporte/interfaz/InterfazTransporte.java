/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: InterfazTransporte.java,v 1.2 2005/12/07 20:36:54 k-marcos Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_transporte
 * Autor: Pablo Barvo - Nov 18, 2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.transporte.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.cupi2.transporte.mundo.EmpresaTransporte;

/**
 * Ventana principal de la aplicación.
 */
public class InterfazTransporte extends JFrame
{
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Clase principal del mundo
     */
    private EmpresaTransporte empresaTransporte;

    //-----------------------------------------------------------------
    // Atributos de la interfaz
    //-----------------------------------------------------------------

    /**
     * Panel de botones
     */
    private PanelBotones paneBotones;

    /**
     * Panel del camión 1
     */
    private PanelCamion panelCamion1;

    /**
     * Panel del camión 2
     */
    private PanelCamion panelCamion2;

    /**
     * Panel del camión 3
     */
    private PanelCamion panelCamion3;

    /**
     * Panel del camión 4
     */
    private PanelCamion panelCamion4;

    /**
     * Diálogo para comprar un camión
     */
    private VentanaComprar ventanaComprar;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Crea la ventana principal de la aplicación.
     */
    public InterfazTransporte( )
    {
        // Crea la clase principal
        empresaTransporte = new EmpresaTransporte( );

        // organizar el panel principal
        getContentPane( ).setLayout( new BorderLayout( ) );
        setSize( 530, 530 );
        setTitle( "Empresa de Transporte" );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        //Paneles Centrales
        JPanel panelCentral = new JPanel( );
        panelCentral.setLayout( new GridLayout( 2, 2 ) );
        add( panelCentral, BorderLayout.CENTER );

        //Panel Camión 1
        panelCamion1 = new PanelCamion( this, 1 );
        panelCentral.add( panelCamion1 );

        //Panel Camión 2
        panelCamion2 = new PanelCamion( this, 2 );
        panelCentral.add( panelCamion2 );

        //Panel Camión 3
        panelCamion3 = new PanelCamion( this, 3 );
        panelCentral.add( panelCamion3 );

        //Panel Camión 4
        panelCamion4 = new PanelCamion( this, 4 );
        panelCentral.add( panelCamion4 );

        //Panel Extensiones
        paneBotones = new PanelBotones( this );
        getContentPane( ).add( paneBotones, BorderLayout.SOUTH );

        centrarVentana( this );
    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Vende el camión especificado
     * @param camion Número del camión a vender
     */
    public void vender( int camion )
    {
        empresaTransporte.venderCamion( camion );
        if( camion == 1 )
            panelCamion1.actualizar( empresaTransporte.darCamion1( ) );
        else if( camion == 2 )
            panelCamion2.actualizar( empresaTransporte.darCamion2( ) );
        else if( camion == 3 )
            panelCamion3.actualizar( empresaTransporte.darCamion3( ) );
        else if( camion == 4 )
            panelCamion4.actualizar( empresaTransporte.darCamion4( ) );
    }

    /**
     * Compra un camión en la posición especificada
     * @param camion Número de camión a comprar
     */
    public void comprar( int camion )
    {
        ventanaComprar = new VentanaComprar( this, camion );
        centrarVentana( ventanaComprar );
        ventanaComprar.setVisible( true );
    }

    /**
     * Realiza la compra del camión
     * @param camion Número de camión a comprar
     * @param matricula Matricula del camión
     * @param capacidad Peso del camión
     * @param consumo Consumo del camión
     */
    public void comprar( int camion, String matricula, int capacidad, double consumo )
    {
        empresaTransporte.comprarCamion( camion, matricula, capacidad, consumo );
        if( camion == 1 )
            panelCamion1.actualizar( empresaTransporte.darCamion1( ) );
        else if( camion == 2 )
            panelCamion2.actualizar( empresaTransporte.darCamion2( ) );
        else if( camion == 3 )
            panelCamion3.actualizar( empresaTransporte.darCamion3( ) );
        else if( camion == 4 )
            panelCamion4.actualizar( empresaTransporte.darCamion4( ) );
    }

    /**
     * Selecciona un camión para realizar un transporte
     */
    public void seleccionar( )
    {
        String valor = JOptionPane.showInputDialog( this, "Peso a transportar (en Kg.)" );
        if( valor != null )
        {
            try
            {
                int cantidad = Integer.parseInt( valor );
                int resultado = empresaTransporte.darMejorCamion( cantidad );
                if( resultado > 0 )
                {
                    JOptionPane.showMessageDialog( this, "El mejor camión para transportar es el camión " + resultado );
                }
                else
                {
                    JOptionPane.showMessageDialog( this, "No tiene un camión disponible para transportar esa carga" );
                }
            }
            catch( NumberFormatException e )
            {
                JOptionPane.showMessageDialog( this, "El peso debe ser un valor numérico", "Error", JOptionPane.ERROR_MESSAGE );
            }
        }
    }

    /**
     * Presenta la suma de los pesos de todos los camiones
     */
    public void totalizarPeso( )
    {
        int peso = empresaTransporte.darCapacidadTotal( );
        JOptionPane.showMessageDialog( this, "La capacidad total de carga es " + peso + " kg.", "Peso Total", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Centra una ventana en la pantalla
     * @param ventana La ventana que se va a centrar
     */
    private void centrarVentana( JFrame ventana )
    {
        Dimension dPantalla = Toolkit.getDefaultToolkit( ).getScreenSize( );
        Dimension dVentana = ventana.getSize( );

        int xEsquina = ( dPantalla.width / 2 ) - ( dVentana.width / 2 );
        int yEsquina = ( dPantalla.height / 2 ) - ( dVentana.height / 2 );

        ventana.setLocation( xEsquina, yEsquina );
    }
    //-----------------------------------------------------------------
    // Puntos de Extensión
    //-----------------------------------------------------------------

    /**
     * Método para la extensión 1
     */
    public void reqFuncOpcion1( )
    {
        String resultado = empresaTransporte.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método para la extensión 2
     */
    public void reqFuncOpcion2( )
    {
        String resultado = empresaTransporte.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    //-----------------------------------------------------------------
    // Ejecución
    //-----------------------------------------------------------------

    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz
     * @param args
     */
    public static void main( String[] args )
    {

        InterfazTransporte interfaz = new InterfazTransporte( );
        interfaz.setVisible( true );
    }

}