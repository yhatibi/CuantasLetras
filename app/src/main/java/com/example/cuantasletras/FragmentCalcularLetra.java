package com.example.cuantasletras;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.cuantasletras.databinding.FragmentCalcularLetraFragmentBinding;

public class FragmentCalcularLetra extends Fragment {
    private FragmentCalcularLetraFragmentBinding binding;


    public static FragmentCalcularLetra newInstance() {
        return new FragmentCalcularLetra();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentCalcularLetraFragmentBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final FragmentCalcularLetraViewModel fragmentCalcularLetraViewModel = new ViewModelProvider(this).get(FragmentCalcularLetraViewModel.class);

        binding.calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String palabra = String.valueOf(binding.palabra);
                char letra =  Character.valueOf(binding.letra.getText().charAt(0));
                fragmentCalcularLetraViewModel.calcular(palabra, letra);
            }
        });

        fragmentCalcularLetraViewModel.contadorLetras.observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double cuota) {
                binding.sumaLetras.setText(fragmentCalcularLetraViewModel.calcular("hola", 'a'));
            }
        });

//        fragmentCalcularLetraViewModel.errorCapital.observe(getViewLifecycleOwner(), new Observer<Double>() {
//            @Override
//            public void onChanged(Double capitalMinimo) {
//                if (capitalMinimo != null) {
//                    binding.sumaLetras.setError("El capital no puede ser inferor a " + capitalMinimo + " euros");
//                } else {
//                    binding.sumaLetras.setError(null);
//                }
//            }
//        });
//
//        fragmentCalcularLetraViewModel.contadorLetras.observe(getViewLifecycleOwner(), new Observer<Integer>() {
//            @Override
//            public void onChanged(Integer plazoMinimo) {
//                if (plazoMinimo != null) {
//                    binding.sumaLetras.setError("El plazo no puede ser inferior a " + plazoMinimo + " años");
//                } else {
//                    binding.sumaLetras.setError(null);
//                }
//            }
//        });

        fragmentCalcularLetraViewModel.calculando.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean calculando) {
                if (calculando) {
                    binding.calculando.setVisibility(View.VISIBLE);
                    binding.sumaLetras.setVisibility(View.GONE);
                } else {
                    binding.calculando.setVisibility(View.GONE);
                    binding.sumaLetras.setVisibility(View.VISIBLE);
                }
            }
        });
    }


}