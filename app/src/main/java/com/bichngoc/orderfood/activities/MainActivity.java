package com.bichngoc.orderfood.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.bichngoc.orderfood.R;
import com.bichngoc.orderfood.adapters.CategoryAdapter;
import com.bichngoc.orderfood.adapters.PopularAdapter;
import com.bichngoc.orderfood.databinding.ActivityMainBinding;
import com.bichngoc.orderfood.interfaces.IRecyclerViewListener;
import com.bichngoc.orderfood.models.Category;
import com.bichngoc.orderfood.models.Food;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private CategoryAdapter mCategoryAdapter;
    private ArrayList<Category> mCategory;

    private PopularAdapter mPopularAdapter;
    private ArrayList<Food> mPopularList;

    private PopularAdapter mNewestAdapter;
    private ArrayList<Food> mNewestList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        recyclerViewCategory();
        recyclerViewPopular();
        recyclerViewNewest();
        bottomNavigation();

        mPopularAdapter.setCallback(new IRecyclerViewListener() {
            @Override
            public void onClickListener(View view, int position) {
                Food clickedFood = mPopularList.get(position);
                Bundle bundle = new Bundle();
                bundle.putSerializable("clickedFood", clickedFood);
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
    private void bottomNavigation() {
        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CartActivity.class));
            }
        });
        binding.linearHomeAppbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));

            }
        });
    }
    private void recyclerViewNewest() {
        mPopularList = new ArrayList<>();
        mPopularList.add(new Food("Pizza1", "cat_1", "beef,cheese,sauce,lettuce,tomato", 20.0));
        mPopularList.add(new Food("Pizza2", "image_food_02", "beef,cheese,sauce,lettuce,tomato", 20.8));
        mPopularList.add(new Food("Pizza3", "image_food_03", "beef,cheese,sauce,lettuce,tomato", 20.5));
        mPopularList.add(new Food("Pizza4", "image_food_01", "beef,cheese,sauce,lettuce,tomato", 20.5));
        mPopularList.add(new Food("Pizza5", "cat_3", "beef,cheese,sauce,lettuce,tomato", 20.5));
        mPopularAdapter = new PopularAdapter(mPopularList);
        binding.recyclerviewMainListnewest.setAdapter(mPopularAdapter);
    }

    private void recyclerViewPopular() {
        mPopularList = new ArrayList<>();
        mPopularList.add(new Food("Pizza1", "cat_1", "beef,cheese,sauce,lettuce,tomato", 20.0));
        mPopularList.add(new Food("Pizza2", "image_food_02", "beef,cheese,sauce,lettuce,tomato", 20.8));
        mPopularList.add(new Food("Pizza3", "image_food_03", "beef,cheese,sauce,lettuce,tomato", 20.5));
        mPopularList.add(new Food("Pizza4", "image_food_01", "beef,cheese,sauce,lettuce,tomato", 20.5));
        mPopularList.add(new Food("Pizza5", "cat_3", "beef,cheese,sauce,lettuce,tomato", 20.5));
        mPopularAdapter = new PopularAdapter(mPopularList);
        binding.recyclerviewHomeListpopular.setAdapter(mPopularAdapter);
    }

    private void recyclerViewCategory() {
        mCategory = new ArrayList<>();
        mCategory.add(new Category("pizza", R.drawable.cat_1));
        mCategory.add(new Category("burger", R.drawable.cat_2));
        mCategory.add(new Category("hotdog", R.drawable.cat_3));
        mCategory.add(new Category("drink", R.drawable.cat_4));
        mCategory.add(new Category("pizza", R.drawable.cat_1));
        mCategory.add(new Category("burger", R.drawable.cat_2));
        mCategory.add(new Category("hotdog", R.drawable.cat_3));
        mCategory.add(new Category("drink", R.drawable.cat_4));
        mCategory.add(new Category("pizza", R.drawable.cat_1));
        mCategory.add(new Category("burger", R.drawable.cat_2));
        mCategory.add(new Category("hotdog", R.drawable.cat_3));
        mCategory.add(new Category("drink", R.drawable.cat_4));
        mCategoryAdapter = new CategoryAdapter(mCategory);
        binding.recyclerviewMainListcategory.setAdapter(mCategoryAdapter);
    }

}