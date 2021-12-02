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
  
  // auto inserts an event into the day specified where most "efficient"
  public void autoMakeEvent(Day day){
    if (startTime.size() == 0){
      day.byPriority.get(0)
    }
    else{
      
    }
  }
  
  // allows the user to manually add the event into the Day, auto-inserting the premade
  public void makeEvent(){
    // takes to event creation screen, inserting toDo values for the event
  }
  
  // this method is what will find the most "efficient" time slot that the event can be added to, returning the start and end time as an int array
  public int[] makeTime(Day day, int timeNeeded){
    int[] times = new int[2];
    Event e;
    int counter = 0;
    int efficiency;
    for (int i = 0; day.getByPriority().get(i) == 0; i++){
      e = day.getByPriority().get(i);
      if (e.getEndTime()-e.getStartTime() <= timeNeeded){
        times[0] = e.getStartTime();
        times[1] = e.getEndTime();
        return times;
      }
    }
    /*while (true){
      e = counter.
    }*/
  }
  
  // functions the same as the one before, but checks for timeslots between the input start and end time
  /*public int[] makeTime(Day day, int timeNeeded, int startTime, int endTime){
    int[] times = new int[2];
  }*/
  
  // efficiency represents how well the times inserted fit within the schedule built
  // it is calculated by multiplying the overlap time by the priority level (the lower the efficiency number, the better)
  public float calculateEfficiency(Day day, int startTime, int endTime){
    float efficiency = 0;
    Event e;
    for (int i = 0; i<day.getByTime().size(); i++){
      e = day.getByTime().get(i);
      if (e.getStartTime() >= startTime){
        efficiency += overlap(e,startTime,endTime)*e.getPriority();
        if (e.getEndTime > endTime)
          break;
      }
    }
    return efficiency;
  }
  
  // calculates the amount of time that the event is overlapping with the times given
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
