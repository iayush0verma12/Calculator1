package com.example.calculator1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    private EditText Calculation, Result;
    private String curr,res;
    private Button btnOne,btntwo,btn7,btn8,btn9,btnDivide,btn4,btn5,btn6,btnMultiply,btn1,btn2,btn3,btnSub,btnDot,btn0,btnEQ,btnPlus;
    private boolean dot_inserted,operator_inserted;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calculation = (EditText)findViewById(R.id.CalculationED);
        Result = (EditText)findViewById(R.id.ResultED);

        curr="";
        res="";
        dot_inserted=false;
        operator_inserted=false;

        btnOne=(Button)findViewById(R.id.btnOne);
        btntwo=(Button)findViewById(R.id.btntwo);
        btn7=(Button)findViewById(R.id.btn7);
        btn8=(Button)findViewById(R.id.btn8);
        btn9=(Button)findViewById(R.id.btn9);
        btnDivide=(Button)findViewById(R.id.btnDivide);
        btn4=(Button)findViewById(R.id.btn4);
        btn5=(Button)findViewById(R.id.btn5);
        btn6=(Button)findViewById(R.id.btn6);
        btnMultiply=(Button)findViewById(R.id.btnMultiply);
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btn3=(Button)findViewById(R.id.btn3);
        btnSub=(Button)findViewById(R.id.btnSub);
        btnDot=(Button)findViewById(R.id.btnDot);
        btn0=(Button)findViewById(R.id.btn0);
        btnEQ=(Button)findViewById(R.id.btnEQ);
        btnPlus=(Button)findViewById(R.id.btnPlus);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr=curr+"0";
                displayOne();
            }
        });

        btn1.setOnClickListener(v -> {
            curr=curr+"1";
            displayOne();
        });

        btn2.setOnClickListener(v -> {
            curr=curr+"2";
            displayOne();
        });

        btn3.setOnClickListener(v -> {
            curr=curr+"3";
            displayOne();
        });

        btn4.setOnClickListener(v -> {
            curr=curr+"4";
            displayOne();
        });

        btn5.setOnClickListener(v -> {
            curr=curr+"5";
            displayOne();
        });

        btn6.setOnClickListener(v -> {
            curr=curr+"6";
            displayOne();
        });

        btn7.setOnClickListener(v -> {
            curr=curr+"7";
            displayOne();
        });

        btn8.setOnClickListener(v -> {
            curr=curr+"8";
            displayOne();
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr=curr+"9";
                displayOne();
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(curr.isEmpty())
                {
                    curr="0.";
                    dot_inserted=true;
                } else if (dot_inserted==false) {
                    curr=curr+".";
                    dot_inserted=true;
                }
                displayOne();
            }
        });
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
                displayOne();
                displayTwo();
            }
        });
        btntwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backspace();
                displayOne();
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //set dot inserted to false
                dot_inserted=false;

                //check if current string is not empty
                if(!curr.isEmpty())
                {
                    if(operator_inserted==true)
                    {
                        backspace();
                    }
                    //check if last digit is dot=>remove it
                    if(curr.substring(curr.length()-1,curr.length()).equals("."))
                    {
                        backspace();
                    }
                    if(!operator_inserted)
                    {
                        curr=curr+" / ";
                        operator_inserted=true;
                    }
                }
                displayOne();
            }
        });
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //set dot inserted to false
                dot_inserted=false;

                //check if current string is not empty
                if(!curr.isEmpty())
                {
                    if(operator_inserted==true)
                    {
                        backspace();
                    }
                    //check if last digit is dot=>remove it
                    if(curr.substring(curr.length()-1,curr.length()).equals("."))
                    {
                        backspace();
                    }
                    if(!operator_inserted)
                    {
                        curr=curr+" * ";
                        operator_inserted=true;
                    }
                }
                displayOne();
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //set dot inserted to false
                dot_inserted=false;

                //check if current string is not empty
                if(!curr.isEmpty())
                {
                    if(operator_inserted==true)
                    {
                        backspace();
                    }
                    //check if last digit is dot=>remove it
                    if(curr.substring(curr.length()-1,curr.length()).equals("."))
                    {
                        backspace();
                    }
                    if(!operator_inserted)
                    {
                        curr=curr+" - ";
                        operator_inserted=true;
                    }
                }
                displayOne();
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //set dot inserted to false
                dot_inserted=false;

                //check if current string is not empty
                if(!curr.isEmpty())
                {
                    if(operator_inserted==true)
                    {
                        backspace();
                    }
                    //check if last digit is dot=>remove it
                    if(curr.substring(curr.length()-1,curr.length()).equals("."))
                    {
                        backspace();
                    }
                    if(!operator_inserted)
                    {
                        curr=curr+" + ";
                        operator_inserted=true;
                    }
                }
                displayOne();
            }
        });

//        btnEQ.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String[] tokens =curr.split(" ",curr.length()-1);
//                if(operator_inserted==true && !curr.substring(curr.length()-1,curr.length()).equals(" "))
//                {
////                    String a=""+tokens[0].charAt(0);
////                    String b=""+tokens[0].charAt(2);
////                    String a=""+tokens[0];
////                    String b=""+tokens[1].charAt(0);
////                    String c=""+tokens[2];
////                    res=a+b+c;
////                    displayTwo();
////                    switch(tokens[0].charAt(1))
////                    {
////                        case '+':
////                            res = Double.toString(Double.parseDouble(a)+Double.parseDouble(b));
////                            break;
////                        case '-':
////                            res = Double.toString(Double.parseDouble(a)-Double.parseDouble(b));
////                            break;
////                        case '*':
////                            res = Double.toString(Double.parseDouble(a)*Double.parseDouble(b));
////                            break;
////                        case '/':
////                            res = Double.toString(Double.parseDouble(a)/Double.parseDouble(b));
////                            break;
//////                        case '-':
//////                            res = Double.toString(Double.parseDouble(tokens[0])-Double.parseDouble(tokens[2]));
//////                            break;
//////                        case '*':
//////                            res = Double.toString(Double.parseDouble(tokens[0])*Double.parseDouble(tokens[2]));
//////                            break;
//////                        case '/':
//////                            res = Double.toString(Double.parseDouble(tokens[0])/Double.parseDouble(tokens[2]));
//////                            break;
////                    }
////                    displayTwo();
//                }
//            }
//        });
        btnEQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operator_inserted==true && !curr.substring(curr.length()-1,curr.length()).equals(" "))
                {
                    String[] tokens =curr.split(" ");
                    switch(tokens[1].charAt(0))
                    {
                        case '+':
                            res = Double.toString(Double.parseDouble(tokens[0])+Double.parseDouble(tokens[2]));
                            break;
                        case '-':
                            res = Double.toString(Double.parseDouble(tokens[0])-Double.parseDouble(tokens[2]));
                            break;
                        case '*':
                            res = Double.toString(Double.parseDouble(tokens[0])*Double.parseDouble(tokens[2]));
                            break;
                        case '/':
                            res = Double.toString(Double.parseDouble(tokens[0])/Double.parseDouble(tokens[2]));
                            break;
                    }
                    displayTwo();
                }
            }
        });
    }

    public void clear()
    {
        res="";
        curr="";
        dot_inserted=false;
        operator_inserted=false;
    }

    public void backspace()
    {
        if(!curr.isEmpty())
        {
            if(curr.substring(curr.length()-1,curr.length()).equals("."))
            {
                dot_inserted=false;
            }
            else if (curr.substring(curr.length()-1,curr.length()).equals(" ")) {
                curr=curr.substring(0,curr.length()-3);
                operator_inserted=false;
            }
            else
            {
                curr=curr.substring(0,curr.length()-1);
            }
        }
    }

    public void displayOne()
    {Calculation.setText(curr);}
    public void displayTwo()
    {
        Result.setText(res);
    }
}

