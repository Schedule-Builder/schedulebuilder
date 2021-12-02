package com.example.schedulebuilder;
import java.util.ArrayList;

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
  
  public int[] makeTime(Day day, int timeNeeded){
    int[] times = new int[2];
    Event e;
    for (int i = 0; day.getByPriority().get(i) == 0; i++){
      e = day.getByPriority().get(i);
      if (e.getEndTime()-e.getStartTime() <= timeNeeded){
        times[0] = e.getStartTime();
        times[1] = e.getEndTime();
        return times;
      }
    }
    int efficiency = calculateEfficiency(times[0],times[1]);
  }
  
  public int[] makeTime(Day day, int timeNeeded, int startTime, int endTime){
    int[] times = new int[2];
  }
  
  public int calculateEfficiency(Day day, int startTime, int endTime){
    
  }
}
