package com.birhman.yearcalendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import org.joda.time.DateTime;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private final static int MIN_YEAR = 1945;
    private final static int MAX_YEAR = 2045;
    private YearFragmentAdapter yearFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        yearFragmentAdapter = new YearFragmentAdapter(getSupportFragmentManager(), buildListOfYears());
        viewPager.setAdapter(yearFragmentAdapter);
        selectFirstDisplayedYear();
    }

    private ArrayList<Integer> buildListOfYears() {
        ArrayList<Integer> listYears = new ArrayList<>();
        for (int i = MIN_YEAR; i <= MAX_YEAR; i++) {
            listYears.add(i);
        }
        return listYears;
    }

    private void selectFirstDisplayedYear() {
        if (yearFragmentAdapter != null) {
            int defaultYear = new DateTime().getYear();
            int desiredYearPosition = yearFragmentAdapter.getYearPosition(defaultYear);
            if (desiredYearPosition > -1)
                viewPager.setCurrentItem(desiredYearPosition);
        }
    }
}