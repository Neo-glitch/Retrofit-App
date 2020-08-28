package com.neo.retrofitpluralsight;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.neo.retrofitpluralsight.services.MessageService;
import com.neo.retrofitpluralsight.services.ServiceBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LandingActivity extends AppCompatActivity {

    private TextView mMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        mMessage = (TextView)findViewById(R.id.message);

        // instantiate instance of message service and we are using getMessage method
        MessageService taskService = ServiceBuilder.buildService(MessageService.class);
        Call<String> call = taskService.getMessage("http://10.0.2.2:9000/messages");

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                mMessage.setText(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                mMessage.setText("Request failed");
            }
        });
    }

    public void GetStarted(View view){
        Intent intent = new Intent(this, IdeaListActivity.class);
        startActivity(intent);
    }
}
