package zqx.com.strong.B;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import zqx.com.strong.B.I.IBaseView;

/**
 * Created by Administrator on 2016/11/27.
 */

public abstract class BaseActivity<V extends IBaseView, P extends BasePresenter<V>> extends AppCompatActivity
        implements IBaseView{

    P mPresenter;
    int layoutId;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createPresenter().attachView((V) this);
        setContentView(onSetContent());
        if(layoutId!=0){
            onSetContent();
        }
        initView(null);
        initData();
    }

    @Override
    public int onSetContent() {
        return 0;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void initData() {

    }

    public abstract P createPresenter();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
        mPresenter=null;
    }

    protected void intentTo(Class<? extends Activity> clazz){
        Intent intent = new Intent();
        intent.setClass(this,clazz);
        startActivity(intent);
    }

    @Override
    public Context obtainContext() {
        return this;
    }

    @Override
    public Context obtainApplicationContext() {
        return getApplicationContext();
    }

}
