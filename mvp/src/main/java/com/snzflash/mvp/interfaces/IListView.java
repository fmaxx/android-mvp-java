package com.snzflash.mvp.interfaces;

import java.util.List;

public interface IListView<M> extends IView {

    void setLoadingVisible(Boolean isVisible);
    void showData(List<M> dataList);
    void refreshDataList();

}
