package com.example.schedulebuilder;


public class ToDo {
  private String name;
  private int minTime;
  private int maxTime;
  private int dueDate;
  private int dueTime;
  private ArrayList<Integer> startTime = new ArrayList<Integer>();
  private ArrayList<Integer> endTime = new ArrayList<Integer>();
  private float priority;
  
  public void autoMakeEvent(Day day){
    if (startTime.size() == 0){
      day.byPriority.get(0)
    }
    else{
      
    }
  }
  
  public void makeEvent(){
    // takes to event creation screen, inserting toDo values for the event
  }
}
