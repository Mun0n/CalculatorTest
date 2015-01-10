package com.javiermunoz.calculatortest.activityinstumentation;

import android.support.test.espresso.action.ViewActions;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import com.javiermunoz.calculatortest.R;
import com.javiermunoz.calculatortest.ui.home.CalculatorActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

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
        onView(allOf(withText("5"), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withText("+"), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withText("7"), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withText("="), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withId(R.id.resultTextView))).check(matches(withText("12")));
    }

    public void testZeroBeforeComma() {
        onView(allOf(withText("."), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withId(R.id.resultTextView))).check(matches(withText("0.")));
    }


    public void testJustOneComma() {
        onView(allOf(withText("."), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withText("2"), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withText("."), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withId(R.id.resultTextView))).check(matches(withText("0.2")));

    }

    public void testSumFloatNumbers() {
        onView(allOf(withText("5"), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withText("."), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withText("5"), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withText("+"), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withText("7"), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withText("="), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withId(R.id.resultTextView))).check(matches(withText("12.5")));
    }

    public void testSubtractNumbers() {
        onView(allOf(withText("7"), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withText("-"), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withText("5"), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withText("="), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withId(R.id.resultTextView))).check(matches(withText("2")));
    }

    public void testSubtractFloatNumbers() {
        onView(allOf(withText("7"), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withText("."), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withText("5"), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withText("-"), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withText("5"), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withText("="), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withId(R.id.resultTextView))).check(matches(withText("2.5")));
    }

    public void testMultpNumbers() {
        onView(allOf(withText("7"), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withText("*"), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withText("5"), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withText("="), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withId(R.id.resultTextView))).check(matches(withText("35")));
    }

    public void testMultpFloatNumbers() {
        onView(allOf(withText("7"), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withText("."), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withText("5"), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withText("*"), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withText("5"), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withText("="), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withId(R.id.resultTextView))).check(matches(withText("37.5")));
    }

    public void testDivNumbers() {
        onView(allOf(withText("1"), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withText("0"), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withText("/"), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withText("2"), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withText("="), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withId(R.id.resultTextView))).check(matches(withText("5")));
    }

    public void testDivFloatNumbers() {
        onView(allOf(withText("1"), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withText("0"), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withText("."), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withText("5"), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withText("/"), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withText("2"), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withText("="), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(allOf(withId(R.id.resultTextView))).check(matches(withText("5.25")));
    }

    public void testReset() {
        onView(allOf(withText("1"), withId(R.id.buttonCalculator))).perform(ViewActions.click());
        onView(withId(R.id.resultTextView)).perform(ViewActions.click());
        onView(allOf(withId(R.id.resultTextView))).check(matches(withText("0")));
    }
}
