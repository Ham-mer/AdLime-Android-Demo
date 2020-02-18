package com.access_company.adlime.demo.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.access_company.adlime.core.api.ad.MixViewAd;
import com.access_company.adlime.core.api.ad.nativead.layout.NativeAdLayout;
import com.access_company.adlime.core.api.listener.AdError;
import com.access_company.adlime.core.api.listener.SimpleAdListener;
import com.access_company.adlime.demo.R;
import com.access_company.adlime.demo.constance.Constance;

public class MixViewActivity extends BaseActivity {

    private final String TAG = "MixViewActivity";

    private Button mLoadButton;
    private Button mShowButton;
    private FrameLayout mContainer;

    private MixViewAd mMixViewAd;
    private String mMixViewId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().setTitle("MixViewAd");

        setContentView(R.layout.activity_mixview);

        initData();
        // Init MixViewAd
        initMixView();
    }

    private void initMixView() {
        mLoadButton = findViewById(R.id.mxiview_load);
        mLoadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Load MixViewAd
                mMixViewAd.loadAd();
            }
        });

        mShowButton = findViewById(R.id.mxiview_show);
        mShowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mShowButton.setEnabled(false);
                // Add MixViewAd AdView To UI
                View adView = mMixViewAd.getAdView();
                if (adView != null && adView != mContainer.getChildAt(0)) {
                    mContainer.removeAllViews();
                    mContainer.addView(adView);
                }
            }
        });

        mContainer = findViewById(R.id.layout_container);

        mMixViewAd = new MixViewAd(this);
        // Set AdUnitId
        mMixViewAd.setAdUnitId(mMixViewId);

        // Or Set NativeAdLayout Supported By AdLime To Render Ad
        mMixViewAd.setNativeAdLayout(NativeAdLayout.getLargeLayout2());

        // Or Set NativeAdLayoutPolicy To Render Ad
        // WeSdk Support SequenceNativeAdLayoutPolicy And RandomNativeAdLayoutPolicy
        // You Can Implement Your NativeAdLayoutPolicy
//        mMixViewAd.setNativeAdLayout(SequenceNativeAdLayoutPolicy.Builder()
//                .add(NativeAdLayout.getLargeLayout1())
//                .add(NativeAdLayout.getLargeLayout2())
//                .add(NativeAdLayout.getLargeLayout3())
//                .add(NativeAdLayout.getLargeLayout4())
//                .build());

        // Or Set MultiStyleNativeAdLayout To Render Ad
//        mMixViewAd.setNativeAdLayout(MultiStyleNativeAdLayout.Builder()
//                .setDefaultLayout(NativeAdLayout.getSmallLayout())
//                .setLargeImageLayout(NativeAdLayout.getLargeLayout3())
//                .setGroupImageLayout(NativeAdLayout.getLargeLayout2())
//                .setVideoLayout(NativeAdLayout.getLargeLayout4())
//                .build());

        // Set MixView Load Event
        mMixViewAd.setAdListener(new SimpleAdListener() {
            @Override
            public void onAdLoaded() {
                Log.d(TAG, "MixViewAd onAdLoaded");
                mShowButton.setEnabled(true);
            }

            @Override
            public void onAdFailedToLoad(AdError adError) {
                Log.d(TAG, "MixViewAd onAdFailedToLoad: " + adError.toString());
            }

            @Override
            public void onAdShown() {
                Log.d(TAG, "MixViewAd onAdShown");
            }

            @Override
            public void onAdClicked() {
                Log.d(TAG, "MixViewAd onAdClicked");
            }

            @Override
            public void onAdClosed() {
                Log.d(TAG, "MixViewAd onAdClosed");
            }
        });
    }

    private void initData() {
        Intent intent = getIntent();
        mMixViewId = intent.getStringExtra(Constance.BUNDLE_TYPE_MIXVIEW);
    }
}
