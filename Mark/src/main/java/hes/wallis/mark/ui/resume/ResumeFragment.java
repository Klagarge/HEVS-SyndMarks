package hes.wallis.mark.ui.resume;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

import hes.wallis.mark.CalculateAverageMarks;
import hes.wallis.mark.MainActivityRank;
import hes.wallis.mark.Marks;
import hes.wallis.mark.SubjectFragment;
import hes.wallis.mark.databinding.FragmentResumeBinding;

public class ResumeFragment extends SubjectFragment {

    private ResumeViewModel resumeViewModel;
    private FragmentResumeBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        resumeViewModel =
                new ViewModelProvider(this).get(ResumeViewModel.class);

        binding = FragmentResumeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Marks german = new Marks(binding.German, CalculateAverageMarks.German());

        Marks mathematics = new Marks(binding.Mathematics, CalculateAverageMarks.Mathematics());
        Marks it = new Marks(binding.IT, CalculateAverageMarks.IT());
        Marks physic = new Marks(binding.Physic, CalculateAverageMarks.Physics());
        TextView science = binding.avgScience;
        science.setText("Average: " + CalculateAverageMarks.Science());

        Marks mechanic = new Marks(binding.Mecanic, CalculateAverageMarks.Mechanic());
        Marks electricity = new Marks(binding.Electricity, CalculateAverageMarks.Electricity());
        TextView business = binding.avgBusiness;
        business.setText("Average: " + CalculateAverageMarks.Business());

        return root;
    }

    @Override
    public void calculateAvg(){

    }
    @Override
    public void refresh(){
        super.refresh();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}