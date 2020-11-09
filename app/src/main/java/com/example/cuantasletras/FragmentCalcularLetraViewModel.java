package com.example.cuantasletras;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class FragmentCalcularLetraViewModel extends AndroidViewModel {
    MutableLiveData<Boolean> calculando = new MutableLiveData<>();

    Executor executor;


    SimuladorContadorLetras simulador;

    MutableLiveData<Character> letra = new MutableLiveData<>();
    MutableLiveData<String> palabra = new MutableLiveData<>();
    MutableLiveData<Integer> contadorLetras = new MutableLiveData<>();
    MutableLiveData<String> errorLetranumero = new MutableLiveData<>();

    public FragmentCalcularLetraViewModel(@NonNull Application application) {
        super(application);

        executor = Executors.newSingleThreadExecutor();
        simulador = new SimuladorContadorLetras();
    }


    public void calcular(final String palabra, final char letra) {

        final SimuladorContadorLetras.Solicitud solicitud = new SimuladorContadorLetras.Solicitud(palabra, letra);

        executor.execute(new Runnable() {
            @Override
            public void run() {

                simulador.calcularCuantasLetras(solicitud, new SimuladorContadorLetras.Callback() {


                    @Override
                    public void cuantasLetrasHay(int letrasContadas) {
                        contadorLetras.postValue(letrasContadas);
                    }

                    @Override
                    public void cuandoInputNoSeaString(String noEsString) {

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