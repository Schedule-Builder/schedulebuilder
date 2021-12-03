package com.example.schedulebuilder;

import java.util.ArrayList;

public class Day { // effectively a fancy priority queue
  public Day(){
    
  }
  
  ArrayList<Event> byTime = new ArrayList<Event>(); // this arrayList is sorted based upon the time that the events start
  ArrayList<Event> byPriority = new ArrayList<Event>(); // this arrayList is sorted based upon the priority level of each event
  
  public ArrayList<Event> getByTime(){
    return byTime;
  }
  
  public ArrayList<Event> getByPriority(){
    return byPriority;
  }

  public void push(Event e){ // adds events to both arrays, sorting them as needed for both
    int counter = byTime.size();
    for (int i = 0; i<counter; i++)
      if (e.getStartTime() <= byTime.get(i).getStartTime()){
        byTime.add(i,e);
        break;
      }
    if (counter == byTime.size())
      byTime.add(e);
      
    for (int i = 0; i<counter; i++)
      if (e.getPriority() <= byPriority.get(i).getPriority()){
        byPriority.add(i,e);
        break;
      }
    if (counter == byPriority.size())
      byPriority.add(e);
  }
  
  public int findInTime(Event e){ // finds an event in the byTime arrayList
    for (int i = 0; i < byTime.size(); i++)
      if (e.getName().equals(byTime.get(i).getName()) && e.startTime == byTime.get(i).startTime)
        return i;
    return -1;
  }

  public int findInPriority(Event e){ // finds an event in the byPriority arrayList
    for (int i = 0; i < byPriority.size(); i++)
      if (e.getName().equals(byPriority.get(i).getName()) && e.startTime == byPriority.get(i).startTime)
        return i;
    return -1;
  }
  public void remove(Event e){
    byTime.remove(findInTime(e));
    byPriority.remove(findInPriority(e));
  }
  
  public void clear(){
    byTime.clear();
    byPriority.clear();
  }

  public void print(){ // prints the events in the lists (Event needs a toString() in order to work)
    for (int i = 0; i<byTime.size(); i++)
      System.out.println(byTime.get(i));
    System.out.println();
    for (int i = 0; i<byPriority.size(); i++)
      System.out.println(byPriority.get(i));
  }
}
