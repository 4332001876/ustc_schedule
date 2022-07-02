package com.edu.ustc.ustcschedule.SQL;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

public class MyTodolist extends BasicSchedule{

    private long WorkLoad;

    //默认不添加备注,重要性为1,创建时必须填写编号,时间,地点和内容
    public MyTodolist (String name,long starting_time,int importance,int is_repeat,int period,String place,String description,long work_load,int is_finish){
        super(name,starting_time,importance,is_repeat,period,place,description,is_finish);
        this.WorkLoad=work_load;

    }
    public MyTodolist(Cursor cursor){
        super(cursor);
        this.setFromCursor(cursor);


    }

    public ContentValues getContentValues(){
        ContentValues info=super.getContentValues();
        info.put("WORK_LOAD",WorkLoad);
        return info;
    }

    public Map getMap() {
        Map<String, Object> info = super.getMap();
        info.put("WORK_LOAD",WorkLoad);
        return info;
    }

    public void toDatabase(SQLiteDatabase db)
    {
        ContentValues info=this.getContentValues();
        db.insert("TODO",null,info);

    }

    public void setFromCursor(Cursor cursor)
    {
        super.setFromCursor(cursor);

        WorkLoad=cursor.getInt(cursor.getColumnIndexOrThrow("WORK_LOAD"));
    }

    public long getWorkLoad() {
        return WorkLoad;
    }

    public void setWorkLoad(long workLoad) {
        WorkLoad = workLoad;
    }

    public String getWorkloadStringTodo() {
        String stringworkload;
        stringworkload=Long.toString(WorkLoad)+"h";
        return stringworkload;
    }
}
