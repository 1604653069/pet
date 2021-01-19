package com.hong.pet.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hong.pet.R;
import com.hong.pet.model.Jx;
import com.youth.banner.Banner;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.indicator.CircleIndicator;

import java.util.List;


public class IndexJxAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private static final int ITEM_HEAD_TYPE = 0;
    private static final int ITEM_NORMAL_TYPE = 1;
    private List<Jx> jxes;
    public IndexJxAdapter(Context context, List<Jx> jxes){
        this.context = context;
        this.jxes = jxes;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType ==ITEM_HEAD_TYPE){
            return new HeaderHolder(LayoutInflater.from(context).inflate(R.layout.item_banner,parent,false));
        }else{
            return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_jx,parent,false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof HeaderHolder){
            bindViewHolderHeard((HeaderHolder)holder);
        }else
            bindViewHolderContent((MyViewHolder)holder);
    }

    private void bindViewHolderContent(MyViewHolder holder) {

    }

    private void bindViewHolderHeard(HeaderHolder holder) {
        holder.indeBanner
                .setAdapter(new ImageAdapter(jxes.get(0).getImgUrls()))
                .setIndicatorGravity(IndicatorConfig.Direction.RIGHT)
                .setIndicator(new CircleIndicator(context));
    }


    @Override
    public int getItemCount() {
        return jxes.size();
    }
    @Override
    public int getItemViewType(int position) {
        if(jxes.get(position).getType()==ITEM_HEAD_TYPE)
            return ITEM_HEAD_TYPE;
        else
            return ITEM_NORMAL_TYPE;
    }
    //内部类，绑定控件
    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView header;//头像
        TextView name;//名字
        TextView address;//位置
        TextView petName;//宠物名称
        TextView petType;//宠物类型
        Button btnLove;//关注
        TextView content;//内容
        ImageView contentImg;//内容图片
        RecyclerView headerRecyclerView;//点赞的头像
        LinearLayout zan;//点赞
        LinearLayout sendGif;//送礼
        LinearLayout comment;//评论
        LinearLayout shareTo;//分享
        public MyViewHolder(View itemView) {
            super(itemView);
            header = itemView.findViewById(R.id.index_jx_header_img);
            name = itemView.findViewById(R.id.index_jx_tv_name);
            address = itemView.findViewById(R.id.index_jx_tv_address);
            petName = itemView.findViewById(R.id.index_jx_tv_pet_name);
            petType = itemView.findViewById(R.id.index_jx_tv_pet_type);
            btnLove = itemView.findViewById(R.id.index_jx_btn_follow);
            content = itemView.findViewById(R.id.index_jx_tv_content);
            contentImg = itemView.findViewById(R.id.index_jx_content_img);
            headerRecyclerView = itemView.findViewById(R.id.index_jx_item_recyclerview_header);
            zan = itemView.findViewById(R.id.index_jx_common_good);
            sendGif = itemView.findViewById(R.id.index_jx_common_send_gift);
            comment = itemView.findViewById(R.id.index_jx_common_talk);
            shareTo = itemView.findViewById(R.id.index_jx_common_shareto);
        }
    }
    class HeaderHolder extends RecyclerView.ViewHolder{
        Banner indeBanner;
        public HeaderHolder(@NonNull View itemView) {
            super(itemView);
            indeBanner = itemView.findViewById(R.id.inde_banner);
        }
    }
}
