package database;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class DBOperator{
	//型 ArrayList の式は、未検査の型変換を使用して ArrayList<Serializable> に準拠するようにする必要があります
	public ArrayList<Serializable> getThread(){ return new ArrayList<>(); }

	public ArrayList<Serializable> getThreadR(String thread_id){ return new ArrayList<>(); }

	public void insertRes(String res_id,String thread_id,String name,String contents){}

	public ArrayList getRes(String thread_id,String res_id){  return new ArrayList(); }

	public void insertThread(String title,String t_name,String contents,String name){}
}