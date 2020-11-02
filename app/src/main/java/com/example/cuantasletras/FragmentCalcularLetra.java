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

public class FragmentCalcularLetra extends Fragment {

    private FragmentCalcularLetraViewModel mViewModel;
    private String palabra;

    public static FragmentCalcularLetra newInstance() {
        return new FragmentCalcularLetra();
    }
    private FragmentCalcularLetra binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_calcular_letra_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FragmentCalcularLetraViewModel.class);
        // TODO: Use the ViewModel

    }


}