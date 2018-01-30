package assignment1.anmol.servingsizecalculator;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import static assignment1.anmol.servingsizecalculator.PotAdd.POT_NAME;
import static assignment1.anmol.servingsizecalculator.PotAdd.WEIGHT_G;
import static assignment1.anmol.servingsizecalculator.PotList.POT_POSITION;

public class Servings extends AppCompatActivity {

    private static final String TAG = "UserClicks";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servings);

        final Intent potInfo = new Intent();

        final Intent intent = getIntent();
        String namePot = intent.getStringExtra(POT_NAME);
        final int potWeight = intent.getIntExtra(WEIGHT_G, 0);

        TextView potNameText = findViewById(R.id.potName);
        potNameText.setText(namePot);

        TextView potWeightText = findViewById(R.id.potWeight);
        potWeightText.setText("" + potWeight);

        //Back Button
        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Add Pot Button Pressed");
                setResult(Activity.RESULT_CANCELED, potInfo);
                finish();
            }
        });

        //Delete Button
        Button deleteButton = findViewById(R.id.deletePot);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Deleting Pot");
                int position = intent.getIntExtra(POT_POSITION, 0);
                potInfo.putExtra(POT_POSITION, position);
                setResult(69, potInfo);
                finish();
            }
        });

        final TextView foodWeightCalculate = findViewById(R.id.foodWeightCalculate);
        final EditText weightFood = findViewById(R.id.weightFood);
        weightFood.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(
                    CharSequence s, int start, int before, int count) {

                try
                {
                    if(Integer.parseInt(weightFood.getText().toString()) >= potWeight)
                    {
                        int weightJustFood = Integer.parseInt(weightFood.getText().toString()) - potWeight;
                        foodWeightCalculate.setText("" + weightJustFood);
                    }
                }
                catch(NumberFormatException nfe)
                {
                    //Do Nothing
                }
            }
            @Override
            public void afterTextChanged(Editable s) {


            }
        });

        final TextView servingWeight = findViewById(R.id.servingWeight);
        final EditText servingNumber = findViewById(R.id.servingNumber);
        servingNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(
                    CharSequence s, int start, int before, int count) {

                try
                {
                    if (Integer.parseInt(servingNumber.getText().toString()) > 0)
                    {
                        int servingWeightNumber = Integer.parseInt(foodWeightCalculate.getText().toString()) / Integer.parseInt(servingNumber.getText().toString());
                        servingWeight.setText("" + servingWeightNumber);
                    }
                }
                catch(NumberFormatException nfe)
                {
                    //Do Nothing
                }

            }
            @Override
            public void afterTextChanged(Editable s) {


            }
        });
    }
}
