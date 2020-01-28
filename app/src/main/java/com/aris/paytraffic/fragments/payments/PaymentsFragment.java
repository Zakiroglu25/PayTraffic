package com.aris.paytraffic.fragments.payments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aris.paytraffic.R;
import com.aris.paytraffic.adapter.RecyclerViewAdapter;
import com.aris.paytraffic.drawerMenu.model.Category;

import java.util.ArrayList;
import java.util.List;

public class PaymentsFragment extends Fragment {

    private PaymentsViewModel mViewModel;
    private RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<Category> categoryList;


    public static PaymentsFragment newInstance() {
        return new PaymentsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.payments_fragment, container, false);
    return root;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        //initialize every thing first
        categoryList = new ArrayList<>();
        //add animals to our animalsList
        categoryList.add(new Category("QR Kodla ödə" , R.drawable.qr_code));
        categoryList.add(new Category("Mobil" , R.drawable.payments_phone));
        categoryList.add(new Category("Kabel TV" , R.drawable.television));
        categoryList.add(new Category("Telefon" , R.drawable.phone_alt));
        categoryList.add(new Category("Kommunal" , R.drawable.construction));
        categoryList.add(new Category("İnternet" , R.drawable.global));
        categoryList.add(new Category("Nəqliyyat" , R.drawable.sports_car));
        categoryList.add(new Category("Sığorta" , R.drawable.unbrella));
        categoryList.add(new Category("Dövlət ödənişləri" , R.drawable.note));
        categoryList.add(new Category("Naxçıvan MR" , R.drawable.flag));
        categoryList.add(new Category("Bank ödənişləri" , R.drawable.money));
        categoryList.add(new Category("Təhsil" , R.drawable.college));

        recyclerViewAdapter = new RecyclerViewAdapter(categoryList);

        recyclerView = view.findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(recyclerViewAdapter);


    }

    }
