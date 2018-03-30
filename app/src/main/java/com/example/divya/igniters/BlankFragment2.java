package com.example.divya.igniters;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class BlankFragment2 extends Fragment {

    public BlankFragment2() {
        // Required empty public constructor
    }
  EditText userName,password;
  Button   login,register;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        userName= getActivity().findViewById(R.id.username);
        password=getActivity().findViewById(R.id.password);
        login=getActivity().findViewById(R.id.login);
        return inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
    }


}
