package zqx.com.strong.B;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zqx.com.strong.B.I.IBaseView;

/**
 * Created by Administrator on 2016/11/27.
 */

public abstract class BaseFragment<V extends IBaseView,P extends BasePresenter<V>>
        extends Fragment implements IBaseView{
    P mPresenter;
    int layoutId;


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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(onSetContent(),container,false);
        createPresenter().attachView((V) view);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
        mPresenter=null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
    }

    @Override
    public Context obtainContext() {
        return getContext();
    }

    @Override
    public Context obtainApplicationContext() {
        return getContext().getApplicationContext();
    }
}
