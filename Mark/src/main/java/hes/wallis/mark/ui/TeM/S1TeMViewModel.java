package hes.wallis.mark.ui.TeM;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class S1TeMViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public S1TeMViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Mechanic fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}