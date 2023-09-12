package com.example.tp3_pa_grupo_2.ui.parqueos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.tp3_pa_grupo_2.databinding.FragmentParqueosBinding;

public class ParqueosFragment extends Fragment {

    private FragmentParqueosBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ParqueosViewModel parqueosViewModel =
                new ViewModelProvider(this).get(ParqueosViewModel.class);

        binding = FragmentParqueosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        parqueosViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}