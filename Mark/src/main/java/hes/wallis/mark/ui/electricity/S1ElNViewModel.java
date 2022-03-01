package hes.wallis.mark.ui.electricity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class S1ElNViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public S1ElNViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is EIN fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}