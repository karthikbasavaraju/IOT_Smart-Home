package io.github.hidroh.calendar;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Fragment2 extends Fragment {
    private static final String TAG = "Tab2Fragment";

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_fragment2,container,false);

        final ToggleButton btn = view.findViewById(R.id.Ac_status);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                DatabaseReference myRef = database.getReference("water_heater");
                //toggle.toggle();
                if ( btn.isChecked()) {
                    Toast.makeText(getActivity(), "On", Toast.LENGTH_SHORT).show();

                    myRef.setValue("true");
                }
                else {
                    Toast.makeText(getActivity(), "Off", Toast.LENGTH_SHORT).show();
                    myRef.setValue("false");
                }
            }
        });

        DatabaseReference waterHeaterButtonRef = FirebaseDatabase.getInstance().getReference("water_heater");
        // Read from the database
        waterHeaterButtonRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                if(value.equals("true"))
                    btn.setChecked(true);
                else
                    btn.setChecked(false);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        DatabaseReference waterHeaterCurTempRef = FirebaseDatabase.getInstance().getReference("water_heater_current_temperature");
        // Read from the database
        waterHeaterCurTempRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Double d = Double.parseDouble(value);
                TextView tv = view.findViewById(R.id.water_heater_current_value);
                tv.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        DatabaseReference waterHeaterTempTempRef = FirebaseDatabase.getInstance().getReference("water_heater_temperature_change");

        // Read from the database
        waterHeaterTempTempRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                TextView tv = view.findViewById(R.id.water_heater_temperature_change);
                tv.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        final TextView tv = view.findViewById(R.id.water_heater_temperature_change);
        ImageView decrease = view.findViewById(R.id.water_heater_decrease);

        decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double temp = Double.parseDouble(tv.getText().toString());
                temp = ((int)((temp-0.1)*10))/10.0;
                DatabaseReference myRef = database.getReference("water_heater_temperature_change");
                myRef.setValue(String.valueOf(temp));
                tv.setText(String.valueOf(temp));

            }
        });

        ImageView increase = view.findViewById(R.id.water_heater_increase);

        increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double temp = Double.parseDouble(tv.getText().toString());
                temp = ((int)((temp+0.1)*10))/10.0;
                DatabaseReference myRef = database.getReference("water_heater_temperature_change");
                myRef.setValue(String.valueOf(temp));
                tv.setText(String.valueOf(temp));
            }
        });




        return view;
    }

}
