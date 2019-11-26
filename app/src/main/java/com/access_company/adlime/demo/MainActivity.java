package com.access_company.adlime.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.access_company.adlime.core.api.AdLimeLoader;
import com.access_company.adlime.core.api.ad.nativead.layout.NativeAdLayout;
import com.access_company.adlime.core.api.listener.SimpleAdListener;
import com.access_company.adlime.demo.activitys.LoadModeActivity;

public class MainActivity extends Activity {

    private FrameLayout mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        mContainer = findViewById(R.id.layout_container);
    }

    private void initView() {
        TextView base = findViewById(R.id.base_test);
        base.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClass(MainActivity.this, MediationActivity.class);
//                intent.putExtra(Constance.BUNDLE_NETWORK_NAME, "Base Test");
//                intent.putExtra(Constance.BUNDLE_TYPE_BANNER,Constance.CREATIVE_BANNER_ID);
//                intent.putExtra(Constance.BUNDLE_TYPE_REWARDED,Constance.CREATIVE_REWARDED_ID);
//                intent.putExtra(Constance.BUNDLE_TYPE_INTERSTITIAL,Constance.CREATIVE_INTERSTITIAL_ID);
//                intent.putExtra(Constance.BUNDLE_TYPE_NATIVE,Constance.CREATIVE_NATIVE_ID);
//                startActivity(intent);

                AdLimeLoader.loadMixViewAd(MainActivity.this,
                        "43e3423b-b841-4e9f-96a8-d7e0783362d3",
                        NativeAdLayout.getMediumLayout(), new SimpleAdListener() {
                            @Override
                            public void onAdLoaded() {
                                mContainer.removeAllViews();
                                AdLimeLoader.showMixViewAd("43e3423b-b841-4e9f-96a8-d7e0783362d3", mContainer);
                            }
                        });
            }
        });
        TextView networks = findViewById(R.id.networks_test);
        networks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClass(MainActivity.this, MediationListActivity.class);
//                startActivity(intent);

                AdLimeLoader.loadMixFullScreenAd(MainActivity.this,
                        "e21882d5-820b-4844-a428-48ba84b5ac32",
                        NativeAdLayout.getFullLayout3(), new SimpleAdListener() {
                            @Override
                            public void onAdLoaded() {
                                AdLimeLoader.showMixFullScreenAd("e21882d5-820b-4844-a428-48ba84b5ac32");
                            }
                        });
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
