package com.birhman.yearcalendar;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class YearFragment extends Fragment implements YearView.MonthGestureListener {
        private final static String YEAR_TAG = "pagal";
        private YearView yearView;
        private TextView txtYear;
        private int year = 2018;

        public static YearFragment newInstance(int year) {
                final YearFragment mf = new YearFragment();
                final Bundle args = new Bundle();
                args.putInt(YEAR_TAG, year);
                mf.setArguments(args);
                return mf;
        }

        public YearFragment() {}

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                if(getArguments() != null)
                        this.year = getArguments().getInt(YEAR_TAG, this.year);
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
                final View v = inflater.inflate(R.layout.year_fragment, container, false);

                txtYear = (TextView) v.findViewById(R.id.txtYear);
                yearView = (YearView) v.findViewById(R.id.yearView);
                yearView.setMonthGestureListener(this);
                txtYear.setText("" + this.year);
                yearView.setYear(this.year);
                return v;
        }

        @Override
        public void onMonthClick(long timeInMillis) {
                DateTime dateTime = new DateTime(timeInMillis);
                DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM");
                Log.d("tiya", "onMonthClick: " + formatter.print(dateTime));
        }

        @Override
        public void onMonthLongClick(long timeInMillis) {
                DateTime dateTime = new DateTime(timeInMillis);
                DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM");
                Log.d("tiya", "onMonthLongClick: " + formatter.print(dateTime));
        }

        @Override
        public void onDayClick(long timeInMillis) {
                DateTime dateTime = new DateTime(timeInMillis);
                DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
                Log.d("tiya", "onDayClick: " + formatter.print(dateTime));
        }

        @Override
        public void onDayLongClick(long timeInMillis) {
                DateTime dateTime = new DateTime(timeInMillis);
                DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
                Log.d("tiya", "onDayLongClick: " + formatter.print(dateTime));
        }

        @Override
        public void onDestroyView() {
                if(yearView != null)
                        yearView.setMonthGestureListener(null);
                super.onDestroyView();
        }
}