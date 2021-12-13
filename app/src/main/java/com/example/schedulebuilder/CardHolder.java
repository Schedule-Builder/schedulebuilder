package com.example.schedulebuilder;



import static com.example.schedulebuilder.Time.difference;
import static com.example.schedulebuilder.Time.fromOperate;
import static com.example.schedulebuilder.Time.toOperate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CardHolder extends PriorityCard{


    Day d;
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
    ArrayList<Event> arr;

    List<Event> card=new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
       d = new Day();

        if(getIntent().getSerializableExtra("card")==null){
           // d= new Day();
        }
        else{
            d = (Day) getIntent().getSerializableExtra("card");
        }

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

        items.clear();

         saveBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub


                prty.setText(priorityNum.getText());
                explanation.setText(detailedExplanation.getText());
                title.setText(titleLine.getText());
                end.setText(endTimeInput.getText());
                start.setText(startTimeInput.getText());


                int s = Integer.parseInt(start.getText().toString());
                int e = Integer.parseInt(end.getText().toString());
                int p = Integer.parseInt(prty.getText().toString());
                //Event event = new Event(title.getText().toString(), true, true, Integer.valueOf(start.getText().toString()), Integer.valueOf(end.getText().toString()), Integer.valueOf(prty.getText().toString()));
                Event event = new Event(title.getText().toString(), true, true, s, e, p);

                d.push(event);
                if (getIntent().getExtras().getBoolean("isChecked")){
                    Toast.makeText(getApplicationContext(), "True", Toast.LENGTH_SHORT).show();
                    arr = d.getByPriority();
                }

                else {
                    arr = d.getByTime();
                    Toast.makeText(getApplicationContext(), "False", Toast.LENGTH_SHORT).show();
                }

                for (int i = 0; i < arr.size(); i++) {

                    String t = arr.get(i).getName();
                    int st = arr.get(i).getStartTime();
                    int et = arr.get(i).getEndTime();
                    int pr = arr.get(i).getPriority();
                    items.add(t + "        " + st + ":00 -" + et + ":00" + "    Priority:" + pr);
                }


                //Tests


                Log.i("myTag","Military time to Minutes"+ Integer.toString(toOperate(123)));
                Log.i("myTag","Minutes to Military Time"+ Integer.toString(fromOperate(83)));

                Log.i("myTag","Find index in Priority List" +Integer.toString(d.findInPriority(event)));
                Log.i("myTag","Find index in Time List"+Integer.toString(d.findInTime(event)));
                // Log.i("myTag", Integer.toString(toOperate(123)));


                //ime t = new Time(1323);



                saveItems();
                //saveCards();

                priorityNum.getText().clear();
                detailedExplanation.getText().clear();
                titleLine.getText().clear();
                endTimeInput.getText().clear();
                startTimeInput.getText().clear();




               Intent i = new Intent(CardHolder.this,PriorityCard.class);
               i.putExtra("cards", (Serializable) d);
                startActivity(i);


            }
        });


        }




        //This function saves items by writing them into the data file


       public void updatedCard(String t) {
           //Toast.makeText(getApplicationContext(), "updated", Toast.LENGTH_SHORT).show();
           /**priorityNum.getText().clear();
           detailedExplanation.getText().clear();
           title.clear();
           endTimeInput.getText().clear();
           startTimeInput.getText().clear();**/
           for (int i = 0; i < card.size(); i++) {
               if (card.get(i).name == t) {
                   priorityNum.setText( card.get(i).priority);
                   ;
                   //detailedExplanation = ;
                   titleLine.setText(card.get(i).name);
                   startTimeInput.setText(card.get(i).startTime);
                   endTimeInput.setText(card.get(i).endTime);
               }
           }

             //saveBtn = findViewById(R.id.saveBtn);
          /** saveBtn.setOnClickListener(new View.OnClickListener() {

               @Override
               public void onClick(View view) {
                  // saveItems();
                   //saveCards();
                   priorityNum.getText().clear();
                   detailedExplanation.getText().clear();
                   titleLine.getText().clear();
                   Intent i = new Intent(CardHolder.this, PriorityCard.class);
                   startActivity(i);


               }
           });**/
       }


        public String getString(TextView title){
            return title.getText().toString();
        }


    //This function saves items by writing them into the data file

}
