package hes.wallis.mark.ui.ein;

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
import hes.wallis.mark.databinding.FragmentEinBinding;

public class EINFragment extends SubjectFragment {

    private EINViewModel einViewModel;
    private FragmentEinBinding binding;

    Double average;
    Marks averageSemester1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        einViewModel =
                new ViewModelProvider(this).get(EINViewModel.class);

        binding = FragmentEinBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        einViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {}
        });

        Marks Exam1 = new Marks(binding.Exam1);
        Marks Exam2 = new Marks(binding.Exam2);
        Marks Project = new Marks(binding.Project);
        Marks semester = new Marks(binding.Semester);
        calculateAvg();
        averageSemester1 = new Marks(binding.AverageEIN, average);


        return root;
    }

    @Override
    public void calculateAvg(){
        average = CalculateAverageMarks.EIN();
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