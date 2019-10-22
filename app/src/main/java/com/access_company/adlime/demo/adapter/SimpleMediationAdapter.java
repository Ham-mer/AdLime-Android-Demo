package com.access_company.adlime.demo.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.access_company.adlime.demo.R;
import com.access_company.adlime.demo.activitys.MediationActivity;
import com.access_company.adlime.demo.bean.Mediation;
import com.access_company.adlime.demo.constance.Constance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class SimpleMediationAdapter extends BaseAdapter {
    private Context mContext;
    private HashMap<String, Mediation> mMediationMap;
    private ArrayList<String> mList = new ArrayList<>();

    public SimpleMediationAdapter(Context context, HashMap<String, Mediation> maps) {
        mContext = context;
        mMediationMap = (HashMap<String, Mediation>) maps.clone();
        Set<String> keys = mMediationMap.keySet();
        for (String key: keys) {
            mList.add(key);
        }
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public String getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextViewHolder holder;
        if (convertView == null) {
            holder = new TextViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_textview, null);
            holder.mTextView = (TextView) convertView;
            convertView.setTag(holder);
        } else {
            holder = (TextViewHolder) convertView.getTag();
        }
        holder.mTextView.setText(getItem(position));
        holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mediation mediation = mMediationMap.get(getItem(position));
                Intent intent = new Intent();
                intent.putExtra(Constance.BUNDLE_NETWORK_NAME, mediation.getmName());
                intent.putExtra(Constance.BUNDLE_TYPE_BANNER, mediation.getBannerId());
                intent.putExtra(Constance.BUNDLE_TYPE_INTERSTITIAL, mediation.getInterstitialId());
                intent.putExtra(Constance.BUNDLE_TYPE_REWARDED, mediation.getRewardedId());
                intent.putExtra(Constance.BUNDLE_TYPE_NATIVE, mediation.getNativeId());
                intent.setClass(mContext, MediationActivity.class);
                mContext.startActivity(intent);

            }
        });
        return convertView;
    }

    class TextViewHolder {
        public TextView mTextView;
    }
}