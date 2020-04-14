package com.example.whowantstobeamillionaire;

import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import androidx.appcompat.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Question2 extends AppCompatActivity{

    private Button submit;


    private String correctAns = "C";
    private boolean answered = false;
    private boolean correctAnswer = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);




    }

    @Override
    public void onBackPressed() {

        DialogInterface.OnClickListener dialogClickListener =
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int button) {
                        if (button == DialogInterface.BUTTON_POSITIVE) {

                            Toast.makeText(Question2.this,
                                    getString(R.string.exit_toast_msg),
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                };


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.are_you_sure))
                .setTitle(R.string.exit_game_title)
                .setPositiveButton("", dialogClickListener)
                .setNegativeButton("", dialogClickListener)
                .setIcon(R.drawable.ic_monetization_on_black_24dp)
                .setPositiveButtonIcon(getDrawable(R.drawable.ic_check))
                .setNegativeButtonIcon(getDrawable(R.drawable.ic_close))
                .show();



    }

    public void submit(View view) {

        if(answered){
            Toast.makeText(Question2.this,
                    getString(R.string.confirmedAlready),
                    Toast.LENGTH_LONG).show();
            return;
        }

        findViewById(R.id.ansA).setBackgroundResource(R.drawable.ans_black);
        findViewById(R.id.ansB).setBackgroundResource(R.drawable.ans_black);
        findViewById(R.id.ansC).setBackgroundResource(R.drawable.ans_black);
        findViewById(R.id.ansD).setBackgroundResource(R.drawable.ans_black);

        final Button selectedButton = (Button) view;

        DialogInterface.OnClickListener dialogClickListener =
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int button) {
                        if (button == DialogInterface.BUTTON_POSITIVE) {

                            if(selectedButton.getText().toString().startsWith(correctAns)) {
                                selectedButton.setBackgroundResource(R.drawable.ans_green);
                                correctAnswer = true;

                                Toast.makeText(Question2.this,
                                        getString(R.string.confirmed),
                                        Toast.LENGTH_LONG).show();
                            } else {
                                selectedButton.setBackgroundResource(R.drawable.ans_org);

                                Toast.makeText(Question2.this,
                                        getString(R.string.confirmed_wrong),
                                        Toast.LENGTH_LONG).show();
                            }

                            answered = true;
                        }


                    }
                };


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.are_you_sure))
                .setTitle("Confirm Answer")
                .setPositiveButton("", dialogClickListener)
                .setNegativeButton("", dialogClickListener)
                .setIcon(R.drawable.ic_monetization_on_black_24dp)
                .setPositiveButtonIcon(getDrawable(R.drawable.ic_check))
                .setNegativeButtonIcon(getDrawable(R.drawable.ic_close))
                .show();



    }

    public void goto_next_question(View view) {

        if(!answered)
            return;
        if(!correctAnswer){
            Intent intent = new Intent(this, results.class);
            intent.putExtra("level", 2);
            startActivity(intent);
        } else {
            Intent intent = new Intent(Question2.this, Question3.class);
            startActivity(intent);
        }
    }

    public void prizemoney(View view) {
        Intent intent = new Intent(this, results.class);
        intent.putExtra("level", 2);
        intent.putExtra("claim", correctAnswer?2000:0);

        startActivity(intent);

    }
}