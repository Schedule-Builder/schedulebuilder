package com.example.schedulebuilder;

import java.util.ArrayList;

public class Day {
  ArrayList<Event> byTime = new ArrayList<Event>();
  ArrayList<Event> byPriority = new ArrayList<Event>();
  
  public ArrayList<Event> getByTime(){
    return byTime;
  }
  
  public ArrayList<Event> getByPriority(){
    return byPriority;
  }

  public void push(Event e){
    int counter = byTime.size();
    for (int i = 0; i<counter; i++)
      if (e.getStartTime() <= bytime.get(i).getStartTime()){
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
  
  public int findInTime(Event e){
    for (int i = 0; i < byTime.size(); i++)
      if (e.getName().equals(byTime.get(i).getName()))
        return i;
    return -1;
  }
    
  public int findInPriority(Event e){
    for (int i = 0; i < byPriority.size(); i++)
      if (e.getName().equals(byPriority.get(i).getName()))
        return i;
    return -1;
  }

  public void print(){
    for (int i = 0; i<byTime.size(); i++)
      System.out.println(byTime.get(i));
    System.out.println();
    for (int i = 0; i<byPriority.size(); i++)
      System.out.println(byPriority.get(i));
  }
}
