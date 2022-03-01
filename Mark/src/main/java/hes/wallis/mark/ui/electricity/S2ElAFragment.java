package hes.wallis.mark.ui.electricity;

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
import hes.wallis.mark.databinding.FragmentS2ElaBinding;

public class S2ElAFragment extends SubjectFragment {

    private S2ElAViewModel s2ElAViewModel;
    private FragmentS2ElaBinding binding;

    Double average;
    Double averageLabs;
    Marks marksAverageLabs;
    Marks averageSemester2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        s2ElAViewModel =
                new ViewModelProvider(this).get(S2ElAViewModel.class);

        binding = FragmentS2ElaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        s2ElAViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {}
        });

        Marks Exam1 = new Marks(binding.Exam1);
        Marks Exam2 = new Marks(binding.Exam2);
        Marks Lab1 = new Marks(binding.Lab1);
        Marks Lab2 = new Marks(binding.Lab2);
        Marks Lab3 = new Marks(binding.Lab3);
        Marks Lab4 = new Marks(binding.Lab4);
        Marks Lab5 = new Marks(binding.Lab5);
        Marks Lab6 = new Marks(binding.Lab6);
        Marks Lab7 = new Marks(binding.Lab7);
        Marks Rapport = new Marks(binding.Rapport);
        Marks semester = new Marks(binding.Semester);
        calculateAvg();
        marksAverageLabs = new Marks(binding.AverageLabs, averageLabs);
        averageSemester2 = new Marks(binding.AverageElA, average);


        return root;
    }

    @Override
    public void calculateAvg(){
        averageLabs = CalculateAverageMarks.ElALabs();
        average = CalculateAverageMarks.ElA();
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