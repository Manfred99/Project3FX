/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tdaCola;


//import cr.ac.ucr.if3001.lab8.domain.ColaException;
//import cr.ac.ucr.if3001.lab8.domain.Cola;
//import cr.ac.ucr.if3001.lab8.domain.ColaEnlazadaHeader;
//import cr.ac.ucr.if3001.lab8.domain.Lista;
//import cr.ac.ucr.if3001.lab8.domain.ListaCircular;
//import cr.ac.ucr.if3001.lab8.domain.ListaEnlazada;
//import cr.ac.ucr.if3001.lab8.domain.ListaEnlazadaDoble;
//import cr.ac.ucr.if3001.lab8.domain.ListaException;
//import cr.ac.ucr.if3001.lab8.domain.Nodo;
//import cr.ac.ucr.if3001.lab8.domain.Pila;
//import cr.ac.ucr.if3001.lab8.domain.PilaEnlazada;
//import cr.ac.ucr.if3001.lab8.domain.PilaLlenaException;
//import cr.ac.ucr.if3001.lab8.domain.PilaVaciaException;
//import cr.ac.ucr.if3001.lab8.domain.Vector;
import Domain.SquareIJ;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OSCAR
 */
public class Utilidades {
//private static 
 private static String s1 ="$###,###.##";
  private static String s2 ="##,###,###.##";
  private static DecimalFormat formato1 = new DecimalFormat(s1);
  private static DecimalFormat formato2 = new DecimalFormat(s2);
  private static Random random = new Random();
  
  
  public static String getFormatoMoneda(double valor){
      return formato1.format(valor);
  }
  public static String getFormato(double valor){
      return formato2.format(valor);
  }
  public static int getAleatorio(int cota){
      return random.nextInt(cota)+1;
  }
  
  public static int aleatoriosRango(int n1, int n2){
      int num =n1+(int) (Math.random()*n2);
      return num;
  }
  
  public int[] ordenaArreglo(int a[]){
        int aux;
    for (int j=0;j<a.length;j++)
       for (int i=0;i<a.length-1;i++){
           if (a[i]<a[i+1]){
               aux = a[i];
               a[i]=a[i+1];
               a[i+1] = aux;
           }//fin if
       } //fin for
    return a;
    }
  public static boolean igualQ(Object a, Object b) {
      
        if( a instanceof Integer&&b instanceof Integer){
            Integer x = (Integer)a;
            Integer y = (Integer)b;
            return x==y;
        }
        if( a instanceof String&&b instanceof String){
            String x = (String)a;
            String y = (String)b;
            
            return x.equals(y);
        }
        if( a instanceof SquareIJ&&b instanceof SquareIJ){
            SquareIJ x = (SquareIJ)a;
            SquareIJ y = (SquareIJ)b;
            
            return x.getI()==y.getI()&&x.getJ()==y.getJ();
        }
//        if( a instanceof PilaArreglo&&b instanceof PilaArreglo){
//            PilaArreglo x = (PilaArreglo)a;
//            PilaArreglo y = (PilaArreglo)b;
//            return x.equals(b);
//        }
//        if( a instanceof PilaEnlazada&&b instanceof PilaEnlazada){
//            PilaEnlazada x = (PilaEnlazada)a;
//            PilaEnlazada y = (PilaEnlazada)b;
//            return x.equals(b);
//        }
        if( a instanceof Character&&b instanceof Character){
             char x = ( char)a;
             char y = ( char)b;
            
            return x==y;
        }
//        if( a instanceof Estudiante&&b instanceof Estudiante){
//            Estudiante x = (Estudiante)a;
//            Estudiante y = (Estudiante)b;
//            return x.getCarne().equals(y.getCarne());
//        }
//       if( a instanceof Vector&&b instanceof Vector){
//            Vector x = (Vector)a;
//            Vector y = (Vector)b;
//            return x.elementosIguales(y);
//        }
//       if( a instanceof Lista&&b instanceof Lista){
//            try {
//                Lista x = (Lista)a;
//                Lista y = (Lista)b;
//                return listasIguales(x, y);
//            } catch (ListaException ex) {
//                Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//       if( a instanceof Pila&&b instanceof Pila){
//           
//                Pila x = (Pila)a;
//                Pila y = (Pila)b;
//                return pilasIguales(x, y);
//            
//        }
//       if( a instanceof Cola&&b instanceof Cola){
//           
//                Cola x = (Cola)a;
//                Cola y = (Cola)b;
//                return colasIguales(x, y);
//            
//        }
//       if( a instanceof Pais&&b instanceof Pais){
//           
//                Pais x = (Pais)a;
//                Pais y = (Pais)b;
//                return x.getNombre().equals(y.getNombre()) ;
//            
//        }
//       if( a instanceof Persona&&b instanceof Persona){
//           
//                Persona x = (Persona)a;
//                Persona y = (Persona)b;
//                return x.getNombre().equals(y.getNombre())&&x.getApellido1().equals(y.getApellido1())&&x.getApellido2().equals(y.getApellido2()) ;
//            
//        }
//       if( a instanceof ListaCircular&&b instanceof ListaCircular){
//            ListaCircular x = (ListaCircular)a;
//            ListaCircular y = (ListaCircular)b;
//            try {
//                return x.existe(y);
//            } catch (ListaException ex) {
//                Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        return false;
  }
  public static int comparar(Object a, Object b) {

		int resultado = 0;

		if (a instanceof Integer) {

			if ((int) a < (int) b) {

				resultado = -1;

			}
			else if ((int) a > (int) b) {

				resultado = 1;

			}
			else {

				resultado = 0;

			}

		}
		else if (a instanceof String) {

			if (((String) a).compareToIgnoreCase((String) b) < 0) {

				resultado = -1;

			}
			else if (((String) a).compareToIgnoreCase((String) b) > 0) {

				resultado = 1;

			}
			else {

				resultado = 0;

			}

		}

		return resultado;

	}

	public static boolean mayorQue(Object e1, Object e2) {

		boolean menor = false;

		if (e1 instanceof Integer) {

			menor = (int) e1 > (int) e2;

		}

		if (e1 instanceof String) {

			menor = String.valueOf(e1).compareToIgnoreCase(String.valueOf(e2)) > 0;

		}

		return menor;
	}

	public static boolean menorQue(Object e1, Object e2) {

		boolean menor = false;

		if (e1 instanceof Integer) {

			menor = (int) e1 < (int) e2;

		}

		if (e1 instanceof String) {

			menor = String.valueOf(e1).compareToIgnoreCase(String.valueOf(e2)) < 0;

		}

		return menor;
	}

	public static Object minimo(Object obj1, Object obj2) {

		Object min = null;

		if (obj1 instanceof Integer) {

			if ((int) obj1 <= (int) obj2) {

				min = obj1;

			}
			else {

				min = obj2;

			}

		}

		if (obj1 instanceof String) {

			if (String.valueOf(obj1).compareToIgnoreCase(String.valueOf(obj2)) < 0) {

				min = obj1;

			}
			else {

				min = obj2;

			}

		}

		return min;
	}

	public static Object maximo(Object obj1, Object obj2) {

		Object max = null;

		if (obj1 instanceof Integer) {

			if ((int) obj1 > (int) obj2) {

				max = obj1;

			}
			else {

				max = obj2;

			}

		}

		if (obj1 instanceof String) {

			if (String.valueOf(obj1).compareToIgnoreCase(String.valueOf(obj2)) > 0) {

				max = obj1;

			}
			else {

				max = obj2;

			}

		}

		return max;
	}

	public static boolean igual(Object a, Object b) {

		boolean iguales = false;

		if (a instanceof String) {

			iguales = (String.valueOf(a).equalsIgnoreCase(String.valueOf(b)));

		}
		if (a instanceof Integer) {

			iguales = ((int) a) == ((int) b);

		}

		return iguales;

	}
//        public static boolean listasIguales(Lista lista1, Lista lista2) throws ListaException {
//        if(lista1.isEmpty()||lista2.isEmpty()){
//            throw new ListaException("La lista esta vacia");
//        }else if(lista1.getSize()!=lista2.getSize()){
//            return false;
//        }
//        int size = lista1.getSize();
//        Object aux;
//        Object aux2;
//            for (int i = 1; i <= size; i++) {
//               aux  = lista1.getElemento(i);
//               aux2  = lista2.getElemento(i);
//                
//               if(!Utilidades.igualQ(aux, aux2)){
//                   
//                    return false;
//                }
//            }
//         
//        return true; //indica q el elemento no existe
//    
//    }
//    public static boolean existe(Pila p, Pila aux, Object o) {
//     try {
//         if(p.isEmpty())
//             return false;
//         if(igualQ(p.top(), o))
//             return true;
//         else{
//             aux.push(p.pop());
//             return existe(p,aux, o);
//         }
//     } catch (PilaVaciaException ex) {
//         Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
//     } catch (PilaLlenaException ex) {
//         Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
//     }
//     return false;
//    }
//    public static boolean pilasIguales(Pila p, Pila p2){
//        
//         boolean result = true;
//         try {
//        PilaEnlazada paux = new PilaEnlazada();
//        PilaEnlazada paux2 = new PilaEnlazada();
//         Vector v1 = new Vector(p.getSize());
//         Vector v2 = new Vector(p2.getSize());
//            int fin = p.getSize();
//            
//            for (int i = 0; i <fin; i++) {
//           
//                
//                 Object e =p.pop();
//                 
//                 v1.insertar1(e);
//                 
//                 
//                paux2.push(e);
//                 
//            
//                
//            }
//            
//            
//            int fin3=paux2.getSize();
//            
//            for (int i = 0; i <fin3; i++) {
//                p.push(paux2.pop());
//                
//            }
//            
//            int fin5 = p2.getSize();
//            for (int i = 0; i <fin5; i++) {
//           
//                
//                 
//                 Object e2 = p2.pop();
//                 
//                 v2.insertar1(e2);
//                 
//                
//                 paux.push(e2);
//            
//                
//            }
//            
//            
//            int fin4=paux.getSize();
//            
//            for (int i = 0; i <fin4; i++) {
//               
//                p2.push(paux.pop());
//            } 
//             
//            if(!igualQ(v1, v2)){
//                result =false;
//            }
//            } catch (PilaVaciaException ex) {
//                 Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
//             } catch (PilaLlenaException ex) {
//                 Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
//             }
//           return result;
//        
//    }
////    public static boolean colasIguales(Cola cola1, Cola cola2) {
////        if(cola1.getSize()!=cola2.getSize()||cola1.isEmpty()||cola2.isEmpty()){
////            return false;
////        }
////        boolean ok = true;
////        Cola aux1 = cola1;
////        Cola aux2 = cola2;
////        Vector vector1 = new Vector(cola1.getSize());
////        Vector vector2 = new Vector(cola1.getSize());
////        int size = cola1.getSize();
////        for (int i = 0; i < size; i++) {
//////            vector1.insertar1(aux1.desencolar());
//////            vector2.insertar1(aux2.desencolar());
////              if(!Utilidades.igualQ(aux1.desencolar(), aux2.desencolar())){
////                  ok = false;
////              }
////        }
////        
////        
////        
////        //return Utilidades.igualQ(vector1, vector2);
////        return ok;
////    }
    
    
}
