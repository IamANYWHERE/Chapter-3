package com.example.chapter3.homework;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lingyihong on 2019-07-29 16:01
 *
 * @author lingyihong@bytedance.com
 */
public class FriendsListAdapter extends RecyclerView.Adapter<FriendsListAdapter.FriendHolder> {

    private Context context;
    private List<String> data;

    public FriendsListAdapter(Context context, List<String> data){
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public FriendHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,viewGroup, false);
        FriendHolder holder = new FriendHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FriendHolder friendHolder, int i) {
        friendHolder.textView.setText(data.get(i));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class FriendHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public FriendHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.view_item);
        }
    }
}
