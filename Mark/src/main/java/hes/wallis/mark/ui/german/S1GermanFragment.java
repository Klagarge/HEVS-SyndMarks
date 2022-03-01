package hes.wallis.mark.ui.german;

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
import hes.wallis.mark.databinding.FragmentS1GermanBinding;

public class S1GermanFragment extends SubjectFragment {

    private S1GermanViewModel s1GermanViewModel;
    private FragmentS1GermanBinding binding;

    Double average;
    Marks averageSemester1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        s1GermanViewModel =
                new ViewModelProvider(this).get(S1GermanViewModel.class);

        binding = FragmentS1GermanBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        s1GermanViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });

        Marks Exam1 = new Marks(binding.Exam1);
        Marks semester = new Marks(binding.Semester);
        calculateAvg();
        averageSemester1 = new Marks(binding.AverageGerman, average);

        return root;
    }

    @Override
     public void calculateAvg(){
        average = CalculateAverageMarks.GermanS1();
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