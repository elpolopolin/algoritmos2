package aed;

class Funciones {

/***  Primera parte: Funciones en java ***/

    int cuadrado(int x) {
        int res = x*x;
        return res;
    }

    double distancia(double x, double y) {
        double res = Math.sqrt(x*x + y*y);
        return res;
    }

    boolean esPar(int n) {
        //boolean res = false;
        //if (n % 2 == 0) {
        //    res = true;
        //}
        return n%2 == 0;
    }

    boolean esBisiesto(int n) {
        //boolean res = false;
        return (n%4==0 & n%100 != 0) || (n%400 == 0);
    }

    int factorialIterativo(int n) {
        int res = 1;
        if(n>0){
        for (int i =n; i!=0;i--){
            res = res*i;
        }}else if (n<0){
            for (int i = n; i!= 0;i++){
            res = res*i;
        }}
        return res;
    }

    int factorialRecursivo(int n) {
        if (n==0){
            return 1;
        }
        else if (n>0){
            return n * factorialRecursivo(n-1);
        }
        else if (n<0) {
            return n * factorialRecursivo(n+1);
        }
        return 0;
    }

    boolean esPrimo(int n) {    
        if (n == 0){
            return false;
        }
        if (n ==1){
            return false;
        }
        for (int i = 1; i<= n; i++) {
            if (n % i == 0){
                if (i != n & i != 1){
                    return false;
                }
            }
        }
        return true;
    }

    int sumatoria(int[] numeros) {
        int res = 0;
        for (int i = 0;i<numeros.length;i++){
            res += numeros[i];
        }
        return res;
    }

    int busqueda(int[] numeros, int buscado) {
        int res = 0;
        for (int i = 0;i<numeros.length;i++) {
            if (numeros[i] == buscado){
                res = i;
            }
        }
        return res;
    }

    boolean tienePrimo(int[] numeros) {
        for (int x: numeros){
            if (esPrimo(x)){
                return true;
            }
        }
        return false;
    }

    boolean todosPares(int[] numeros) {

        for (int n:numeros){
            if (!esPar(n)){
                return false;
            }   
        }
        return true;
    }

    boolean esPrefijo(String s1, String s2) {
        int i =0;
        if (s1.length() > s2.length()){return false;}

        while (i < s1.length() & i < s2.length()){
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
            i++;
        }
        
        return true;
    }

    boolean esSufijo(String s1, String s2) {
        //dar vuelta s1 y s2}
        String s1AlReves = "";
        String s2AlReves = "";
        for (int i= (s1.length()-1);i>=0;i--){
            s1AlReves += s1.charAt(i);
            //ystem.out.println(i);
        }
         for (int x= (s2.length()-1);x>=0;x--){
            s2AlReves += s2.charAt(x);
            //ystem.out.println(i);
        }
        return esPrefijo(s1AlReves, s2AlReves);
    }

/***  Segunda parte: Debugging ***/

    boolean xor(boolean a, boolean b) {
        return (a || b) && !(a & b);
    }

    boolean iguales(int[] xs, int[] ys) {
        boolean res = true;
        
         if (xs.length != ys.length) {
            return false;
        }
        for (int i = 0; i < xs.length; i++) {
            if (xs[i] != ys[i]) {
                res = false;
            }
        }
        return res && (xs.length == ys.length);
    }

    boolean ordenado(int[] xs) {
        boolean res = true;
        for (int i = 0; i < xs.length -1; i++) {
            if (xs[i] > xs [i+1]) {
                res = false;
            }
        }
        return res;
    }

    int maximo(int[] xs) {
        int res = xs[0];
        for (int i = 0; i < xs.length; i++) {
            if (xs[i] > res){
                res = xs[i];
            } 
        }
        return res;
    }

    boolean todosPositivos(int[] xs) {
        boolean res = true;
        for (int x : xs) {
            if (x > 0) {
            }else{
                res = false;
            }
        }
        return res;
    }

    //new int[0]) que significa wey? cheuquear los test
    //this.maximo({1,2,3}) //this refiere a la clase en la q estas
}
