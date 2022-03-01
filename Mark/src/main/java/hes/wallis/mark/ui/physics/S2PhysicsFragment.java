package hes.wallis.mark.ui.physics;

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
import hes.wallis.mark.databinding.FragmentS2PhysicsBinding;

public class S2PhysicsFragment extends SubjectFragment {

    private S2PhysicsViewModel s2PhysicsViewModel;
    private FragmentS2PhysicsBinding binding;

    Double average;
    Marks averageSemester2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        s2PhysicsViewModel =
                new ViewModelProvider(this).get(S2PhysicsViewModel.class);

        binding = FragmentS2PhysicsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        s2PhysicsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) { }
        });

        Marks Exam1 = new Marks(binding.Exam1);
        Marks semester = new Marks(binding.Semester);
        calculateAvg();
        averageSemester2 = new Marks(binding.AveragePhysics, average);


        return root;
    }

    @Override
    public void calculateAvg(){
        average = CalculateAverageMarks.Physics();
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