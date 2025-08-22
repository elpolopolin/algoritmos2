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
        // COMPLETAR
        return false;
    }

/***  Segunda parte: Debugging ***/

    boolean xor(boolean a, boolean b) {
        return a || b && !(a && b);
    }

    boolean iguales(int[] xs, int[] ys) {
        boolean res = true;

        for (int i = 0; i < xs.length; i++) {
            if (xs[i] != ys[i]) {
                res = false;
            }
        }
        return res;
    }

    boolean ordenado(int[] xs) {
        boolean res = true;
        for (int i = 0; i < xs.length; i++) {
            if (xs[i] > xs [i+1]) {
                res = false;
            }
        }
        return res;
    }

    int maximo(int[] xs) {
        int res = 0;
        for (int i = 0; i <= xs.length; i++) {
            if (xs[i] > res) res = i;
        }
        return res;
    }

    boolean todosPositivos(int[] xs) {
        boolean res = false;
        for (int x : xs) {
            if (x > 0) {
                res = true;
            } else {
                res = false;
            }
        }
        return res;
    }

    //this.maximo({1,2,3}) //this refiere a la clase en la q estas
}
