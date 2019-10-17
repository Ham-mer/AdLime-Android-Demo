package com.access_company.adlime.demo.activitys;

import android.os.Bundle;
import android.widget.ListView;

import com.access_company.adlime.demo.R;
import com.access_company.adlime.demo.adapter.SimpleMediationAdapter;
import com.access_company.adlime.demo.bean.Mediation;
import com.access_company.adlime.demo.utils.Utils;

import java.util.HashMap;

public class MediationListActivity extends BaseActivity {
    private ListView mListView;
    private HashMap<String, Mediation> mInfoMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_meditaion);
        getActionBar().setTitle("Netwrok Test");

        initData();
        initView();
    }

    private void initView() {
        mListView = findViewById(R.id.mediation_list);
        SimpleMediationAdapter adapter = new SimpleMediationAdapter(MediationListActivity.this, mInfoMap);
        mListView.setAdapter(adapter);
    }

    private void initData() {
        String info = Utils.getAssetsContent(MediationListActivity.this, "taurus_ad.json");
        mInfoMap = Utils.getMediation(info);
    }

}
