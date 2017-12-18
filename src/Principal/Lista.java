/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

/**
 *
 * @author 166550477-16550499-16550506-16550518
 */
 
public class Lista {
    Almacenamiento Nodo;


    private Almacenamiento nIni;
    private Almacenamiento nFin;
    
    public Lista(){
        nIni=null;
        nFin=null;
    }
    public Lista(Almacenamiento nNodo){
        nIni=nNodo;
        nFin=nNodo;
    }
   
        public void imprimirElementos(){
        if (nIni == null) {
            System.out.println("La lista está vacía");
        }else{
            Almacenamiento nTemp = nIni;
        while(nTemp != null){
            System.out.print(nTemp.getDatos()+" - ");
            nTemp = nTemp.getnSig();
        }
        }
    }

            public int valorEn(int iPos) throws Exception{
        //VERIFICAR QUE EL VALOR INGRESADO SEA MENOR AL TAMAÑO DE LA LISTA
        int iVal=0;
        if (iPos<contarElementos() && iPos>0) {
            Almacenamiento nTemp= nIni;
    if(nIni== null){
            return 0;
        }else{
            for (int i = 0; i < iPos; i++) {
            nTemp = nTemp.getnSig();
        }
            }
            iVal=Integer.parseInt(nTemp.getID());
        }else{
            throw new Exception("La posición no es válida");
        }return iVal;
        
    }

    public void agregarNodoMejorado(Almacenamiento nNodo){
        if(nIni== null){
            nIni= nNodo;//SOLO CUANDO LAS LISTA ESTA VACIA
            nFin=nNodo;
        }else{
        nFin.setnSig(nNodo);
        nFin=nNodo;
        }
    }
    
        public int contarElementos(){
        Almacenamiento nTemp= nIni;
    if(nIni== null){
            return 0;
        }else{
        int iCont=0;
            while(nTemp != null){
                iCont++;
                nTemp= nTemp.getnSig();
                
            }return iCont;
            
        }
    }
    
    

    public void insertareN(int iPos,Almacenamiento nNodo) throws Exception{
            if (iPos>=0 && iPos<contarElementos()) {
        //INSERTAR AL INICIO DE LA LISTA
            if (iPos==0) {
                nNodo.setnSig(nIni);//CUALQUIER POSICION EXCEPTO AL FINAL
                Almacenamiento nTemp = nIni;
                for (int i = 0; i < (iPos-1); i++) {
                    nTemp = nTemp.getnSig();
                }
                nIni=nNodo;
                
            }else{//INSERTAR EN CUALQUIER POSICION EXCEPTO AL FINAL
                Almacenamiento nTemp = nIni;
                for (int i = 0; i < (iPos-1); i++) {
                    nTemp = nTemp.getnSig();
                }
                nNodo.setnSig(nTemp.getnSig());
                nTemp.setnSig(nNodo);
            }
    }else{
                throw new Exception("La posición no es válida");
            }
    }
    
//     public  void selectionSort(Lista Lista)  {
//        for (int i = 0; i < Lista.contarElementos(); i++) {
//           
//            Almacenamiento minimo= Lista.nIni;
//            for (int j = i + 1; j < Lista.contarElementos(); j++) {//Buscar más pequeño
//                if (Lista.nIni.getID().compareTo(Lista.Nodo.nSig.getID())<Lista.nIni.getID().compareTo(Lista.Nodo.nSig.getID())) {
//                    minimo= minimo.nSig; //Guardar posición más pequeño
//                }
//            }//Terminamos de buscar
//            
//            //Intercambiar
//           Almacenamiento temporal=  minimo;
//           minimo= Lista.nIni;
//           Lista.nIni= temporal;
//        }
//    }
 
    
    // buscar el primer valor, vacio, si la lista tiene valores regresar true y si no regresar false
    public boolean esVacio(){
        if (nIni==null) {
            return false;
        }else{
            return true;
        }
    }
    
    public void impEsVacio(){
        if (esVacio()==true) {
            System.out.println("Si, la lista tiene elementos");
        }else{
            System.out.println("No, la lista no tiene elementos");
        }
    }
}

class Nodo{

  private String nomb;
    private String apel;
    private String grad;
    private int id;
    private double n1,n2,n3,n4,n5,n6,n7,n8,nf;
    private Almacenamiento nSig;
    
    public Nodo(){
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
        nf= 0D;
        nSig= null;

    }
    
    public Nodo(String sNom, String sApe, String sGrad, int ID, double dn1, double dn2, double dn3,
            double dn4, double dn5, double dn6, double dn7, double dn8, double dnf){
        
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
        nf= dnf;
        nSig=null;
        
        
        
    }
    
    public Nodo(String sNom, String sApe, String sGrad, int ID, double dn1, double dn2, double dn3,
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

    public String getNomb() {
        return nomb;
    }

    public void setNomb(String nomb) {
        this.nomb = nomb;
    }

    public String getApel() {
        return apel;
    }

    public void setApel(String apel) {
        this.apel = apel;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getN1() {
        return n1;
    }

    public void setN1(double n1) {
        this.n1 = n1;
    }

    public double getN2() {
        return n2;
    }

    public void setN2(double n2) {
        this.n2 = n2;
    }

    public double getN3() {
        return n3;
    }

    public void setN3(double n3) {
        this.n3 = n3;
    }

    public double getN4() {
        return n4;
    }

    public void setN4(double n4) {
        this.n4 = n4;
    }

    public double getN5() {
        return n5;
    }

    public void setN5(double n5) {
        this.n5 = n5;
    }

    public double getN6() {
        return n6;
    }

    public void setN6(double n6) {
        this.n6 = n6;
    }

    public double getN7() {
        return n7;
    }

    public void setN7(double n7) {
        this.n7 = n7;
    }

    public double getN8() {
        return n8;
    }

    public void setN8(double n8) {
        this.n8 = n8;
    }

    public double getNf() {
        return nf;
    }

    public void setNf(double nf) {
        this.nf = nf;
    }

    public Almacenamiento getnSig() {
        return nSig;
    }

    public void setnSig(Almacenamiento nSig) {
        this.nSig = nSig;
    }

    
    
}
