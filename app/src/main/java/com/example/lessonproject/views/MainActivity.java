package com.example.lessonproject.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.lessonproject.AdapterClickInterface;
import com.example.lessonproject.R;
import com.example.lessonproject.adapters.CountriesAdapter;
import com.example.lessonproject.models.CountriesModel;
import com.example.lessonproject.views.fragments.DashboardFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * This lesson discusses the concept of recycler views
 * and how to use them.
 */
public class MainActivity extends AppCompatActivity implements AdapterClickInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //we are going to create a static array of data.

        List<CountriesModel> countriesModelList = new ArrayList<>();
        //now create one instance of a country model and add data to it before adding to the list
//this represents one object model item, add it to the list array


        String yorubaNames[] = {"ayo", "Ope"};

        String[] yorubaNames1 = new String[4];
        yorubaNames1[0] = "Bello";


        countriesModelList.add(new CountriesModel(
                "Ethiopia",
                "This is home to be in",
                "Africa", "https://img.freepik.com/free-photo/newlyweds-with-wineglasses-kissing_1153-2834.jpg?t=st=1681494846~exp=1681495446~hmac=0398a97f9c1103223fd09e585155f28feb3e0736a73807ac42e386d8e90eb3a0"));

        countriesModelList.add(new CountriesModel(
                "China",
                "Cross boundary home of peace",
                "Asia", "https://img.freepik.com/premium-photo/happy-teen-girl-blogging-phone-stone-background-teen-girl-blogging-phone-outdoor_474717-109314.jpg"));

        countriesModelList.add(new CountriesModel(
                "Switzerland",
                "Home of the brave people",
                "Beijing", "https://img.freepik.com/free-photo/indoor-photo-satisfied-teenage-girl-texts-cellular-reads-interesting-article-online-wears-casual-outfit-creats-new-publication-own-web-page-isolated-brown-wall-with-free-space_273609-26359.jpg?w=900&t=st=1681494829~exp=1681495429~hmac=96c3ca94ca438990122d80d40cd7174015bd369bcc8a178271aafbe6182b9ea9"));

        countriesModelList.add(new CountriesModel(
                "Bronzon",
                "Graven image of the guys.",
                "Balablue",
                "https://i.guim.co.uk/img/media/6ee83331d88b3ac46588feb40f107acad7d7c3d7/260_116_1585_951/master/1585.jpg?width=620&quality=85&dpr=1&s=none"));

        countriesModelList.add(new CountriesModel(
                "Germany",
                "Bolidn In the faoold",
                "Badoke0d", "https://img.freepik.com/free-photo/prosperous-businessman-keeps-hands-crossed-has-satisfied-expression_273609-16711.jpg?w=740&t=st=1681494704~exp=1681495304~hmac=7deb0d37abf0d54331fe03c62bbaa63d81e9648d1345e32680b0e03b072cada4"));


        //now instantiate the recycler view to display the items
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        //now call the adapter you created, pass in the context and the list you created
        CountriesAdapter countriesAdapter = new CountriesAdapter(this, countriesModelList);
        //set the adapter to the recycler view you created to now display.
        recyclerView.setAdapter(countriesAdapter);

    }

    @Override
    public void handleClickItem(CountriesModel countriesModel) {
//        Toast.makeText(this, "Item 11clicked is " + countriesModel.getName(), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("name", countriesModel.getName());
        intent.putExtra("continent", countriesModel.getContinent());
        intent.putExtra("description", countriesModel.getDescription());
        intent.putExtra("image", countriesModel.getCountryImage());

        startActivity(intent);
    }
}