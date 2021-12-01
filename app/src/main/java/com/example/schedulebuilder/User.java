package com.example.schedulebuilder;

public class User {
    
    private boolean militaryTime = false; // this variable decides whether or not the times for the events will be in military time (true) or not (false)
    private boolean cardDisplay = false; // this variable likely won't be used for a while- it will activate a specialized view that is a stretch goal
    private boolean timeTracker = false; // this will decide if the user would want to notify when they finish activities in order to keep track of how they stick to their schedule
    
    
    public boolean getMilitaryTime(){
        return militaryTime;
    }
    
    public boolean getCardDisplay(){
        return cardDisplay;
    }
    
    public boolean getTimeTracker(){
        return timeTracker;
    }
    
    
    public void setMilitaryTime(boolean militaryTime){
        this.militaryTime = militaryTime;
    }
    
    public void setCardDisplay(boolean cardDisplay){
        this.cardDisplay = cardDisplay;
    }
    
    public void setTimeTracker(boolean timeTracker){
        this.timeTracker = timeTracker;
    }
    
}
