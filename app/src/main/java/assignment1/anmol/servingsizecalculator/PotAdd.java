package assignment1.anmol.servingsizecalculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static assignment1.anmol.servingsizecalculator.PotList.RESULTCODE_ADDPOT;

public class PotAdd extends AppCompatActivity {

    private static final String TAG = "UserClicks";
    public static final String WEIGHT_G = "weight_g";
    public static final String POT_NAME = "pot_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pot_add);

        final EditText namePot = findViewById(R.id.potNameInput);
        final EditText weightPot = findViewById(R.id.potInput);
        final Intent potInfo = new Intent();

        Button ok = findViewById(R.id.okButton);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Okay Button Pressed");
                try {
                    if (namePot.getText().toString().length() < 1) {
                        Toast.makeText(getApplicationContext(), "Pot name must at least have 1 character", Toast.LENGTH_SHORT)
                                .show();
                    } else {
                        String nameOfPot = namePot.getText().toString();
                        int weightPotInG = Integer.parseInt(weightPot.getText().toString());
                        Intent potInfo = new Intent();
                        potInfo.putExtra(POT_NAME, nameOfPot);
                        potInfo.putExtra(WEIGHT_G, weightPotInG);
                        setResult(RESULTCODE_ADDPOT, potInfo);
                        finish();
                    }
                }
                catch(NumberFormatException nfe)
                {
                    Toast.makeText(getApplicationContext(), "Weight Of Pot must be greater than or equal to 0", Toast.LENGTH_SHORT)
                            .show();
                }

            }
        });

        Button cancel = findViewById(R.id.cancelButton);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Cancel Button Pressed");
                setResult(Activity.RESULT_CANCELED, potInfo);
                finish();
            }
        });


    }
}
