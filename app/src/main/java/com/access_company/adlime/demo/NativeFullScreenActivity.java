package com.access_company.adlime.demo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.access_company.adlime.core.api.AdLime;
import com.access_company.adlime.core.api.ad.nativead.NativeAd;
import com.access_company.adlime.core.api.ad.nativead.layout.NativeAdLayout;
import com.access_company.adlime.core.api.listener.AdError;
import com.access_company.adlime.core.api.listener.SimpleAdListener;

public class NativeFullScreenActivity extends Activity {

    private final String TAG = "NativeFullScreen";
    private NativeAd mNativeAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native_fullscreen);
        initNativeAd();
        initView();
    }

    private void initNativeAd() {
        // Create NativeAd
        mNativeAd = new NativeAd(this);
        mNativeAd.setAdUnitId("444dd66b-af52-4fd1-9260-5559e7488432");

        mNativeAd.setNativeAdLayout(NativeAdLayout.getFullLayout4());

        // Listen Ad load result
        mNativeAd.setAdListener(new SimpleAdListener() {
            @Override
            public void onAdLoaded() {
                Log.d(TAG, "NativeAd onAdLoaded");
            }

            @Override
            public void onAdShown() {
                Log.d(TAG, "NativeAd onAdShown");
            }

            @Override
            public void onAdClicked() {
                Log.d(TAG, "NativeAd onAdClicked");
            }

            @Override
            public void onAdClosed() {
                Log.d(TAG, "NativeAd onAdClosed");
            }

            @Override
            public void onAdFailedToLoad(AdError adError) {
                Log.d(TAG, "NativeAd onAdFailedToLoad: " + adError);
            }
        });

        mNativeAd.loadAd();
    }

    private void initView() {
        // Ad NativeAd to UI
        ViewGroup nativeAdContainer = findViewById(R.id.nativead_container);
        nativeAdContainer.addView(mNativeAd.getAdView());

        ImageView close = findViewById(R.id.native_fullscreen_close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Release when app exit.
        AdLime.getDefault().release();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // You should add onBackPressed callback if you mediation Chartboost.
        AdLime.getDefault().onBackPressed(this);
    }
}
