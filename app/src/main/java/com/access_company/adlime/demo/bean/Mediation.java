package com.access_company.adlime.demo.bean;

import com.access_company.adlime.demo.constance.Constance;

import org.json.JSONObject;

public class Mediation {
    private String mName;
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
        return mediation;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getmName() {
        return mName;
    }

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
