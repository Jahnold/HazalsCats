package com.hazal.hazalscats;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private RecyclerView recycler;
    private CatsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRetrofit();
        initRecycler();

        getCats();
    }

    private void initRetrofit() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://www.mocky.io/v2/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    private void initRecycler() {

        recycler = findViewById(R.id.recycler);

        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        recycler.setLayoutManager(lm);

        adapter = new CatsAdapter();
        recycler.setAdapter(adapter);
    }


    private void getCats() {

        CatsApi api = retrofit.create(CatsApi.class);

        api.getCats().enqueue(new Callback<List<Cat>>() {
            @Override
            public void onResponse(Call<List<Cat>> call, Response<List<Cat>> response) {
                if (response.isSuccessful()) {

                    List<Cat> cats = response.body();
                    adapter.setCats(cats);
                }
            }

            @Override
            public void onFailure(Call<List<Cat>> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Oh Noes, error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
