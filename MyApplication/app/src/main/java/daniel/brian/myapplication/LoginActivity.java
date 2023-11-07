package daniel.brian.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Accessing all the passwords
        EditText username = findViewById(R.id.username1);
        EditText userPassword = findViewById(R.id.userpassword1);
        Button login = findViewById(R.id.login1);
        DBHelper DB = new DBHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = userPassword.getText().toString();

                if(user.equals("") || pass.equals("")){
                    Toast.makeText(LoginActivity.this,"Please enter all the fields",Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkuserpass = DB.checkUsernamePassword(user,pass);
                    if(checkuserpass == true){
                        Toast.makeText(LoginActivity.this,"Sign in Successful",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(LoginActivity.this,"Invalid credentials",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}