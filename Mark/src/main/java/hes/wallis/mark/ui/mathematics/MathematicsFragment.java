package hes.wallis.mark.ui.mathematics;

import android.os.Bundle;
import android.text.InputFilter;
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

import hes.wallis.mark.Marks;
import hes.wallis.mark.R;
import hes.wallis.mark.TestIfMark;
import hes.wallis.mark.databinding.FragmentMathematicsBinding;

public class MathematicsFragment extends Fragment {

    private hes.wallis.mark.ui.mathematics.MathematicsViewModel MathematicsViewModel;
    private FragmentMathematicsBinding binding;

    public EditText RankS1mathExam1;
    public EditText RankS1mathExam2;
    public EditText RankS1mathExam3;
    public Button PbS1mathExam1;
    public Button PbS1mathExam2;
    public Button PbS1mathExam3;

    Double S1mathExam1;
    Double S1mathExam2;
    Double S1mathExam3;

    //final String DEFAULT_RANK = getString(R.string.defaultMark);


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MathematicsViewModel =
                new ViewModelProvider(this).get(MathematicsViewModel.class);

        binding = FragmentMathematicsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textMath;

        // Define and describe text for ranks
        final TextView TextS1MathExam1 = binding.textS1mathExam1;
        final TextView TextS1MathExam2 = binding.textS1mathExam2;
        final TextView TextS1MathExam3 = binding.textS1mathExam3;
        TextS1MathExam1.setText("First exam:");
        TextS1MathExam2.setText("Second exam:");
        TextS1MathExam3.setText("Semester exam:");

        //Define buttons
        PbS1mathExam1 = binding.PbS1mathExam1;
        PbS1mathExam2 = binding.PbS1mathExam2;
        PbS1mathExam3 = binding.PbS1mathExam3;

        // Define, add filters and name for input ranks
        RankS1mathExam1 = binding.RankS1mathExam1;
        RankS1mathExam2 = binding.RankS1mathExam2;
        RankS1mathExam3 = binding.RankS1mathExam3;
        RankS1mathExam1.setFilters(new InputFilter[] {new TestIfMark()});
        RankS1mathExam1.setHint(Marks.toHing(PbS1mathExam1, "mark"));
        RankS1mathExam2.setFilters(new InputFilter[] {new TestIfMark()});
        RankS1mathExam2.setHint(Marks.toHing(PbS1mathExam2, "mark"));
        RankS1mathExam3.setFilters(new InputFilter[] {new TestIfMark()});
        RankS1mathExam3.setHint(Marks.toHing(PbS1mathExam3, "mark"));

        if(!RankS1mathExam1.getText().toString().equals("mark"))S1mathExam1 = Marks.PbPressed(PbS1mathExam1, RankS1mathExam1);


        PbS1mathExam1.setOnClickListener(view -> S1mathExam1 = Marks.PbPressed(PbS1mathExam1, RankS1mathExam1));
        PbS1mathExam2.setOnClickListener(view -> S1mathExam2 = Marks.PbPressed(PbS1mathExam2, RankS1mathExam2));
        PbS1mathExam3.setOnClickListener(view -> S1mathExam3 = Marks.PbPressed(PbS1mathExam3, RankS1mathExam3));


        MathematicsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}