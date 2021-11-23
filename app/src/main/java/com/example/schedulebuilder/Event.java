package com.example.schedulebuilder;

public class Event {

    private String name;
    private boolean locked;
    private boolean morning;
    private int startTime;
    private int endTime;
    private int priority;

    public Event(String name, boolean locked, boolean morning, int startTime, int endTime, int priority){
        this.name = name;
        this.locked = locked;
        this.morning = morning;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
    }


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

    public int getPriority(){
        return priority;
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

    public void setPriority(int priority){
        this.priority = priority;
    }


    public void toMilitary(Event e){
        if (e.morning && e.startTime >= 1200)
            e.startTime -= 1200;
        else if (!e.morning && e.startTime < 1200)
            e.startTime += 1200;

        if (e.morning && e.endTime >= 1200)
            e.endTime -= 1200;
        else if (!e.morning && e.endTime < 1200)
            e.endTime += 1200;
    }

    public int fromMilitary(Event e){
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
        }
        return startTime;
    }

    public String displayTime(int time){
        return Integer.toString(time / 1000) + Integer.toString(time / 100 % 10) + ":" + Integer.toString(time % 100 - time % 10) + Integer.toString(time % 10);
    }

    public String displayTime(int time, boolean morning){
        String str = "PM";
        if (morning)
            str = "AM";
        return Integer.toString(time / 1000) + Integer.toString(time / 100 % 10) + ":" + Integer.toString(time % 100 - time % 10) + Integer.toString(time % 10)
                + " " + str;
    }
}