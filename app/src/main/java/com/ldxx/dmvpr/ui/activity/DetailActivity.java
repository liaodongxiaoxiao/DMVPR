package com.ldxx.dmvpr.ui.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.ldxx.dmvpr.R;
import com.ldxx.dmvpr.base.BaseActivity;
import com.ldxx.dmvpr.component.AppComponent;
import com.ldxx.dmvpr.component.DaggerDetailComponent;
import com.ldxx.dmvpr.model.bean.MenuDetail;
import com.ldxx.dmvpr.module.DetailModel;
import com.ldxx.dmvpr.module.MenuListModule;
import com.ldxx.dmvpr.presenter.DetailPresenter;
import com.ldxx.dmvpr.ui.view.DetailView;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.lujun.androidtagview.TagContainerLayout;

public class DetailActivity extends BaseActivity implements DetailView {

    @BindView(R.id.menu_name)
    TextView menuName;
    @BindView(R.id.menu_img)
    SimpleDraweeView menuImg;
    @BindView(R.id.menu_step)
    WebView menuStep;

    @Inject
    DetailPresenter presenter;
    @BindView(R.id.progress)
    ProgressBar progress;
    @BindView(R.id.scroll)
    View scroll;
    @BindView(R.id.menu_keywords)
    TagContainerLayout menuKeywords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        initToolBar();

        presenter.getDetail(getIntent().getStringExtra("id"));
    }

    private void initToolBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("做法详情");
        }
    }

    @Override
    protected void setupComponent(AppComponent appComponent) {
        DaggerDetailComponent.builder()
                .appComponent(appComponent)
                .detailModel(new DetailModel(this))
                .menuListModule(new MenuListModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void setDetail(MenuDetail detail) {
        menuName.setText(detail.getName());
        menuImg.setImageURI(Uri.parse("http://tnfs.tngou.net/img" + detail.getImg()));
        List<String> keywords = Arrays.asList( detail.getKeywords().split(" "));
        menuKeywords.setTags(keywords);
        menuStep.getSettings().setDefaultTextEncodingName("UTF-8");
        menuStep.loadData(detail.getMessage(), "text/html; charset=UTF-8", null);
    }

    @Override
    public void showProgress() {
        progress.setVisibility(View.VISIBLE);
        scroll.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        progress.setVisibility(View.GONE);
        scroll.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
