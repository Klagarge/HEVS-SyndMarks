package hes.wallis.mark.ui.german;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GermanViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GermanViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is German fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}