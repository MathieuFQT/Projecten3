package groep19.evaandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void registerNewUser(View view){
        //Register a new user
        final Button registerBtn = (Button) findViewById(R.id.registerButton);
        registerBtn.setText("Proficiat!");
    }
}
