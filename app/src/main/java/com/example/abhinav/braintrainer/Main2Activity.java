package com.example.abhinav.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {
    TextView timer;
    TextView score;
    TextView finished;
    TextView ques;
    Button reset,b1,b2,b3,b4;
    CountDownTimer timeit;
    int ansLoc;
    GridLayout gridLayout;


    public void playagain(View v){


        timer.setVisibility(View.VISIBLE);
        gridLayout.setVisibility(View.VISIBLE);
        score.setVisibility(View.VISIBLE);
        reset.setVisibility(View.INVISIBLE);
        ques.setVisibility(View.VISIBLE);

        timer.setText("30s");
        score.setText("0/0");

        quesagain();
        timeit.start();



    }

    public void quesagain(){


        Random rand=new Random();

        int a =rand.nextInt(21);

        int b =rand.nextInt(21);

        ques.setText(Integer.toString(a) + " + " + Integer.toString(b));

        ansLoc=rand.nextInt(4);



        if(Integer.parseInt(b1.getTag().toString())==ansLoc) {
            b1.setText(a + b +"");

            b2.setText(rand.nextInt(41)+"");
            b3.setText(rand.nextInt(41)+"");
            b4.setText(rand.nextInt(41)+ "");

        }
        else if(Integer.parseInt(b2.getTag().toString())==ansLoc) {
            b2.setText(a + b+"");

            b1.setText(rand.nextInt(41)+"");
            b3.setText(rand.nextInt(41)+"");
            b4.setText(rand.nextInt(41)+"");

        }

        else if(Integer.parseInt(b3.getTag().toString())==ansLoc) {
            b3.setText(a + b+"");

            b2.setText(rand.nextInt(41)+"");
            b1.setText(rand.nextInt(41)+"");
            b4.setText(rand.nextInt(41)+"");

        }

        else  {
            b4.setText(a + b+"");

            b2.setText(rand.nextInt(41)+"");
            b3.setText(rand.nextInt(41)+"");
            b1.setText(rand.nextInt(41)+"");

        }

    }

    public void test(View v){

        String a=score.getText().toString();
        int pos=-1;

        for(int i=0;i<a.length();i++){

            if(a.charAt(i)=='/')
                pos=i;

        }



        if(Integer.parseInt(v.getTag().toString())==ansLoc){

            finished.setText("Correct!");




                 int answered=Integer.parseInt(a.substring(0,pos));
                 int total=Integer.parseInt(a.substring(pos+1,a.length()));

                 answered++;
                 total++;

                 score.setText(answered+"/"+total);

        }

        else{

            finished.setText("Incorrect!");


            int answered=Integer.parseInt(a.substring(0,pos));
            int total=Integer.parseInt(a.substring(pos+1,a.length()));

            total++;
            score.setText(answered+"/"+total);



        }
        quesagain();




    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

         timer=(TextView)findViewById(R.id.TimeTextView);
         score=(TextView)findViewById(R.id.ScoreTextView);
         finished=(TextView) findViewById(R.id.finishedTextview);
         ques=(TextView) findViewById(R.id.quesView);

         reset=(Button)findViewById(R.id.resetButton);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button1);
        b3=(Button)findViewById(R.id.button2);
        b4=(Button)findViewById(R.id.button3);



         reset.setVisibility(View.INVISIBLE);


       timeit = new CountDownTimer(30000,1000) {


            @Override
            public void onTick(long l) {

                timer.setText(l/1000+"s");

            }

            @Override
            public void onFinish() {


                gridLayout=(GridLayout)findViewById(R.id.gridLayout);
                gridLayout.setVisibility(View.INVISIBLE);
                timer.setVisibility(View.INVISIBLE);
                score.setVisibility(View.INVISIBLE);
                ques.setVisibility(View.INVISIBLE);
                reset.setVisibility(View.VISIBLE);
                finished.setText("Your Final Score:"+ score.getText().toString());

            }
        }.start();

quesagain();

    }
}
