package com.access_company.adlime.demo;

import android.app.Application;

import com.access_company.adlime.core.api.AdLime;
import com.access_company.adlime.core.api.AdLimeConfiguration;

public class TestApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        AdLime.getDefault().setGdprConsent(true);
        // Show Log
        AdLime.setTestServer("https://sdktest.adlime.net");
        AdLime.setLogEnable(true);
        // Init With AppId
        AdLimeConfiguration configuration = new AdLimeConfiguration.Builder(this)
                .appId("d13be96e-e172-4645-b761-4827a0ae8c0c")
                .build();
        AdLime.getDefault().initialize(this, configuration);
    }

}
