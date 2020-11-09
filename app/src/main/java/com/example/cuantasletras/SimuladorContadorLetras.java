package com.example.cuantasletras;

public class SimuladorContadorLetras {


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
        void cuandoInputNoSeaString(String noEsString);
        void cuandoEmpieceElCalculo();
        void cuandoFinaliceElCalculo();
    }

    public void calcularCuantasLetras(Solicitud palabra, Callback callback) {
        int contadorLetras = 0;
        callback.cuandoEmpieceElCalculo();
        for (int i = 0; i < palabra.palabra.length(); i++) {
            char atPos0 = palabra.palabra.charAt( i );

            if (atPos0 == palabra.letra) {
                contadorLetras++;
            }
        }

        boolean error = false;
        if(!error) {
            callback.cuantasLetrasHay(contadorLetras);
        }

    }


}
