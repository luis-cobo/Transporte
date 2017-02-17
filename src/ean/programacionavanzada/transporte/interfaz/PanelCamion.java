/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id: PanelCamion.java,v 1.2 2005/12/07 20:36:54 k-marcos Exp $ 
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1
 * Las imágenes de los camiones son adaptadas de la imagen disponible en 
 * http://www.midisegni.it/disegni/vari.shtml 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_transporte
 * Autor: Pablo Barvo - Nov 18, 2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.transporte.interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.transporte.mundo.Camion;

/**
 * Panel para mostrar la información de un camión
 */
public class PanelCamion extends JPanel implements ActionListener
{

    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------

    private static final String VENDER = "VENDER";

    private static final String COMPRAR = "COMPRAR";

    private static final String CAMION_EXISTE = "data/camionExiste.gif";

    private static final String CAMION_NO_EXISTE = "data/camionNoExiste.gif";

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Ventana principal
     */
    private InterfazTransporte principal;

    /**
     * Número del camión en la empresa
     */
    private int numeroCamion;

    //-----------------------------------------------------------------
    // Atributos de la interfaz
    //-----------------------------------------------------------------

    /**
     * Etiqueta con la imagen del camión
     */
    private JLabel etiquetaImagen;

    /**
     * Etiqueta de la matrícula
     */
    private JLabel etiquetaMatricula;

    /**
     * Etiqueta Capacidad del camión
     */
    private JLabel etiquetaCapacidad;

    /**
     * Etiqueta Consumo del camión
     */
    private JLabel etiquetaConsumo;

    /**
     * Botón comprar
     */
    private JButton btnComprar;

    /**
     * Botón vender
     */
    private JButton btnVender;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Constructor del panel
     * @param laPrincipal Ventana principal de la aplicación. laPrincipal != null.
     * @param elNumeroCamion
     */
    public PanelCamion( InterfazTransporte laPrincipal, int elNumeroCamion )
    {
        principal = laPrincipal;
        numeroCamion = elNumeroCamion;
        setBorder( new TitledBorder( "Camión " + numeroCamion ) );
        setLayout( new GridBagLayout( ) );

        //Etiqueta de Imagen
        ImageIcon icono = new ImageIcon( CAMION_NO_EXISTE );
        etiquetaImagen = new JLabel( "" );
        etiquetaImagen.setIcon( icono );
        etiquetaImagen.setBorder( new TitledBorder( "" ) );

        //Etiqueta Matrícula
        etiquetaMatricula = new JLabel( "    N/A    " );
        etiquetaMatricula.setForeground( Color.BLUE.darker( ) );
        etiquetaMatricula.setFont( new Font( "Tahoma", Font.BOLD, 28 ) );

        //Etiqueta Capacidad
        etiquetaCapacidad = new JLabel( "Capacidad: N/A" );

        //Etiqueta Consumo
        etiquetaConsumo = new JLabel( "Consumo: N/A" );

        //Botón Comprar
        btnComprar = new JButton( "Comprar" );
        btnComprar.setPreferredSize( new Dimension( 150, 25 ) );
        btnComprar.setActionCommand( COMPRAR );
        btnComprar.addActionListener( this );

        //Botón Vender
        btnVender = new JButton( "Vender" );
        btnVender.setEnabled( false );
        btnVender.setPreferredSize( new Dimension( 150, 25 ) );
        btnVender.setActionCommand( VENDER );
        btnVender.addActionListener( this );

        //Organización
        GridBagConstraints posicion = new GridBagConstraints( 0, 0, 2, 2, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( etiquetaImagen, posicion );

        posicion = new GridBagConstraints( 2, 0, 4, 2, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( etiquetaMatricula, posicion );

        posicion = new GridBagConstraints( 0, 2, 6, 2, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( etiquetaCapacidad, posicion );

        posicion = new GridBagConstraints( 0, 4, 6, 2, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( etiquetaConsumo, posicion );

        posicion = new GridBagConstraints( 0, 6, 3, 2, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( btnComprar, posicion );

        posicion = new GridBagConstraints( 3, 6, 3, 2, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( btnVender, posicion );
    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Actualiza la información del camión
     * @param camion Camión con la información
     */
    public void actualizar( Camion camion )
    {
        if( camion == null )
        {
            ImageIcon icono = new ImageIcon( CAMION_NO_EXISTE );
            etiquetaImagen.setIcon( icono );
            etiquetaMatricula.setText( "    N/A    " );
            etiquetaCapacidad.setText( "Capacidad: N/A" );
            etiquetaConsumo.setText( "Consumo: N/A" );
            btnComprar.setEnabled( true );
            btnVender.setEnabled( false );
        }
        else
        {
            ImageIcon icono = new ImageIcon( CAMION_EXISTE );
            etiquetaImagen.setIcon( icono );
            etiquetaMatricula.setText( camion.darMatricula( ) );
            etiquetaCapacidad.setText( "Capacidad: " + formatearValor( camion.darCapacidad( ) ) + " Kg." );
            etiquetaConsumo.setText( "Consumo: " + formatearValor( camion.darConsumo( ) ) + " galones/kilómetro" );
            btnComprar.setEnabled( false );
            btnVender.setEnabled( true );
        }
    }

    /**
     * Manejo de eventos de los botones
     * @param e Acción que generó el evento. e != null.
     */
    public void actionPerformed( ActionEvent e )
    {
        if( VENDER.equals( e.getActionCommand( ) ) )
        {
            principal.vender( numeroCamion );
        }
        else
        {
            principal.comprar( numeroCamion );
        }
    }

    /**
     * formatea un valor numérico para presentar en la interfaz <br>
     * @param valor El valor numérico a ser formateado.
     * @return Retorna una cadena con el valor formateado con puntos y signos.
     */
    private String formatearValor( double valor )
    {
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( " ###,###.##" );
        df.setMinimumFractionDigits( 2 );
        return df.format( valor );
    }

    /**
     * formatea un valor numérico para presentar en la interfaz <br>
     * @param valor El valor numérico a ser formateado.
     * @return Retorna una cadena con el valor formateado con puntos y signos.
     */
    private String formatearValor( int valor )
    {
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( " ###,###" );
        df.setMinimumFractionDigits( 0 );
        return df.format( valor );
    }

}