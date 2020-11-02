package com.example.cuantasletras;

public class SimuladorContadorLetras {
    public String palabra;
    public char letra;

    public SimuladorContadorLetras(String palabra, char letra) {
        this.palabra = palabra;
        this.letra = letra;
    }

    public int calcularCuantasLetras() {
        int contadorLetras = 0;
        for (int i = 0; i < palabra.length(); i++) {
            char atPos0 = palabra.charAt( i );

            if (atPos0 == letra) {
                contadorLetras++;
            }
        }
        return contadorLetras;
    }


}
