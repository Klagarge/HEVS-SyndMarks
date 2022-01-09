package hes.wallis.mark.ui.electricity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ElectricityViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ElectricityViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Electricity fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}