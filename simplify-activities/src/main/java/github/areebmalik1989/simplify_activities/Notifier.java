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

package github.areebmalik1989.simplify_activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.HashMap;

import github.areebmalik1989.simplify_activities.activity.iActivity.INotice;
import github.areebmalik1989.simplify_activities.activity.Notice;

public class Notifier {

    private Context context;

    public Notifier(Context context){
        this.context = context;
    }

    /**
     * Method to start NoticeActivity
     * @param title : Sets the title in the actionbar
     * @param noticeMap : Map key and value will be used for notice title and body respectively.
     */
    public void showNotice(String title, HashMap<String, String> noticeMap){

        Bundle bundle = new Bundle();
        bundle.putString(INotice.TITLE_KEY, title);
        bundle.putSerializable(INotice.MAP_KEY, noticeMap);

        Intent intent = new Intent(context, Notice.class);
        intent.putExtra(INotice.BUNDLE_KEY, bundle);
        context.startActivity(intent);
    }
}
