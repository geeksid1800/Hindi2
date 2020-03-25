package com.example.hindi;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {



    /**
     * Create a new {@link CategoryAdapter} object.
     *
     * @param fm is the fragment manager that will keep each fragment's state in the adapter
     *           across swipes.
     */
    public CategoryAdapter(FragmentManager fm){
        super(fm);
    }

    //sets the titles for the sliding tabs
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "Numbers";
        } else if(position==1){
            return "Family";
        } else if(position==2){
            return "Colours";
        } else{
            return "Phrases";
        }
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new NumbersFragment();
        } else if (position == 1) {
            return new FamilyFragment();
        } else if (position == 2) {
            return new ColoursFragment();
        } else {
            return new PhrasesFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
