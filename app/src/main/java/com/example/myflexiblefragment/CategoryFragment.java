package com.example.myflexiblefragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment implements View.OnClickListener {


    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_category, container, false);
    }
    @Override

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnDetailCategory = view.findViewById(R.id.btn_detail_category);
        btnDetailCategory.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId()== R.id.btn_detail_category);
        DetaiCategoryFragment mDetaiCategoryFragment = new DetaiCategoryFragment();

        Bundle mBundle = new Bundle();
        mBundle.putString(DetaiCategoryFragment.EXTRA_NAME,"LifeStyle");
        String description = "Kategori ini berisi produk2 lifeStyle";

        mDetaiCategoryFragment.setArguments(mBundle);
        mDetaiCategoryFragment.setDescription(description);

        FragmentManager mFragmentManager = getFragmentManager();
        if (mFragmentManager!= null){
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.frame_container, mDetaiCategoryFragment,DetaiCategoryFragment.class.getSimpleName());
            mFragmentTransaction.addToBackStack(null);
            mFragmentTransaction.commit();
        }
    }
}
