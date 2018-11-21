package id.ac.uin_suka.learning.elearning;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username,password;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharePrefManager sharePrefManager = new SharePrefManager(this);

        if (sharePrefManager.getSPSudahLogin()){
            Intent baruIntent = new Intent(LoginActivity.this, Home.class);
            startActivity(baruIntent);
//            startActivity(new Intent(LoginActivity.this, Home.class)
//                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }

        username = (EditText)findViewById(R.id.et_login_nim);
        password = (EditText)findViewById(R.id.et_login_pass);
        btnLogin = (Button)findViewById(R.id.btn_login);

        btnLogin.setOnClickListener((v) -> {
            String usernameKey = username.getText().toString();
            String passwordKey = password.getText().toString();

            if (usernameKey.equals("1") && passwordKey.equals("test")){
                Toast.makeText(getApplicationContext(), "LOGIN SUKSE", Toast.LENGTH_SHORT).show();

                sharePrefManager.saveSPString(SharePrefManager.SP_EMAIL, usernameKey);
                sharePrefManager.saveSPString(SharePrefManager.SP_NAMA, "Nama Mhs Coba");
                sharePrefManager.saveSPBoolean(SharePrefManager.SP_SUDAH_LOGIN, true);

                Intent masukIntent = new Intent(LoginActivity.this, Home.class);
                startActivity(masukIntent);
                finish();
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setMessage("Username atau Password salah!")
                        .setNegativeButton("Retry", null).create().show();
            }
        });
    }
}
