/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import controlador.Controlador;
import java.awt.*;
import javax.swing.*;
import java.sql.SQLException;
import javax.swing.border.EmptyBorder;
/**
 *
 * @author Diurno
 */
public class VentanaPrincipal extends javax.swing.JPanel {
     private JTextArea areaResultados;
    private Controlador controlador;
    private JPanel panelArticulos;
    private JPanel panelTiendas;
    private JPanel panelVentas;
    private JPanel panelEjemplares;
    
    public VentanaPrincipal() {
        configurarPanel();
        inicializarComponentes();
    }
    
    private void configurarPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(new EmptyBorder(10, 10, 10, 10));
    }
    
    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
    
    private void inicializarComponentes() {
        // Crear pestañas
        JTabbedPane tabbedPane = new JTabbedPane();
        crearPanelArticulos();
        crearPanelTiendas();
        crearPanelVentas();
        crearPanelEjemplares();
        
        tabbedPane.addTab("Artículos", panelArticulos);
        tabbedPane.addTab("Tiendas", panelTiendas);
        tabbedPane.addTab("Ventas", panelVentas);
        tabbedPane.addTab("Ejemplares", panelEjemplares);
        
        // Área de resultados
        areaResultados = new JTextArea();
        areaResultados.setEditable(false);
        areaResultados.setWrapStyleWord(true);
        areaResultados.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(areaResultados);
        scrollPane.setPreferredSize(new Dimension(400, 500));
        
        // Añadir componentes al panel
        add(tabbedPane, BorderLayout.WEST);
        add(scrollPane, BorderLayout.CENTER);
    }
    
    private void crearPanelArticulos() {
        panelArticulos = new JPanel();
        panelArticulos.setLayout(new BoxLayout(panelArticulos, BoxLayout.Y_AXIS));
        panelArticulos.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        JButton btnMostrar = crearBoton("Mostrar Artículos", e -> {
            try {
                controlador.mostrarTodosArticulos();
            } catch (SQLException ex) {
                mostrarError(ex);
            }
        });
        
        JButton btnInsertar = crearBoton("Insertar Artículo", e -> {
            controlador.insertarArticulo();
        });
        
        JButton btnEliminar = crearBoton("Eliminar Artículo", e -> {
            controlador.eliminarArticulo();
        });
        
        JButton btnEliminarRelacionado = crearBoton("Eliminar con Relaciones", e -> {
            controlador.eliminarArticuloRelacionado();
        });
        
        panelArticulos.add(btnMostrar);
        panelArticulos.add(Box.createRigidArea(new Dimension(0, 5)));
        panelArticulos.add(btnInsertar);
        panelArticulos.add(Box.createRigidArea(new Dimension(0, 5)));
        panelArticulos.add(btnEliminar);
        panelArticulos.add(Box.createRigidArea(new Dimension(0, 5)));
        panelArticulos.add(btnEliminarRelacionado);
    }
    
    private void crearPanelTiendas() {
        panelTiendas = new JPanel();
        panelTiendas.setLayout(new BoxLayout(panelTiendas, BoxLayout.Y_AXIS));
        panelTiendas.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        JButton btnMostrar = crearBoton("Mostrar Tienda", e -> {
            try {
                controlador.mostrarTienda();
            } catch (SQLException ex) {
                mostrarError(ex);
            }
        });
        
        JButton btnInsertar = crearBoton("Insertar Tienda", e -> {
            try {
                controlador.insertarTienda();
            } catch (SQLException ex) {
                mostrarError(ex);
            }
        });
        
        JButton btnActualizar = crearBoton("Actualizar Tienda", e -> {
            try {
                controlador.actualizarTienda();
            } catch (SQLException ex) {
                mostrarError(ex);
            }
        });
        
        JButton btnEliminar = crearBoton("Eliminar Tienda", e -> {
            try {
                controlador.eliminarTienda();
            } catch (SQLException ex) {
                mostrarError(ex);
            }
        });
        
        panelTiendas.add(btnMostrar);
        panelTiendas.add(Box.createRigidArea(new Dimension(0, 5)));
        panelTiendas.add(btnInsertar);
        panelTiendas.add(Box.createRigidArea(new Dimension(0, 5)));
        panelTiendas.add(btnActualizar);
        panelTiendas.add(Box.createRigidArea(new Dimension(0, 5)));
        panelTiendas.add(btnEliminar);
    }
    
    private void crearPanelVentas() {
        panelVentas = new JPanel();
        panelVentas.setLayout(new BoxLayout(panelVentas, BoxLayout.Y_AXIS));
        panelVentas.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        JButton btnMostrar = crearBoton("Mostrar Ventas", e -> {
            try {
                controlador.mostrarVentas();
            } catch (SQLException ex) {
                mostrarError(ex);
            }
        });
        
        JButton btnInsertar = crearBoton("Insertar Venta", e -> {
            try {
                controlador.insertarVentas();
            } catch (SQLException ex) {
                mostrarError(ex);
            }
        });
        
        JButton btnActualizar = crearBoton("Actualizar Venta", e -> {
            try {
                controlador.actualizarVentas();
            } catch (SQLException ex) {
                mostrarError(ex);
            }
        });
        
        JButton btnEliminar = crearBoton("Eliminar Venta", e -> {
            try {
                controlador.eliminarVentas();
            } catch (SQLException ex) {
                mostrarError(ex);
            }
        });
        
        panelVentas.add(btnMostrar);
        panelVentas.add(Box.createRigidArea(new Dimension(0, 5)));
        panelVentas.add(btnInsertar);
        panelVentas.add(Box.createRigidArea(new Dimension(0, 5)));
        panelVentas.add(btnActualizar);
        panelVentas.add(Box.createRigidArea(new Dimension(0, 5)));
        panelVentas.add(btnEliminar);
    }
    
    private void crearPanelEjemplares() {
        panelEjemplares = new JPanel();
        panelEjemplares.setLayout(new BoxLayout(panelEjemplares, BoxLayout.Y_AXIS));
        panelEjemplares.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        JButton btnMostrar = crearBoton("Mostrar Ejemplares", e -> {
            try {
                controlador.mostrarEjemplar_Articulo();
            } catch (SQLException ex) {
                mostrarError(ex);
            }
        });
        
        JButton btnInsertar = crearBoton("Insertar Ejemplar", e -> {
            try {
                controlador.insertarEjemplar_Articulo();
            } catch (SQLException ex) {
                mostrarError(ex);
            }
        });
        
        JButton btnActualizar = crearBoton("Actualizar Ejemplar", e -> {
            try {
                controlador.actualizarEjemplar_Articulo();
            } catch (SQLException ex) {
                mostrarError(ex);
            }
        });
        
        JButton btnEliminar = crearBoton("Eliminar Ejemplar", e -> {
            try {
                controlador.eliminarEjemplar_Articulo();
            } catch (SQLException ex) {
                mostrarError(ex);
            }
        });
        
        panelEjemplares.add(btnMostrar);
        panelEjemplares.add(Box.createRigidArea(new Dimension(0, 5)));
        panelEjemplares.add(btnInsertar);
        panelEjemplares.add(Box.createRigidArea(new Dimension(0, 5)));
        panelEjemplares.add(btnActualizar);
        panelEjemplares.add(Box.createRigidArea(new Dimension(0, 5)));
        panelEjemplares.add(btnEliminar);
    }
    
    private JButton crearBoton(String texto, java.awt.event.ActionListener listener) {
        JButton boton = new JButton(texto);
        boton.setAlignmentX(Component.LEFT_ALIGNMENT);
        boton.setMaximumSize(new Dimension(200, 30));
        boton.addActionListener(listener);
        return boton;
    }
    
    public void mostrarMensaje(String mensaje) {
        areaResultados.append(mensaje + "\n\n");
        areaResultados.setCaretPosition(areaResultados.getDocument().getLength());
    }
    
    private void mostrarError(Exception e) {
        JOptionPane.showMessageDialog(this, 
                "Error: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        mostrarMensaje("Error: " + e.getMessage());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
