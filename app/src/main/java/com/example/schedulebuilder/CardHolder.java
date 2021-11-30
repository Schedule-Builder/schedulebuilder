package com.example.schedulebuilder;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

public class CardHolder extends PriorityCard{



    Button saveBtn;
    EditText priorityNum;
    EditText detailedExplanation;
    EditText titleLine;
    EditText startDate;
    EditText endDate;
    TextView priority;
    TextView explanation;
    TextView title;
    TextView start;
    TextView end;
    RecyclerView rvItems;
    ItemAdapter itemsAdapter;

    public static List<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.priority_card);


        priorityNum = findViewById(R.id.priorityNum);
        detailedExplanation = findViewById(R.id.detailedExplanation);
        titleLine = findViewById(R.id.titleLine);
       // startDate = findViewById(R.id.startDate);
        //endDate = findViewById(R.id.endDate);

        priority = findViewById(R.id.priorityNum);
        explanation = findViewById(R.id.detailedExplanation);
        title = findViewById(R.id.title);
      //  start = findViewById(R.id.startDate);
       // end = findViewById(R.id.endDate);

        loadItems();










            rvItems = findViewById(R.id.rvItems);

            saveBtn = findViewById(R.id.saveBtn);

           // loadItems();

         /** ItemAdapter.OnLongClickListener onLongClickListener = new ItemAdapter.OnLongClickListener() {
                @Override
                public void onItemClicked(int position) {
                    //Deletes the item from the model
                   // items.remove(position);
                    //Notify the adapter
                    itemsAdapter.notifyItemRemoved(position);
                    Toast.makeText(getApplicationContext(), "item was remove", Toast.LENGTH_SHORT).show();
                    //saveItems();
                }

            };
            itemsAdapter = new ItemAdapter(items, onLongClickListener);
            rvItems.setAdapter(itemsAdapter);**/
           // rvItems.setLayoutManager(new LinearLayoutManager(this));
         saveBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                priority.setText(priorityNum.getText());
                explanation.setText(detailedExplanation.getText());
                title.setText(titleLine.getText());
                start.setText(endDate.getText());
                end.setText(startDate.getText());
                //Modify adapter that an item is inserted
                String t = getString(title);
                //Add item to the model
                items.add(t);
                //Modify adapter that an item is inserted
                //itemsAdapter.notifyItemInserted(items.size() - 1);

                Toast.makeText(getApplicationContext(), "item was added", Toast.LENGTH_SHORT).show();
                saveItems();




               // Intent i = new Intent(CardHolder.this,PriorityCard.class);
                //startActivity(i);


            }
        });


        }



        //This function saves items by writing them into the data file


       /** public void updateText(View view){
            priority.setText(priorityNum.getText());
            explanation.setText(detailedExplanation.getText());
            title.setText(titleLine.getText());
            start.setText(endDate.getText());
            end.setText(startDate.getText());


        }**/



        public String getString(TextView title){
            return title.getText().toString();
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
