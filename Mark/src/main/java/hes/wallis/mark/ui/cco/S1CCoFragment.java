package hes.wallis.mark.ui.cco;

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
import hes.wallis.mark.databinding.FragmentS1CcoBinding;


public class S1CCoFragment extends SubjectFragment {

    private S1CCoViewModel S1CCoViewModel;
    private FragmentS1CcoBinding binding;

    Double average;
    Marks averageSemester1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        S1CCoViewModel =
                new ViewModelProvider(this).get(S1CCoViewModel.class);

        binding = FragmentS1CcoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        S1CCoViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });

        Marks Exam1 = new Marks(binding.Exam1);
        Marks Project = new Marks(binding.Project);
        Marks semester = new Marks(binding.Semester);
        calculateAvg();
        averageSemester1 = new Marks(binding.AverageCCo, average);

        return root;
    }

    @Override
    public void calculateAvg(){
        average = CalculateAverageMarks.CCoS1();
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