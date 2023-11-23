package daniel.brian.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            //Accessing all the passwords
            EditText username = findViewById(R.id.username);
            EditText userPassword = findViewById(R.id.userpassword);
            EditText userRePassword = findViewById(R.id.userRepassword);
            Button Register = findViewById(R.id.btnregister);
            Button login = findViewById(R.id.login);
            DBHelper DB = new DBHelper(this);

            Register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String user = username.getText().toString();
                    String pass = userPassword.getText().toString();
                    String repass = userRePassword.getText().toString();

                   if(user.equals("") || pass.equals("") || repass.equals(""))
                       Toast.makeText(MainActivity.this,"Please enter all the fields",Toast.LENGTH_SHORT).show();
                   else{
                       if(pass.equals(repass)){
                           Boolean checkuser = DB.checkUsername(user);
                           if(checkuser == false){
                               Boolean insert = DB.insertData(user,pass);
                               if(insert == true){
                                   Toast.makeText(MainActivity.this,"Registered successfully",Toast.LENGTH_SHORT).show();
                                   Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                                   startActivity(intent);
                               }else{
                                   Toast.makeText(MainActivity.this,"Registration failed",Toast.LENGTH_SHORT).show();
                               }
                           }else{
                               Toast.makeText(MainActivity.this,"User already exists! Please sign In",Toast.LENGTH_SHORT).show();
                           }
                       }else{
                           Toast.makeText(MainActivity.this,"Passwords not matching",Toast.LENGTH_SHORT).show();
                       }
                   }
                }
            });

            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                 Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                 startActivity(intent);
                }
            });
    }
}