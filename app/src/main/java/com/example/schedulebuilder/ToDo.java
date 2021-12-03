package com.example.schedulebuilder;
import java.util.ArrayList;

public class ToDo {
  private String name; // the name of the task that neeeds to be done
  private int timeNeeded; // the estimated amount of time needed to complete this task
  private int dueDate; // the day by which the task needs to be completed
  private int dueTime; // the time by which the task needs to be completed
  private ArrayList<Time> bounds = new ArrayList<Time>(); // a collection of the boundsm alternating between start and end time
  private float priority; // the priority level
  
  public ToDo{
    
  }
  
  // auto inserts an event into the day specified where most "efficient"
  public void autoMakeEvent(Day day){
    this.findFreeTime(Day)
  }
  
  // allows the user to manually add the event into the Day, auto-inserting the premade
  public void makeEvent(){
    // takes to event creation screen, inserting toDo values for the event
  }
  
  // this method is what will find the most "efficient" time slot that the event can be added to, returning the start and end time as an int array
  public int[] makeTime(Day day){
    int[] times = new int[2];
    Event e;
    int efficiency = Integer.MAX_VALUE;
    int temp;
    int counter;
    for (int i = 0; i<day.getByTime().size(); i++){
      e = day.getByTime().get(i);
      counter = i+1;
      if (e.getEndTime()-e.getStartTime() >= timeNeeded){
        temp = calculateEfficiency(day,e.getStartTime(),e.getEndTime())
        if (temp <= 0){
          times[0] = e.getStartTime();
          times[1] = e.getEndTime();
          return times;
        }
        else
          if (temp < efficiency)
            efficiency = temp;
      }
      if (counter < day.getByTime())
    }
  }
  
  // functions the same as the one before, but checks for timeslots between the input start and end time
  public int[] makeTime(Day day, int timeNeeded, int startTime, int endTime){
    int[] times = new int[2];
  }
  
  // efficiency represents how well the times inserted fit within the schedule built
  // it is calculated by multiplying the overlap time by the priority level (the lower the efficiency number, the better)
  public float calculateEfficiency(Day day, int startTime, int endTime){
    float efficiency = 0;
    Event e;
    for (int i = 0; i<day.getByTime().size(); i++){
      e = day.getByTime().get(i);
      if (e.getStartTime() >= startTime){
        efficiency += overlap(e,startTime,endTime)*(priority - e.getPriority());
        if (e.getEndTime > endTime)
          break;
      }
    }
    return efficiency;
  }
  
  public float calculateEfficiency(Event e, int overlap){
    return overlap * (priority - e.getPriority());
  }
  
  // finds free time positions and add them to an arraylist in pairs, with the start time first and the end time second
  public ArrayList<Integer> findFreeTime(Day day){
    int i = 0;
    Event e;
    ArrayList<Integer> ans = new ArrayList<Integer>();
    do {
      e = day.getByTime().get(i);
      if (e.getLocked()){
        i++;
        continue;
      }
      if (ans.size() % 2 == 0)
        ans.add(e.getStartTime());
      e = day.getByTime().get(i+1);
      if (e.getLocked())
        ans.add(e.getStartTime());
    }
    while (i<day.getByTime().size()-1);
    if (ans.size() % 2 != 0)
      ans.add(e.getEndTime());
  }
  
  public Day freestTime(Day day, ArrayList<Integer> arr){
    Day focus = new Day();
    Day temp = new Day();
    float ftemp;
    int needed;
    float efficiency = Float.MAX_VALUE;
    int num;
    Event e = new Event();
    for (int j = 0; j<arr.size()/2; j++){
      needed = Time.fromOperate(timeNeeded);
      for (int i = 0; i < day.getByTime().size(); i++){
        e = day.getByTime().get(i);
        num = e.overlap(arr.get(j*2),arr.get(j*2+1));
        if (num != 0)
          temp.push(e);
        if (temp.size()!=0 && num == 0) 
          break;
      }
      ftemp = this.efficiencyBlock(temp);
      if (ftemp < efficiency){
        efficiency = ftemp;
        focus = temp;
      }
    }
    this.insertEvent(day, focus.getbyTime().get(0).getStartTime, Time.add(focus.getbyTime().get(0).getStartTime, Time.fromOperate(timeNeeded)););
  }
  
  public float efficiencyBlock(Day days){
    float efficiency = Float.MAX_VALUE;
    Event e = new Event();
    int temp = timeNeeded;
    int difference;
    if (days.getbyTime().get(0) - days.getbyTime().get(days.getByTime().size()) < temp)
      return efficiency;
    efficiency = 0;
    for (int i = 0; i < days.getByPriority().size(); i++)
      e = days.getByPriority().get(i);
      difference = Time.difference(e.getStartTime(),e.getEndTime())
      if (temp <= difference){
        efficiency += calculateEfficiency(e, temp);
        return efficiency;
      }
      temp -= difference;
    }
  }
  
  // within a collection of events, finds the freest time possible that meets the time restraint
  /*public int[] findTimes(Day day){
    int[] times = new int[2];
    Event e = new Event();
    int openTime = 0;
    for (int i = 0; i < day.getByPriority().size(); i++){
      e = day.getbyPriority().get(i);
      openTime += Time.difference(e.getStartTime(),e.getEndTime());
      if (openTime >= timeNeeded){
        times[0] = e.getStartTime();
        times[1] = e.getEndTime();
        return times;
      }
      times[0] = 
    }
  }*/
  
  public void insertEvent(Day day, int startTime, int endTime){
    Event e = new Event(name, false, false, startTime, endTime, priority, timeNeeded);
    day.push(e);
    int index = day.findInTime(e);
    day.remove(index+1)
    day.getByTime().get(index+1).setStartTime(endTime);
  }
}
