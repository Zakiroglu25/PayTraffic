package com.aris.paytraffic.fragments.mainMenu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.aris.paytraffic.R;
import com.aris.paytraffic.fragments.mainMenu.adapter.MainMenuAdapter;
import com.aris.paytraffic.utils.Utils;
import com.aris.paytraffic.viewPager.CardPagerAdapter;
import com.aris.paytraffic.viewPager.ShadowTransformer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainMenuFragment extends Fragment {

    private MainMenuViewModel mViewModel;
    RecyclerView recyclerView;
    List<Object> objects = new ArrayList<>();
    MainMenuAdapter mainMenuAdapter;


    public static MainMenuFragment newInstance() {
        return new MainMenuFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(this).get(MainMenuViewModel.class);
        return inflater.inflate(R.layout.main_menu_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainMenuViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        recyclerView = view.findViewById(R.id.add_Shablon);
        Utils.loadDefaultRecyclerConfg(recyclerView,getContext());

       ViewPager pager =  view.findViewById(R.id.viewPager);

        CardPagerAdapter cardPagerAdapter = new CardPagerAdapter();
        ShadowTransformer mCardShadowTransformer = new ShadowTransformer(pager, cardPagerAdapter);


        pager.setAdapter(new CardPagerAdapter());
        //todo kursat mene shekilleri liste cevirib soxmagi izahliyarsan
       // pager.setPageTransformer(false,new ShadowTransformer());


        objects.addAll(Arrays.asList(
                MainMenuAdapter.ViewType.ADDSHABLON,
                MainMenuAdapter.ViewType.SHABLON,
                MainMenuAdapter.ViewType.SHABLON,
                MainMenuAdapter.ViewType.SHABLON,
                MainMenuAdapter.ViewType.SHABLON,
                MainMenuAdapter.ViewType.SHABLON,
                MainMenuAdapter.ViewType.SHABLON,
                MainMenuAdapter.ViewType.SHABLON,
                MainMenuAdapter.ViewType.SHABLON,
                MainMenuAdapter.ViewType.SHABLON
        ));


        mainMenuAdapter = new MainMenuAdapter();
        recyclerView.setAdapter(mainMenuAdapter);
        mainMenuAdapter.setData(objects);

    }
}
