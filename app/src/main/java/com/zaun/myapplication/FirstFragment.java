package com.zaun.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.zaun.myapplication.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {
    private FragmentFirstBinding binding;
    private Button btnLogin;
    private EditText inputLogin;
    private EditText inputPass;

    private void bindingView() {
        this.inputLogin = binding.inputLogin;
        this.inputPass = binding.inputPassword;
        this.btnLogin = binding.btnLogin;
    }

    private void bindingAction() {
        this.btnLogin.setOnClickListener(view1 -> login());
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindingView();
        bindingAction();

    }

    public void login() {
        if (inputLogin.getText().toString().equals("admin")
                && inputPass.getText().toString().equals("123456")) {
            Toast.makeText(getActivity(), "Login successfully", Toast.LENGTH_SHORT).show();
            NavHostFragment.findNavController(FirstFragment.this)
                    .navigate(R.id.action_Login_to_Home);
        } else {
            Toast.makeText(getActivity(), "Login failed", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}