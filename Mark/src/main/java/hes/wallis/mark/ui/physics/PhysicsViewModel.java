package hes.wallis.mark.ui.physics;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PhysicsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PhysicsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Physic fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}