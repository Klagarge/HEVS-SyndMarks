package hes.wallis.mark.ui.it;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

import hes.wallis.mark.CalculateAverageMarks;
import hes.wallis.mark.Marks;
import hes.wallis.mark.SubjectFragment;
import hes.wallis.mark.databinding.FragmentS1ItBinding;

public class S1ITFragment extends SubjectFragment {

    private S1ITViewModel S1ITViewModel;
    private FragmentS1ItBinding binding;

    Double average;
    Marks averageSemester1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        S1ITViewModel =
                new ViewModelProvider(this).get(S1ITViewModel.class);

        binding = FragmentS1ItBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Marks Exam1 = new Marks(binding.Exam1);
        Marks Bonus = new Marks(binding.Bonus, 1);
        Marks semester = new Marks(binding.Semester);
        calculateAvg();
        averageSemester1 = new Marks(binding.AverageIT, average);

        return root;
    }

    @Override
    public void calculateAvg(){
        average = CalculateAverageMarks.ITS1();
    }

    @Override
    public void refresh(){
        super.refresh();
        EditText output = averageSemester1.avg.outputMark;
        output.setText(average.toString());
        Log.i("DebugHER", "Average IT: " + average);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}