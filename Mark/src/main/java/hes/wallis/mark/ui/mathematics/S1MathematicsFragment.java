package hes.wallis.mark.ui.mathematics;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import hes.wallis.mark.CalculateAverageMarks;
import hes.wallis.mark.Marks;
import hes.wallis.mark.SubjectFragment;
import hes.wallis.mark.databinding.FragmentS1MathematicsBinding;

public class S1MathematicsFragment extends SubjectFragment {

    private S1MathematicsViewModel S1MathematicsViewModel;
    private FragmentS1MathematicsBinding binding;

    Double average;
    Marks averageSemester1;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        S1MathematicsViewModel =
                new ViewModelProvider(this).get(S1MathematicsViewModel.class);

        binding = FragmentS1MathematicsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        S1MathematicsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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
        average = CalculateAverageMarks.MathematicsS1();
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