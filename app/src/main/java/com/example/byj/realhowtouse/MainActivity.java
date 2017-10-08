package com.example.byj.realhowtouse;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    PagerAdapter adapter;

    private static int currentpage = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // viewpager code
        viewPager = (ViewPager)findViewById(R.id.pager);
        adapter = new ViewPagerAdapter(getApplicationContext());
        viewPager.setAdapter(adapter);

        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentpage = 1;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if(state == ViewPager.SCROLL_STATE_IDLE) {
                    int pagecount = 3;
                    if(currentpage==0) {
                        viewPager.setCurrentItem(pagecount - 1, false);
                    }
                    else if (currentpage == pagecount - 1){
                        viewPager.setCurrentItem(0, false);
                    }
                }
            }
        });
    }
}
