package hes.wallis.mark.ui.Static;

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
import hes.wallis.mark.databinding.FragmentS2StaticBinding;


public class S2StaticFragment extends SubjectFragment {

    private S2StaticViewModel s2StaticViewModel;
    private FragmentS2StaticBinding binding;

    Double average;
    Marks averageSemester2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        s2StaticViewModel =
                new ViewModelProvider(this).get(S2StaticViewModel.class);

        binding = FragmentS2StaticBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        s2StaticViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });

        Marks Exam1 = new Marks(binding.Exam1);
        Marks semester = new Marks(binding.Semester);
        calculateAvg();
        averageSemester2 = new Marks(binding.AverageStatic, average);

        return root;
    }

    @Override
    public void calculateAvg(){
        average = CalculateAverageMarks.Static();
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