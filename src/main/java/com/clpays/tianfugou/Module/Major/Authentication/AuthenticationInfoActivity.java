package com.clpays.tianfugou.Module.Major.Authentication;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import com.clpays.tianfugou.Adapter.CredentialsAdapter;
import com.clpays.tianfugou.App.app;
import com.clpays.tianfugou.Entity.Credentials.CredentialsItem;
import com.clpays.tianfugou.Module.Base.BaseActivity;
import com.clpays.tianfugou.Network.RequestProperty;
import com.clpays.tianfugou.Network.RetrofitHelper;
import com.clpays.tianfugou.R;
import com.clpays.tianfugou.Utils.SystemBarHelper;
import com.clpays.tianfugou.Utils.tools.isGetStringFromJson;
import com.google.gson.JsonObject;

public class AuthenticationInfoActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.head)
    ImageView head;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;


    @OnClick(R.id.back)
    public void back(){
        finish();
    }


    List<CredentialsItem> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SystemBarHelper.immersiveStatusBar(this);
        SystemBarHelper.setHeightAndPadding(this, toolbar);
        items=new ArrayList<>();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_authentication;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        Glide
                .with(this)
                .load(R.drawable.head)
                .apply(app.optionsRoundedCircle)
                .into(head);

        JsonObject obj= RequestProperty.CreateTokenJsonObjectBody();//带了Token的
        RetrofitHelper.getUcenterAPI()
                .getCardinfo(obj)
                .compose(this.bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(bean -> {
                    String a = bean.string();
                    if ("true".equals(isGetStringFromJson.handleData("success", a))) {

                    }
                    String message= isGetStringFromJson.handleData("message",a);
                }, throwable -> {
                    //ToastUtil.ShortToast("数据错误");
                });

      /*  List<CredentialsItem>
        CredentialsItem item=new CredentialsItem();
        item.setName("手机号码");
        item.setValue("18725663275");
        CredentialsItem item2=new CredentialsItem();
        item2.setName("账户名称");
        item2.setValue("段师傅");
        CredentialsItem item3=new CredentialsItem();
        item3.setName("账户号码");
        item3.setValue("622848047898762530");
        CredentialsItem item4=new CredentialsItem();
        item4.setName("账户状态");
        item4.setValue("冻结");
        items.add(item);
        items.add(item2);
        items.add(item3);
        items.add(item4);*/

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CredentialsAdapter adapter=new CredentialsAdapter(this,items);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void initToolBar() {

    }

}
