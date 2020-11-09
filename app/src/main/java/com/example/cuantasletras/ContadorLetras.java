package com.example.cuantasletras;

import android.util.Log;

public class ContadorLetras {


    public static class Solicitud {
        public String palabra;
        public char letra;

        public Solicitud(String palabra, char letra) {
            this.palabra = palabra;
            this.letra = letra;
        }
    }

    interface Callback {
        void cuantasLetrasHay(int letrasContadas);
        void cuandoErrorLongitud(int longMax);
        void cuandoEmpieceElCalculo();
        void cuandoFinaliceElCalculo();
    }

    public void calcularCuantasLetras(Solicitud solicitud, Callback callback) {
        int contadorLetras = 0;
        int maxLong = 10;
        callback.cuandoEmpieceElCalculo();

        if(solicitud.palabra.length() > maxLong){
            Log.e("ABCD", "error contador: " + solicitud.palabra.length());
            callback.cuandoErrorLongitud(maxLong);
        } else {
            for (int i = 0; i < solicitud.palabra.length(); i++) {
                char atPos0 = solicitud.palabra.charAt( i );

                if (atPos0 == solicitud.letra) {
                    contadorLetras++;
                }
            }

            callback.cuantasLetrasHay(contadorLetras);
        }

        callback.cuandoFinaliceElCalculo();
    }


}
