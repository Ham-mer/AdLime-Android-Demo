package com.access_company.adlime.demo.bean;

import com.access_company.adlime.demo.constance.Constance;

import org.json.JSONObject;

public class Mediation {
    private String mName;
//    private String mBannerId_320_50;
//    private String mBannerId_320_100;
//    private String mBannerId_300_250;
//    private String mBannerId_468_60;
//    private String mBannerId_728_90;
//    private String mInterstitialId;
//    private String mRewardedId;
//    private String mNativeId;
//    private String mMixView;
//    private String mMixFullScreen;

    private JSONObject mBannerJson;
    private JSONObject mNativeJson;
    private JSONObject mInterstitalJson;
    private JSONObject mRewardedVideoJson;
    private JSONObject mMixViewJson;
    private JSONObject mMixFullScreenJson;

    public Mediation() {

    }

    public static Mediation fromJson(JSONObject object) {
        Mediation mediation = new Mediation();
        mediation.mName = object.optString(Constance.BUNDLE_TYPE_MEDIATION_NAME);
        mediation.mBannerJson = object.optJSONObject(Constance.BUNDLE_TYPE_BANNER);
        mediation.mNativeJson = object.optJSONObject(Constance.BUNDLE_TYPE_NATIVE);
        mediation.mInterstitalJson = object.optJSONObject(Constance.BUNDLE_TYPE_INTERSTITIAL);
        mediation.mRewardedVideoJson = object.optJSONObject(Constance.BUNDLE_TYPE_REWARDED);
        mediation.mMixViewJson = object.optJSONObject(Constance.BUNDLE_TYPE_MIXVIEW);
        mediation.mMixFullScreenJson = object.optJSONObject(Constance.BUNDLE_TYPE_MIXFULLSCREEN);
//        mediation.mBannerId_320_50 = object.optString(Constance.BUNDLE_TYPE_BANNER_320_50);
//        mediation.mBannerId_320_100 = object.optString(Constance.BUNDLE_TYPE_BANNER_320_100);
//        mediation.mBannerId_300_250 = object.optString(Constance.BUNDLE_TYPE_BANNER_300_250);
//        mediation.mBannerId_468_60 = object.optString(Constance.BUNDLE_TYPE_BANNER_468_60);
//        mediation.mBannerId_728_90 = object.optString(Constance.BUNDLE_TYPE_BANNER_728_90);
//        mediation.mInterstitialId = object.optString(Constance.BUNDLE_TYPE_INTERSTITIAL);
//        mediation.mNativeId = object.optString(Constance.BUNDLE_TYPE_NATIVE);
//        mediation.mRewardedId = object.optString(Constance.BUNDLE_TYPE_REWARDED);
//        mediation.mMixView = object.optString(Constance.BUNDLE_TYPE_MIXVIEW);
//        mediation.mMixFullScreen = object.optString(Constance.BUNDLE_TYPE_MIXFULLSCREEN);

        return mediation;
    }

    public void setName(String name) {
        this.mName = name;
    }

//    public void setBannerId(String bannerId) {
//        this.mBannerId_320_50 = bannerId;
//    }
//
//    public void setInterstitialId(String interstitialId) {
//        this.mInterstitialId = interstitialId;
//    }
//
//    public void setRewardedId(String rewardedId) {
//        this.mRewardedId = rewardedId;
//    }
//
//    public void setNativeId(String nativeId) {
//        this.mNativeId = nativeId;
//    }

    public String getmName() {
        return mName;
    }


    //    public String getBannerId_320_50() {
//        return mBannerId_320_50;
//    }
//
//    public String getBannerId_320_100() {
//        return mBannerId_320_100;
//    }
//
//    public String getBannerId_300_250() {
//        return mBannerId_300_250;
//    }
//
//    public String getBannerId_468_60() {
//        return mBannerId_468_60;
//    }
//
//    public String getBannerId_728_90() {
//        return mBannerId_728_90;
//    }
//
//    public String getInterstitialId() {
//        return mInterstitialId;
//    }
//
//    public String getRewardedId() {
//        return mRewardedId;
//    }
//
//    public String getNativeId() {
//        return mNativeId;
//    }
//
//    public String getMixViewId() {
//        return mMixView;
//    }
//
//    public String getMixFullScreen() {
//        return mMixFullScreen;
//    }
    public JSONObject getBannerJson() {
        return mBannerJson;
    }


    public JSONObject getNativeJson() {
        return mNativeJson;
    }

    public JSONObject getInterstitalJson() {
        return mInterstitalJson;
    }

    public JSONObject getRewardedVideoJson() {
        return mRewardedVideoJson;
    }

    public JSONObject getMixViewJson() {
        return mMixViewJson;
    }

    public JSONObject getMixFullScreenJson() {
        return mMixFullScreenJson;
    }

}
