package com.access_company.adlime.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.access_company.adlime.demo.activitys.LoadModeActivity;
import com.access_company.adlime.demo.activitys.MediationActivity;
import com.access_company.adlime.demo.activitys.MediationListActivity;
import com.access_company.adlime.demo.bean.Mediation;
import com.access_company.adlime.demo.constance.Constance;
import com.access_company.adlime.demo.utils.Utils;

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
                Mediation mediation = Utils.getMediationSingle(Utils.getAssetsContent(MainActivity.this, "base_ad.json"));
                intent.putExtra(Constance.BUNDLE_NETWORK_NAME, "Base_Test");
                if (mediation.getBannerJson() != null) {
                    intent.putExtra(Constance.BUNDLE_TYPE_BANNER, mediation.getBannerJson().toString());
                }
                if (mediation.getInterstitalJson() != null) {
                    intent.putExtra(Constance.BUNDLE_TYPE_INTERSTITIAL, mediation.getInterstitalJson().toString());
                }
                if (mediation.getNativeJson() != null) {
                    intent.putExtra(Constance.BUNDLE_TYPE_NATIVE, mediation.getNativeJson().toString());
                }
                if (mediation.getRewardedVideoJson() != null) {
                    intent.putExtra(Constance.BUNDLE_TYPE_REWARDED, mediation.getRewardedVideoJson().toString());
                }
                if (mediation.getMixViewJson() != null) {
                    intent.putExtra(Constance.BUNDLE_TYPE_MIXVIEW, mediation.getMixViewJson().toString());
                }
                if (mediation.getMixFullScreenJson() != null) {
                    intent.putExtra(Constance.BUNDLE_TYPE_MIXFULLSCREEN, mediation.getMixFullScreenJson().toString());
                }
                intent.setClass(MainActivity.this, MediationActivity.class);
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
