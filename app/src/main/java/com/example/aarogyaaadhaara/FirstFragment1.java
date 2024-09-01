package com.example.aarogyaaadhaara;

import com.example.aarogyaaadhaara.Person;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment1 extends Fragment {

    private RecyclerView recyclerView;
    private PersonAdapter adapter;
    private List<Person> personList;
    private Button btnAdd;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        btnAdd = view.findViewById(R.id.btnAdd);

        // Initialize personList with your own Person class
        personList = new ArrayList<>();
        adapter = new PersonAdapter(personList);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(adapter);

        btnAdd.setOnClickListener(v -> showAddPersonDialog());

        // Add initial data
        addPerson(new Person(R.drawable.user, "Ani", 18, "Female"));
        addPerson(new Person(R.drawable.user, "Suchi", 19, "Female"));
        addPerson(new Person(R.drawable.user, "Adi", 62, "Male"));
        addPerson(new Person(R.drawable.user, "Sid", 7, "Male"));
        addPerson(new Person(R.drawable.user, "Sid", 7, "Male"));
        return view;
    }

    private void showAddPersonDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_add_person, null);
        builder.setView(dialogView);

        EditText etName = dialogView.findViewById(R.id.etName);
        EditText etAge = dialogView.findViewById(R.id.etAge);
        EditText etGender = dialogView.findViewById(R.id.etGender);

        builder.setTitle("Add Person")
                .setPositiveButton("Add", (dialog, which) -> {
                    String name = etName.getText().toString();
                    int age = Integer.parseInt(etAge.getText().toString());
                    String gender = etGender.getText().toString();

                    addPerson(new Person(R.drawable.user, name, age, gender));
                })
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    private void addPerson(Person person) {
        personList.add(person);
        adapter.notifyItemInserted(personList.size() - 1);
    }
}
