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
    }

        public void updateText(View view){
            priority.setText(priorityNum.getText());
            explanation.setText(detailedExplanation.getText());
            title.setText(titleLine.getText());
            start.setText(endDate.getText());
            end.setText(startDate.getText());
             saveBtn.setOnClickListener(new View.OnClickListener() {

               @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub


                   //Modify adapter that an item is inserted
                   getList();


                  //Intent i = new Intent(CardHolder.this,PriorityCard.class);
                  //startActivity(i);

                }
            });

        }
        public List<String> getList(){
            String item = cards.getString();
            //Add item to the model
            PriorityCard.items.add(item);
            itemsAdapter.notifyItemInserted(items.size() - 1);

         return items;
        }

        public String getString(){
            return title.getText().toString();
        }



    //This function saves items by writing them into the data file

}
