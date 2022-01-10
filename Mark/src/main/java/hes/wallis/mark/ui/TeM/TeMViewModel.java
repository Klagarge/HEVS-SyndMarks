package hes.wallis.mark.ui.TeM;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TeMViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TeMViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Mechanic fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}