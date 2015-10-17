package groep19.evaandroid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;


public class VragenLijstAfterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RelativeLayout layout=(RelativeLayout)findViewById(R.id.layVragenLst);

        setContentView(layout);

        // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        fillSpinners(layout);


    }


    public void fillSpinners(RelativeLayout layout)
    {

        int spinNr=0,spinID,awnserID;

        String spinName;
        String awnserName;

        View v;

        for(int i=0; i<layout.getChildCount();i++)
        {
            v=layout.getChildAt(i);

            if(v instanceof Spinner) {
                spinNr++;
                spinName="question"+spinNr+"After";
                awnserName="question"+spinNr+"AwnsersAft";

                spinID= Integer.parseInt(spinName);
                awnserID= Integer.parseInt(awnserName);

                Spinner spinner =(Spinner) findViewById(spinID);

                // Create an ArrayAdapter using the string array and a default spinner layout
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,awnserID, android.R.layout.simple_spinner_item);
                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                // Apply the adapter to the spinner
                spinner.setAdapter(adapter);


            }



        }

    }




}
