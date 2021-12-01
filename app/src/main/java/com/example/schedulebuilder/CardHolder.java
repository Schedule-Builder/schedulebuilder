package com.example.schedulebuilder;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
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
    Switch locked;
    Switch morning;
    EditText priorityNum;
    EditText detailedExplanation;
    EditText titleLine;
    EditText startTimeInput;
    EditText endTimeInput;
    TextView prty;
    TextView explanation;
    TextView title;
    TextView start;
    TextView end;
    RecyclerView rvItems;
    ItemAdapter itemsAdapter;

    List<Event> card=new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.priority_card);

        saveBtn = findViewById(R.id.saveBtn);
        priorityNum = findViewById(R.id.priorityNum);
        detailedExplanation = findViewById(R.id.detailedExplanation);
        titleLine = findViewById(R.id.titleLine);
        startTimeInput = findViewById(R.id.startTimeInput);
        endTimeInput = findViewById(R.id.endTimeInput);

        prty = findViewById(R.id.priorityNum);
        explanation = findViewById(R.id.detailedExplanation);
        title = findViewById(R.id.title);
        start = findViewById(R.id.startTime);
        end = findViewById(R.id.endTime);

       /** loadItems();










            rvItems = findViewById(R.id.rvItems);

            saveBtn = findViewById(R.id.saveBtn);

            loadItems();

          ItemAdapter.OnLongClickListener onLongClickListener = new ItemAdapter.OnLongClickListener() {
                @Override
                public void onItemClicked(int position) {
                    //Deletes the item from the model
                    items.remove(position);
                    //Notify the adapter
                    itemsAdapter.notifyItemRemoved(position);
                    Toast.makeText(getApplicationContext(), "item was remove", Toast.LENGTH_SHORT).show();
                    saveItems();
                }

            };
            itemsAdapter = new ItemAdapter(items, onLongClickListener);
            rvItems.setAdapter(itemsAdapter);
            rvItems.setLayoutManager(new LinearLayoutManager(this));**/
         saveBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                prty.setText(priorityNum.getText());
                explanation.setText(detailedExplanation.getText());
                title.setText(titleLine.getText());
                start.setText(endTimeInput.getText());
                end.setText(startTimeInput.getText());
                //Modify adapter that an item is inserted
                String t = getString(title);
                //Add item to the model
                items.add(t);
                int s = Integer.parseInt(start.getText().toString());
                int e = Integer.parseInt(end.getText().toString());
                //Event event = new Event(title.getText().toString(), true, true, Integer.valueOf(start.getText().toString()), Integer.valueOf(end.getText().toString()), Integer.valueOf(prty.getText().toString()));
                Event event = new Event(title.getText().toString(), true, true, s, e, Integer.valueOf(prty.getText().toString()));
               // Toast.makeText(getApplicationContext(), "here", Toast.LENGTH_SHORT).show();
                card.add(event);
                //Modify adapter that an item is inserted
                //itemsAdapter.notifyItemInserted(items.size() - 1);

                Toast.makeText(getApplicationContext(), Integer.toString(items.size()), Toast.LENGTH_SHORT).show();
                saveItems();

                priorityNum.getText().clear();
                detailedExplanation.getText().clear();
                titleLine.getText().clear();


               Intent i = new Intent(CardHolder.this,PriorityCard.class);
                startActivity(i);


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
       public void updatedCard(String t){
         //  Toast.makeText(getApplicationContext(), "updated", Toast.LENGTH_SHORT).show();
           setContentView(R.layout.priority_card);
        for(int i=0; i<card.size();i++){
            if(card.get(i).name == t){
                priorityNum.setText(card.get(i).priority);;
                //detailedExplanation = ;
                titleLine.setText(card.get(i).name);
                startTimeInput.setText(card.get(i).startTime);
                endTimeInput.setText(card.get(i).endTime);
            }
            }

        }



        public String getString(TextView title){
            return title.getText().toString();
        }

   /**private File getDataFile() {
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
    }**/



    //This function saves items by writing them into the data file

}
