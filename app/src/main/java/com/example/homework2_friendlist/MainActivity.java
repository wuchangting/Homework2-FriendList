package com.example.homework2_friendlist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.airbnb.lottie.LottieAnimationView;
import com.example.homework2_friendlist.adapter.MyFragmentStateAdapter;
import com.example.homework2_friendlist.fragment.VPFragment;
import com.example.homework2_friendlist.fragment.VPFriendFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

        private ViewPager viewPager;

        private BottomNavigationView bottomNavigationView;

        private MyFragmentStateAdapter myFragmentStateAdaper;

        private List<Fragment> fragmentList;

        private LottieAnimationView lottieAnimationView;



        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            lottieAnimationView = findViewById(R.id.lottie_layer);

            viewPager = findViewById(R.id.vpf_nav_tab);
            bottomNavigationView = findViewById(R.id.bottom_tab_menu);

            initData();

            myFragmentStateAdaper = new MyFragmentStateAdapter(getSupportFragmentManager(), fragmentList);
            viewPager.setAdapter(myFragmentStateAdaper);
            //页面滑动时，导航栏也改变
            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    onPagerScrolled(position);

                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });

            //导航栏与viewpager建立连接
            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    int id = item.getItemId();
                    if (id == R.id.menu_home)
                        viewPager.setCurrentItem(0);
                    else if (id == R.id.menu_chat)
                        viewPager.setCurrentItem(1);
                    else if (id == R.id.menu_my)
                        viewPager.setCurrentItem(2);

                    return true;

                }
            });
        }

        public void initData () {
            fragmentList = new ArrayList<>();

            VPFragment fragment1 = VPFragment.newInstance("首页", "");
            VPFragment fragment2 = VPFragment.newInstance("我的", "");
            VPFriendFragment friendFragment = VPFriendFragment.newInstance("聊天", "");

            fragmentList.add(fragment1);
            fragmentList.add(friendFragment);
            fragmentList.add(fragment2);

        }

        private void onPagerScrolled ( int position){
            switch (position) {
                case 0:
                    bottomNavigationView.setSelectedItemId(R.id.menu_home);
                    break;
                case 1:
                    bottomNavigationView.setSelectedItemId(R.id.menu_chat);
                    break;

                case 2:
                    bottomNavigationView.setSelectedItemId(R.id.menu_my);
                    break;
                default:
                    break;
            }
        }
    }
