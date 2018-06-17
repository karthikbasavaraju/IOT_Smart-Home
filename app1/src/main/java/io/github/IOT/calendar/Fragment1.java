package io.github.IOT.calendar;

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
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Fragment1 extends Fragment {


    static Boolean isTouched1 = false;
    static Boolean isTouched2 = false;
    static Boolean isTouched3 = false;
    private static final String TAG = "Tab1Fragment";
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private Button btnTEST;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment1,container,false);
        /*btnTEST = (Button) view.findViewById(R.id.button);

        btnTEST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "TESTING BUTTON CLICK 1",Toast.LENGTH_SHORT).show();
            }
        });*/


        final SwitchCompat switchCompat1 = view.findViewById(R.id.light_status_switch1);


        switchCompat1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                isTouched1 = true;
                return false;
            }
        });

        switchCompat1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isTouched1) {
                    isTouched1 = false;
                    if (isChecked) {
                        Toast.makeText(getActivity(),"On",Toast.LENGTH_SHORT).show();
                        // Write a message to the database

                        DatabaseReference myRef = database.getReference("light1");

                        myRef.setValue("true");
                    }
                    else {

                        DatabaseReference myRef = database.getReference("light1");

                        myRef.setValue("false");
                    }
                }
            }
        });



        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("light1");
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                if(value.equals("true"))
                    switchCompat1.setChecked(true);
                else
                    switchCompat1.setChecked(false);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });





        final SwitchCompat switchCompat2 = view.findViewById(R.id.light_status_switch2);


        switchCompat2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                isTouched2 = true;
                return false;
            }
        });

        switchCompat2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isTouched2) {
                    isTouched2 = false;
                    if (isChecked) {
                        Toast.makeText(getActivity(),"On",Toast.LENGTH_SHORT).show();
                        // Write a message to the database

                        DatabaseReference myRef = database.getReference("light2");

                        myRef.setValue("true");
                    }
                    else {

                        DatabaseReference myRef = database.getReference("light2");

                        myRef.setValue("false");
                    }
                }
            }
        });



        DatabaseReference myRef2 = FirebaseDatabase.getInstance().getReference("light2");
        // Read from the database
        myRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                if(value.equals("true"))
                    switchCompat2.setChecked(true);
                else
                    switchCompat2.setChecked(false);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });




        final SwitchCompat switchCompat3 = view.findViewById(R.id.light_status_switch3);


        switchCompat3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                isTouched3 = true;
                return false;
            }
        });

        switchCompat3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isTouched3) {
                    isTouched3 = false;
                    if (isChecked) {
                        Toast.makeText(getActivity(),"On",Toast.LENGTH_SHORT).show();
                        // Write a message to the database

                        DatabaseReference myRef = database.getReference("light3");

                        myRef.setValue("true");
                    }
                    else {

                        DatabaseReference myRef = database.getReference("light3");

                        myRef.setValue("false");
                    }
                }
            }
        });



        DatabaseReference myRef3 = FirebaseDatabase.getInstance().getReference("light3");
        // Read from the database
        myRef3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                if(value.equals("true"))
                    switchCompat3.setChecked(true);
                else
                    switchCompat3.setChecked(false);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        return view;


    }

}
