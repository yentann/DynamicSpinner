package com.example.a17045679.dynamicspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner Spinner1;
    Button btn1;
    Spinner Spinner2;

    ArrayList<String> alNumbers;
    ArrayAdapter<String> aaNumbers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner1 = findViewById(R.id.spinner1);
        btn1 = findViewById(R.id.buttonUpdate);
        Spinner2 = findViewById(R.id.spinner2);


        //Initialise the ArrayList
        alNumbers = new ArrayList<>();

        //Create an ArrayAdapter using the default Spinner layout and the ArrayList
        aaNumbers = new ArrayAdapter (this,android.R.layout.simple_spinner_dropdown_item, alNumbers);


        //Bind the ArrayList to the Spinner
        Spinner2.setAdapter(aaNumbers);



        //the Spinner1 (even and odd) numbers
        ArrayAdapter<String> spinnerArrayAdapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.number_types));
        spinnerArrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        Spinner1.setAdapter(spinnerArrayAdapter1);

        //Get the string-array and store as an Array
        final String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
        final String[] strNumbers1 = getResources().getStringArray(R.array.odd_numbers);


        //Implement the button onClick() method
        //to load the correct number list when it is clicked
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = Spinner1.getSelectedItemPosition();
                alNumbers.clear();


                if (pos == 0) {
                    //Convert Array to List and add to the ArrayList
                    alNumbers.addAll(Arrays.asList(strNumbers));
                }
                else  {
                    //Convert Array to List and add to the ArrayList
                    alNumbers.addAll(Arrays.asList(strNumbers1));
                }


            }
        });












    }
}
