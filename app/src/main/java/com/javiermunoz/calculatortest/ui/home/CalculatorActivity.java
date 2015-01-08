package com.javiermunoz.calculatortest.ui.home;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import com.javiermunoz.calculatortest.R;

public class CalculatorActivity extends ActionBarActivity {

    private GridView gridView;
    private TextView mainTextView;

    private String firstNumber = "";
    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        mainTextView = (TextView) findViewById(R.id.resultTextView);
        mainTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainTextView.setText("0");
                firstNumber = "";
                operator = "";

            }
        });

        gridView = (GridView) findViewById(R.id.buttonsGridView);
        gridView.setAdapter(new ButtonsAdapter(this));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                buttonPressed(position);
            }
        });


    }

    private void buttonPressed(int position) {
        switch (AppConstants.numbers[position]) {
            case AppConstants.BUTTON_PLUS:
            case AppConstants.BUTTON_MINUS:
            case AppConstants.BUTTON_MULTP:
            case AppConstants.BUTTON_DIV:
                calculateFunctionallity(AppConstants.numbers[position]);
                break;

            case AppConstants.BUTTON_DOT:
                if (!mainTextView.getText().toString().contains(AppConstants.BUTTON_DOT)) {
                    mainTextView.setText(mainTextView.getText() + AppConstants.BUTTON_DOT);
                }
                break;

            case AppConstants.BUTTON_EQUALS:
                equalsFunctionallity();
                break;

            default:
                writeInMainText(AppConstants.numbers[position]);
        }
    }


    private void calculateFunctionallity(String operator) {
        String currentlyInMain = mainTextView.getText().toString();
        this.operator = operator;
        if (currentlyInMain.equalsIgnoreCase("0")) {
            if (!firstNumber.equalsIgnoreCase("")) {
                mainTextView.setText(firstNumber);
            } else {
                mainTextView.setText("0");
            }
        } else {
            if (!firstNumber.equalsIgnoreCase("")) {
                float result = 0;
                if (operator.equalsIgnoreCase(AppConstants.BUTTON_PLUS)) {
                    result = (Float.parseFloat(firstNumber) + Float.parseFloat(currentlyInMain));
                } else if (operator.equalsIgnoreCase(AppConstants.BUTTON_MINUS)) {
                    result = (Float.parseFloat(firstNumber) - Float.parseFloat(currentlyInMain));
                } else if (operator.equalsIgnoreCase(AppConstants.BUTTON_MULTP)) {
                    result = (Float.parseFloat(firstNumber) * Float.parseFloat(currentlyInMain));
                } else if (operator.equalsIgnoreCase(AppConstants.BUTTON_DIV)) {
                    result = (Float.parseFloat(firstNumber) / Float.parseFloat(currentlyInMain));
                } else {
                    return;
                }

                mainTextView.setText(String.valueOf(result));
            } else {
                firstNumber = mainTextView.getText().toString();
                mainTextView.setText("0");
            }
        }
    }


    private void equalsFunctionallity() {
        String currentlyInMain = mainTextView.getText().toString();

        if (!firstNumber.equalsIgnoreCase("") && !currentlyInMain.equalsIgnoreCase("0")) {
            try {
                float result = 0;
                if (operator.equalsIgnoreCase(AppConstants.BUTTON_PLUS)) {
                    result = (Float.parseFloat(firstNumber) + Float.parseFloat(currentlyInMain));
                } else if (operator.equalsIgnoreCase(AppConstants.BUTTON_MINUS)) {
                    result = (Float.parseFloat(firstNumber) - Float.parseFloat(currentlyInMain));
                } else if (operator.equalsIgnoreCase(AppConstants.BUTTON_MULTP)) {
                    result = (Float.parseFloat(firstNumber) * Float.parseFloat(currentlyInMain));
                } else if (operator.equalsIgnoreCase(AppConstants.BUTTON_DIV)) {
                    result = (Float.parseFloat(firstNumber) / Float.parseFloat(currentlyInMain));
                } else {
                    return;
                }

                if (result == Math.round(result)) {
                    // integer
                    mainTextView.setText(String.valueOf(Math.round(result)));
                } else {
                    mainTextView.setText(String.valueOf(result));
                }
            } catch (Exception ignored) {
            }
        }
    }

    private void writeInMainText(String text) {
        String comparingWith = mainTextView.getText().toString();
        if (!comparingWith.equalsIgnoreCase("0")) {
            mainTextView.setText(mainTextView.getText() + text);
        } else if (!comparingWith.equalsIgnoreCase("+")
            && !comparingWith.equalsIgnoreCase("-")
            && !comparingWith.equalsIgnoreCase("*")
            && !comparingWith.equalsIgnoreCase("/")
            && !comparingWith.equalsIgnoreCase("=")
            && !comparingWith.equalsIgnoreCase(",")) {

            mainTextView.setText(text);
        }
    }
}
