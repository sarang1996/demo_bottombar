package punchtech.demo_bottombar;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    private int[] tabIcons = {
            R.drawable.home_white,
            R.drawable.home_white,
            R.drawable.home_white,
            R.drawable.home_white,
            R.drawable.home_white
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.bottombar_pager);
        tabLayout = (TabLayout) findViewById(R.id.bottombar_tablayout);


        for (int i = 0; i < 5; i++) {
            tabLayout.addTab(tabLayout.newTab());
        }

        Pager adapter = new Pager(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.beginFakeDrag();
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        setupIcons();

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                switch (tabLayout.getSelectedTabPosition()) {
                    case 0:
                        setupIcons();
                        tabLayout.getTabAt(0).setIcon(R.drawable.notify_white);
                        viewPager.setCurrentItem(tab.getPosition());
                        break;
                    case 1:
                        setupIcons();
                        tabLayout.getTabAt(1).setIcon(R.drawable.notify_white);
                        viewPager.setCurrentItem(tab.getPosition());
                        break;
                    case 2:
                        setupIcons();
                        tabLayout.getTabAt(2).setIcon(R.drawable.notify_white);
                        viewPager.setCurrentItem(tab.getPosition());
                        break;
                    case 3:
                        setupIcons();
                        tabLayout.getTabAt(3).setIcon(R.drawable.notify_white);
                        viewPager.setCurrentItem(tab.getPosition());
                        break;
                    case 4:
                        setupIcons();
                        tabLayout.getTabAt(4).setIcon(R.drawable.notify_white);
                        viewPager.setCurrentItem(tab.getPosition());
                        break;
                    default:
                        break;
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void setupIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
        tabLayout.getTabAt(4).setIcon(tabIcons[4]);
    }

    public class Pager extends FragmentStatePagerAdapter {
            int tabCount;

        public Pager(FragmentManager fm, int tabCount) {
            super(fm);
            this.tabCount = tabCount;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new frag1();
                case 1:
                    return new frag2();
                case 2:
                    return new frag1();
                case 3:
                    return new frag2();
                case 4:
                    return new frag1();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return tabCount;
        }
    }
}
