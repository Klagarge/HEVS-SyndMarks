package hes.wallis.mark.ui.electricity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import hes.wallis.mark.databinding.FragmentElectricityBinding;

public class ElectricityFragment extends Fragment {

    private ElectricityViewModel electricityViewModel;
    private FragmentElectricityBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        electricityViewModel =
                new ViewModelProvider(this).get(ElectricityViewModel.class);

        binding = FragmentElectricityBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textElectricity;
        electricityViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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