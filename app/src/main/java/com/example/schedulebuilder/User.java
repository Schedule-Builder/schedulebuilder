package com.example.schedulebuilder;

public class User {
    
    private boolean militaryTime = false;
    private boolean cardDisplay = false;
    private boolean timeTracker = false;
    
    
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