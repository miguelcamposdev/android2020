package com.miguelcr.a11_tabnavigation.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.miguelcr.a11_tabnavigation.R;
import com.miguelcr.a11_tabnavigation.UsuariosFragment;


public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // Devolver el Fragment que se carga en cada pestaña (tab).

        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        if(position == 0) {
            return PlaceholderFragment.newInstance(position + 1);
        }

        return new UsuariosFragment();

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        // Este método devuelve el título de cada pestaña
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Decide el nº de pestañas que se van a mostrar.
        return 2;
    }
}