package com.snzflash.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.snzflash.mvp.R;
import com.snzflash.mvp.R2;
import com.snzflash.mvp.interfaces.IListView;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ListFragment<M> extends MvpFragment implements IListView<M> {

    @BindView(R2.id.emptyMessageTextView)
    TextView emptyMessageTextView;

    @BindView(R2.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R2.id.progressBar)
    ProgressBar progressBar;

    @BindView(R2.id.recyclerView)
    RecyclerView recyclerView;

    protected ArrayList<M> dataSet = new ArrayList<>();
    protected RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter = null;

    protected void setEmptyMessage(String message) {
        setEmptyMessageVisibility(!message.isEmpty());
        emptyMessageTextView.setText(message);


    }

    protected void setEmptyMessageVisibility(Boolean value) {
        int visibility = value ? View.GONE : View.VISIBLE;
        emptyMessageTextView.setVisibility(visibility);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_recycler_view, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    private void initViews() {

       swipeRefreshLayout.setOnRefreshListener(this::onSwipeToRefresh);

       setProgressBarVisible(false);

        int accent = ContextCompat.getColor(getActivity(), R.color.colorPrimary);
        swipeRefreshLayout.setColorSchemeColors(accent);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        adapter = createAdapter();

        if (adapter == null) {
            throw new IllegalArgumentException("createAdapter() should return adapter instance.");
        }
        recyclerView.setAdapter(adapter);
    }

   /* @Override
    protected void injectDependencies(AppComponent appComponent) {

    }*/

    @Override
    void beforeDestroy() {
        setProgressBarVisible(false);
    }

    @Override
    public void onPause() {
        super.onPause();
        setProgressBarVisible(false);
    }

    @Override
    public void showData(List<M> dataList) {
        dataSet.clear();
        dataSet.addAll(dataList);
        setSwipeLayoutRefreshingFalse();
        setLoadingVisible(false);
        setEmptyMessageVisibility(dataSet.isEmpty());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setLoadingVisible(Boolean value) {
        int visibility = value ? View.GONE : View.VISIBLE;
        progressBar.setVisibility(visibility);
        setSwipeLayoutRefreshingFalse();
    }

    protected void setSwipeLayoutRefreshingFalse(){
        if(swipeRefreshLayout.isRefreshing()){
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    protected void onSwipeToRefresh() {

    }

    @Override
    public void refreshDataList() {
        adapter.notifyDataSetChanged();
    }

    private void setProgressBarVisible(Boolean value){
        Float alpha = value ? 1.0f : 0.0f;
        try{
            Field f = swipeRefreshLayout.getClass().getDeclaredField("mCircleView");
            f.setAccessible(true);
            ImageView img = (ImageView) f.get(swipeRefreshLayout);
            img.setAlpha(alpha);
        }catch (Exception e){
            // don't need to anything
        }
    }

    protected RecyclerView.Adapter<? extends RecyclerView.ViewHolder> createAdapter() {
        return null;
    }
}
