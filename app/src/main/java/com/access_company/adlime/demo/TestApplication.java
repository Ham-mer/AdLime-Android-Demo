package com.access_company.adlime.demo;

import android.app.Application;

import com.access_company.adlime.core.api.AdLime;
import com.facebook.ads.AdSettings;

public class TestApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        AdLime.getDefault().setTestMode(true);
        AdLime.getDefault().setGdprConsent(true);
        // Show Log
        AdLime.getDefault().setLogEnable(true);
        // Init With AppId
        AdLime.getDefault().init(this, "d13be96e-e172-4645-b761-4827a0ae8c0c");
    }
}
