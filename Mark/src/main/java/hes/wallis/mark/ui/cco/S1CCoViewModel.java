package hes.wallis.mark.ui.cco;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class S1CCoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public S1CCoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Mechanic fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}