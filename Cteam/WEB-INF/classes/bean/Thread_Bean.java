package bean;
import java.util.Date;


public class Thread_Bean{
  private String thread_id;
  private String title;
  private String t_name;
  private String name;
  private String t_contents;
  private String thread_time;

  public void setThread_id(String thread_id){
		this.thread_id = thread_id;
	}
	public String getThread_id(){
		return thread_id;
	}

	public void setTitle(String title){
		this.title = title;
	}
	public String getTitle(){
		return title;
	}

	public void setT_name(String t_name){
		this.t_name = t_name;
	}
	public String getT_name(){
		return t_name;
	}

  public void setName(String name){
    this.name = name;
  }
  public String getName(){
    return name;
  }


	public void setT_contents(String t_contents){
		this.t_contents = t_contents;
	}
	public String getT_contents(){
		return t_contents;
	}

	public void setThread_time(String thread_time){
		this.thread_time = thread_time;
	}
	public String getThread_time(){
		return thread_time;
	}
}
