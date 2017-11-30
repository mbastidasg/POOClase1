/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import Contabilidad.Beneficiario;
import Contabilidad.Cat1;
import Contabilidad.Clase;
import Contabilidad.Contabilidad;
import Contabilidad.Cuenta;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MARIAJOSE
 */
public class MostrarC extends JPanel {
    private boolean DEBUG = false;
public  MostrarC () throws IOException{
        
        // TODO code application logic here
        Cat1 catalogoCuentas = new Cat1 ();
      Contabilidad cont1 = new Contabilidad(catalogoCuentas);
      File clases = new File ("cuentas/clase.txt");
      
      //crear clases
       FileReader leeClase = new FileReader (clases);
      BufferedReader bc1 = new BufferedReader  (leeClase);
      String lineaClase;
      Clase[] clase = new Clase[6];
       int j = 0;
      while ( (lineaClase = bc1.readLine()) != null && j<=5){
         
          String div[] = lineaClase.split(",");
          int numero1 = Integer.parseInt(div[0]);
          String nombreCuenta = div[1];
          String naturalezaCuenta = div[2];
          Clase clases1 = new Clase (numero1, nombreCuenta,naturalezaCuenta);
         
                clase[j] = clases1;
                

              
                         j++;
      }
      
     // crear catalogo clases
     String nomArc []= {"activos", "pasivos", "patrimonio", "ingresos","gastos" , "costosdeventa", "costosdePuO"};
      
     for (int i=0; i< nomArc.length; i++){
         File cuentas = new File ("cuentas/"+ nomArc[i] + ".txt");
         FileReader leeCuenta = new FileReader (cuentas);
      BufferedReader bc2 = new BufferedReader  (leeCuenta);
      String lineaCuenta;
       while ( (lineaCuenta = bc2.readLine()) != null){
          
         //  int k=0;
          String divCuenta[] = lineaCuenta.split(",");
         
         String hello ="";
         String hello1 ="";
                for (int k=0; k<6; k++) {
                    String hy = divCuenta[0];
                    clase[k].getNombreClase();
               
          if (hy.equals(clase[k].getNombreClase())){
           j = clase[k].getNumero();
             hello = clase[k].getNombreClase();
             hello1 = clase [k].getNaturaleza();
              
              Clase clase11 = new Clase (j, hello, hello1);
          int numeCuenta = Integer.parseInt(divCuenta[1]);
          String num1 = divCuenta[1];
        String grupoCuenta = divCuenta[2];
        String num2 = divCuenta[3];
        int numCuenta = Integer.parseInt(divCuenta[3]);
        String cuentaC = divCuenta[4];
        String num3 = divCuenta [5];
        int numSubCuenta = Integer.parseInt(divCuenta[5]);
        String nomSubCuenta = divCuenta[6];
        String ls = Integer.toString(j) +num1 +num2 +num3;
            
      Cuenta crearcuentas = new Cuenta (clase11, numeCuenta , grupoCuenta, numCuenta,cuentaC, numSubCuenta, nomSubCuenta, ls);
                catalogoCuentas.addCuenta1(crearcuentas);
          } else{
            
          }
                  };

       }
    JPanel  panel = new JPanel();
        DefaultTableModel tableModel = new DefaultTableModel ();
        JTable table = new JTable (tableModel);
        panel.setLayout( new BorderLayout());
        String[] columnNames = {"Número de cuenta","Clase",
                                "Grupo",
                                "Cuenta", "Subcuenta"};
       tableModel.setColumnIdentifiers(columnNames);
       String fila[] = new String[tableModel.getColumnCount()];
       String ncc; String cl; String gr; String c; String sc;
       
       for (int p = 0; p < cont1.getCatalogo().getCuentas().size(); p++){
           fila [0] = cont1.getCatalogo().getCuentas().get(i).getNumeroCuenta();
           fila [1] = cont1.getCatalogo().getCuentas().get(i).getClase().getNombreClase();
           fila [2] = cont1.getCatalogo().getCuentas().get(i).getGrupo();
           fila [3] = cont1.getCatalogo().getCuentas().get(i).getCuenta();
           fila[4] = cont1.getCatalogo().getCuentas().get(i).getSubcuenta();
           
     
              tableModel.addRow(fila);
        };
      
       table.setModel(tableModel);
  
//       
//        table.setPreferredScrollableViewportSize(new Dimension(500, 1000));
//        table.setFillsViewportHeight(true);
//       
        //Create the scroll pane and add the table to it.
   JScrollPane scrollPane = new JScrollPane(table);
//
//        //Add the scroll pane to this panel.
        add(scrollPane);
    }
}
public static void createAndShowGUIBEN() throws IOException  {
        //Create and set up the window.
        javax.swing.JFrame frame = new javax.swing.JFrame("Catálogo de cuentas");
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        MostrarC newContentPane = new MostrarC();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic herejavax.swing.SwingUtilities.invokeLater(new Runnable() {
javax.swing.SwingUtilities.invokeLater(new Runnable() {            
public void run() {
                try {
                    createAndShowGUIBEN();
                } catch (IOException ex) {
                    Logger.getLogger(MostrarBeneficiarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    }
    

