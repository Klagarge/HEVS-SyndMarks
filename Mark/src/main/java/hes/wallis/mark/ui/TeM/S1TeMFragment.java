package hes.wallis.mark.ui.TeM;

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
import hes.wallis.mark.databinding.FragmentS1TemBinding;


public class S1TeMFragment extends SubjectFragment {

    private S1TeMViewModel s1TeMViewModel;
    private FragmentS1TemBinding binding;

    Double average;
    Double avgRapports;
    Marks averageSemester1;
    Marks averageRapportsSemester1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        s1TeMViewModel =
                new ViewModelProvider(this).get(S1TeMViewModel.class);

        binding = FragmentS1TemBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        s1TeMViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });

        Marks Rapport1 = new Marks(binding.Rapport1);
        Marks Rapport2 = new Marks(binding.Rapport2);
        Marks Rapport3 = new Marks(binding.Rapport3);
        Marks Exam1 = new Marks(binding.Exam1);
        Marks semester = new Marks(binding.Semester);
        calculateAvg();
        averageSemester1 = new Marks(binding.AverageTeM, average);
        averageRapportsSemester1 = new Marks(binding.Rapports, avgRapports);

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