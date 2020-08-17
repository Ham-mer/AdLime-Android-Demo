package com.access_company.adlime.demo;

import android.app.Application;

import com.access_company.adlime.core.api.AdLime;

public class TestApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        AdLime.getDefault().setTestMode(true);
        AdLime.getDefault().setGdprConsent(true);
        // Show Log
        AdLime.getDefault().setLogEnable(true);
        // Init With AppId
        AdLime.getDefault().init(this, "7e01c979-8379-4595-acc2-27c701525b77");
        AdLime.getDefault().setNetworkDebugMode(true);
//        AdLime.getDefault().setNetworkTestMode(true);
    }
}
