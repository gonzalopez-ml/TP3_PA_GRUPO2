package com.example.tp3_pa_grupo_2.ui.miCuenta;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MiCuentaViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public MiCuentaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}