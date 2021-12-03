package com.example.schedulebuilder;

// takes care of the times, such as time operations and displaying time
public class Time {
  public Time(){
    
  }
  
  private int time;
  private boolean morning; // if true, AM- if false, PM
  private boolean systemSetting = true; // if true, displays standard time- if false, displays military time
  
  public int getTime(){
    return time;
  }
  
  public void setSystemSetting(boolean systemSetting){
    this.systemSetting = systemSetting;
  }
  
  // the input for both of these functions has the earlier time come first
  public int add(int time1, int time2){
    return time1+time2-(time2/100-time1/100)*40;
  }
  
  public int subtract(int time1, int time2){
    return time2-time1-()(time2/100-time1/100)*40;
  }
  
  /*public int toMilitary(int time, bool morning){
    
  }
  
  public Time toStandard(int time){
    
  }*/
}
