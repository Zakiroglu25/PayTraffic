package com.aris.paytraffic.fragments.mainMenu;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainMenuViewModel extends ViewModel {
    private MutableLiveData<String> mText;
    // TODO: Implement the ViewModel

    public MainMenuViewModel(){
        mText = new MutableLiveData<>();
        mText.setValue("Mainmenu Fragment");
    }
    public LiveData<String> getText(){
        return mText;
    }
}
