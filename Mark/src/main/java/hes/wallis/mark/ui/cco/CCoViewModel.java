package hes.wallis.mark.ui.cco;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CCoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CCoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Mechanic fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}