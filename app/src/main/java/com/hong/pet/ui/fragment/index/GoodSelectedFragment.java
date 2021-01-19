package com.hong.pet.ui.fragment.index;

import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hong.pet.R;
import com.hong.pet.adapter.ImageAdapter;
import com.hong.pet.adapter.IndexJxAdapter;
import com.hong.pet.base.BaseFragment;
import com.hong.pet.model.Jx;
import com.hong.pet.mvp.main.index.IndexPresenter;
import com.hong.pet.mvp.main.index.IndexView;
import com.youth.banner.Banner;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class GoodSelectedFragment extends BaseFragment<IndexPresenter> implements IndexView {
    @BindView(R.id.fragment_index_good_recycler)
    RecyclerView fragmentIndexGoodRecycler;
//    @BindView(R.id.inde_banner)
//    Banner indeBanner;

    private List<String> titles = new ArrayList<>();
    private List<Integer> imgUrl = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.fragment_index_good_sel;
    }

    @Override
    protected void dosomething() {
        imgUrl.add(R.mipmap.jx_header_1);
        imgUrl.add(R.mipmap.jx_header_2);
        imgUrl.add(R.mipmap.jx_header_3);
        imgUrl.add(R.mipmap.jx_header_4);
        imgUrl.add(R.mipmap.jx_header_5);
//        indeBanner.addBannerLifecycleObserver(this)//添加生命周期观察者
//                .setAdapter(new ImageAdapter(imgUrl))
//                .setIndicatorGravity(IndicatorConfig.Direction.RIGHT)
//                .setIndicator(new CircleIndicator(getContext()));
        List<Jx> jxes = new ArrayList<>();
        for(int i=0;i<6;i++){
            Jx jx = new Jx();
            if(i==0){
                jx.setType(0);
                jx.setImgUrls(imgUrl);
            }else{
                jx.setType(1);
            }
            jxes.add(jx);
        }
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        fragmentIndexGoodRecycler.setLayoutManager(manager);
        fragmentIndexGoodRecycler.setAdapter(new IndexJxAdapter(getContext(),jxes));
    }

    @Override
    public void onStart() {
        super.onStart();
//        indeBanner.start();
    }

    @Override
    public void onStop() {
        super.onStop();
//        indeBanner.stop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //indeBanner.destroy();
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
