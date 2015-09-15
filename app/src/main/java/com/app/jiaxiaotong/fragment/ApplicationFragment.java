package com.app.jiaxiaotong.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.jiaxiaotong.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link ApplicationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ApplicationFragment extends Fragment implements View.OnClickListener{

    public static ApplicationFragment newInstance() {
        ApplicationFragment fragment = new ApplicationFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public ApplicationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_application, container, false);
        initView(view);
        return view ;
        
    }

    private void initView(View view) {
        View checkInLayout = view.findViewById(R.id.application_checking_in_layout);
        View  consumeLayout = view.findViewById(R.id.application_consume_layout);
        View classNoticeLayout = view.findViewById(R.id.application_class_notice_layout);
        checkInLayout.setOnClickListener(this);
        consumeLayout.setOnClickListener(this);
        classNoticeLayout.setOnClickListener(this);
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.application_checking_in_layout:

                break;
            case R.id.application_class_notice_layout:

                break;
            case R.id.application_consume_layout:

                break;
        }
    }
}
