package com.hong.pet.ui.fragment;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.hong.pet.R;
import com.hong.pet.base.BaseFragment;
import com.hong.pet.mvp.main.index.IndexPresenter;
import com.hong.pet.mvp.main.index.IndexView;
import com.hong.pet.ui.fragment.index.ActivityFragment;
import com.hong.pet.ui.fragment.index.ChannelFragment;
import com.hong.pet.ui.fragment.index.GoodSelectedFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class FragmentIndex extends BaseFragment<IndexPresenter> implements IndexView {


    @BindView(R.id.index_tab_layout)
    TabLayout indexTabLayout;
    @BindView(R.id.index_viewpager)
    ViewPager indexViewpager;
    private String[] titles = {"精选","动态","频道"};
    private List<Fragment> fragments = new ArrayList<>();
    @Override
    public int getLayoutId() {
        return R.layout.fragment_index;
    }

    @Override
    protected void dosomething() {
        fragments.add(new GoodSelectedFragment());
        fragments.add(new ActivityFragment());
        fragments.add(new ChannelFragment());
        for(int i=0;i<titles.length;i++)
            indexTabLayout.addTab(indexTabLayout.newTab().setText(titles[i]));
        indexViewpager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        });
        indexTabLayout.setupWithViewPager(indexViewpager,false);
    }

    @Override
    protected IndexPresenter getPresenter() {
        return new IndexPresenter(getContext(), this);
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void onFail(String message) {

    }
}
