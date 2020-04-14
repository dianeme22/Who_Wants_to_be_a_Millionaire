package com.example.whowantstobeamillionaire;

import android.content.Context;
import android.content.Intent;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class results extends AppCompatActivity{

    TextView res_text;
    TextView your_money;
    ImageView i ;
    int level;
    int claim = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        level = getIntent().getExtras().getInt("level");
        claim = getIntent().getExtras().getInt("claim", 0);
        res_text = (TextView) findViewById(R.id.res_text);
        your_money = (TextView) findViewById(R.id.your_money);
        your_money.setText(String.format("You won $ %s", claim));

        i = findViewById(R.id.img_gif);

    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        View v = super.onCreateView(name, context, attrs);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void run() {
                try {
                    Drawable decodedAnimation;
                    int gif = R.drawable.winning;

                    if(level == 1){
                        gif = R.drawable.zero;
                    } else if (level == 2 ){
                        gif = R.drawable.goodjob;

                    } else if(level ==3){
                        gif = R.drawable.goodjob;

                    } else if (level ==4){
                        gif = R.drawable.goodjob;

                    }else if (level ==5){
                        gif = R.drawable.goodjob;

                    }else if (level ==6){
                        gif = R.drawable.goodjob;

                    }else if (level ==7){
                        gif = R.drawable.goodjob;

                    }else if (level ==8){
                        gif = R.drawable.goodjob;

                    }else if (level ==9){
                        gif = R.drawable.goodjob;

                    }else if (level ==10){
                        gif = R.drawable.goodjob;

                    } else {
                        gif = R.drawable.winning;
                        res_text.setText("Congratulations!!\nYou are a Millionaire!!!");

                    }

                    decodedAnimation = ImageDecoder.decodeDrawable(ImageDecoder.createSource(getResources(), gif), new ImageDecoder.OnHeaderDecodedListener() {
                        @Override
                        public void onHeaderDecoded(ImageDecoder decoder, ImageDecoder.ImageInfo info, ImageDecoder.Source source) {

                        }
                    });
                    i.setImageDrawable(decodedAnimation);
                    if(decodedAnimation instanceof AnimatedImageDrawable)
                        ((AnimatedImageDrawable)decodedAnimation).start();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, 2000);

        //


        return v;
    }

    public void goto_next_question(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}


