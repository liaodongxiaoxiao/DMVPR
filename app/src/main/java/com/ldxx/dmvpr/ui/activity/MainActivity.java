package com.ldxx.dmvpr.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.ldxx.dmvpr.BuildConfig;
import com.ldxx.dmvpr.R;
import com.ldxx.dmvpr.adapter.MenuListAdapter;
import com.ldxx.dmvpr.base.BaseActivity;
import com.ldxx.dmvpr.component.AppComponent;
import com.ldxx.dmvpr.component.DaggerMainComponent;
import com.ldxx.dmvpr.model.bean.MenuList;
import com.ldxx.dmvpr.module.MainModule;
import com.ldxx.dmvpr.module.MenuListModule;
import com.ldxx.dmvpr.presenter.MainPresenter;
import com.ldxx.dmvpr.ui.view.MainView;
import com.ldxx.dmvpr.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainView {
    private static final String TAG = "MainActivity";
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.progress)
    ProgressBar progress;

    @Inject
    MainPresenter presenter;

    @Inject
    AppUtils appUtils;

    MenuListAdapter adapter;
    List<MenuList> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        adapter = new MenuListAdapter(data);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapter);
        Log.e(TAG, "onCreate: " + appUtils.getVersionName());
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void setupComponent(AppComponent appComponent) {
        DaggerMainComponent.builder()
                .appComponent(appComponent)
                .mainModule(new MainModule(this))
                .menuListModule(new MenuListModule(BuildConfig.BASE_HOST))
                .build()
                .inject(this);
    }

    @Override
    public void setItems(List<MenuList> items) {
        adapter.addData(items);
        Log.e(TAG, "setItems: "+adapter.getItemCount() );
    }

    @Override
    public void toast(String msg) {

    }

    @Override
    public void showProgress() {
        progress.setVisibility(View.VISIBLE);
        recycler.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progress.setVisibility(View.INVISIBLE);
        recycler.setVisibility(View.VISIBLE);
    }

    @Override
    public void requestSuccess(Object data, int tag) {

    }

    @Override
    public void requestError(Throwable e, int tag) {

    }
}
