package com.example.schedulebuilder;

import static com.example.schedulebuilder.Time.fromOperate;
import static com.example.schedulebuilder.Time.toOperate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


public class PriorityCard extends AppCompatActivity {

    CardHolder card;

    Switch isPriority;
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
        isPriority = findViewById(R.id.isPriority);
        btnAdd = findViewById(R.id.btnAdd);
        etItem = findViewById(R.id.etItem);
        rvItems = findViewById(R.id.rvItems);
        eventBtn = findViewById(R.id.eventBtn);
        saveBtn = findViewById(R.id.saveBtn);

        loadItems();

        Intent i = new Intent(PriorityCard.this, CardHolder.class);

                ItemAdapter.OnClickListener onClickListener = new ItemAdapter.OnClickListener(){
                    public void onItemClicked(int position){
                        card = new CardHolder();
                        setContentView(R.layout.priority_card);

                        card.updatedCard(items.get(position));

                    }
                };
                ItemAdapter.OnLongClickListener onLongClickListener = new ItemAdapter.OnLongClickListener() {
            @Override
            public void onItemLongClicked(int position) {
                //Deletes the item from the model
                //CardHolder.updatedCard(item.get(position))
                items.remove(position);

                //Notify the adapter
                itemsAdapter.notifyItemRemoved(position);
                Toast.makeText(getApplicationContext(), "item was remove", Toast.LENGTH_SHORT).show();
                saveItems();
                //saveCards();
            }

        };

        SharedPreferences settings = getSharedPreferences("com.example.schedulebuilder", MODE_PRIVATE);
        boolean checked = settings.getBoolean("isPriority", isPriority.isChecked());
        isPriority.setChecked(checked);
        isPriority.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = settings.edit();
                editor.putBoolean("isPriority", isChecked);

                i.putExtra("isChecked",  isChecked);
                editor.commit();
                //Time t = new Time(1334);
                if(isChecked){
                    //Log.i("myTag", Integer.toString(toOperate(123)));
                    //Toast.makeText(getApplicationContext(), t.difference(1456), Toast.LENGTH_SHORT).show();

                   // Toast.makeText(getApplicationContext(), "True", Toast.LENGTH_SHORT).show();
                }else
                    //Log.i("myTag", Integer.toString(t.difference(1456)));
                    //Toast.makeText(getApplicationContext(), t.fromOperate(1334), Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "False", Toast.LENGTH_SHORT).show();

            }
        });

        itemsAdapter = new ItemAdapter(items, onLongClickListener, onClickListener);
        rvItems.setAdapter(itemsAdapter);
        rvItems.setLayoutManager(new LinearLayoutManager(this));


        eventBtn= findViewById(R.id.eventBtn);
        eventBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Day day = (Day) getIntent().getSerializableExtra("cards");
                i.putExtra("card", (Serializable) day);

                startActivity(i);
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

     public void saveCards(){
        try {
            FileUtils.writeLines(getDataFile(), card.card);
        } catch(IOException e){
            Log.e("MainActivity","Error writing item", e );
        }
    }


    //This function saves items by writing them into the data file
}