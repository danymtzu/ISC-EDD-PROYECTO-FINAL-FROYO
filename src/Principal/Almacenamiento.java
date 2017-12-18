
package Principal;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.io.*;
import java.util.StringTokenizer;


//@author 166550477-16550499-16550506-16550518

public class Almacenamiento {
    //Todas las variables a utilizar
    private String nomb;
    private String apel;
    private String grad;
    private int id;
    private double n1,n2,n3,n4,n5,n6,n7,n8,nf;
     Almacenamiento nSig;

    //Tokenizer para el separador de los datos
    private StringTokenizer strz;
    //Un arreglo que guarde todos los datos ingresados
    private String [] dats;
    int contador=0;

    public Almacenamiento(){//Constructor por defecto, inicializando las variables
        nomb = "";
        apel = "";
        grad = "";
        id = 0;
        n1 = 0D;
        n2 = 0D;
        n3 = 0D;
        n4 = 0D;
        n5 = 0D;
        n6 = 0D;
        n7 = 0D;
        n8 = 0D;
        nSig= null;
        dats = new String[13];
    }
    
        public Almacenamiento(String sNom, String sApe, String sGrad, int ID, double dn1, double dn2, double dn3,
            double dn4, double dn5, double dn6, double dn7, double dn8){
        
        nomb = sNom;
        apel = sApe;
        grad = sGrad;
        id = ID;
        n1 = dn1;
        n2 = dn2;
        n3 = dn3;
        n4 = dn4;
        n5 = dn5;
        n6 = dn6;
        n7 = dn7;
        n8 = dn8;
        nSig=null;
        
        
        
    }
    
    public Almacenamiento(String sNom, String sApe, String sGrad, int ID, double dn1, double dn2, double dn3,
            double dn4, double dn5, double dn6, double dn7, double dn8, double dnf , Almacenamiento nNod){
        
        sNom=sNom;
        sApe=sApe;
        sGrad=sGrad;
        ID=ID;
        dn1= dn1;
        dn2= dn2;
        dn3= dn3;
        dn4= dn4;
        dn5= dn5;
        dn6= dn6;
        dn7= dn7;
        dn8= dn8;
        dnf= dnf;
        
        nSig=nNod;
        
  }



    public boolean setInfoEscrit(String nomb, String apel, String grad){//Método que define si escribir o no los datos de texto

        if(nomb.equals("") || apel.equals("") || grad.equals("")){//Si están vacíos los campos, será falso y no escribirá
            return false;
        }
        else{//Si hay algo en los textfield, guardar los datos en las variables creadas
            this.nomb = nomb;
            this.apel = apel;
            this.grad = grad;
            return true;
        }
    }

    public boolean setInfoNumer(String id, String n1, String n2, String n3, String n4, String n5, String n6, String n7, String n8){
            //Define si escribir o no en el archivo, si todos los campos son válidos, guarda los datos en las variables creadas al inicio
        try{
            //Todos los datos se transforman a double, ya que se recibe un String
            this.id = Integer.parseInt(id);
            this.n1 = Double.parseDouble(n1);
            this.n2 = Double.parseDouble(n2);
            this.n3 = Double.parseDouble(n3);
            this.n4 = Double.parseDouble(n4);
            this.n5 = Double.parseDouble(n5);
            this.n6 = Double.parseDouble(n6);
            this.n7 = Double.parseDouble(n7);
            this.n8 = Double.parseDouble(n8);
            return true;
        }catch(NumberFormatException ex){//Si no es un número válido regresa false
            return false;
        }
    }

    public String getDatosAGuardar(){//Método que muestra los datos que se van a guardar

        String aux = "Nombre(s): " + nomb + "\n" +
                     "Apellido(s): " + apel + "\n" +
                     "ID: " + id + "\n" +
                     "Semestre: " + grad + "\n" +
                     "Participación: " + n1 + "\n" +
                     "Tareas: " + n2 + "\n" +
                     "Exa.Lectura: " + n3 + "\n" +
                     "Prácticas: " + n4 + "\n" +
                     "Exa.Teórico: " + n5 + "\n" +
                     "Expocisión: " + n6 + "\n" +
                     "Proyecto: " + n7 + "\n" +
                     "Exa.Práctico: " + n8 + "\n" +
                     "Calificación Final: " + notaFinal();

        return aux;
    }

    private double notaFinal(){//Calcula la nota final de la unidad y le un formato a dos decimales

        
        DecimalFormat dec = new DecimalFormat("000.00");//Crea el formato de decimal
        double aux = (n1*0.05) + (n2*0.10) + (n3*0.10) + (n4*0.10) + (n5*0.15) + (n6*0.15) + (n7*0.15) + (n8*0.20);//Los números están basados en la calificación del profr. Rubén
        Double.toString(aux);//Transforma a String
        nf = Double.parseDouble(dec.format(aux));//Transforma de nuevo a double
        
        return nf;
    }

    public boolean guardar(){//Método para guardar los datos en un .txt

        File f = new File("Datos.txt");//Crea el archivo

        try{
            if(!f.exists()){//Si no existe, lo crea

                f.createNewFile();
            }

            FileWriter fw = new FileWriter(f, true);//Creamos un File Writter para escribir en el archivo

            String datos = id + "_" + apel + "_" + nomb + "_" + grad + "_" +
                            n1 + "_" + n2 + "_" + n3 + "_" + n4 + "_" + n5 + "_" + n6 + "_"+n7 + "_" + n8 + "_" + nf + "\n";

            fw.write(datos + "");//Escribe los datos y cierra el archivo
            fw.close();
            
            return true;

        }
        catch(IOException ex){//Excepción para prevenir errores
            return false;
        }
    }

    public boolean VerificarRepetido(String id){//Comprueba si el ID existe o no

        boolean est = false;//inicializamos la variable

        try{
            FileReader fr = new FileReader("Datos.txt");//Leemos el archivo
            BufferedReader br = new BufferedReader(fr);

            String s;//Variable que lee en el archivo

            while((s = br.readLine()) != null){//mientras que haya algo que leer

                String aux = s.substring(0,id.length()-1);//Los datos se guardan en un auxiliar

                if(aux.equals(id)){//si es igual el ID ingresado y el del archivo
                    est = true;
                    s = null;//Vacia la variable
                }
            }
        }
//        Excepciones para que funcione correctamente o muestre un dialogo que diga que no es pobible
        catch(FileNotFoundException ex){
            est = false;
        }
        catch(IOException ex){
            est = false;
        }

        return est;
    }

    public boolean buscarDato(String id){//Busca el ID ingresado

        boolean est = false;//Inicializamos la variable

        try{
            FileReader fr = new FileReader("Datos.txt");//Lee el archivo
            BufferedReader br = new BufferedReader(fr);

            String s;//Variable para recorrer el archivo

            while((s = br.readLine()) != null){

                String aux = s.substring(0,id.length());

                if(aux.equals(id)){//Si es igual el ID

                    strz = new StringTokenizer(s, "_");//Asigna los separadores al Tokenizer
                    
                    int i = 0;//Variable de la pocisión
                    while(strz.hasMoreTokens()){//Mientras haya más tokens

                        dats[i] = (String)strz.nextElement();//Almacena en la pocisión el elemento respectivo
                        i++;
                    }

                    est = true;
                    s = null;
                    break;
                }
            }
        }
        catch(FileNotFoundException ex){
            est = false;
        }
        catch(IOException ex){
            est = false;
        }

        return est;
    }

    public String getDatos(){//Nos regresa todos los datos en el archivo

        String datos = "";

        try{

            FileReader fr = new FileReader("Datos.txt");
            BufferedReader br = new BufferedReader(fr);

            String s;//Variable que recorre el archivo

            while((s = br.readLine()) != null){//Mientras haya algo que leer

                datos += (s + "\n");//Va acumulando los datos en la variable
            }

            return datos;//Regresa el dato final
        }
        catch(FileNotFoundException ex){
            return "ERROR ARCHIVO NO ENCONTRADO";
        }
        catch(IOException ex){
            return "ERROR AL PROCESAR ARCHIVO ";
        }
    }
    
    private void hacerLista(String id){
                boolean est = false;//Inicializamos la variable

        try{
            FileReader fr = new FileReader("Datos.txt");//Lee el archivo
            BufferedReader br = new BufferedReader(fr);

            String s;//Variable para recorrer el archivo

            while((s = br.readLine()) != null){

                String aux = s.substring(0,id.length());

                if(aux.equals(id)){//Si es igual el ID

                    strz = new StringTokenizer(s, "_");//Asigna los separadores al Tokenizer
                    
                    int i = 0;//Variable de la pocisión
                    while(strz.hasMoreTokens()){//Mientras haya más tokens

                        dats[getContador()] = (String)strz.nextElement();//Almacena en la pocisión el elemento respectivo
                        i++;
                    }

                    est = true;
                    s = null;
                    break;
                }
            }
        }
        catch(FileNotFoundException ex){
            est = false;
        }
        catch(IOException ex){
            est = false;
        }
    }

    //Getter and Setter
    public String getNombre(){
        return dats[2];
    }

    public String getApellido(){
        return dats[1];
    }

    public String getID(){
        return dats[0];
    }

    public String getGrado(){
        return dats[3];
    }

    public String getN1(){
        return dats[4];
    }

    public String getN2(){
        return dats[5];
    }

    public String getN3(){
        return dats[6];
    }

    public String getN4(){
        return dats[7];
    }
    
    public String getN5(){
        return dats[8];
    }
    
    public String getN6(){
        return dats[9];
    }
    
    public String getN7(){
        return dats[10];
    }
    public String getN8(){
        return dats[11];
    }
    public String getNF(){
        return dats[12];
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

//        public void hacerArreglo(){//Busca el ID ingresado
////            setContador(contador+13);
//            int[] Array = new int[getContador()];
////            String id="";
//
//
//        try{
//            FileReader fr = new FileReader("Datos.txt");//Lee el archivo
//            BufferedReader br = new BufferedReader(fr);
//
//            String s;//Variable para recorrer el archivo
//
//            while((s = br.readLine()) != null){
//
////                String aux;
//
////                if(aux.equals(id)){//Si es igual el ID
//
//                    strz = new StringTokenizer(s, "_");//Asigna los separadores al Tokenizer
//                    
//                    int i = 0;//Variable de la pocisión
//                    while(strz.hasMoreTokens()){//Mientras haya más tokens
//
//                        dats[contador] = (String)strz.nextElement();//Almacena en la pocisión el elemento respectivo
//                        contador++;
////                    }
//
//                    s = null;
//                    break;
//                }
//            }
//        }
//        catch(FileNotFoundException ex){
//        }
//        catch(IOException ex){
//        }
//
//    }
    public Almacenamiento getnSig() {
        
       return nSig;
    }
    
   public  void setnSig(Almacenamiento nSig){
        
         this.nSig = nSig;
    }
    
    
}
