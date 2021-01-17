package com.hong.pet.rxjava;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;


import com.hong.pet.base.BaseRespon;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver<T> implements Observer<BaseRespon<T>> {
    private boolean showDialog =true;
    private ProgressDialog progressDialog;
    private Context context;
    private Disposable disposable;
    @Override
    public void onSubscribe(Disposable d) {
        this.disposable = d;
        if(!isConnected(this.context)){
            Toast.makeText(context, "网络未连接", Toast.LENGTH_SHORT).show();
            if(this.disposable.isDisposed())
                this.disposable.dispose();
            cancleRequest();
        }else{
            if(progressDialog==null&&showDialog==true){
                progressDialog = new ProgressDialog(context);
                progressDialog.setMessage("正在加载中...");
                progressDialog.show();
            }
        }
        Log.i("TAG","onSubscribe");
    }
    public BaseObserver(Context context){
        this(context,true);
    }
    public BaseObserver(Context context,boolean showDialog){
        this.context = context;
        this.showDialog = showDialog;
    }
    @Override
    public void onNext(BaseRespon<T> tBaseRespon) {
        Log.i("TAG","onNext");
        if(tBaseRespon.getCode()==200){
            onSuccess(tBaseRespon.getData());
        } else{
            onFailure(null,tBaseRespon.getMsg());
        }
        hidDialog();
    }

    @Override
    public void onError(Throwable e) {
        Log.i("TAG","onError");
        progressDialog.dismiss();
        onFailure(e, RxExceptionUtil.exceptionHandler(e));
    }

    @Override
    public void onComplete() {
        Log.i("TAG","onComplete");
        cancleRequest();
    }
    public void hidDialog() {
        if (progressDialog != null && showDialog == true){
            progressDialog.dismiss();
            progressDialog = null;
        }


    }
    /**
     * 是否有网络连接，不管是wifi还是数据流量
     * @param context
     * @return
     */
    public static boolean isConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info == null) {
            return false;
        }
        boolean available = info.isAvailable();
        return available;
    }
    /**
     * 取消订阅
     */
    public void cancleRequest(){
        if (disposable!=null&&disposable.isDisposed()) {
            disposable.dispose();
            hidDialog();
        }
    }

    public abstract void onSuccess(T t);
    public abstract void onFailure(Throwable t,String errorMessage);
}
