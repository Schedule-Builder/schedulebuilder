package com.example.schedulebuilder;

// takes care of the times, such as time operations and displaying time
public class Time {
  private int time;
  private boolean morning; // if true, AM- if false, PM
  private boolean systemSetting = true; // if true, displays standard time- if false, displays military time
  
  public Time(){
    
  }
  
  public Time(int time){
    this.time = time;
  }
  
  public int getTime(){
    return time;
  }
  
  public void setTime(int time){
    this.time = time;
  }
  
  public void setSystemSetting(boolean systemSetting){
    this.systemSetting = systemSetting;
  }
  
  public int add(int time){
    if (this.time > time)
      return this.time+time-(this.time/100-time/100)*40;
    return time+this.time-(time/100-this.time/100)*40;
  }
  
  public int difference(int time){
    if (this.time > time)
      return this.time-time-(this.time/100-time/100)*40;
    return time-this.time-(time/100-this.time/100)*40;
  }
  
  /*public int toMilitary(int time, bool morning){
    
  }
  
  public Time toStandard(int time){
    
  }*/
}
