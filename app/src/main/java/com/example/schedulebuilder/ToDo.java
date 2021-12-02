package com.example.schedulebuilder;
import java.util.ArrayList;

public class ToDo {
  private String name; // the name of the task that neeeds to be done
  private int timeNeeded; // the estimated amount of time needed to complete this task
  private int dueDate; // the day by which the task needs to be completed
  private int dueTime; // the time by which the task needs to be completed
  private ArrayList<Integer> startTime = new ArrayList<Integer>(); // a collection of the preferred start times to work on the event
  private ArrayList<Integer> endTime = new ArrayList<Integer>(); // a collection of the preferred end times to work on the event (corresponds with the startTime array list)
  private float priority; // the priority level
  
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
  
  public float calculateEfficiency(Day day, int startTime, int endTime){
    float efficiency = 0;
    Event e;
    for (int i = 0; i<day.getByTime().size(); i++){
      e = day.getByTime().get(i);
      if (e.getStartTime() >= startTime){
        efficiency += overlap(e,startTime,endTime);
        if (e.getEndTime > endTime)
          break;
      }
    }
    return efficiency;
  }
  
  public int overlap(Event e, int startTime, int endTime){
    if (startTime < e.getStartTime() && endTime < e.getEndTime())
      return endTime - e.getStartTime();
    
    if (startTime < e.getStartTime() && endTime > e.getEndTime())
      return e.getEndTime() - e.getStartTime();
    
    if (startTime > e.getStartTime() && endTime > e.getEndTime())
      return e.getEndTime() - startTime;
    
    if (startTime > e.getStartTime() && endTime < e.getEndTime())
      return endTime - e.getStartTime();
  }
}
