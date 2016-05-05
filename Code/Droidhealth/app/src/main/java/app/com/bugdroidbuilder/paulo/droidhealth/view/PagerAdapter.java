package app.com.bugdroidbuilder.paulo.droidhealth.view;

/**
 *
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import app.com.bugdroidbuilder.paulo.droidhealth.view.advices.AdvicesFragment;
import app.com.bugdroidbuilder.paulo.droidhealth.view.profile.ProfileFragment;


public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        //return a fragment according to the ViewPager position
        switch (position) {
            case 0:
                return new ProfileFragment();
            case 1:
                return new AdvicesFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
