package com.example.homework2_friendlist.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.airbnb.lottie.LottieAnimationView;
import com.example.homework2_friendlist.Message;
import com.example.homework2_friendlist.R;
import com.example.homework2_friendlist.adapter.MyFragmentVPTAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VPFriendFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VPFriendFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    private ViewPager viewPager;

    private TabLayout tabLayout;

    private List<Fragment> fragmentList;

    private MyFragmentVPTAdapter myFragmentVPTAdapter;

    private List<String> stringList;

    private LottieAnimationView lottie;


    public VPFriendFragment() {
        // Required empty public constructor
    }


    public static VPFriendFragment newInstance(String param1, String param2) {
        VPFriendFragment fragment = new VPFriendFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_v_p_friend, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPager = view.findViewById(R.id.tab_viewpager);
        tabLayout = view.findViewById(R.id.tab_layout);

        lottie = view.findViewById(R.id.lottie_layer1);


        initData();

        myFragmentVPTAdapter = new MyFragmentVPTAdapter(getChildFragmentManager(),fragmentList,stringList);
        viewPager.setAdapter(myFragmentVPTAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                lottie.setVisibility(LottieAnimationView.VISIBLE);
                lottie.playAnimation();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        lottie.cancelAnimation();
                        lottie.setVisibility(LottieAnimationView.INVISIBLE);
                    }
                },5000);
            }

            @Override
            public void onPageSelected(int position) {

                Log.d("lottie", "PageSelected执行"+position);
                lottie.setVisibility(LottieAnimationView.VISIBLE);
                lottie.playAnimation();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        lottie.cancelAnimation();
                        lottie.setVisibility(LottieAnimationView.INVISIBLE);
                    }
                },5000);


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    public void initData(){
        fragmentList = new ArrayList<>();

        VPFragment fragment1 = VPFragment.newInstance("好友列表","");
        VPFragment fragment2 = VPFragment.newInstance("我的好友","");
        VPFragment fragment3 = VPFragment.newInstance("附近的人","");
        VPFragment fragment4 = VPFragment.newInstance("群聊","");


        fragmentList.add(fragment1);
        fragmentList.add(fragment2);
        fragmentList.add(fragment3);
        fragmentList.add(fragment4);


        stringList = new ArrayList<>();
        stringList.add("好友列表");
        stringList.add("我的好友");
        stringList.add("附近的人");
        stringList.add("群聊");


    }
}