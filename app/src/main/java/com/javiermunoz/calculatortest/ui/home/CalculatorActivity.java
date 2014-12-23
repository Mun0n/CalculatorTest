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

    gridView = (GridView) findViewById(R.id.buttonsGridView);

    gridView.setAdapter(new ButtonsAdapter(this));

    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        switch (position) {
          case BUTTON_0:
            break;
          case BUTTON_1:
            break;
          case BUTTON_2:
            break;
          case BUTTON_3:
            break;
          case BUTTON_4:
            break;
          case BUTTON_5:
            break;
          case BUTTON_6:
            break;
          case BUTTON_7:
            break;
          case BUTTON_8:
            break;
          case BUTTON_9:
            break;
          case BUTTON_PLUS:
            break;
          case BUTTON_MINUS:
            break;
          case BUTTON_MULTP:
            break;
          case BUTTON_DIV:
            break;
          case BUTTON_COMMA:
            break;
          case BUTTON_EQUALS:
            break;

        }
      }
    });
  }
}
