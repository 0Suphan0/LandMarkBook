package com.suphan.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.suphan.landmarkbook.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    ArrayList<Landmark> allLandMarks ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        //datas
        Landmark pisa = new Landmark("Pisa","Italy",R.drawable.pisa);
        Landmark eiffel= new Landmark("Eiffel","France",R.drawable.eiffel);
        Landmark londonBridge = new Landmark("London Bridge","UK",R.drawable.londonbridge);
        Landmark colloseum = new Landmark("Colloseum","Italy",R.drawable.colloseum);


        //initialize arrayList
        allLandMarks=new ArrayList<>();


        //add to arrayList
        allLandMarks.add(pisa);
        allLandMarks.add(eiffel);
        allLandMarks.add(londonBridge);
        allLandMarks.add(colloseum);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        LandmarkAdapter landmarkAdapter = new LandmarkAdapter(allLandMarks);

        binding.recyclerView.setAdapter(landmarkAdapter);



















        //Bu map ve collect işlemi min api24 seviye ister. O yüzden bu şekilde dönüştürme işlemi olmuyor.Aslında doğru yazım.
        //amacımız objelerin ismini string biçiminde listViewde göstermekti...
        // ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1
        //,allLandMarks.stream().map(landmark -> landmark.name).collect(Collectors.toList()));

//
//        ArrayList<String> landMarkNames = new ArrayList<>();
//
//        for (int i =0; i<allLandMarks.size();i++){
//
//           landMarkNames.add(allLandMarks.get(i).name) ;
//
//        }
//
//
//        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,landMarkNames);
//
//        binding.listView.setAdapter(arrayAdapter);
//
//
//        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent  intent = new Intent(MainActivity.this,DetailActivity.class);
//                intent.putExtra("landMark",allLandMarks.get(position));
//                startActivity(intent);
//            }
//        });

    }
}