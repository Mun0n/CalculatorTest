package com.javiermunoz.calculatortest.activityinstumentation;

import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;
import android.widget.GridView;
import com.javiermunoz.calculatortest.R;
import com.javiermunoz.calculatortest.ui.home.CalculatorActivity;
import java.util.Map;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static com.android.support.test.deps.guava.base.Preconditions.checkNotNull;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;

/**
 * Created by javier.munoz on 23/12/14.
 */
@LargeTest
public class CalculatorTest extends ActivityInstrumentationTestCase2<CalculatorActivity> {

  public CalculatorTest() {
    super(CalculatorActivity.class);
  }

  @Override protected void setUp() throws Exception {
    super.setUp();
    getActivity();
  }

  public void testSumNumbers() {
    onView(allOf(withText("5"), withId(R.id.buttonCalculator))).perform(ViewActions.click());
    onView(allOf(withText("+"), withId(R.id.buttonCalculator))).perform(ViewActions.click());
    onView(allOf(withText("7"), withId(R.id.buttonCalculator))).perform(ViewActions.click());
    onView(allOf(withText("="), withId(R.id.buttonCalculator))).perform(ViewActions.click());
  }
}
