package hes.wallis.mark.ui.mechanic;

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

import hes.wallis.mark.databinding.FragmentMechanicBinding;

public class MechanicFragment extends Fragment {

    private MechanicViewModel mechanicViewModel;
    private FragmentMechanicBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mechanicViewModel =
                new ViewModelProvider(this).get(MechanicViewModel.class);

        binding = FragmentMechanicBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textMechanic;
        mechanicViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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