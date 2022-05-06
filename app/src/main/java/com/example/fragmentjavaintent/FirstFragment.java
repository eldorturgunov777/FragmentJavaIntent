package com.example.fragmentjavaintent;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FirstFragment extends Fragment {
    private FirstListener listener;
    TextView tv_first;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        initViews(view);
        return view;
    }
    void initViews(View view){
        tv_first = view.findViewById(R.id.tv_first);
        Button b_first = view.findViewById(R.id.b_first);
        b_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onFirstSend(new User(15,"456"));
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof  FirstListener){
            listener = (FirstListener) context;
        }else{
            throw new RuntimeException(context.toString() + " must implement FirstListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public void updateFirstText(String str){
        tv_first.setText(str);
    }

    public interface FirstListener{
        void onFirstSend(User user);
    }
}