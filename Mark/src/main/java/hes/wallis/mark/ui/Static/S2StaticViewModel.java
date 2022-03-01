package hes.wallis.mark.ui.Static;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class S2StaticViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public S2StaticViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Static fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}