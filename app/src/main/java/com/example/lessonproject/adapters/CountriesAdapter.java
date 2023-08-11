package com.example.lessonproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.lessonproject.AdapterClickInterface;
import com.example.lessonproject.R;
import com.example.lessonproject.models.CountriesModel;

import java.util.List;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.ViewHolder> {
    private final Context context;
    private final List<CountriesModel> countriesModelList;
    private final AdapterClickInterface adapterClickInterface;

    public CountriesAdapter(Context context, List<CountriesModel> countriesModelList) {
        this.context = context;
        this.countriesModelList = countriesModelList;
        adapterClickInterface = (AdapterClickInterface) context;
    }

    @NonNull
    @Override
    public CountriesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View myView = layoutInflater.inflate(R.layout.country_item, parent, false);
        return new ViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull CountriesAdapter.ViewHolder holder, int index) {
        CountriesModel countriesModel = countriesModelList.get(index);

        holder.countryNameTv.setText(countriesModel.getName());
        holder.countryDescriptionTv.setText(countriesModel.getDescription());
        holder.continentTv.setText(countriesModel.getContinent());

        Glide.with(context).load(countriesModel.getCountryImage()).into(holder.countryImageView);

//        holder.itemView.setOnClickListener(v -> adapterClickInterface.handleClickItem(countriesModelList.get(index)));
    }

    @Override
    public int getItemCount() {
        return countriesModelList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        private final TextView countryNameTv, countryDescriptionTv, continentTv;
        private final ImageView countryImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            countryDescriptionTv = itemView.findViewById(R.id.description_tv);
            countryNameTv = itemView.findViewById(R.id.country_name_tv);
            continentTv = itemView.findViewById(R.id.continent_tv);
            countryImageView = itemView.findViewById(R.id.country_image_iv);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //now you can catch events here on click
            adapterClickInterface.handleClickItem(countriesModelList.get(getAdapterPosition()));
        }
    }
}
