package groep19.evaandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Login extends AppCompatActivity {


    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void LoginUser(View View)
    {
        // Gegevens ophalen uit gui
        String emailadres = ((EditText) findViewById(R.id.txtEmail)).getText().toString();
        String wachtwoord = ((EditText) findViewById(R.id.txtPassword)).getText().toString();

        // REST API CALL KOMT HIER

        Intent intent;
        if (emailadres.equals("test@test.com") && wachtwoord.equals("w8Woord!"))
        {
            intent = new Intent(this, Home.class);
        }
        else
        {
            intent = new Intent(this, Login.class);
        }
        startActivity(intent);
    }
}
