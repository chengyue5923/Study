package cn.steve.dateCalendar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import cn.steve.study.R;
import rx.Subscriber;

/**
 * Created by yantinggeng on 2016/10/20.
 */

public class DayPickerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datecalendar);
        final DayPickerView dayPickerView = (DayPickerView) findViewById(R.id.daypicker);
        ArrayMap<String, DatePriceVO> datas = new ArrayMap<>();

        Calendar cal = Calendar.getInstance();

        for (int i = 0; i < 100; i++) {
            DatePriceVO vo = new DatePriceVO();
            String date = formatDate(cal);
            vo.setDate(date);
            vo.setPrice("¥" + i);
            vo.setStock(i);
            datas.put(date, vo);
            cal.add(Calendar.DAY_OF_MONTH, 1);
        }

        Day2AdapterBuilder builder = new Day2AdapterBuilder();
        builder.withSelected("2016-11-11").getDayAdapter(datas, new Subscriber<BaseDayAdapter>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseDayAdapter baseDayAdapter) {
                dayPickerView.setAdapter(baseDayAdapter);
            }
        });

    }


    private String formatDate(Calendar cal) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = cal.getTime();
        return sdf.format(date);
    }
}