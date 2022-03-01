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
import hes.wallis.mark.databinding.FragmentS2ItBinding;

public class S2ITFragment extends SubjectFragment {

    private S2ITViewModel S1ITViewModel;
    private FragmentS2ItBinding binding;

    Double average;
    Marks averageSemester2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        S1ITViewModel =
                new ViewModelProvider(this).get(S2ITViewModel.class);

        binding = FragmentS2ItBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Marks Exam1 = new Marks(binding.Exam1);
        Marks project = new Marks(binding.Project);
        Marks Bonus = new Marks(binding.Bonus, 1);
        calculateAvg();
        averageSemester2 = new Marks(binding.AverageIT, average);

        return root;
    }

    @Override
    public void calculateAvg(){
        average = CalculateAverageMarks.ITS2();
    }

    @Override
    public void refresh(){
        super.refresh();
        EditText output = averageSemester2.avg.outputMark;
        output.setText(average.toString());
        Log.i("DebugHER", "Average IT: " + average);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}