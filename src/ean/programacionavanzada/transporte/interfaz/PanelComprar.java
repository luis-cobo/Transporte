/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id: PanelComprar.java,v 1.1 2005/12/07 20:36:54 k-marcos Exp $ 
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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Panel para la compra de un cami�n
 */
public class PanelComprar extends JPanel implements ActionListener
{
    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------

    /**
     * Comando Aceptar
     */
    private static final String ACEPTAR = "ACEPTAR";

    /**
     * Comando Cancelar
     */
    private static final String CANCELAR = "CANCELAR";

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Ventana del panel
     */
    private VentanaComprar ventana;

    //-----------------------------------------------------------------
    // Atributos de Interfaz
    //-----------------------------------------------------------------

    /**
     * Etiqueta Matr�cula
     */
    private JLabel etiquetaMatricula;

    /**
     * Texto de Matr�cula
     */
    private JTextField txtMatricula;

    /**
     * Etiqueta Matr�cula
     */
    private JLabel etiquetaCapacidad;

    /**
     * Texto de Matr�cula
     */
    private JTextField txtCapacidad;

    /**
     * Etiqueta Matr�cula
     */
    private JLabel etiquetaConsumo;

    /**
     * Texto de Matr�cula
     */
    private JTextField txtConsumo;

    /**
     * Bot�n Aceptar
     */
    private JButton btnAceptar;

    /**
     * Bot�n Cancelar
     */
    private JButton btnCancelar;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Constructor de la ventana.
     * @param laVentana Ventana del panel. laVentana != null.
     */
    public PanelComprar( VentanaComprar laVentana )
    {
        ventana = laVentana;

        setLayout( new BorderLayout( ) );

        //Crea los elementos
        JPanel panelCentral = new JPanel( );
        panelCentral.setLayout( new GridLayout( 4, 2 ) );
        panelCentral.setBorder( new TitledBorder( "Compra" ) );

        //Matricula
        etiquetaMatricula = new JLabel( "Matr�cula:" );
        panelCentral.add( etiquetaMatricula );
        txtMatricula = new JTextField( );
        txtMatricula.setColumns( 10 );
        panelCentral.add( txtMatricula );

        //Capacidad
        etiquetaCapacidad = new JLabel( "Capacidad:" );
        panelCentral.add( etiquetaCapacidad );
        txtCapacidad = new JTextField( );
        txtCapacidad.setColumns( 10 );
        panelCentral.add( txtCapacidad );

        //Capacidad
        etiquetaConsumo = new JLabel( "Consumo:" );
        panelCentral.add( etiquetaConsumo );
        txtConsumo = new JTextField( );
        txtConsumo.setColumns( 10 );
        panelCentral.add( txtConsumo );

        //Botones
        btnAceptar = new JButton( "Aceptar" );
        btnAceptar.setActionCommand( ACEPTAR );
        btnAceptar.addActionListener( this );
        panelCentral.add( btnAceptar );
        btnCancelar = new JButton( "Cancelar" );
        btnCancelar.setActionCommand( CANCELAR );
        btnCancelar.addActionListener( this );
        panelCentral.add( btnCancelar );

        add( panelCentral );

    }

    //-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------

    /**
     * Manejo de eventos de los botones
     * @param e Acci�n que gener� el evento. e != null.
     */
    public void actionPerformed( ActionEvent e )
    {
        int capacidad = 0;
        double consumo = 0;

        if( ACEPTAR.equals( e.getActionCommand( ) ) )
        {
            //Validaci�n de contenido completo
            if( txtMatricula.getText( ).length( ) == 0 || txtCapacidad.getText( ).length( ) == 0 || txtConsumo.getText( ).length( ) == 0 )
            {
                JOptionPane.showMessageDialog( this, "Debe ingresar todos los valores", "Error", JOptionPane.ERROR_MESSAGE );
                return;
            }

            //Validaci�n matricula
            String matricula = txtMatricula.getText( );
            if( matricula.length( ) != 6 )
            {
                JOptionPane.showMessageDialog( this, "La matr�cula debe tener 6 caracteres", "Error", JOptionPane.ERROR_MESSAGE );
                return;
            }
            //Validaci�n de la capacidad
            try
            {

                capacidad = Integer.parseInt( txtCapacidad.getText( ) );
                if( capacidad <= 0 )
                {
                    JOptionPane.showMessageDialog( this, "La capacidad debe ser mayor que cero", "Error", JOptionPane.ERROR_MESSAGE );
                    return;
                }
            }
            catch( NumberFormatException e2 )
            {
                JOptionPane.showMessageDialog( this, "La capacidad debe ser num�rica", "Error", JOptionPane.ERROR_MESSAGE );
                return;
            }
            //Validaci�n de Matr�cula y ejecuci�n
            try
            {
                consumo = Double.parseDouble( txtConsumo.getText( ) );
                if( consumo <= 0 )
                {
                    JOptionPane.showMessageDialog( this, "El consumo debe ser mayor que cero", "Error", JOptionPane.ERROR_MESSAGE );
                    return;
                }

            }
            catch( NumberFormatException e2 )
            {
                JOptionPane.showMessageDialog( this, "El consumo debe ser real", "Error", JOptionPane.ERROR_MESSAGE );
                return;
            }
            //Realiza la compra
            ventana.comprar( matricula, capacidad, consumo );
        }
        else
        {
            ventana.cancelar( );
        }
    }

}
