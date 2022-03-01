package hes.wallis.mark.ui.electricity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class S2ElAViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public S2ElAViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is ElA fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}