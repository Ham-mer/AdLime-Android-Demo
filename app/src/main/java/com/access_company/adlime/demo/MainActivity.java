package com.access_company.adlime.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.access_company.adlime.demo.activitys.LoadModeActivity;
import com.access_company.adlime.demo.activitys.MediationActivity;
import com.access_company.adlime.demo.activitys.MediationListActivity;
import com.access_company.adlime.demo.constance.Constance;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        TextView base = findViewById(R.id.base_test);
        base.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, MediationActivity.class);
                intent.putExtra(Constance.BUNDLE_NETWORK_NAME, "Base Test");
                intent.putExtra(Constance.BUNDLE_TYPE_BANNER_320_50,Constance.CREATIVE_BANNER_ID);
                intent.putExtra(Constance.BUNDLE_TYPE_BANNER_320_100,Constance.CREATIVE_BANNER_ID);
                intent.putExtra(Constance.BUNDLE_TYPE_BANNER_300_250,Constance.CREATIVE_BANNER_ID);
                intent.putExtra(Constance.BUNDLE_TYPE_BANNER_468_60,Constance.CREATIVE_BANNER_ID);
                intent.putExtra(Constance.BUNDLE_TYPE_BANNER_728_90,Constance.CREATIVE_BANNER_ID);
                intent.putExtra(Constance.BUNDLE_TYPE_REWARDED,Constance.CREATIVE_REWARDED_ID);
                intent.putExtra(Constance.BUNDLE_TYPE_INTERSTITIAL,Constance.CREATIVE_INTERSTITIAL_ID);
                intent.putExtra(Constance.BUNDLE_TYPE_NATIVE,Constance.CREATIVE_NATIVE_ID);
                startActivity(intent);
            }
        });
        TextView networks = findViewById(R.id.networks_test);
        networks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, MediationListActivity.class);
                startActivity(intent);
            }
        });
        TextView strategy = findViewById(R.id.strategy_test);
        strategy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, LoadModeActivity.class);
                startActivity(intent);

            }
        });
    }
}
