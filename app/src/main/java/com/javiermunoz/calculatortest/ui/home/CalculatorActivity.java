package com.javiermunoz.calculatortest.ui.home;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import com.javiermunoz.calculatortest.R;

public class CalculatorActivity extends ActionBarActivity {

  private GridView gridView;
  private TextView mainTextView;
  private boolean isCommaSet = false;

  private String firstNumber = "";
  private String secondNumber = "";
  private String operator = "";

  private final int BUTTON_0 = 13;
  private final int BUTTON_1 = 8;
  private final int BUTTON_2 = 9;
  private final int BUTTON_3 = 10;
  private final int BUTTON_4 = 4;
  private final int BUTTON_5 = 5;
  private final int BUTTON_6 = 6;
  private final int BUTTON_7 = 0;
  private final int BUTTON_8 = 1;
  private final int BUTTON_9 = 2;
  private final int BUTTON_PLUS = 15;
  private final int BUTTON_MINUS = 11;
  private final int BUTTON_MULTP = 7;
  private final int BUTTON_DIV = 3;
  private final int BUTTON_COMMA = 12;
  private final int BUTTON_EQUALS = 14;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_calculator);

    mainTextView = (TextView) findViewById(R.id.resultTextView);

    gridView = (GridView) findViewById(R.id.buttonsGridView);

    gridView.setAdapter(new ButtonsAdapter(this));

    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        buttonPressed(position);
      }
    });
  }

  private void buttonPressed(int position) {
    switch (position) {
      case BUTTON_0:
        writeInMainText("0");
        break;
      case BUTTON_1:
        writeInMainText("1");
        break;
      case BUTTON_2:
        writeInMainText("2");
        break;
      case BUTTON_3:
        writeInMainText("3");
        break;
      case BUTTON_4:
        writeInMainText("4");
        break;
      case BUTTON_5:
        writeInMainText("5");
        break;
      case BUTTON_6:
        writeInMainText("6");
        break;
      case BUTTON_7:
        writeInMainText("7");
        break;
      case BUTTON_8:
        writeInMainText("8");
        break;
      case BUTTON_9:
        writeInMainText("9");
        break;
      case BUTTON_PLUS:
        sumFunctionallity();
        break;
      case BUTTON_MINUS:
        mainTextView.setText("0");
        break;
      case BUTTON_MULTP:
        mainTextView.setText("0");
        break;
      case BUTTON_DIV:
        mainTextView.setText("0");
        break;
      case BUTTON_COMMA:
        if (!isCommaSet) {
          isCommaSet = true;
          mainTextView.setText(mainTextView.getText() + ",");
        }
        break;
      case BUTTON_EQUALS:
        equalsFunctionallity();
        break;
    }
  }

  private void equalsFunctionallity() {
    String actuallyInMain = mainTextView.getText().toString();
    if (!firstNumber.equalsIgnoreCase("")) {
      if (operator.equalsIgnoreCase("+")) {
        int result = (Integer.parseInt(firstNumber) + Integer.parseInt(actuallyInMain));
        mainTextView.setText(result);
      }
    }
  }

  private void sumFunctionallity() {
    String actuallyInMain = mainTextView.getText().toString();
    operator = "+";
    if (actuallyInMain.equalsIgnoreCase("0")) {
      if (!firstNumber.equalsIgnoreCase("")) {
        mainTextView.setText(firstNumber);
      } else {
        mainTextView.setText("0");
      }
    } else {
      if (!firstNumber.equalsIgnoreCase("")) {
        int result = Integer.parseInt(firstNumber) + Integer.parseInt(actuallyInMain);
        mainTextView.setText(result);
      } else {
        firstNumber = mainTextView.getText().toString();
        mainTextView.setText("0");
      }
    }
  }

  private void writeInMainText(String text) {
    String comparingWith = mainTextView.getText().toString();
    if (!comparingWith.equalsIgnoreCase("0")) {
      mainTextView.setText(mainTextView.getText() + text);
    } else if (comparingWith.equalsIgnoreCase("+")
        || comparingWith.equalsIgnoreCase("-")
        || comparingWith.equalsIgnoreCase("*")
        || comparingWith.equalsIgnoreCase("/")
        || comparingWith.equalsIgnoreCase("=")
        || comparingWith.equalsIgnoreCase(",")) {

    } else {
      mainTextView.setText(text);
    }
  }
}
