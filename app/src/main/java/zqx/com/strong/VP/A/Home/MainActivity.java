package zqx.com.strong.VP.A.Home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import zqx.com.strong.B.BaseActivity;
import zqx.com.strong.R;

public class MainActivity extends BaseActivity<IHome,HomePresenter> implements IHome{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public HomePresenter createPresenter() {
        return new HomePresenter();
    }
}
