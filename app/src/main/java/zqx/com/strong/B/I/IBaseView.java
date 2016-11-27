package zqx.com.strong.B.I;

import android.content.Context;
import android.view.View;

/**
 * Created by Administrator on 2016/11/27.
 */

public interface IBaseView {
    int onSetContent();
    void initView(View view);
    void initData();
    Context obtainContext();
    Context obtainApplicationContext();
}
