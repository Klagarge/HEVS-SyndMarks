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
import hes.wallis.mark.databinding.FragmentItBinding;

public class ITFragment extends SubjectFragment {

    private ITViewModel ITViewModel;
    private FragmentItBinding binding;

    Double average;
    Double bonusS1;
    Marks averageSemester1;
    Marks ITBonusS1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ITViewModel =
                new ViewModelProvider(this).get(ITViewModel.class);

        binding = FragmentItBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Marks Exam1 = new Marks(binding.Exam1);
        Marks Bonus1 = new Marks(binding.Bonus1, 43);
        Marks Bonus2 = new Marks(binding.Bonus2, 16);
        Marks Project = new Marks(binding.Project, 13);
        Marks semester = new Marks(binding.Semester);
        calculateAvg();
        averageSemester1 = new Marks(binding.AverageIT, average);
        ITBonusS1 = new Marks(binding.Bonus, bonusS1);

        return root;
    }

    @Override
    public void calculateAvg(){
        average = CalculateAverageMarks.IT();
        bonusS1 = CalculateAverageMarks.ITbonus();
    }

    @Override
    public void refresh(){
        super.refresh();
        EditText output = averageSemester1.avg.outputMark;
        output.setText(average.toString());
        Log.i("DebugHER", "Average IT: " + average);
        EditText bonus = ITBonusS1.avg.outputMark;
        bonus.setText(bonusS1.toString());
        Log.i("DebugHER", "Bonus IT: " + bonusS1);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}