package hes.wallis.mark.ui.informatics;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InformaticsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public InformaticsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Informatic fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}