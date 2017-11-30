/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contabilidad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author MARIAJOSE
 */
public class Contabilidad {
    private Cat1 catalogo;
    private RegistroMes[] registrosanio;
    private static ArrayList<Beneficiario> beneficiarios;

    public Contabilidad(Cat1 catalogo) {
        this.catalogo = catalogo;
        this.registrosanio = new RegistroMes[12];
        this.beneficiarios = new ArrayList<>();
    }

    public ArrayList<Beneficiario> getBeneficiarios() {
        return beneficiarios;
    }

    public void setBeneficiarios(ArrayList<Beneficiario> beneficiarios) {
        this.beneficiarios = beneficiarios;
    }

    public Cat1 getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Cat1 catalogo) {
        this.catalogo = catalogo;
    }

    public RegistroMes[] getRegistrosanio() {
        return registrosanio;
    }

    public void setRegistrosanio(RegistroMes[] registrosanio) {
        this.registrosanio = registrosanio;
    }
    
    
    public boolean BG(){
        double debitoTotal = 0.0;
        double creditoTotal = 0.0;
        double total = 0.0;
        for(RegistroMes registrom  : registrosanio){
            for (RegistroDia registrod1 : registrom.getRegistroM() ){
                for (Registro1 registrouno : registrod1.getRegistros()){
                if (registrouno.getCuenta().getClase().getNombreClase().equals("activo")){
                    registrouno.getCuenta().getSubcuenta();
               if (registrouno.getValorRegistro() <= 0){//menor
                       creditoTotal += registrouno.getValorRegistro();
                    } else {
                    debitoTotal += registrouno.getValorRegistro();
                } }else if (registrouno.getCuenta().getClase().getNombreClase().equals("pasivo") && registrouno.getCuenta().getClase().getNombreClase().equals("patrimonio")){
                        registrouno.getCuenta().getSubcuenta();
                        if (registrouno.getValorRegistro() <= 0){//menor
                       debitoTotal += registrouno.getValorRegistro();
                    } else {
                    creditoTotal += registrouno.getValorRegistro();
                }
            }
                }
        }
    }
       if (debitoTotal == creditoTotal){
           return true;
       }else;
       return false;
   }
  public void addBen (Beneficiario e){
      this.beneficiarios.add(e);
  }
  public void eliminarBen (Beneficiario e){
      this.beneficiarios.remove(e);
  }
  public void modBen (Beneficiario e, String cambiob, String h, String l, String f ){
      for (Beneficiario s : beneficiarios){
          if (e.getNombreTercero().equals(s.getNombreTercero())){
             s.setNombreTercero(cambiob);
             s.setCedulaNit(h);
             s.setDireccion(l);
             s.setTelefono(f);
          }
      }
  }
   
//    public String[] mostrarBG(){
//        
//         for(RegistroMes registrom  : registrosanio){
//            for (RegistroDia registrod1 : registrom.getRegistroM() ){
//                for (Registro1 registrouno : registrod1.getRegistros()){
//                if (registrouno.getCuenta().getClase().getNombreClase().equals("activo")){
//                    String hello= "";
//                    hello = String.valueOf(registrouno.getValorRegistro());
//                  if (registrouno.getValorRegistro() <= 0){//menor
//                      
//                        
//                    } else  {
//                    
//               
//            }
//        }
//            if (registrouno.getCuenta().getClase().getNombreClase().equals("pasivo")){
//                String hello= "";
//                    hello = String.valueOf(registrouno.getValorRegistro());
//                  if (registrouno.getValorRegistro() <= 0){//menor
//                      
//                        
//                    } else  {
//                    result.put("Paivo",registrouno.getCuenta().getSubcuenta(), "", hello);
//               
//            }
//            }   if (registrouno.getCuenta().getClase().getNombreClase().equals("patrimonio")){
//                String hello= "";
//                    hello = String.valueOf(registrouno.getValorRegistro());
//                  if (registrouno.getValorRegistro() <= 0){//menor
//                      
//                        result.put("Patrimonio",registrouno.getCuenta().getSubcuenta(), hello,  "");
//                    } else  {
//                    result.put("Patrimonio",registrouno.getCuenta().getSubcuenta(), "", hello);
//               
//            }
//       
//    }
//} 
//    }
//         
//    }
//         return result;
//}
  public static ArrayList<Cuenta> leerCat() throws FileNotFoundException, IOException{
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
         File cuentas = new File ("cuentas/" + nomArc[i]+ ".txt");
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
    }
     return catalogoCuentas.getCuentas();
    }
     public static ArrayList<Beneficiario> leerBen() throws FileNotFoundException, IOException{
         ArrayList<Beneficiario> bens = new ArrayList <>();
         File beneficiarios1 = new File ("Beneficiarios/beneficiarios.txt");
         FileReader leeBene = new FileReader (beneficiarios1);
      BufferedReader bc3 = new BufferedReader  (leeBene);
      String lineaBene;
       while ( (lineaBene = bc3.readLine()) != null){
           String divB[] = lineaBene.split(",");
           String nomB = divB[0];
           String cedBene = divB[1];
           String dirB = divB[2];
           String telB = divB[3];
           Beneficiario ben = new Beneficiario (nomB, cedBene, dirB, telB);
           System.out.println(ben.cedulaNit);
           beneficiarios.add(ben);
          
       }
       return bens;
     }
     public static void escribirBen(ArrayList<Beneficiario> bens) throws IOException{
         String sFichero = "Beneficiarios/beneficiarios.txt";
         File fichero = new File(sFichero);
            if (fichero.exists()) {
                BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
                for (Beneficiario b1 : bens){
                  bw.write(b1.getNombreTercero()+ ","+ b1.getCedulaNit() + ""+ b1.getDireccion() + "," + b1.getTelefono() );
                  bw.newLine();
                }
     } else {
                
            }
     }
}