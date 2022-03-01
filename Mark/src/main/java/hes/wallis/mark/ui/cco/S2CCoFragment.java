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
import hes.wallis.mark.databinding.FragmentS2CcoBinding;


public class S2CCoFragment extends SubjectFragment {

    private S2CCoViewModel S2CCoViewModel;
    private FragmentS2CcoBinding binding;

    Double average;
    Marks averageSemester2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        S2CCoViewModel =
                new ViewModelProvider(this).get(S2CCoViewModel.class);

        binding = FragmentS2CcoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        S2CCoViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });

        Marks Project = new Marks(binding.Project);
        Marks semester = new Marks(binding.Semester);
        calculateAvg();
        averageSemester2 = new Marks(binding.AverageCCo, average);

        return root;
    }

    @Override
    public void calculateAvg(){
        average = CalculateAverageMarks.CCoS2();
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