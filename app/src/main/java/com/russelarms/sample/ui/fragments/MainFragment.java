package com.russelarms.sample.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.russelarms.sample.R;
import com.russelarms.sample.data.managers.DataManager;
import com.russelarms.sample.data.model.Photo;
import com.russelarms.sample.data.model.PxResponse;
import com.russelarms.sample.data.network.AbstractRequestListener;
import com.russelarms.sample.ui.activities.BaseSpiceActivity;
import com.russelarms.sample.ui.adapters.PhotoAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ruslan on 09.01.2016.
 */
public class MainFragment extends Fragment {

    public static final String TAG = "MainFragment";

    private RecyclerView mRecyclerView;
    private PhotoAdapter mAdapter;

    private DataManager mDataManager;

    private List<Photo> mPhotos = new ArrayList<>();

    public static MainFragment newInstance() {
        Bundle args = new Bundle();

        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        loadData();
        initRecycler(v);

        return v;
    }

    private void loadData() {
        mPhotos = new ArrayList<>();

        mDataManager = DataManager.getInstance();

        mDataManager.getPhotos(1, new AbstractRequestListener<PxResponse>() {
            @Override
            public void onRequestSuccess(PxResponse pxResponse) {
                List<Photo> photos = pxResponse.photos;

                if (photos != null && !photos.isEmpty()) {
                    mPhotos.addAll(photos);
                    mAdapter.notifyDataSetChanged();
                }
            }
        }, ((BaseSpiceActivity) getActivity()).getSpiceManager());
    }

    void initRecycler(View v) {
        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(false);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new PhotoAdapter(mPhotos);
        mRecyclerView.setAdapter(mAdapter);
    }

}
