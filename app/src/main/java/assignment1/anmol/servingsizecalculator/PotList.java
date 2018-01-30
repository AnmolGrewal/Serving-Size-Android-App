package assignment1.anmol.servingsizecalculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static assignment1.anmol.servingsizecalculator.PotAdd.POT_NAME;
import static assignment1.anmol.servingsizecalculator.PotAdd.WEIGHT_G;

//https://www.youtube.com/watch?v=eAPFgC9URqc Reference Brian Fraser Adapter Video
public class PotList extends AppCompatActivity {

    public static final int RESULTCODE_ADDPOT = 40;
    PotCollection mainList = new PotCollection();
    private static final String TAG = "UserClicks";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.potlist);

        //Add Pot Stuff
        Button addPotButton = findViewById(R.id.addPotButton);
        addPotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Add Pot Button Pressed");
                Intent swapAddPot = new Intent(PotList.this, PotAdd.class);
                startActivityForResult(swapAddPot, RESULTCODE_ADDPOT);

            }
        });

        populateListView();
        registerPotClick();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == Activity.RESULT_CANCELED)
            return;

        switch(requestCode) {
            case RESULTCODE_ADDPOT:
                String potName = data.getStringExtra("Pot Name");
                Toast.makeText(getApplicationContext(), potName, Toast.LENGTH_SHORT)
                        .show();
                mainList.addPot(getPotFromIntent(data));
                populateListView();
        }
    }

    public static Pot getPotFromIntent(Intent data)
    {
        String potName = data.getStringExtra(POT_NAME);
        int weightInG = data.getIntExtra(WEIGHT_G, 0);
        return (new Pot(potName, weightInG));
    }

    private void registerPotClick() {
        ListView listPot = findViewById(R.id.potListStuff);
        listPot.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView textView = (TextView) viewClicked;
                String message = textView.getText().toString();
            }
        });
    }

    private void populateListView() {
        Pot pot1 = new Pot("1", 5);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.items, mainList.getPotDescriptions());

        ListView listPot = findViewById(R.id.potListStuff);
        listPot.setAdapter(adapter);
    }
}
