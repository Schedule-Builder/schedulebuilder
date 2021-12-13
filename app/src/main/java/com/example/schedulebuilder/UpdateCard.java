package com.example.schedulebuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

/**public class UpdateCard extends CardHolder {

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.priority_card);




    public void updatedCard(String t){
        //Toast.makeText(getApplicationContext(), "updated", Toast.LENGTH_SHORT).show();

        for (int i = 0; i < card.size(); i++) {
            if (card.get(i).name == t) {
                priorityNum.setText(card.get(i).priority);
                ;
                //detailedExplanation = ;
                titleLine.setText(card.get(i).name);
                startTimeInput.setText(card.get(i).startTime);
                endTimeInput.setText(card.get(i).endTime);
            }
        }
        saveBtn = findViewById(R.id.saveBtn);
         saveBtn.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
        // saveItems();
        //saveCards();
        priorityNum.getText().clear();
        detailedExplanation.getText().clear();
        titleLine.getText().clear();

    }
}
    }
       updatedCard();
   }**/