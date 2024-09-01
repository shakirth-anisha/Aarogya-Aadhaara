package com.example.aarogyaaadhaara;
import com.example.aarogyaaadhaara.Person;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    private final List<Person> personList;

    public PersonAdapter(List<Person> personList) {
        this.personList = personList;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person, parent, false);
        return new PersonViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        Person person = personList.get(position);
        holder.imageView.setImageResource(person.getImageResId());
        holder.nameTextView.setText(person.getName());
        holder.ageTextView.setText(String.valueOf(person.getAge()));
        holder.genderTextView.setText(person.getGender());
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameTextView;
        TextView ageTextView;
        TextView genderTextView;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.personImage); // Ensure ID matches XML
            nameTextView = itemView.findViewById(R.id.personName);
            ageTextView = itemView.findViewById(R.id.personAge);
            genderTextView = itemView.findViewById(R.id.personGender);
        }
    }

}
