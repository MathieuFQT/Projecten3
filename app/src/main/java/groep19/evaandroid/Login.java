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
import android.widget.Toast;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.Bind;
import butterknife.ButterKnife;
//import groep19.evaandroid.REST.RestApiCall;

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
        String emailadresApp = ((EditText) findViewById(R.id.txtEmail)).getText().toString();
        String wachtwoordApp = ((EditText) findViewById(R.id.txtPassword)).getText().toString();

        // Geheugenplaatsen voorzien om emailadres en wachtwoord van REST api in op te slaan
        String emailadresRest = "";
        String wachtwoordRest = "";

        // Code om inloggen te doen werken zonder API
        boolean emailadresBestaat = emailadresApp.equals("test@test.com");
        String wachtwoordDb = "w8Woord!";

        // Code om inloggen te doen werken met API
        // http://stackoverflow.com/questions/28549315/login-example-in-android-using-post-method-using-rest-api
        // op te roepen methode : /api/login
        Ion.with(getApplicationContext())
                .load("http://localhost:3000/api/login")
                .setBodyParameter("mail", emailadresApp)
                .setBodyParameter("wachtwoord", wachtwoordApp)
                .asString()
                .setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String result) {
                        try {
                            JSONObject json = new JSONObject(result);    // Converts the string "result" to a JSONObject
                            String json_result = json.getString("status"); // Get the string "result" inside the Json-object
                            if (json_result.equalsIgnoreCase("200")){ // Checks if the "result"-string is equals to "ok"
                                String log = ("test");
                                // Result is "OK"
                            } else {
                                // Result is NOT "OK"

                            }
                        } catch (JSONException ex){
                            // This method will run if something goes wrong with the json, like a typo to the json-key or a broken JSON.

                        }
                    }
                });

        // body uit response object halen en uitlezen


        // Wachtwoord valideren en object om te gaan naar het volgend scherm klaarzetten
        Intent intent;
        if (emailadresBestaat && wachtwoordApp.equals(wachtwoordDb))
        {
            intent = new Intent(this, Home.class);
        }
        else
        {
            intent = new Intent(this, Login.class);
        }

        // Doorsturen naar het juiste scherm
        startActivity(intent);
    }



}
