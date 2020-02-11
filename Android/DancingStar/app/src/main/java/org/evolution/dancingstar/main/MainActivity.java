package org.evolution.dancingstar.main;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import org.evolution.dancingstar.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mDanceRecyclerView;
    private ArrayList<Dance> mDanceList;
    private LinearLayoutManager mLinearLayoutManager;
    private LinearLayout mLayoutVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLayoutVideo = findViewById(R.id.main_layout_video);

        mDanceList = new ArrayList<>();
        mDanceList.add(new Dance("아무노래","지코(ZICO)"));
        mDanceList.add(new Dance("아무노래2","지코(ZICO)2"));
        mDanceList.add(new Dance("아무노래3","지코(ZICO)3"));
        mDanceList.add(new Dance("아무노래4","지코(ZICO)4"));
        mDanceList.add(new Dance("아무노래5","지코(ZICO)5"));
        mDanceList.add(new Dance("아무노래","지코(ZICO)"));
        mDanceList.add(new Dance("아무노래2","지코(ZICO)2"));
        mDanceList.add(new Dance("아무노래3","지코(ZICO)3"));
        mDanceList.add(new Dance("아무노래4","지코(ZICO)4"));
        mDanceList.add(new Dance("아무노래5","지코(ZICO)5"));
        mDanceList.add(new Dance("아무노래","지코(ZICO)"));
        mDanceList.add(new Dance("아무노래2","지코(ZICO)2"));
        mDanceList.add(new Dance("아무노래3","지코(ZICO)3"));
        mDanceList.add(new Dance("아무노래4","지코(ZICO)4"));
        mDanceList.add(new Dance("아무노래5","지코(ZICO)5"));

        mDanceRecyclerView = findViewById(R.id.main_recycler_dance);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mDanceRecyclerView.setLayoutManager(mLinearLayoutManager);
        DanceAdapter danceAdapter = new DanceAdapter(mDanceList);
        mDanceRecyclerView.setAdapter(danceAdapter);
        danceAdapter.setOnItemClickListener(new DanceAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                v.setBackgroundColor(Color.parseColor("#7f9f85"));
                mLayoutVideo.setVisibility(View.VISIBLE);
            }
        });
    }
}
