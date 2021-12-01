package com.example.schedulebuilder;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


public class PriorityCard extends AppCompatActivity {

    List<CardHolder> cards=new ArrayList<>();
    //public static List<String> items;

    Button btnAdd;
    Button eventBtn;
    Button saveBtn;
    EditText etItem;
    RecyclerView rvItems;
    ItemAdapter itemsAdapter;
    List<String> items=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_card);

        //saveItems();

        btnAdd = findViewById(R.id.btnAdd);
        etItem = findViewById(R.id.etItem);
        rvItems = findViewById(R.id.rvItems);
        eventBtn = findViewById(R.id.eventBtn);
        saveBtn = findViewById(R.id.saveBtn);

        loadItems();

        ItemAdapter.OnLongClickListener onLongClickListener = new ItemAdapter.OnLongClickListener() {
            @Override
            public void onItemClicked(int position) {
                //Deletes the item from the model
                CardHolder card = new CardHolder();
                card.updatedCard(items.get(position));
                //items.remove(position);
                //Notify the adapter
                itemsAdapter.notifyItemChanged(position);
                Toast.makeText(getApplicationContext(), "item was remove", Toast.LENGTH_SHORT).show();
                saveItems();
            }

        };

        itemsAdapter = new ItemAdapter(items, onLongClickListener);
        rvItems.setAdapter(itemsAdapter);
        rvItems.setLayoutManager(new LinearLayoutManager(this));


        eventBtn= findViewById(R.id.eventBtn);
        eventBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

               //CardHolder card = new CardHolder();
                //cards.add(card);
                Intent i = new Intent(PriorityCard.this,CardHolder.class);
                startActivity(i);

                //saveItems();


                //Toast.makeText(getApplicationContext(), cards.getString(), Toast.LENGTH_SHORT).show();



            }
        });

    }

    private File getDataFile() {
        return new File(getFilesDir(), "data.txt");
    }

    //This function will load items by reading every line of the data file
    private void loadItems() {
        try {
            items = new ArrayList<>(FileUtils.readLines(getDataFile(), Charset.defaultCharset()));
        } catch (IOException e) {
            Log.e("MainActivity","Error reading item", e );
            items = new ArrayList<>();
        }

    }

    public void saveItems(){
        try {
            FileUtils.writeLines(getDataFile(), items);
        } catch(IOException e){
            Log.e("MainActivity","Error writing item", e );
        }
    }


    //This function saves items by writing them into the data file
}