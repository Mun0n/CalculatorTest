package com.javiermunoz.calculatortest.activityinstumentation;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.GridView;
import android.widget.TextView;
import com.javiermunoz.calculatortest.R;
import com.javiermunoz.calculatortest.ui.home.CalculatorActivity;

/**
 * Created by javier.munoz on 23/12/14.
 */
public class CalculatorTest extends ActivityInstrumentationTestCase2<CalculatorActivity> {

  public CalculatorTest(Class<CalculatorActivity> activityClass) {
    super(activityClass);
  }

  public void testSum() {
    final int NUM_0 = 5;
    final int result;

    Activity activity = getActivity();

    final GridView gridView = (GridView) activity.findViewById(R.id.buttonsGridView);
    activity.runOnUiThread(new Runnable() {
      @Override public void run() {
        TextView t5 = (TextView) gridView.getItemAtPosition(5);
        Integer i = Integer.parseInt(t5.getText().toString());
        t5.requestFocus();
        assertEquals(NUM_0, i.intValue());
      }
    });

    activity.finish();
    setActivity(null);
  }
}
