package com.aris.paytraffic.fragments.notfication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.aris.paytraffic.R;
import com.aris.paytraffic.fragments.notfication.adapter.NotificationAdapter;
import com.aris.paytraffic.utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NotficationFragment extends Fragment {

    private NotficationViewModel mViewModel;
    RecyclerView recyclerView;
    List<Object> objects = new ArrayList<>();

    public static NotficationFragment newInstance() {
        return new NotficationFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.notfication_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(NotficationViewModel.class);
        // TODO: Use the ViewModel
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        recyclerView = view.findViewById(R.id.notification);
        Utils.loadDefaultRecyclerConfg(recyclerView,getContext());

        objects.addAll(Arrays.asList(
                NotificationAdapter.ViewType.NOTIFICATION,
                NotificationAdapter.ViewType.NOTIFICATION,
                NotificationAdapter.ViewType.NOTIFICATION,
                NotificationAdapter.ViewType.NOTIFICATION,
                NotificationAdapter.ViewType.NOTIFICATION,
                NotificationAdapter.ViewType.NOTIFICATION,
                NotificationAdapter.ViewType.NOTIFICATION

        ));

        NotificationAdapter notificationAdapter= new NotificationAdapter();
        recyclerView.setAdapter(notificationAdapter);
        notificationAdapter.setData(objects);

    }

}
