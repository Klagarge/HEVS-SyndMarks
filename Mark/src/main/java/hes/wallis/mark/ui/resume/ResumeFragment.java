package hes.wallis.mark.ui.resume;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import hes.wallis.mark.CalculateAverageMarks;
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


        resumeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });

        Double avgGerman = CalculateAverageMarks.German();
        Double avgMath = CalculateAverageMarks.Mathematics();
        Double avgIT = CalculateAverageMarks.IT();
        Double avgPhysic = CalculateAverageMarks.Physic();
        Double avgSciences = CalculateAverageMarks.Science();
        Double avgMechanic = CalculateAverageMarks.Mechanic();
        Double avgElectricity = CalculateAverageMarks.Electricity();
        Double avgBusiness = CalculateAverageMarks.Business();


        Marks german = new Marks(binding.German, Marks.aroundDemi(avgGerman));
        Marks mathematics = new Marks(binding.Mathematics, avgMath);
        Marks it = new Marks(binding.IT, avgIT);
        //Marks physic = new Marks(binding.Physic, avgPhysic);
        Marks mechanic = new Marks(binding.Mecanic, avgMechanic);
        Marks electricity = new Marks(binding.Electricity, avgElectricity);

        TextView science = binding.avgScience;
        science.setText("Average: " + Marks.aroundDemi(avgSciences));
        TextView business = binding.avgBusiness;
        business.setText("Average: " + Marks.aroundDemi(avgBusiness));

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