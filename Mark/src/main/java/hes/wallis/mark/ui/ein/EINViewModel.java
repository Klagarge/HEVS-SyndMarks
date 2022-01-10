package hes.wallis.mark.ui.ein;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EINViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public EINViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is EIN fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}