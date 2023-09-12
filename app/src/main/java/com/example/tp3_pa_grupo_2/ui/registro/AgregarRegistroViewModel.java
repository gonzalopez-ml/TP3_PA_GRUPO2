package com.example.tp3_pa_grupo_2.ui.registro;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AgregarRegistroViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public AgregarRegistroViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}