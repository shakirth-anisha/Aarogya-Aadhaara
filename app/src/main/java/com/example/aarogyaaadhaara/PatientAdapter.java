package com.example.aarogyaaadhaara;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.PatientViewHolder> {

    private List<Patient> patientList;
    private Context context;

    public PatientAdapter(List<Patient> patientList, Context context) {
        this.patientList = patientList;
        this.context = context;
    }

    @NonNull
    @Override
    public PatientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_patient, parent, false);
        return new PatientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PatientViewHolder holder, int position) {
        Patient patient = patientList.get(position);

        holder.nameTextView.setText(patient.getName());
        holder.ageTextView.setText(String.valueOf(patient.getAge()));
        holder.phoneTextView.setText(patient.getPhoneNumber());
        holder.dosesTextView.setText(patient.getDosesTakenFormatted());

        holder.readMoreButton.setOnClickListener(v -> showPatientDetailsDialog(patient));
    }

    @Override
    public int getItemCount() {
        return patientList.size();
    }

    private void showPatientDetailsDialog(Patient patient) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_patient_details, null);

        TextView nameTextView = dialogView.findViewById(R.id.nameTextView);
        TextView ageTextView = dialogView.findViewById(R.id.ageTextView);
        TextView phoneTextView = dialogView.findViewById(R.id.phoneTextView);

        nameTextView.setText(patient.getName());
        ageTextView.setText(String.valueOf(patient.getAge()));
        phoneTextView.setText(patient.getPhoneNumber());

        ViewGroup medicineContainer = dialogView.findViewById(R.id.medicineContainer);
        for (Medicine medicine : patient.getMedicines()) {
            View medicineView = LayoutInflater.from(context).inflate(R.layout.item_medicine, medicineContainer, false);

            TextView medicineNameTextView = medicineView.findViewById(R.id.medicineName);
            TextView medicineDosesTextView = medicineView.findViewById(R.id.medicineDoses);
            TextView issuedDateTextView = medicineView.findViewById(R.id.issuedDate);
            TextView expiryDateTextView = medicineView.findViewById(R.id.expiryDate);
            TextView sideEffectsTextView = medicineView.findViewById(R.id.sideEffects);

            medicineNameTextView.setText(medicine.getName());
            medicineDosesTextView.setText(medicine.getDosesTakenFormatted());
            issuedDateTextView.setText(medicine.getDateIssued());
            expiryDateTextView.setText(medicine.getExpirationDate());
            sideEffectsTextView.setText(medicine.getSideEffects());

            medicineContainer.addView(medicineView);
        }

        builder.setView(dialogView);
        builder.setPositiveButton("Close", null);
        builder.show();
    }

    static class PatientViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, ageTextView, phoneTextView, dosesTextView;
        View readMoreButton;

        PatientViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.patientName);
            ageTextView = itemView.findViewById(R.id.patientAge);
            phoneTextView = itemView.findViewById(R.id.patientPhone);
            dosesTextView = itemView.findViewById(R.id.patientDoses);
            readMoreButton = itemView.findViewById(R.id.readMoreButton);
        }
    }
}
