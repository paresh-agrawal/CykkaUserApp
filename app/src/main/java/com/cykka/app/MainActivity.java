package com.cykka.app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.annotations.NotNull;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.cardview.widget.CardView;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.Objects;

import pl.pzienowicz.autoscrollviewpager.AutoScrollViewPager;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private LinearLayout dotsLayout;
    private AutoScrollViewPager autoScrollViewPager;
    private MainActivity.MyViewPagerAdapter myViewPagerAdapter;
    private TextView[] dots;
    private int[] layouts;

    private HorizontalScrollView horizontalScrollView;
    private LinearLayout llCategories;
    private CardView cvStocksTechnical, cvStocksFundamental, cvBonds, cvCrypto, cvGoldSilver, cvCurrencyForex, cvCommodity, cvInsurance, cvRetirement, cvTax, cvLoan, cvMutualFunds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Cykka");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        changeStatusBarColor();

        init();

        onCategoryClick();

        //llCategories.requestChildFocus(cvCommodity, cvCommodity);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.open, R.string.close);

        navigationView.setNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        layouts = new int[]{
                R.layout.dashboard_banner1,
                R.layout.dashboard_banner2,
                R.layout.dashboard_banner3,
                R.layout.dashboard_banner4,
                R.layout.dashboard_banner5,
                R.layout.dashboard_banner6};

        addBottomDots(0);
        changeStatusBarColor();

        myViewPagerAdapter = new MyViewPagerAdapter();

        autoScrollViewPager.setAdapter(myViewPagerAdapter);
        autoScrollViewPager.startAutoScroll(1500);
        autoScrollViewPager.setInterval(5000);
        autoScrollViewPager.setScrollDurationFactor(3);
        autoScrollViewPager.setCycle(true);
        autoScrollViewPager.setStopScrollWhenTouch(true);
        autoScrollViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                addBottomDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void onCategoryClick() {

        cvStocksTechnical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDetailsActivity("StocksTechnical");
            }
        });

        cvStocksFundamental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDetailsActivity("StocksFundamental");
            }
        });

        cvBonds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDetailsActivity("Bonds");
            }
        });

        cvCrypto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDetailsActivity("Crypto");
            }
        });

        cvGoldSilver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDetailsActivity("GoldSilver");
            }
        });

        cvCurrencyForex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDetailsActivity("CurrencyForex");
            }
        });

        cvCommodity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDetailsActivity("Commodity");
            }
        });

        cvInsurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDetailsActivity("Insurance");
            }
        });

        cvRetirement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDetailsActivity("Retirement");
            }
        });

        cvTax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDetailsActivity("Tax");
            }
        });


        cvLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDetailsActivity("Loan");
            }
        });

        cvMutualFunds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDetailsActivity("MutualFunds");
            }
        });



    }

    private void startDetailsActivity(String category) {

        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra("Category", category);
        startActivity(intent);

    }


    private void init() {
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        dotsLayout = findViewById(R.id.layoutDots);
        autoScrollViewPager = findViewById(R.id.view_pager);

        horizontalScrollView = findViewById(R.id.sv_categories);
        llCategories = findViewById(R.id.ll_categories);
        cvStocksTechnical= findViewById(R.id.cv_stocks_technical);
        cvStocksFundamental= findViewById(R.id.cv_stocks_fundamental);
        cvBonds= findViewById(R.id.cv_bonds);
        cvCrypto= findViewById(R.id.cv_crypto);
        cvGoldSilver= findViewById(R.id.cv_gold_silver);
        cvCurrencyForex= findViewById(R.id.cv_currency_forex);
        cvCommodity = findViewById(R.id.cv_commodity);
        cvInsurance= findViewById(R.id.cv_insurance);
        cvRetirement= findViewById(R.id.cv_retirement);
        cvTax= findViewById(R.id.cv_tax);
        cvLoan= findViewById(R.id.cv_loan);
        cvMutualFunds= findViewById(R.id.cv_mutual_funds);
    }

    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];

        int colorsDot = getResources().getColor(R.color.white_background);

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(30);
            dots[i].setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            dots[i].setTextColor(colorsDot);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[currentPage].setTextSize(50);
            dots[currentPage].setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        }
    }

    /**
     * View pager adapter
     */
    public class MyViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private NavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int id = item.getItemId();
            Intent intent;
            Uri uri;
            switch(id)
            {
                default:
                    return true;
            }

        }
    };

    @Override
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id){

        }

        return super.onOptionsItemSelected(item);
    }

    private void changeStatusBarColor() {
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
    }
}
