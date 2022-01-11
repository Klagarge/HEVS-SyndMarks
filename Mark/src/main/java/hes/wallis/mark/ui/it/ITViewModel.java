package hes.wallis.mark.ui.it;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ITViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ITViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Informatic fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}