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

package github.areebmalik1989.simplify_activities.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

import github.areebmalik1989.simplify_activities.R;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.MyViewHolder> {

    private List<Map.Entry<String, String>> noticeList;

    public NoticeAdapter(List<Map.Entry<String, String>> noticeList) {
        this.noticeList = noticeList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notice_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Map.Entry<String, String> entry = noticeList.get(position);

        holder.title.setText(entry.getKey());
        holder.body.setText(entry.getValue());
    }

    @Override
    public int getItemCount() {
        return noticeList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title, body;

        public MyViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);
        }
    }
}

