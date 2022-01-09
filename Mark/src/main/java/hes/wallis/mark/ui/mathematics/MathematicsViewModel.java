package hes.wallis.mark.ui.mathematics;

import android.view.View;
import android.widget.Button;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import hes.wallis.mark.R;

public class MathematicsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MathematicsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("1er Semestre");
    }

    public LiveData<String> getText() {
        return mText;
    }
}