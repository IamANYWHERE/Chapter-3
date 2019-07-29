package com.example.chapter3.homework;


import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;

import java.util.ArrayList;
import java.util.List;

public class PlaceholderFragment extends Fragment {

    private LottieAnimationView lottieAnimationView;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        View view = inflater.inflate(R.layout.fragment_placeholder, container, false);
        lottieAnimationView = view.findViewById(R.id.view_lottie_friend_list_loading);
        recyclerView = view.findViewById(R.id.view_recycler);
        FriendsListAdapter adapter = new FriendsListAdapter(getContext(), getData(30));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    private List<String> getData(int size) {
        List<String> data = new ArrayList<>();
        for (int i = 0; i<size; i++){
            data.add("friend "+ (i+1));
        }
        return data;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lottieAnimationView.setRepeatMode(LottieDrawable.RESTART);
        lottieAnimationView.setRepeatCount(View.INVISIBLE);
        lottieAnimationView.playAnimation();
        recyclerView.setAlpha(0);
        recyclerView.setVisibility(View.INVISIBLE);

        final Animator animator1 = AnimatorInflater.loadAnimator(getContext(), R.animator.fade_out);
        final Animator animator2 = AnimatorInflater.loadAnimator(getContext(), R.animator.fade_in);
        final AnimatorSet set = new AnimatorSet();
        set.play(animator1).with(animator2);
        animator1.setTarget(lottieAnimationView);
        animator2.setTarget(recyclerView);
        animator1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                lottieAnimationView.pauseAnimation();
                lottieAnimationView.setVisibility(View.INVISIBLE);
            }
        });
        animator2.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                recyclerView.setVisibility(View.VISIBLE);
            }
        });
        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                set.start();
            }
        }, 5000);
    }
}
