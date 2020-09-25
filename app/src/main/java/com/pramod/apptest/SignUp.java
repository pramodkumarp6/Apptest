package com.pramod.apptest;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.pramod.apptest.aap.RetrofitClient;
import com.pramod.apptest.models.DefaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUp extends AppCompatActivity {
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);




    }


    public void register(){

        progressDialog.setMessage("Registering user...");
        progressDialog.show();

        Call<DefaultResponse> call = RetrofitClient.getInstance().getApi().createUser( );


        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response)
            {
                progressDialog.dismiss();

                Toast.makeText(getApplicationContext(), response.body().getMsg(), Toast.LENGTH_LONG).show();


            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });



    }
}