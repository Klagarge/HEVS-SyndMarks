package hes.wallis.mark.ui.german;

import android.content.SyncStatusObserver;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import hes.wallis.mark.Average;
import hes.wallis.mark.MarkLine;
import hes.wallis.mark.Marks;
import hes.wallis.mark.SubjectFragment;
import hes.wallis.mark.databinding.FragmentGermanBinding;

public class GermanFragment extends SubjectFragment {

    private GermanViewModel germanViewModel;
    private FragmentGermanBinding binding;

    Double Exam1Mark;
    Double semesterMark;
    Double average;
    Marks Exam1;
    Marks semester;
    Marks averageSemester1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        germanViewModel =
                new ViewModelProvider(this).get(GermanViewModel.class);

        binding = FragmentGermanBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        germanViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });

        Exam1 = new Marks(binding.Exam1);
        semester = new Marks(binding.Semester);
        calculateAvg();
        averageSemester1 = new Marks(binding.AverageSemester1, average);

        return root;
    }

    @Override
    public void calculateAvg(){
        Exam1Mark = Exam1.GetMark();
        semesterMark = semester.GetMark();
        average = (Exam1Mark+semesterMark)/2.0;
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