package cn.steve.dateCalendar;

import android.content.Context;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import java.util.ArrayList;

import cn.steve.study.R;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by yantinggeng on 2016/10/20.
 */

public class DayPickerView extends FrameLayout {

    private RecyclerView recyclerView;

    public DayPickerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.daypicker_layout, this, true);
        init();
    }

    private void init() {
        recyclerView = (RecyclerView) findViewById(R.id.dayPickerRecyclerView);
        GridLayoutManager mLayoutManager = new GridLayoutManager(this.getContext(), 7);
        recyclerView.setLayoutManager(mLayoutManager);
    }

    public void setData(final ArrayMap<String, DatePriceVO> datas) {
        Observable.create(new Observable.OnSubscribe<ArrayList<AdapterItem>>() {
            @Override
            public void call(Subscriber<? super ArrayList<AdapterItem>> subscriber) {
                Day2AdapterBuilder builder = new Day2AdapterBuilder();
                builder.setDatas(datas);
                ArrayList<AdapterItem> adapterItems = builder.generateAdapterDatas();
                subscriber.onNext(adapterItems);
            }
        })
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Action1<ArrayList<AdapterItem>>() {
                @Override
                public void call(ArrayList<AdapterItem> o) {
                    DayAdapter adapter = new DayAdapter();
                    adapter.setDatas(o);
                    recyclerView.setAdapter(adapter);
                }
            });
    }

}
