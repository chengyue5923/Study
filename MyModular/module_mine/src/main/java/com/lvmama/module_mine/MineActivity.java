package com.lvmama.module_mine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.steve.NameGenerate;

@NameGenerate
public class MineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);
    }
}
