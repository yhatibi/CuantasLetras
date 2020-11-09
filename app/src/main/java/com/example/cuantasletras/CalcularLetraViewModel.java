package com.example.cuantasletras;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CalcularLetraViewModel extends AndroidViewModel {
    MutableLiveData<Boolean> calculando = new MutableLiveData<>();

    Executor executor;
    ContadorLetras contadorLetras;

    MutableLiveData<Character> letra = new MutableLiveData<>();
    MutableLiveData<String> palabra = new MutableLiveData<>();
    MutableLiveData<Integer> letrasContadas = new MutableLiveData<>();
    MutableLiveData<Integer> maxLeng = new MutableLiveData<>();

    public CalcularLetraViewModel(@NonNull Application application) {
        super(application);

        executor = Executors.newSingleThreadExecutor();
        contadorLetras = new ContadorLetras();
    }


    public void calcular(final String palabra, final char letra) {

        final ContadorLetras.Solicitud solicitud = new ContadorLetras.Solicitud(palabra, letra);

        executor.execute(new Runnable() {
            @Override
            public void run() {

                contadorLetras.calcularCuantasLetras(solicitud, new ContadorLetras.Callback() {
                    @Override
                    public void cuantasLetrasHay(int lc) {
                        maxLeng.postValue(null);
                        letrasContadas.postValue(lc);
                    }

                    @Override
                    public void cuandoErrorLongitud(int longMax) {
                        Log.e("ABCD", "error vm");
                        maxLeng.postValue(longMax);
                    }

                    @Override
                    public void cuandoEmpieceElCalculo() {
                        calculando.postValue(true);
                    }

                    @Override
                    public void cuandoFinaliceElCalculo() {
                        calculando.postValue(false);
                    }

                });
            }
        });


    }
}