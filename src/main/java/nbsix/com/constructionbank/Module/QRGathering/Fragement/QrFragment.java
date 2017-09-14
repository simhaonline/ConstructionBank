package nbsix.com.constructionbank.Module.QRGathering.Fragement;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.OnClick;
import nbsix.com.constructionbank.App.app;
import nbsix.com.constructionbank.Module.Base.BaseFragment;
import nbsix.com.constructionbank.R;
import nbsix.com.constructionbank.Utils.EventUtil;
import nbsix.com.constructionbank.Utils.SystemBarHelper;


public class QrFragment extends BaseFragment {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.qr)
    ImageView qr;

    @OnClick(R.id.shoukuanjilu)
    public void goGj(){
        EventBus.getDefault().post(new EventUtil("流水明细"));
    }

    @OnClick(R.id.back)
    public void back(){
        getActivity().finish();
    }

    public static QrFragment newInstance() {

        return new QrFragment();
    }

    @Override
    public void initRecyclerView(){

    }
    @Override
    public int getLayoutResId() {
        return R.layout.fragment_qrgathering;
    }

    @Override
    public void finishCreateView(Bundle state) {
        SystemBarHelper.setHeightAndPadding(getContext(), toolbar);
        Glide.with(getContext()).load(R.drawable.qr_g_dsy).apply(app.optionsNormal).into(qr);
    }

}
