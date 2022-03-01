package hes.wallis.mark.ui.mathematics;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class S2MathematicsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public S2MathematicsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("2eme Semestre");
    }

    public LiveData<String> getText() {
        return mText;
    }
}