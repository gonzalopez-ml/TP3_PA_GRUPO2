package com.example.tp3_pa_grupo_2.ui.registro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.tp3_pa_grupo_2.databinding.FragmentAgregarRegistroBinding;

public class AgregarRegistroFragment extends Fragment {

    private FragmentAgregarRegistroBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AgregarRegistroViewModel agregarRegistroViewModel =
                new ViewModelProvider(this).get(AgregarRegistroViewModel.class);

        binding = FragmentAgregarRegistroBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}