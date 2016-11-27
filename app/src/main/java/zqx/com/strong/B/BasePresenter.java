package zqx.com.strong.B;

import java.lang.ref.WeakReference;

import zqx.com.strong.B.I.IBasePresenter;
import zqx.com.strong.B.I.IBaseView;

/**
 * Created by Administrator on 2016/11/27.
 */

public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter{
    WeakReference<V> view;

    public V getView() {
        return view.get();
    }

    public void attachView(V v){
        if(view==null){
            view = new WeakReference<>(v);
        }
    }

    public void detachView(){
        if(view!=null){
            view.clear();
            view=null;
        }
    }
}
