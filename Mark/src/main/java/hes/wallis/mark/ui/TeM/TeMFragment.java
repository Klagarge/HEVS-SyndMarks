package hes.wallis.mark.ui.TeM;

import android.os.Bundle;
import android.util.Log;
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
import hes.wallis.mark.databinding.FragmentTemBinding;


public class TeMFragment extends SubjectFragment {

    private TeMViewModel teMViewModel;
    private FragmentTemBinding binding;

    Double average;
    Double avgRapports;
    Marks averageSemester1;
    Marks averageRapportsSemester1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        teMViewModel =
                new ViewModelProvider(this).get(TeMViewModel.class);

        binding = FragmentTemBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        teMViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });

        Marks Rapport1 = new Marks(binding.Rapport1);
        Marks Rapport2 = new Marks(binding.Rapport2);
        Marks Rapport3 = new Marks(binding.Rapport2);
        Marks Exam1 = new Marks(binding.Exam1);
        Marks semester = new Marks(binding.Semester);
        calculateAvg();
        averageSemester1 = new Marks(binding.AverageTeM, average);

        return root;
    }

    @Override
    public void calculateAvg(){
        average = CalculateAverageMarks.TeM();
        avgRapports = CalculateAverageMarks.TeMrapports();
    }

    @Override
    public void refresh(){
        super.refresh();
        EditText output = averageSemester1.avg.outputMark;
        output.setText(average.toString());
        EditText rapports = averageRapportsSemester1.avg.outputMark;
        rapports.setText(avgRapports.toString());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}