package cn.steve.toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import cn.steve.study.R;

/**
 * 测试toolbar的使用的demo <p/> <p/> Created by yantinggeng on 2015/11/10.
 */
public class ToolBarMainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        stardardToolbar();
        //customView();
    }

    private void stardardToolbar() {
        //调用setSupportActionBar方法的目的是将Toolbar作为ActionBar来对待，仅此而已
        //这时候。将会把toolBar当做actionbar一样使用
//      setSupportActionBar(toolbar);
        //不设置setSupportActionBar就可以很自由的操作toolbar了
        //设置主标题及其颜色
        toolbar.setTitle("此处可以自定义的标题");
        toolbar.setTitleTextColor(getResources().getColor(R.color.yellow_light));
        // 设置次标题及其颜色
        toolbar.setSubtitle("SteveYan");
        toolbar.setSubtitleTextColor(Color.LTGRAY);
        // 设置导航按钮
        toolbar.setNavigationIcon(R.drawable.ic_launcher);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ToolBarMainActivity.this, "导航按钮！", Toast.LENGTH_SHORT).show();
            }
        });
        // 设置Logo图标
        toolbar.setLogo(R.drawable.customer_icon);

        toolbar.inflateMenu(R.menu.toolbar_menu);
        //为菜单的每一项设置监听
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(ToolBarMainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private void customView() {
        setSupportActionBar(toolbar);
        View view = LayoutInflater.from(this).inflate(R.layout.wechat_me, null);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(view);
    }

}
