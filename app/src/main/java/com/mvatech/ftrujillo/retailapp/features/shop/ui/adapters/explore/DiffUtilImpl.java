package com.mvatech.ftrujillo.retailapp.features.shop.ui.adapters.explore;

import androidx.recyclerview.widget.DiffUtil;

import java.util.List;

public class DiffUtilImpl<T> extends DiffUtil.Callback {
    private final List<T> mOldList;
    private final List<T> mNewList;

    public DiffUtilImpl(List<T> oldList, List<T> newList) {
        this.mOldList = oldList;
        this.mNewList = newList;
    }

    @Override
    public int getOldListSize() {
        return mOldList.size();
    }

    @Override
    public int getNewListSize() {
        return mNewList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldList.get(oldItemPosition) == mNewList.get(newItemPosition);
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldList.get(oldItemPosition).equals(mNewList.get(newItemPosition));
    }
}
