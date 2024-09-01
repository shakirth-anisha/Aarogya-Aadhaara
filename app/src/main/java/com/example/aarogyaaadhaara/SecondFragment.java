package com.example.aarogyaaadhaara;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import android.os.Environment;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SecondFragment extends Fragment {

    private RecyclerView recyclerView;
    private PatientAdapter adapter;
    private List<Patient> patientList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recyclerViewPatients);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize patient list
        patientList = new ArrayList<>();
        List<Medicine> medicines1 = new ArrayList<>();
        medicines1.add(new Medicine("Medicine A", 60, 63, "01/01/2023", "01/01/2024", "Nausea"));
        medicines1.add(new Medicine("Medicine B", 30, 30, "02/01/2023", "02/01/2024", "Headache"));
        medicines1.add(new Medicine("Medicine C", 15, 15, "03/01/2023", "03/01/2024", "Drowsiness"));

        List<Medicine> medicines2 = new ArrayList<>();
        medicines2.add(new Medicine("Medicine X", 50, 63, "04/01/2023", "04/01/2024", "None"));
        medicines2.add(new Medicine("Medicine Y", 60, 63, "05/01/2023", "05/01/2024", "Dizziness"));

        patientList.add(new Patient(R.drawable.user, "Xaden",18, "123-456-7890", medicines1));
        patientList.add(new Patient(R.drawable.user, "Sid", 7, "987-654-3210", medicines2));

        // Set up adapter
        adapter = new PatientAdapter(patientList, getContext());
        recyclerView.setAdapter(adapter);

        return view;
    }
}
