package id.ac.uin_suka.learning.elearning;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Objects;

import id.ac.uin_suka.learning.elearning.apihelper.BaseApiService;
import id.ac.uin_suka.learning.elearning.apihelper.UtilsApi;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText username,password;
    Button btnLogin;
    ProgressDialog loading;

    BaseApiService mApiService;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mContext = this;


        SharePrefManager sharePrefManager = new SharePrefManager(this);

        if (sharePrefManager.getSPSudahLogin()){
            Intent baruIntent = new Intent(LoginActivity.this, Home.class);
            startActivity(baruIntent);
//            startActivity(new Intent(LoginActivity.this, Home.class)
//                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }

        mApiService = UtilsApi.getAPIService();
        initComponents();
    }

    private void initComponents() {
        username = (EditText)findViewById(R.id.et_login_nim);
        password = (EditText)findViewById(R.id.et_login_pass);
        btnLogin = (Button)findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(view -> {
            loading = ProgressDialog.show(mContext, null, "Harap tunggu...", true, false);
            requestLogin();
        });
    }

    private void requestLogin() {
        SharePrefManager sharePrefManager = new SharePrefManager(this);
        String uname = username.getText().toString();
        String pass = password.getText().toString();

        mApiService.loginRequest(uname, pass)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(@NonNull Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            loading.dismiss();
                            try {
                                JSONObject jsonResult = new JSONObject(Objects.requireNonNull(response.body()).string());
                                if (jsonResult.getString("error").equals("false")){
                                    sharePrefManager.saveSPString(SharePrefManager.SP_EMAIL, uname);
                                    sharePrefManager.saveSPString(SharePrefManager.SP_NAMA, "Nama Mhs Coba");
                                    sharePrefManager.saveSPBoolean(SharePrefManager.SP_SUDAH_LOGIN, true);

                                    Toast.makeText(mContext, "Login Sukses", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(LoginActivity.this, Home.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    String error_message = jsonResult.getString("error_msg");
                                    Toast.makeText(LoginActivity.this, error_message, Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            loading.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.toString());
                        loading.dismiss();
                    }
                });
    }
}
