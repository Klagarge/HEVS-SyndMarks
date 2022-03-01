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
import hes.wallis.mark.databinding.FragmentS2GermanBinding;

public class S2GermanFragment extends SubjectFragment {

    private S2GermanViewModel s2GermanViewModel;
    private FragmentS2GermanBinding binding;

    Double average;
    Marks averageSemester2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        s2GermanViewModel =
                new ViewModelProvider(this).get(S2GermanViewModel.class);

        binding = FragmentS2GermanBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        s2GermanViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });

        Marks Project = new Marks(binding.Project);
        Marks Exam1 = new Marks(binding.Exam1);
        Marks semester = new Marks(binding.Semester);
        calculateAvg();
        averageSemester2 = new Marks(binding.AverageGerman, average);

        return root;
    }

    @Override
     public void calculateAvg(){
        average = CalculateAverageMarks.GermanS2();
    }
    @Override
    public void refresh(){
        super.refresh();
        EditText output = averageSemester2.avg.outputMark;
        output.setText(average.toString());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}