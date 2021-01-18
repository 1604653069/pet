package com.hong.pet.ui.activity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.hong.pet.R;
import com.hong.pet.base.BaseActivity;
import com.hong.pet.mvp.lar.LogOrRePresenter;
import com.hong.pet.mvp.lar.LogOrReView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class LogOrReActivity extends BaseActivity<LogOrRePresenter> implements LogOrReView {
    @BindView(R.id.log_or_re_regit_btn)
    Button logOrReRegitBtn;
    @BindView(R.id.log_or_re_login_btn)
    Button logOrReLoginBtn;
    @BindView(R.id.log_or_re_viewpager)
    ViewPager logOrReViewpager;
    private List<String> titles = new ArrayList<>();
    private List<String> contents = new ArrayList<>();
    private List<Integer> images = new ArrayList<>();
    private int[] ids = {R.id.one_tip,R.id.two_tip,R.id.three_tip,R.id.four_tip};
    private List<RadioButton> radioButtons = new ArrayList<>();
    @Override
    protected void dosomething() {
        makeStatusBarTransparent();
        intiView();
        logOrReViewpager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return titles.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view==object;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                View view = LayoutInflater.from(LogOrReActivity.this).inflate(R.layout.fragment_lor_layout,null);
                ImageView imageView = view.findViewById(R.id.lor_img);
                imageView.setImageResource(images.get(position));
                Glide.with(LogOrReActivity.this).load(images.get(position)).asGif().into(imageView);
                TextView title = view.findViewById(R.id.lor_title);
                title.setText(titles.get(position));
                TextView content = view.findViewById(R.id.lor_content);
                content.setText(contents.get(position));
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                View view = (View) object;
                container.removeView(view);
            }
        });
        logOrReViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for(int i=0;i<radioButtons.size();i++){
                    if(i==position)
                        radioButtons.get(i).setBackgroundResource(R.drawable.bander_sel);
                    else
                        radioButtons.get(i).setBackgroundResource(R.drawable.bander_un_sel);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void intiView() {
        titles.add("精选功能升级");
        titles.add("新增动态板块");
        titles.add("伤害才能新增拼团");
        titles.add("全新试用功能");

        contents.add("多图形展示,演绎爱宠生活点滴");
        contents.add("宠友热辣分享，第一时间就能看见");
        contents.add("和宠友一起买，享受超乎想象的优惠");
        contents.add("一键申请，各类宠物商品免费用");

        images.add(R.drawable.guide1);
        images.add(R.drawable.guide2);
        images.add(R.drawable.guide3);
        images.add(R.drawable.guide4);

        for(int i=0;i<ids.length;i++){
            RadioButton radioButton = this.findViewById(ids[i]);
            radioButtons.add(radioButton);
        }
    }
    @OnClick(R.id.log_or_re_regit_btn)
    public void regiterBtn(){
        startActivity(new Intent(this,RegiterActivity.class));
    }
    @OnClick(R.id.log_or_re_login_btn)
    public void loginBtn(){
        startActivity(new Intent(this,LoginActivity.class));
    }
    @Override
    protected LogOrRePresenter getPresenter() {
        return new LogOrRePresenter(this,this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_log_or_re;
    }

}
