package com.example.edu.newthread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int progressBar = 0;
    Button btnRun;
    ProgressBar progressBarPost;
    ImageView imageViewLink;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBarPost = findViewById(R.id.progressBarPost);
        imageViewLink = (ImageView)findViewById(R.id.imageViewLink);
        btnRun = (Button)findViewById(R.id.btnRun);
        btnRun.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        new Thread(new Runnable() {
            String strUri = "https://www.google.com/images/ooglelogo_color_272x92dp.png";
            @Override
            public void run() {
                while (progressBar < 100){
                    try {
                        Thread.sleep(100);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                progressBar ++;
                progressBarPost.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBarPost.setProgress(progressBar);

                    }
                });
            }}
        }).start();
    }
}
