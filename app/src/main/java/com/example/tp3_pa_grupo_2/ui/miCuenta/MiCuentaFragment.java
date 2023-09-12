package com.example.tp3_pa_grupo_2.ui.miCuenta;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.tp3_pa_grupo_2.databinding.FragmentMicuentaBinding;

public class MiCuentaFragment extends Fragment {

    private FragmentMicuentaBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MiCuentaViewModel miCuentaViewModel =
                new ViewModelProvider(this).get(MiCuentaViewModel.class);

        binding = FragmentMicuentaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSlideshow;
        miCuentaViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}