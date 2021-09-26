package com.cykka.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.NavUtils;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import pl.pzienowicz.autoscrollviewpager.AutoScrollViewPager;

public class DetailsActivity extends AppCompatActivity {

    private String category;
    private int currentItem=0;
    private HorizontalScrollView horizontalScrollView;
    private LinearLayout llCategories;
    private CardView cvStocksTechnical, cvStocksFundamental, cvBonds, cvCrypto, cvGoldSilver, cvCurrencyForex, cvCommodity, cvInsurance, cvRetirement, cvTax, cvLoan, cvMutualFunds;
    private TextView tvStocksTechnical, tvStocksFundamental, tvBonds, tvCrypto, tvGoldSilver, tvCurrencyForex, tvCommodity, tvInsurance, tvRetirement, tvTax, tvLoan, tvMutualFunds;
    private AutoScrollViewPager autoScrollViewPager;
    private DetailsActivity.MyViewPagerAdapter myViewPagerAdapter;
    private int[] layouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getSupportActionBar().setTitle("Daily Updates");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();

        layouts = new int[]{
                R.layout.z_category_page01_stocks_technical,
                R.layout.z_category_page02_stocks_fundamental,
                R.layout.z_category_page03_bonds,
                R.layout.z_category_page04_crypto,
                R.layout.z_category_page05_gold_silver,
                R.layout.z_category_page06_currency_forex,
                R.layout.z_category_page07_commodity,
                R.layout.z_category_page08_insurance,
                R.layout.z_category_page09_retirement,
                R.layout.z_category_page10_tax,
                R.layout.z_category_page11_loan,
                R.layout.z_category_page12_mutual_fund};

        myViewPagerAdapter = new DetailsActivity.MyViewPagerAdapter();

        autoScrollViewPager.setAdapter(myViewPagerAdapter);
        autoScrollViewPager.stopAutoScroll();
        autoScrollViewPager.setCurrentItem(currentItem);
        //setCategoryPager();
        autoScrollViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setCategoryFocused(getCategoryTitle(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        onCategoryClick();

    }

    private void onCategoryClick() {

        cvStocksTechnical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCategoryFocused("StocksTechnical");
                autoScrollViewPager.setCurrentItem(currentItem);
            }
        });

        cvStocksFundamental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCategoryFocused("StocksFundamental");
                autoScrollViewPager.setCurrentItem(currentItem);
            }
        });

        cvBonds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCategoryFocused("Bonds");
                autoScrollViewPager.setCurrentItem(currentItem);
            }
        });

        cvCrypto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCategoryFocused("Crypto");
                autoScrollViewPager.setCurrentItem(currentItem);
            }
        });

        cvGoldSilver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCategoryFocused("GoldSilver");
                autoScrollViewPager.setCurrentItem(currentItem);
            }
        });

        cvCurrencyForex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCategoryFocused("CurrencyForex");
                autoScrollViewPager.setCurrentItem(currentItem);
            }
        });

        cvCommodity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCategoryFocused("Commodity");
                autoScrollViewPager.setCurrentItem(currentItem);
            }
        });

        cvInsurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCategoryFocused("Insurance");
                autoScrollViewPager.setCurrentItem(currentItem);
            }
        });

        cvRetirement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCategoryFocused("Retirement");
                autoScrollViewPager.setCurrentItem(currentItem);
            }
        });

        cvTax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCategoryFocused("Tax");
                autoScrollViewPager.setCurrentItem(currentItem);
            }
        });


        cvLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCategoryFocused("Loan");
                autoScrollViewPager.setCurrentItem(currentItem);
            }
        });

        cvMutualFunds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCategoryFocused("MutualFunds");
                autoScrollViewPager.setCurrentItem(currentItem);
            }
        });



    }

    private String getCategoryTitle(int position) {
        switch (position){
            case 0:
            default:
                return "StocksTechnical";
            case 1:
                return "StocksFundamental";
            case 2:
                return "Bonds";
            case 3:
                return "Crypto";
            case 4:
                return "GoldSilver";
            case 5:
                return "CurrencyForex";
            case 6:
                return "Commodity";
            case 7:
                return "Insurance";
            case 8:
                return "Retirement";
            case 9:
                return "Tax";
            case 10:
                return "Loan";
            case 11:
                return "MutualFunds";
        }
    }

    private void init() {

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

        tvStocksTechnical= findViewById(R.id.tv_stocks_technical);
        tvStocksFundamental= findViewById(R.id.tv_stocks_fundamental);
        tvBonds= findViewById(R.id.tv_bonds);
        tvCrypto= findViewById(R.id.tv_crypto);
        tvGoldSilver= findViewById(R.id.tv_gold_silver);
        tvCurrencyForex= findViewById(R.id.tv_currency_forex);
        tvCommodity = findViewById(R.id.tv_commodity);
        tvInsurance= findViewById(R.id.tv_insurance);
        tvRetirement= findViewById(R.id.tv_retirement);
        tvTax= findViewById(R.id.tv_tax);
        tvLoan= findViewById(R.id.tv_loan);
        tvMutualFunds= findViewById(R.id.tv_mutual_funds);

        Intent intent = getIntent();
        category = intent.getStringExtra("Category");
        setCategoryFocused(category);



    }


    @SuppressLint("ResourceAsColor")
    private void setCategoryFocused(String category) {

        setAllNormal();

        switch (category){

            case "StocksTechnical":
            default:
                llCategories.requestChildFocus(cvStocksTechnical,cvStocksTechnical);
                llCategories.requestChildFocus(cvStocksTechnical, cvStocksFundamental);
                cvStocksTechnical.setBackgroundResource(R.color.random9);
                tvStocksTechnical.setTextColor(getColor(R.color.white_background));
                currentItem = 0;
                break;
            case "StocksFundamental":
                llCategories.requestChildFocus(cvStocksFundamental, cvStocksTechnical);
                llCategories.requestChildFocus(cvStocksFundamental,cvBonds);
                cvStocksFundamental.setBackgroundResource(R.color.random9);
                tvStocksFundamental.setTextColor(getColor(R.color.white_background));
                currentItem = 1;
                break;
            case "Bonds":
                llCategories.requestChildFocus(cvBonds, cvStocksFundamental);
                llCategories.requestChildFocus(cvBonds, cvCrypto);
                cvBonds.setBackgroundResource(R.color.random9);
                tvBonds.setTextColor(getColor(R.color.white_background));
                currentItem = 2;
                break;
            case "Crypto":
                llCategories.requestChildFocus(cvCrypto, cvBonds);
                llCategories.requestChildFocus(cvCrypto, cvGoldSilver);
                cvCrypto.setBackgroundResource(R.color.random9);
                tvCrypto.setTextColor(getColor(R.color.white_background));
                currentItem = 3;
                break;
            case "GoldSilver":
                llCategories.requestChildFocus(cvGoldSilver, cvCrypto);
                llCategories.requestChildFocus(cvGoldSilver, cvCurrencyForex);
                cvGoldSilver.setBackgroundResource(R.color.random9);
                tvGoldSilver.setTextColor(getColor(R.color.white_background));
                currentItem = 4;
                break;
            case "CurrencyForex":
                llCategories.requestChildFocus(cvCurrencyForex, cvGoldSilver);
                llCategories.requestChildFocus(cvCurrencyForex, cvCommodity);
                cvCurrencyForex.setBackgroundResource(R.color.random9);
                tvCurrencyForex.setTextColor(getColor(R.color.white_background));
                currentItem = 5;
                break;
            case "Commodity":
                llCategories.requestChildFocus(cvCommodity, cvCurrencyForex);
                llCategories.requestChildFocus(cvCommodity, cvInsurance);
                cvCommodity.setBackgroundResource(R.color.random9);
                tvCommodity.setTextColor(getColor(R.color.white_background));
                currentItem = 6;
                break;
            case "Insurance":
                llCategories.requestChildFocus(cvInsurance, cvCommodity);
                llCategories.requestChildFocus(cvInsurance, cvRetirement);
                cvInsurance.setBackgroundResource(R.color.random9);
                tvInsurance.setTextColor(getColor(R.color.white_background));
                currentItem = 7;
                break;
            case "Retirement":
                llCategories.requestChildFocus(cvRetirement, cvInsurance);
                llCategories.requestChildFocus(cvRetirement, cvTax);
                cvRetirement.setBackgroundResource(R.color.random9);
                tvRetirement.setTextColor(getColor(R.color.white_background));
                currentItem = 8;
                break;
            case "Tax":
                llCategories.requestChildFocus(cvTax, cvRetirement);
                llCategories.requestChildFocus(cvTax, cvLoan);
                cvTax.setBackgroundResource(R.color.random9);
                tvTax.setTextColor(getColor(R.color.white_background));
                currentItem = 9;
                break;
            case "Loan":
                llCategories.requestChildFocus(cvLoan, cvTax);
                llCategories.requestChildFocus(cvLoan, cvMutualFunds);
                cvLoan.setBackgroundResource(R.color.random9);
                tvLoan.setTextColor(getColor(R.color.white_background));
                currentItem = 10;
                break;
            case "MutualFunds":
                llCategories.requestChildFocus(cvMutualFunds, cvLoan);
                llCategories.requestChildFocus(cvMutualFunds, cvMutualFunds);
                cvMutualFunds.setBackgroundResource(R.color.random9);
                tvMutualFunds.setTextColor(getColor(R.color.white_background));
                currentItem = 11;
                break;


        }
    }

    private void setAllNormal() {
        cvStocksTechnical.setBackgroundResource(R.color.white_background);
        cvStocksFundamental.setBackgroundResource(R.color.white_background);
        cvBonds.setBackgroundResource(R.color.white_background);
        cvCrypto.setBackgroundResource(R.color.white_background);
        cvGoldSilver.setBackgroundResource(R.color.white_background);
        cvCurrencyForex.setBackgroundResource(R.color.white_background);
        cvCommodity.setBackgroundResource(R.color.white_background);
        cvInsurance.setBackgroundResource(R.color.white_background);
        cvRetirement.setBackgroundResource(R.color.white_background);
        cvTax.setBackgroundResource(R.color.white_background);
        cvLoan.setBackgroundResource(R.color.white_background);
        cvMutualFunds.setBackgroundResource(R.color.white_background);

        tvStocksTechnical.setTextColor(getColor(R.color.primary_text));
        tvStocksFundamental.setTextColor(getColor(R.color.primary_text));
        tvBonds.setTextColor(getColor(R.color.primary_text));
        tvCrypto.setTextColor(getColor(R.color.primary_text));
        tvGoldSilver.setTextColor(getColor(R.color.primary_text));
        tvCurrencyForex.setTextColor(getColor(R.color.primary_text));
        tvCommodity.setTextColor(getColor(R.color.primary_text));
        tvInsurance.setTextColor(getColor(R.color.primary_text));
        tvRetirement.setTextColor(getColor(R.color.primary_text));
        tvTax.setTextColor(getColor(R.color.primary_text));
        tvLoan.setTextColor(getColor(R.color.primary_text));
        tvMutualFunds.setTextColor(getColor(R.color.primary_text));

    }

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
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
