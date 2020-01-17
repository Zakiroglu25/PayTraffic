package com.aris.paytraffic.auth;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.aris.paytraffic.R;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
//    ApiInterface service = ApiClient.getClient().create(ApiInterface.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

//        final EditText editText = findViewById(R.id.phone_number);
        Button button = findViewById(R.id.daxilol);


        SharedPreferences sharedpreferences = getSharedPreferences("PayTraffic", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedpreferences.edit();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                service.login(new RequestUserLogin(editText.getText().toString().equals(new Callback<Response<UserModel>>() {
//                    @Override
//                    public void onResponse(Call<Response<UserModel>> call, retrofit2.Response<Response<UserModel>> response) {
//                        if (response.body() != null) {
//                            if (response.body().getStatus() == 200) {
//                                editor.putString("phone", response.body().getResponse().getPhone());
//                                editor.apply();
//                                System.out.println(response.body().getResponse().getPhone());
                                Intent intent = new Intent(LoginActivity.this, PhoneCode.class);
                                startActivity(intent);
//                            } else if (response.body().getStatus() == 404) {
//                                Toast.makeText(LoginActivity.this, "xxxxxxx", Toast.LENGTH_SHORT).show();
//                                Log.e(TAG, "onResponse: Movcud deil" );
//                            } else {
//                                System.out.println("xxxx");
//                            }
//                        } else {
//                            System.out.println("xeta");
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<Response<UserModel>> call, Throwable t) {
//                        System.out.println(t.getMessage());
//                    }
//                });
            }
        });
    }
}
