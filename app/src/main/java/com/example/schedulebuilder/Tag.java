package com.example.schedulebuilder;

public class Tag { // this class allows the user to be able to put in preset parameters that are associated with the tags
    
  // special tag variable
  private String color;
  
  //varibales that are shared between classes
  private String name; // this variable is the name of the event
  private float priority; // this variable contains the priority level of the event, which is important for the bot
  
  // variables that are associated with the Event class
  private boolean locked; // this variable decides whether or not this event can be dragged to a new time (true)
  private boolean morning; // this variable tells whether it is morning (true) or after noon (false)
  private int startTime; // this variable includes the start time of the event
  private int endTime; // this variable includes the end time of the event
  private int minTime; // this variable describes the minimum amount of time that this event should last
  
  // variables that are associated with the ToDo class
  private int timeNeeded; // the estimated amount of time needed to complete this task
  private int dueDate; // the day by which the task needs to be completed
  private int dueTime; // the time by which the task needs to be completed
  private ArrayList<Time> bounds = new ArrayList<Time>(); // a collection of the bounds alternating between start and end time
    
  // empty constructor
  public Tag(){
      
  }
    
  // constructor for event tag
  public Tag(String name, boolean locked, boolean morning, int startTime, int endTime, float priority, int minTime){
    this.name = name;
    this.locked = locked;
    this.morning = morning;
    this.startTime = startTime;
    this.endTime = endTime;
    this.priority = priority;
    this.minTime = minTime;
  }
  
  // constructor for ToDo tag
  public ToDo(String name, int timeNeeded, int dueDate, int dueTime, ArrayList<Time> bounds, float priority){
    this.name = name;
    this.timeNeeded = timeNeeded;
    this.dueDate = dueDate;
    this.dueTime = dueTime;
    this.bounds = bounds;
    this.priority = priority;
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
  
  public int getTimeNeeded(){
    return timeNeeded;
  }
  
  public int getDueDate(){
    return dueDate;
  }
	
	public int getDueTime(){
		return dueTime;
	}
	
	public ArrayList<Time> getBounds(){
		return bounds;
	}
	
	public String getColor(){
		return color;
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
	
	public void setTimeNeeded(int timeNeeded){
    this.timeNeeded = timeNeeded;
  }
  
  public void setDueDate(int dueDate){
    this.dueDate = dueDate;
  }
	
	public void setDueTime(int dueTime){
		this.dueTime = dueTime;
	}
	
	public void setBounds(ArrayList<Time> bounds){
		this.bounds = bounds;
	}
	
	public void setColor(String color){
		this.color = color;
	}
    
}
