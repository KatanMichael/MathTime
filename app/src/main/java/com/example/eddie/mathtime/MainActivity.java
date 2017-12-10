package com.example.eddie.mathtime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{


    int a, b;
    int sum=0;
    String value;
    boolean Plus = false;
    boolean Minus = false;
    boolean Multi=false;
    boolean Div = false;
    TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultView = findViewById(R.id.result);

        value="";

        Button b0 = findViewById(R.id.num_0);
        b0.setOnClickListener(new NumsButtonsListner('0'));

        Button b1 = findViewById(R.id.num_1);
        b1.setOnClickListener(new NumsButtonsListner('1'));

        Button b2 = findViewById(R.id.num_2);
        b2.setOnClickListener(new NumsButtonsListner('2'));

        Button b3 = findViewById(R.id.num_3);
        b3.setOnClickListener(new NumsButtonsListner('3'));

        Button b4 = findViewById(R.id.num_4);
        b4.setOnClickListener(new NumsButtonsListner('4'));

        Button b5 = findViewById(R.id.num_5);
        b5.setOnClickListener(new NumsButtonsListner('5'));

        Button b6 = findViewById(R.id.num_6);
        b6.setOnClickListener(new NumsButtonsListner('6'));

        Button b7 = findViewById(R.id.num_7);
        b7.setOnClickListener(new NumsButtonsListner('7'));

        Button b8 = findViewById(R.id.num_8);
        b8.setOnClickListener(new NumsButtonsListner('8'));

        Button b9 = findViewById(R.id.num_9);
        b9.setOnClickListener(new NumsButtonsListner('9'));


        Button bPlus = findViewById(R.id.plus);
        bPlus.setOnClickListener(new OpButtonsListener('+'));
        Button bMinus = findViewById(R.id.minus);
        bMinus.setOnClickListener(new OpButtonsListener('-'));
        Button bMulti = findViewById(R.id.multi);
        bMulti.setOnClickListener(new OpButtonsListener('*'));
        Button bDiv = findViewById(R.id.div);
        bDiv.setOnClickListener(new OpButtonsListener('/'));


        Button bEqual = findViewById(R.id.equal);
        bEqual.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                if(Plus)
                {
                        {
                        String first = value.substring(0, value.indexOf('+'));
                        String second = value.substring(value.indexOf('+') + 1);

                        if(second.equals(""))
                        {
                            b = 0;
                        }

                        Plus = false;
                        Minus = false;
                        Multi = false;
                        Div = false;
                        if(first.equals(""))
                        {
                            a = Integer.parseInt(resultView.getText().toString());

                            sum = a + b;
                        }else
                        {
                            sum = Integer.parseInt(first) + Integer.parseInt(second);
                        }

                    }
                }

                if(Minus)
                {
                    String first=value.substring(0,value.indexOf('-'));
                    String second=value.substring(value.indexOf('-')+1);
                    Plus = false;
                    Minus = false;
                    Multi = false;
                    Div = false;                    if(first.equals(""))
                    {
                        sum = Integer.parseInt(resultView.getText().toString())
                                - Integer.parseInt(second);
                    }else
                    sum=Integer.parseInt(first)- Integer.parseInt(second);
                }

                if(Multi)
                {
                    String first=value.substring(0,value.indexOf('*'));
                    String second=value.substring(value.indexOf('*')+1);
                    Plus = false;
                    Minus = false;
                    Multi = false;
                    Div = false;                    if(first.equals(""))
                    {
                        sum = Integer.parseInt(resultView.getText().toString())
                                * Integer.parseInt(second);
                    }else {
                        sum = Integer.parseInt(first) * Integer.parseInt(second);
                    }
                }

                if(Div)
                {
                    String first=value.substring(0,value.indexOf('/'));
                    String second=value.substring(value.indexOf('/')+1);
                    Plus = false;
                    Minus = false;
                    Multi = false;
                    Div = false;                    if(first.equals(""))
                    {
                        sum = Integer.parseInt(resultView.getText().toString())
                                / Integer.parseInt(second);
                    }else
                    sum=Integer.parseInt(first)/ Integer.parseInt(second);
                }

                TextView val=(TextView) findViewById(R.id.inital_text);
                val.setText(value);

                TextView result=(TextView)findViewById(R.id.result);
                result.setText(Integer.toString(sum));
                value="";

            }
        });


        Button bClear = findViewById(R.id.clear);
        bClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                TextView val=(TextView) findViewById(R.id.inital_text);
                val.setText(" ");
                value="";

                TextView result=(TextView) findViewById(R.id.result);
                result.setText(" ");

            }
        });

    }

    private class OpButtonsListener implements View.OnClickListener
    {
        private char sign;

        public OpButtonsListener(char sign) {
            this.sign=sign;
        }

        @Override
        public void onClick(View view)
        {
            switch(this.sign)
            {
                case('+') :
                    Plus=true;
                case('-') :
                    Minus=true;
                case('*') :
                    Multi=true;
                case('/') :
                    Div=true;
            }
            value = value + sign ;
            TextView val = (TextView) findViewById(R.id.inital_text);
            val.setText(value);
        }
    }



    private class NumsButtonsListner implements View.OnClickListener
    {

        private char num;
        public NumsButtonsListner(char num)
        {
            this.num=num;
        }

        @Override
        public void onClick(View view)
        {

            value = value + num ;
            TextView val = (TextView) findViewById(R.id.inital_text);
            val.setText(value);
        }

    }

}