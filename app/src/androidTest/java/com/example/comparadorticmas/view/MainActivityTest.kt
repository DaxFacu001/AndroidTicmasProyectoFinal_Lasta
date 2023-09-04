package com.example.comparadorticmas.view

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.comparadorticmas.R

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
internal class MainActivityTest {
 @get: Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun mainActivity_CompareInitText(){
        Espresso.onView(
            ViewMatchers.withId(R.id.buttonCompare)
        ).perform(ViewActions.click())


    Espresso.onView(
    ViewMatchers.withId(R.id.textResult)
    ).check(
        ViewAssertions.matches(
       ViewMatchers.withText("Son iguales"))
        )


    }

    @Test
    fun mainActivity_CompareDifText() {

        Espresso.onView(
            ViewMatchers.withId(R.id.editText1)
        ).perform(ViewActions.typeText("diferente"))

        ViewActions.closeSoftKeyboard()

        Espresso.onView(
            ViewMatchers.withId(R.id.buttonCompare)
        ).perform(ViewActions.click())


        Espresso.onView(
            ViewMatchers.withId(R.id.textResult)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Son diferentes"))
        )


    }
}