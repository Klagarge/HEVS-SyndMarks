package hes.wallis.mark.ui.it;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import hes.wallis.mark.CalculateAverageMarks;
import hes.wallis.mark.Marks;
import hes.wallis.mark.SubjectFragment;
import hes.wallis.mark.databinding.FragmentItBinding;

public class ITFragment extends SubjectFragment {

    private ITViewModel ITViewModel;
    private FragmentItBinding binding;

    Double average;
    Marks averageSemester1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ITViewModel =
                new ViewModelProvider(this).get(ITViewModel.class);

        binding = FragmentItBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Marks Exam1 = new Marks(binding.Exam1);
        Marks Bonus1 = new Marks(binding.Bonus1, 43);
        Marks Bonus2 = new Marks(binding.Bonus2, 16);
        Marks Project = new Marks(binding.Project, 0);
        Marks semester = new Marks(binding.Semester);
        calculateAvg();
        averageSemester1 = new Marks(binding.AverageIT, average);

        return root;
    }

    @Override
    public void calculateAvg(){
        average = CalculateAverageMarks.IT();
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