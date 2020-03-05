
package bean;

import java.util.Date;

public class Res_Bean{
  private String res_id;
  private String thread_id;
  private String res_name;
  private String res_contents;
  private String res_time;

  public void setRes_id(String res_id){
    this.res_id=res_id;
  }
  public void setThread_id(String thread_id){
    this.thread_id=thread_id;
  }
  public void setRes_name(String res_name){
    this.res_name=res_name;
  }
  public void setRes_contents(String res_contents){
    this.res_contents=res_contents;
  }
  public void setRes_time(String res_time){
    this.res_time=res_time;
  }

  public String getRes_id(){
    return res_id;
  }
  public String getThread_id(){
    return thread_id;
  }
  public String getRes_name(){
    return res_name;
  }
  public String getRes_contents(){
    return res_contents;
  }
  public String getRes_time(){
    return res_time;
  }
}
