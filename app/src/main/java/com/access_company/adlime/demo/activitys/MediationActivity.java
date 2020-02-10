package com.access_company.adlime.demo.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import com.access_company.adlime.demo.R;
import com.access_company.adlime.demo.constance.Constance;


public class MediationActivity extends BaseActivity {

    private final String TAG = "MainActivity";

    //    private String mBannerId_320_50;
//    private String mBannerId_320_100;
//    private String mBannerId_300_250;
//    private String mBannerId_468_60;
//    private String mBannerId_728_90;
//    private String mInterstitialId;
//    private String mNativeId;
//    private String mRewardedId;
//    private String mMixViewId;
//    private String mMixFullScreenId;
    private String mBannerInfo;
    private String mInterstitialInfo;
    private String mNativeInfo;
    private String mRewardedInfo;
    private String mMixViewInfo;
    private String mMixFullScreenInfo;
    private String mNetworkName;

    // BannerAd
//    private Button mBannerLoadButton_320_50;
//    private Button mBannerLoadButton_320_100;
//    private Button mBannerLoadButton_300_250;
//    private Button mBannerLoadButton_468_60;
//    private Button mBannerLoadButton_728_90;


    // BannerAd
    private Button mBannerLoadButton;
    // NativeAd
    private Button mNativeLoadButton;

    // InterstitialAd
    private Button mInterstitialLoadButton;

    // RewardedVideoAd
    private Button mRewardedLoadButton;

    // MixedViewAd
    private Button mMixViewLoadButton;

    // MixFullScreen
    private Button mMixFullScreenLoadButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mediation);
        initData();
        getActionBar().setTitle(mNetworkName);
        // Init Ads
        initBannerAdView();
        initNativeAd();
        initInterstitialAd();
        initRewardedVideoAd();
        initMixViewAd();
        initMixFullScreen();
    }

    private void initData() {
        Intent intent = getIntent();
        mNetworkName = intent.getStringExtra(Constance.BUNDLE_NETWORK_NAME);
        mBannerInfo = intent.getStringExtra(Constance.BUNDLE_TYPE_BANNER);
        mNativeInfo = intent.getStringExtra(Constance.BUNDLE_TYPE_NATIVE);
        mInterstitialInfo = intent.getStringExtra(Constance.BUNDLE_TYPE_INTERSTITIAL);
        mRewardedInfo = intent.getStringExtra(Constance.BUNDLE_TYPE_REWARDED);
        mMixViewInfo = intent.getStringExtra(Constance.BUNDLE_TYPE_MIXVIEW);
        mMixFullScreenInfo = intent.getStringExtra(Constance.BUNDLE_TYPE_MIXFULLSCREEN);
    }

    private void initBannerAdView() {
        // Load Ad
//        mBannerLoadButton_320_50 = findViewById(R.id.banner_button_320_50);
//        if (mBannerId_320_50 == null || TextUtils.isEmpty(mBannerId_320_50)) {
//            mBannerLoadButton_320_50.setVisibility(View.GONE);
//        }
//        mBannerLoadButton_320_50.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClass(MediationActivity.this, BannerActivity.class);
//                intent.putExtra("banner", mBannerId_320_50);
//                startActivity(intent);
//            }
//        });
//
//        mBannerLoadButton_320_100 = findViewById(R.id.banner_button_320_100);
//        if (mBannerLoadButton_320_100 == null || TextUtils.isEmpty(mBannerId_320_100)) {
//            mBannerLoadButton_320_100.setVisibility(View.GONE);
//        }
//        mBannerLoadButton_320_100.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClass(MediationActivity.this, BannerActivity.class);
//                intent.putExtra("banner", mBannerId_320_100);
//                startActivity(intent);
//            }
//        });
//
//        mBannerLoadButton_300_250 = findViewById(R.id.banner_button_300_250);
//        if (mBannerId_300_250 == null || TextUtils.isEmpty(mBannerId_300_250)) {
//            mBannerLoadButton_300_250.setVisibility(View.GONE);
//        }
//        mBannerLoadButton_300_250.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClass(MediationActivity.this, BannerActivity.class);
//                intent.putExtra("banner", mBannerId_300_250);
//                startActivity(intent);
//            }
//        });
//
//        mBannerLoadButton_468_60 = findViewById(R.id.banner_button_468_60);
//        if (mBannerId_468_60 == null || TextUtils.isEmpty(mBannerId_468_60)) {
//            mBannerLoadButton_468_60.setVisibility(View.GONE);
//        }
//        mBannerLoadButton_468_60.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClass(MediationActivity.this, BannerActivity.class);
//                intent.putExtra("banner", mBannerId_468_60);
//                startActivity(intent);
//            }
//        });
//
//        mBannerLoadButton_728_90 = findViewById(R.id.banner_button_728_90);
//        if (mBannerId_728_90 == null || TextUtils.isEmpty(mBannerId_728_90)) {
//            mBannerLoadButton_728_90.setVisibility(View.GONE);
//        }
//        mBannerLoadButton_728_90.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClass(MediationActivity.this, BannerActivity.class);
//                intent.putExtra("banner", mBannerId_728_90);
//                startActivity(intent);
//            }
//        });
        mBannerLoadButton = findViewById(R.id.banner_button);
        if (mBannerInfo == null || TextUtils.isEmpty(mBannerInfo)) {
            mBannerLoadButton.setVisibility(View.GONE);
        }
        mBannerLoadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MediationActivity.this, AdContainerActivity.class);
                intent.putExtra(Constance.BUNDLE_TYPE_MEDIATION_NAME, mNetworkName);
                intent.putExtra(Constance.BUNDLE_TYPE_JSON, Constance.BUNDLE_TYPE_BANNER);
                intent.putExtra(Constance.BUNDLE_TYPE_INFO, mBannerInfo);
                startActivity(intent);
            }
        });
    }

    private void initNativeAd() {
        mNativeLoadButton = findViewById(R.id.native_button);
        if (mNativeInfo == null || TextUtils.isEmpty(mNativeInfo)) {
            mNativeLoadButton.setVisibility(View.GONE);
            return;
        }
        mNativeLoadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MediationActivity.this, AdContainerActivity.class);
                intent.putExtra(Constance.BUNDLE_TYPE_MEDIATION_NAME, mNetworkName);
                intent.putExtra(Constance.BUNDLE_TYPE_JSON, Constance.BUNDLE_TYPE_NATIVE);
                intent.putExtra(Constance.BUNDLE_TYPE_INFO, mNativeInfo);
                startActivity(intent);
            }
        });
    }

    private void initInterstitialAd() {
        // Create InterstitialAd
        mInterstitialLoadButton = findViewById(R.id.interstitial_button);

        if (mInterstitialInfo == null || TextUtils.isEmpty(mInterstitialInfo)) {
            mInterstitialLoadButton.setVisibility(View.GONE);
            return;
        }
        mInterstitialLoadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MediationActivity.this, AdContainerActivity.class);
                intent.putExtra(Constance.BUNDLE_TYPE_MEDIATION_NAME, mNetworkName);
                intent.putExtra(Constance.BUNDLE_TYPE_JSON, Constance.BUNDLE_TYPE_INTERSTITIAL);
                intent.putExtra(Constance.BUNDLE_TYPE_INFO, mInterstitialInfo);
                startActivity(intent);
            }
        });

    }

    private void initRewardedVideoAd() {
        // Create RewardedVideoAd
        mRewardedLoadButton = findViewById(R.id.rewardedvideo_button);

        if (mRewardedInfo == null || TextUtils.isEmpty(mRewardedInfo)) {
            mRewardedLoadButton.setVisibility(View.GONE);
            return;
        }
        mRewardedLoadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MediationActivity.this, AdContainerActivity.class);
                intent.putExtra(Constance.BUNDLE_TYPE_MEDIATION_NAME, mNetworkName);
                intent.putExtra(Constance.BUNDLE_TYPE_JSON, Constance.BUNDLE_TYPE_REWARDED);
                intent.putExtra(Constance.BUNDLE_TYPE_INFO, mRewardedInfo);
                startActivity(intent);
            }
        });

    }

    private void initMixViewAd() {
        // Create RewardedVideoAd
        mMixViewLoadButton = findViewById(R.id.mixview_button);

        if (mMixViewInfo == null || TextUtils.isEmpty(mMixViewInfo)) {
            mMixViewLoadButton.setVisibility(View.GONE);
            return;
        }
        mMixViewLoadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MediationActivity.this, AdContainerActivity.class);
                intent.putExtra(Constance.BUNDLE_TYPE_MEDIATION_NAME, mNetworkName);
                intent.putExtra(Constance.BUNDLE_TYPE_JSON, Constance.BUNDLE_TYPE_MIXVIEW);
                intent.putExtra(Constance.BUNDLE_TYPE_INFO, mMixViewInfo);
                startActivity(intent);
            }
        });

    }

    private void initMixFullScreen() {
        // Create RewardedVideoAd
        mMixFullScreenLoadButton = findViewById(R.id.mixfullscreen_button);

        if (mMixFullScreenInfo == null || TextUtils.isEmpty(mMixFullScreenInfo)) {
            mMixFullScreenLoadButton.setVisibility(View.GONE);
            return;
        }
        mMixFullScreenLoadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MediationActivity.this, AdContainerActivity.class);
                intent.putExtra(Constance.BUNDLE_TYPE_MEDIATION_NAME, mNetworkName);
                intent.putExtra(Constance.BUNDLE_TYPE_JSON, Constance.BUNDLE_TYPE_MIXFULLSCREEN);
                intent.putExtra(Constance.BUNDLE_TYPE_INFO, mMixFullScreenInfo);
                startActivity(intent);
            }
        });

    }
}

