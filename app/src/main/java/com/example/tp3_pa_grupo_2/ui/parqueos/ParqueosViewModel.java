package com.example.tp3_pa_grupo_2.ui.parqueos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ParqueosViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ParqueosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}