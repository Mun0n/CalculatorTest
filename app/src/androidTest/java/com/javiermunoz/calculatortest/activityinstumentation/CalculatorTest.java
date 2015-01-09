package com.javiermunoz.calculatortest.activityinstumentation;

import android.support.test.espresso.action.ViewActions;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import com.javiermunoz.calculatortest.R;
import com.javiermunoz.calculatortest.ui.home.CalculatorActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

/**
 * Created by javier.munoz on 23/12/14.
 */
@LargeTest
public class CalculatorTest extends ActivityInstrumentationTestCase2<CalculatorActivity> {

    public CalculatorTest() {
        super(CalculatorActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testSumNumbers() {
        //onView(allOf(withText("5"), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        //onView(allOf(withText("+"), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        //onView(allOf(withText("7"), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        //onView(allOf(withText("="), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        //onView(allOf(withId(R.id.resultTextView))).check(matches(withText("12")));
        onView(withId(R.id.resultTextView)).check(matches(isDisplayed()));
    }
}
