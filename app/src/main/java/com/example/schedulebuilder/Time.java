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
    return Time.toOperate(this.time) + Time.toOperate(time);
  }
  
  public int difference(int time){
    if (this.time > time)
      return Time.toOperate(this.time)-Time.toOperate(time);
    return Time.toOperate(time)-Time.toOperate(this.time);
  }
  
  public static int add(int time1, int time2){
    return Time.toOperate(time1) + Time.toOperate(time2);
  }
  
  public static int difference(int time1, int time2){
    if (time1 > time2)
      return Time.toOperate(time1)-Time.toOperate(time2);
    return Time.toOperate(time2)-Time.toOperate(time1);
  }
  
  // converts times into an addable format
  public static int toOperate(int time){
    return time/100*60+time%100;
  }
  
  public static int fromOperate(int time){
    return time/60*100+time%60;
  }
  
  /*public int toMilitary(int time, bool morning){
    
  }
  
  public Time toStandard(int time){
    
  }*/
}
