package com.example.calculator_arcsoftwaresitltm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView screen, sign;
    Button ac, sin, cos, back, one, two, three, fore, five, six, seven, eight, nine, zero, divide, multi, add, minus, equal, dot, ln, root, sqr, log;

    String shign, value1, value2;
    Double num1, num2, result;

    boolean hasDot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = findViewById(R.id.screen);
        sign = findViewById(R.id.sign);

        ac = findViewById(R.id.ac_id);
        sin = findViewById(R.id.sin_id);
        cos = findViewById(R.id.cos_id);
        back = findViewById(R.id.back_id);
        one = findViewById(R.id.one_id);
        two = findViewById(R.id.two_id);
        three = findViewById(R.id.three_id);
        fore = findViewById(R.id.forth_id);
        five = findViewById(R.id.fifth_id);
        six = findViewById(R.id.six_id);
        seven = findViewById(R.id.seven_id);
        eight = findViewById(R.id.eight_id);
        nine = findViewById(R.id.ninth_id);
        zero = findViewById(R.id.zero_id);
        divide = findViewById(R.id.div_id);
        multi = findViewById(R.id.mul_id);
        add = findViewById(R.id.plus_id);
        minus = findViewById(R.id.minus_id);
        equal = findViewById(R.id.equal_id);
        dot = findViewById(R.id.dot_id);
        ln = findViewById(R.id.ln_id);
        root = findViewById(R.id.root_id);
        log = findViewById(R.id.log_id);
        sqr = findViewById(R.id.sqr_id);

        hasDot = false;

    }

    public void btn_zero(View view) {
        screen.setText(screen.getText() + "0");
    }

    public void btn_three(View view) {
        screen.setText(screen.getText() + "3");
    }

    public void btn_two(View view) {
        screen.setText(screen.getText() + "2");
    }

    public void btn_one(View view) {
        screen.setText(screen.getText() + "1");
    }

    public void btn_six(View view) {
        screen.setText(screen.getText() + "6");
    }

    public void btn_fifth(View view) {
        screen.setText(screen.getText() + "5");
    }

    public void btn_forth(View view) {
        screen.setText(screen.getText() + "4");
    }

    public void btn_ninth(View view) {
        screen.setText(screen.getText() + "9");
    }

    public void btn_eight(View view) {
        screen.setText(screen.getText() + "8");
    }

    public void btn_seven(View view) {

        screen.setText(screen.getText() + "7");
    }


    public void btn_plus(View view) {

        shign = "+";
        value1 = screen.getText().toString();

        sign.setText(screen.getText()+"+");
        screen.setText(null);
        hasDot = false;


    }


    public void btn_dot(View view) {

        if (!hasDot) {

            if (screen.getText().equals("")) {
                screen.setText("0.");
            } else {
                screen.setText(screen.getText() + ".");

            }
            hasDot = true;

        }
    }


    public void btn_minus(View view) {
        shign = "-";
        value1 = screen.getText().toString();
        sign.setText(screen.getText()+"-");
        screen.setText(null);
        hasDot = false;


    }


    public void btn_mul(View view) {

        shign = "*";
        value1 = screen.getText().toString();
        sign.setText(screen.getText()+"*");
        screen.setText(null);
        hasDot = false;


    }


    public void btn_div(View view) {
        shign = "/";
        value1 = screen.getText().toString();
        sign.setText(screen.getText()+"÷");
        screen.setText(null);

        hasDot = false;
    }


    public void btn_root(View view) {
        shign = "root";

        screen.setText(null);
        sign.setText("√");
        hasDot = false;

    }

    public void btn_sqr(View view) {

        shign = "power";
        value1 = screen.getText().toString();
        screen.setText(null);
        sign.setText("xⁿ");
        hasDot = false;
    }

    public void btn_ln(View view) {
        shign = "ln";
        screen.setText(null);
        sign.setText("ln");
        hasDot = false;
    }

    public void btn_log(View view) {
        shign = "log";
        screen.setText(null);
        sign.setText("log");
        hasDot = false;
    }

    public void btn_back(View view) {

        if (screen.getText().equals("")) {
            screen.setText(null);
        } else {
            int len = screen.getText().length();
            String s = screen.getText().toString();
            if (s.charAt(len - 1) == '.') {
                hasDot = false;
                screen.setText(screen.getText().subSequence(0, screen.getText().length() - 1));

            } else {
                screen.setText(screen.getText().subSequence(0, screen.getText().length() - 1));
            }
        }
    }

    public void btn_cos(View view) {
        shign = "cos";
        screen.setText(null);
        hasDot = false;
        sign.setText("cos");
    }

    public void btn_sin(View view) {

        shign = "sin";
        screen.setText(null);
        hasDot = false;
        sign.setText("sin");
    }

    public void btn_equal(View view) {


        if (shign == null) {
            sign.setText("Error!");
        } else if (screen.getText().equals("")) {
            sign.setText("Error!");
        } else if ((shign.equals("+") || shign.equals("-") || shign.equals("*") || shign.equals("/")) && value1.equals("")) {
            sign.setText("Error!");
        } else {
            switch (shign) {
                default:
                    break;
                case "log":
                    value1 = screen.getText().toString();
                    num1 = Double.parseDouble(value1);
                    sign.setText(Math.log10(num1) + "");
                    shign = null;
                    screen.setText(null);

                    break;
                case "ln":
                    value1 = screen.getText().toString();
                    num1 = Double.parseDouble(value1);
                    sign.setText(Math.log(num1) + "");
                    shign = null;
                    screen.setText(null);
                    break;
                case "power":
                    num1 = Double.parseDouble((value1));
                    value2 = screen.getText().toString();
                    num2 = Double.parseDouble(value2);
                    sign.setText(Math.pow(num1, num2) + "");
                    shign = null;
                    screen.setText(null);
                    break;
                case "root":
                    value1 = screen.getText().toString();
                    num1 = Double.parseDouble((value1));
                    sign.setText(Math.sqrt(num1) + "");
                    shign = null;
                    screen.setText(null);
                    break;

                case "sin":
                    value1 = screen.getText().toString();
                    num1 = Double.parseDouble((value1));
                    sign.setText(Math.sin(num1) + "");
                    shign = null;
                    screen.setText(null);
                    break;
                case "cos":
                    value1 = screen.getText().toString();
                    num1 = Double.parseDouble((value1));
                    sign.setText(Math.cos(num1) + "");
                    shign = null;
                    screen.setText(null);
                    break;

                case "+":
                    value2 = screen.getText().toString();
                    num1 = Double.parseDouble(value1);
                    num2 = Double.parseDouble(value2);
                    result = num1 + num2;
                    sign.setText(result + "");
                    shign = null;
                    screen.setText(null);
                    break;
                case "-":
                    value2 = screen.getText().toString();
                    num1 = Double.parseDouble(value1);
                    num2 = Double.parseDouble(value2);
                    result = num1 - num2;
                    sign.setText(result + "");
                    shign = null;
                    screen.setText(null);
                    break;
                case "*":
                    value2 = screen.getText().toString();
                    num1 = Double.parseDouble(value1);
                    num2 = Double.parseDouble(value2);
                    result = num1 * num2;
                    sign.setText(result + "");
                    shign = null;
                    screen.setText(null);
                    break;
                case "/":
                    value2 = screen.getText().toString();
                    num1 = Double.parseDouble(value1);
                    num2 = Double.parseDouble(value2);
                    result = num1 / num2;
                    sign.setText(result + "");
                    shign = null;
                    screen.setText(null);
                    break;
            }

        }







    }


    public void btn_ac(View view) {
        screen.setText(null);
        sign.setText(null);
        hasDot = false;
        value1 = null;
        value2 = null;
        shign = null;


    }


}