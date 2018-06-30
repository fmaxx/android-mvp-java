package com.snzflash.mvp.components;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;

public class AdapterBase<M extends ViewHolder> extends RecyclerView.Adapter<M> {
    @NonNull
    @Override
    public M onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull M holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        // @see https://github.com/airbnb/epoxy/wiki/Avoiding-Memory-Leaks
        // This will force all models to be unbound and their views recycled once the RecyclerView is no longer in use. We need this so resources
        // are properly released, listeners are detached, and views can be returned to view pools (if applicable).
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            ((LinearLayoutManager) recyclerView.getLayoutManager()).setRecycleChildrenOnDetach(true);
        }
    }
}
