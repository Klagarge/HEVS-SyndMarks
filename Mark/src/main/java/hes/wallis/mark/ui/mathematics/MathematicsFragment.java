package hes.wallis.mark.ui.mathematics;

import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import hes.wallis.mark.CalculateAverageMarks;
import hes.wallis.mark.Marks;
import hes.wallis.mark.R;
import hes.wallis.mark.SubjectFragment;
import hes.wallis.mark.TestIfMark;
import hes.wallis.mark.databinding.FragmentMathematicsBinding;

public class MathematicsFragment extends SubjectFragment {

    private hes.wallis.mark.ui.mathematics.MathematicsViewModel MathematicsViewModel;
    private FragmentMathematicsBinding binding;

    Double average;
    Marks averageSemester1;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MathematicsViewModel =
                new ViewModelProvider(this).get(MathematicsViewModel.class);

        binding = FragmentMathematicsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        MathematicsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });

        Marks Exam1 = new Marks(binding.Exam1);
        Marks Exam2 = new Marks(binding.Exam2);
        Marks semester = new Marks(binding.Semester);
        calculateAvg();
        averageSemester1 = new Marks(binding.AverageMathematics, average);

        return root;
    }


    @Override
    public void calculateAvg(){
        average = CalculateAverageMarks.Mathematics();
    }

    @Override
    public void refresh(){
        super.refresh();
        EditText output = averageSemester1.avg.outputMark;
        output.setText(average.toString());
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}