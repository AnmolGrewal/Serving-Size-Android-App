package assignment1.anmol.servingsizecalculator;

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

//https://www.youtube.com/watch?v=eAPFgC9URqc Reference Brian Fraser Adapter Video
public class PotList extends AppCompatActivity {

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
                Toast.makeText(getApplicationContext(), "Starboard (right) is green", Toast.LENGTH_SHORT)
                        .show();
            }
        });

        populateListView();
        registerPotClick();
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
        //Initiating PotCollection as member
        PotCollection mainList = new PotCollection();
        Pot pot1 = new Pot("1", 5);

        mainList.addPot(pot1);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.items, mainList.getPotDescriptions());

        ListView listPot = findViewById(R.id.potListStuff);
        listPot.setAdapter(adapter);
    }
}
