/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdaCola;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Equipo
 */
public class ColaEnlazada implements  Cola{
    private Nodo anterior;
    private Nodo posterior;
    private int contador;

    public ColaEnlazada() {
        this.anterior = null;
        this.posterior = null;
        this.contador = 0;
    }
    
    
    @Override
    public int getSize() {
        
        return contador;
    }

    @Override
    public boolean isEmpty() {
       return anterior==null; 
    }

    @Override
    public void anular() {
        this.anterior = null;
        this.posterior = null;
        this.contador = 0;
    }

    @Override
    public int getPosicion(Object elemento) throws ColaException {
        if(isEmpty())
            throw  new ColaException("La cola esta vacia");
        ColaEnlazada colaAux = new ColaEnlazada();
        
        int contador1=0;
        int contadorDefinitivo=-1;//Indica que no existe
        while(!isEmpty()){
            contador1++;
            if(Utilidades.igualQ(frente(), elemento)){
               
                contadorDefinitivo = contador1;
            }
            colaAux.encolar(desencolar());
            
        }
        //al final dejo la cola con todos los elementos encolados
        anterior=colaAux.anterior;
        posterior = colaAux.posterior;
        contador = colaAux.contador;  
        return contadorDefinitivo;
    }
    public Object getElemento(Object elemento) throws ColaException{
        if(isEmpty())
            throw  new ColaException("La cola esta vacia");
        if(existe(elemento)){
            ColaEnlazada colaAux = new ColaEnlazada();
            Object elementoToReturn = new Object();
        
        while(!isEmpty()){
            
            if(Utilidades.igualQ(frente(), elemento)){
               elementoToReturn=frente();
                
            }
            colaAux.encolar(desencolar());
            
        }
        //al final dejo la cola con todos los elementos encolados
        anterior=colaAux.anterior;
        posterior = colaAux.posterior;
        contador = colaAux.contador;  
        return elementoToReturn;
        }else{
            return false;
        }
        
        
    }

    @Override
    public void encolar(Object elemento) {
        Nodo nuevoNodo = new Nodo(elemento);
        if(isEmpty()){//La primera vez
            posterior = nuevoNodo;
            //garantizo que anterior quede apuntando al primer nodo
            anterior=posterior;
        }else{//Significa que al menos hay uno
            posterior.sgte=nuevoNodo;
            posterior=nuevoNodo;
        }
        contador++;
    }

    @Override
    public Object desencolar(){
        if(isEmpty())
            return null;
        Object elemento = anterior.elemento;
        //caso1 Cuando solo hay un elemento 
        //Cuando estan apuntando al mismo nodo
        if(anterior == posterior){
            anular();//Eliminamos la cola
            
        }
        //Caso2 cuando hay varios
        else{
            anterior=anterior.sgte;    
        }
        //Actuaalizo el contador
        contador--;
        return elemento;
    }

    @Override
    public boolean existe(Object elemento) throws ColaException {
        if(isEmpty())
            return false;
        ColaEnlazada colaAux = new ColaEnlazada();
        boolean encontrado=false;
        while(!isEmpty()){
            if(Utilidades.igualQ(frente(), elemento)){
                encontrado=true;
            }
            colaAux.encolar(desencolar());
        }
        //al final dejo la cola con todos los elementos encolados
        anterior=colaAux.anterior;
        posterior = colaAux.posterior;
        contador = colaAux.contador;  
        return encontrado;
//        for (int i = anterior+1; i <= posterior; i++) {
//            if(Utilidades.igualQ(cola[i], elemento))
//                return true;
//        }
//        return false;
    }
//    public boolean existeGenerico(Object elemento) throws ColaException, PilaVaciaException, PilaLlenaException, ListaException{
//         if(!existe(elemento)){
//            if(isEmpty())
//            throw  new ColaException("La cola esta vacia");
//        ColaEnlazada colaAux = new ColaEnlazada();
//        boolean encontrado=false;
//        while(!isEmpty()){
//            if(frente()instanceof Vector&&!encontrado){
//                Vector v = (Vector)frente();
//                
//                encontrado = v.existe(elemento);
////                if(encontrado){
////                    break;
////                }
//            }else if(frente() instanceof PilaEnlazada&&!encontrado){
//                PilaEnlazada p= (PilaEnlazada)frente();
//                PilaEnlazada aux = new PilaEnlazada();
//                if(Utilidades.existe(p, aux, elemento)){
//                    encontrado=true;
//                }
//                while(!aux.isEmpty()){
//                    p.push(aux.pop());
//                }
//                
//            }else if(frente() instanceof ListaEnlazada&&!encontrado){
//                ListaEnlazada lista = (ListaEnlazada)frente();
//                encontrado=lista.existe(elemento);
//            }else if(frente() instanceof ListaEnlazadaDoble&&!encontrado){
//                ListaEnlazadaDoble lista = (ListaEnlazadaDoble)frente();
//                encontrado=lista.existe(elemento);
//            }else if(frente() instanceof ListaCircular&&!encontrado){
//                ListaCircular lista = (ListaCircular)frente();
//                encontrado=lista.existe(elemento);
//            }else if(frente() instanceof ListaCircularEnlazadaDoble&&!encontrado){
//                ListaCircularEnlazadaDoble lista = (ListaCircularEnlazadaDoble)frente();
//                encontrado=lista.existe(elemento);
//            }
//               
//            
//            colaAux.encolar(desencolar());
//        }
//        //al final dejo la cola con todos los elementos encolados
//        anterior=colaAux.anterior;
//        posterior = colaAux.posterior;
//        contador = colaAux.contador;  
//        return encontrado;
//        }else if(existe(elemento)){
//            return true;
//        }
//         return false;    
//    }
    @Override
    public Object frente() {
        if(isEmpty())
            return null;
        return anterior.elemento;
    }
    public Nodo getNodo(int posicion) throws ColaException{
        if(isEmpty())
            throw  new ColaException("La cola esta vacia");
        Nodo aux=anterior;
        int posLista=1;
        while(aux!=null){
            if(Utilidades.igualQ(posLista, posicion)){
                return aux;
            }
            posLista++;
            aux=aux.sgte;
        }
        return  null;
    }
    @Override
    public String toString(){
        if(isEmpty()) return "La cola esta vacía";
        String result="\nCola Enlazada\n";
        
        
        ColaEnlazada colaAux = new ColaEnlazada();
        while(!isEmpty()){
            
                result+=frente()+", ";
                colaAux.encolar(desencolar());
            
            
        }
        //al final dejo la cola con todos los elementos encolados
        
        anterior=colaAux.anterior;
        posterior = colaAux.posterior;
        contador = colaAux.contador;   
//        for (int i = anterior+1; i <= posterior; i++) {
//            result+=cola[i]+", ";
//        }
        return result;
    }
}
