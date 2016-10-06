package com.lapism.searchview.sample.undone;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.lapism.searchview.SearchAdapter;
import com.lapism.searchview.sample.base.BaseActivity;


public class HistoryToggleActivity extends BaseActivity {

    @Override
    protected int getNavItem() {
        return NAV_ITEM_HISTORY_TOGGLE;
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Toast.makeText(HistoryToggleActivity.this, "Fetching from entire database", Toast.LENGTH_SHORT).show();
        if (mFab != null) {
            mFab.setOnClickListener(new View.OnClickListener() {
                int clickCount = 0;

                @Override
                public void onClick(View v) {
                    clickCount++;
                    if (clickCount == 4)
                        clickCount = 1;
                    SearchAdapter adapter = (SearchAdapter) mSearchView.getAdapter();
                    adapter.setDatabaseKey(clickCount);
                    Toast.makeText(HistoryToggleActivity.this, "Fetching from version " + clickCount, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}