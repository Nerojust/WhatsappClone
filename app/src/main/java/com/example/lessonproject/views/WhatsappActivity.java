package com.example.lessonproject.views;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.lessonproject.R;
import com.example.lessonproject.views.fragments.ButterFragment;
import com.example.lessonproject.views.fragments.ChatFragment;
import com.example.lessonproject.views.fragments.DashboardFragment;
import com.example.lessonproject.views.fragments.ProfileFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class WhatsappActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whatsapp);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        setupViewPager(viewPager);
        viewPager.setCurrentItem(1);
        Toolbar toolbar = findViewById(R.id.toolbar);

        ImageView searchIcon = toolbar.findViewById(R.id.search);
        ImageView moreIcon = toolbar.findViewById(R.id.more_icon);
        ImageView cameraIcon = toolbar.findViewById(R.id.camera_icon);

        // Set click listener for the toolbar title
        searchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle title click
                Toast.makeText(WhatsappActivity.this, "Search Icon clicked", Toast.LENGTH_SHORT).show();

            }
        });

        cameraIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle title click

                Toast.makeText(WhatsappActivity.this, "Camera Icon clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // Set click listener for the more icon
        moreIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle more icon click
                Toast.makeText(WhatsappActivity.this, "More Icon clicked", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(ChatFragment.newInstance("", ""), "", R.drawable.camera);
        adapter.addFragment(ButterFragment.newInstance("", ""), "Butter", 0);
        adapter.addFragment(DashboardFragment.newInstance("", ""), "Guys", 0);
        adapter.addFragment(ProfileFragment.newInstance("", ""), "Profile", 0);
        viewPager.setAdapter(adapter);

        // Connect TabLayout with ViewPager
        tabLayout.setupWithViewPager(viewPager);


        // Set custom tab views
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(adapter.getTabView(i));
            }
        }
    }


    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> fragmentList = new ArrayList<>();
        private final List<String> fragmentTitleList = new ArrayList<>();
        private final List<Integer> tabIconResIds = new ArrayList<>();

        ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        void addFragment(Fragment fragment, String title, int tabIconResId) {
            fragmentList.add(fragment);
            fragmentTitleList.add(title);
            tabIconResIds.add(tabIconResId);
        }

        public CharSequence getPageTitle(int position) {
            return fragmentTitleList.get(position);
        }

        View getTabView(int position) {
            View tabView = getLayoutInflater().inflate(R.layout.custom_tab_item, null);
            ImageView tabIconView = tabView.findViewById(R.id.tab_icon);
            TextView tabTextView = tabView.findViewById(R.id.tab_text);

            tabIconView.setImageResource(tabIconResIds.get(position));
            tabTextView.setText(fragmentTitleList.get(position));

            return tabView;
        }
    }

}
