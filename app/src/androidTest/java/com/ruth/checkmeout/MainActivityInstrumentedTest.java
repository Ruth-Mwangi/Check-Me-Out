package com.ruth.checkmeout;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.ruth.checkmeout.ui.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void goToScanner() {
        onView(withId(R.id.txtGoToScan)).perform(click());
    }

    @Test
    public void openDrawer() throws InterruptedException {
        onView(withId(R.id.activity_main)).perform(click());
        onView(withId(R.id.signInLink)).perform(click());
        onView(withId(R.id.logInEmail)).perform(typeText("rwmwangi96@gmail.com"));
        onView(withId(R.id.logInPassword)).perform(typeText("Trinidad96"));
        onView(withId(R.id.logInButton)).perform(click());

    }
}
