package com.example.schedulebuilder;

import java.util.Comparator;

public class Event{
    
    private String name; // this variable is the name of the event
    private boolean locked; // this variable decides whether or not this event can be dragged to a new time (true)
    private boolean morning; // this variable tells whether it is morning (true) or after noon (false)
    private int startTime; // this variable includes the start time of the event
    private int endTime; // this variable includes the end time of the event
    private float priority; // this variable contains the priority level of the event, which is important for the bot
    private int minTime; // this variable describes the minimum amount of time that this event should last
    
    //this method is to make the event based on what the user initially puts in
    public Event(String name, boolean locked, boolean morning, int startTime, int endTime, float priority, int minTime){
        this.name = name;
        this.locked = locked;
        this.morning = morning;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
	this.minTime = minTime;
    }
    
    // typical getters and setters
    public String getName(){
        return name;
    }
    
    public boolean getLocked(){
        return locked;
    }
    
    public boolean getMorning(){
        return morning;
    }
    
    public int getStartTime(){
        return startTime;
    }
    
    public int getEndTime(){
        return endTime;
    }
    
    public float getPriority(){
        return priority;
    }
	
    public int getMinTime(){
        return minTime;
    }	
    
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setLocked(boolean locked){
        this.locked = locked;
    }
    
    public void setMorning(boolean morning){
        this.morning = morning;
    }
    
    public void setStartTime(int startTime){
        this.startTime = startTime;
    }
    
    public void setEndTime(int endTime){
        this.endTime = endTime;
    }
    
    public void setPriority(float priority){
        this.priority = priority;
    }
    
    public void setMinTime(int minTime){
        this.minTime = minTime;
    }	
	
    
    // converts to military time from regular time
    /*public void toMilitary(int time){
        if (e.morning && e.startTime >= 1200)
            e.startTime -= 1200;
        else if (!e.morning && e.startTime < 1200)
            e.startTime += 1200;
            
        if (e.morning && e.endTime >= 1200)
            e.endTime -= 1200;
        else if (!e.morning && e.endTime < 1200)
            e.endTime += 1200;
    }
    
    // converts to regular time from military
    public int fromMilitary(int time){
        if (e.startTime >= 1200){
            e.morning = false;
            if (e.startTime >= 1300)
                e.startTime -= 1200;
        }
        else if (e.startTime < 1200){
            e.morning = true;
            if (e.startTime < 100)
                e.startTime += 1200;
        }
        
        if (e.endTime >= 1200){
            e.morning = false;
            if (e.endTime >= 1300)
                e.endTime -= 1200;
        }
        else if (e.endTime < 1200){
            e.morning = true;
            if (e.endTime < 100)
                e.endTime += 1200;
        };
    }*/
    
    // displays the int time as a string an the proper format (military time)
    public String displayTime(int time){
        return Integer.toString(time / 1000) + Integer.toString(time / 100 % 10) + ":" + Integer.toString(time % 100 - time % 10) + Integer.toString(time % 10);
    }
    
    // displays the int time as a string an the proper format (regular time)
    public String displayTime(int time, boolean morning){
        String str = "PM";
        if (morning)
            str = "AM";
        return Integer.toString(time / 1000) + Integer.toString(time / 100 % 10) + ":" + Integer.toString(time % 100 - time % 10) + Integer.toString(time % 10)
 + " " + str;
    }
	
    // calculates the amount of time that the event is overlapping with the times given
    public int overlap(int startTime, int endTime){
    	Time t = new Time(endTime);
 	if (startTime < this.startTime && endTime < this.endTime)
    		return t.difference(this.startTime);
    
    	if (startTime < this.startTime && endTime > this.endTime){
    		t.setTime(this.endTime);
    		return  t.difference(this.startTime);
    	}
    
    	if (startTime > this.startTime && endTime > this.endTime){
      		t.setTime(startTime);
      		return t.difference(this.endTime);
    	}
    
    	if (startTime > this.startTime && endTime < this.endTime)
      		return t.difference(this.startTime);
  	}
	
	return 0;
}
