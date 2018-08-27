/*
 * Copyright 2018 Areeb Malik
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package github.areebmalik1989.simplify_activities.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import github.areebmalik1989.simplify_activities.R;
import github.areebmalik1989.simplify_activities.activity.iActivity.INotice;
import github.areebmalik1989.simplify_activities.adapter.NoticeAdapter;

public class Notice extends AppCompatActivity implements INotice {

    private String title;

    private RecyclerView recyclerView;
    private NoticeAdapter adapter;
    private List<Map.Entry<String, String>> noticeList;
    private Map<String, String> noticeMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        noticeList = new CopyOnWriteArrayList<>();
        adapter = new NoticeAdapter(noticeList);

        Bundle bundle = getIntent().getBundleExtra(BUNDLE_KEY);

        noticeMap = (Map<String, String>) bundle.getSerializable(MAP_KEY);
        title = bundle.getString(TITLE_KEY);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);

        recyclerView = findViewById(R.id.notice_recyclerview);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        setTitle();
        update();
    }

    private void update(){

        noticeList.removeAll(noticeList.subList(0, noticeList.size()));

        noticeList.addAll(noticeMap.entrySet());

        adapter.notifyDataSetChanged();
    }

    private void setTitle(){

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(title);
    }
}
