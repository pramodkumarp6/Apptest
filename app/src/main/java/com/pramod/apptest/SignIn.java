package com.pramod.apptest;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.pramod.apptest.aap.RetrofitClient;
import com.pramod.apptest.models.DefaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignIn extends AppCompatActivity {

    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        getSupportActionBar().setTitle("Login");
    }






    public void login(){


        progressDialog.show();

        Call<DefaultResponse> call = RetrofitClient.getInstance().getApi().userLogin( );

        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                progressDialog.dismiss();
                DefaultResponse loginResponse = response.body();
                // progressDialog.dismiss();
                if (!loginResponse.isErr()) {
                    // progressDialog.dismiss();
                    finish();
/*

                    SharedPrefManager.getInstance(Login.this).saveUser(loginResponse.getUser());

                    Intent intent = new Intent(Login.this, DashBoard.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                    // mCtx.startActivity(new Intent(mCtx, Login.class));
                    startActivity(intent);
                    //finish();
*/

                } else {
                    Toast.makeText(getApplicationContext(), "Invalid email or password", Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                // finish();
            }
        });

    }
}