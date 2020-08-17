package com.access_company.adlime.demo.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.access_company.adlime.core.api.ad.BannerAdView;
import com.access_company.adlime.core.api.listener.AdError;
import com.access_company.adlime.core.api.listener.SimpleAdListener;
import com.access_company.adlime.demo.R;


public class BannerActivity extends BaseActivity {

    private final String TAG = "BannerActivity";

    private Button mLoadButton;
    private LinearLayout mContainer;
    private String mBannerId;

    private BannerAdView mBannerAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().setTitle("BannerAdView");
        setContentView(R.layout.activity_banner);

        initData();
        // Init BannerAdView
        initBannerAdView();
    }

    private void initData() {
        Intent intent = getIntent();
        mBannerId = intent.getStringExtra("banner");
        mBannerId = "72614bef-cca0-42f9-9b40-ef82f3b4a94e";
    }

    private void initBannerAdView() {
        mContainer = findViewById(R.id.layout_banner);
        mLoadButton = findViewById(R.id.banner_load);
        mLoadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Load BannerAdView
                mBannerAdView.loadAd();
            }
        });

        if (mBannerId == null || TextUtils.isEmpty(mBannerId)) {
            mLoadButton.setVisibility(View.GONE);
            Toast.makeText(BannerActivity.this, "bannerId is null", Toast.LENGTH_SHORT).show();
            return;
        }

        mBannerAdView = new BannerAdView(this);
        mBannerAdView.setAdUnitId(mBannerId);

        // Listen Ad load result
        mBannerAdView.setAdListener(new SimpleAdListener() {
            @Override
            public void onAdLoaded() {
                Log.d(TAG, "BannerAdView onAdLoaded");
            }

            @Override
            public void onAdShown() {
                Log.d(TAG, "BannerAdView onAdShown");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mBannerAdView.loadAd();
                    }
                }, 10000);
            }

            @Override
            public void onAdClicked() {
                Log.d(TAG, "BannerAdView onAdClicked");
            }

            @Override
            public void onAdClosed() {
                Log.d(TAG, "BannerAdView onAdClosed");
            }

            @Override
            public void onAdFailedToLoad(AdError adError) {
                Log.d(TAG, "BannerAdView onAdFailedToLoad: " + adError.toString());
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mBannerAdView.loadAd();
                    }
                }, 100);
            }
        });
        mContainer.addView(mBannerAdView);
    }
}
