package com.example.ozanmac.spacexlaunchsretrofit;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;


import com.example.ozanmac.spacexlaunchsretrofit.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {

    RestInterface restInterface;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);



        restInterface = ApiClient.getClient().create(RestInterface.class);

        Call<List<Launch>> call = restInterface.getLaunhes();

        call.enqueue(new Callback<List<Launch>>() {
            @Override
            public void onResponse(Call<List<Launch>> call, Response<List<Launch>> response) {

                List<Launch> launchList = new ArrayList<>();
                launchList = response.body();

                for (Launch launch: launchList) {
                    System.out.println(launch.toString());
                    binding.setRocket(launch.rocket);
                }

                

            }

            @Override
            public void onFailure(Call<List<Launch>> call, Throwable t) {

            }
        });


    }
}
