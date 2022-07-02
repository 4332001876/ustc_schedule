package com.edu.ustc.ustcschedule.SQL;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class BasicSchedule {

    private int id;//id将作为删除依据，adapter里的类必须拥有id!
    private String Name;

    private long StartingTime;

    private int Importance;//1,2,3代表重要性
    private int IsRepeat;
    private int Period;
    private String Place;
    private String Description;

    private int IsFinish;//0==not finished


    //日期和时间采用Java自带的时间和日期类,使用setYear等函数修改
    public BasicSchedule(String name, long starting_time, int importance, int is_repeat, int period, String place, String description, int is_finish) {
        id = 0;
        Name = name;
        StartingTime = starting_time;
        Importance = importance;
        IsRepeat = is_repeat;
        Period = period;
        Place = place;
        Description = description;
        IsFinish = is_finish;


    }

    public BasicSchedule(Cursor cursor) {
        this.setFromCursor(cursor);


    }


    public ContentValues getContentValues() {
        ContentValues info = new ContentValues();

        info.put("NAME", Name);
        info.put("START_TIME", StartingTime);
        info.put("IMPORTANCE", Importance);
        info.put("IS_REPEAT", IsRepeat);
        info.put("PERIOD", Period);
        info.put("PLACE", Place);
        info.put("DESCRIPTION", Description);

        info.put("IS_FINISH", IsFinish);
        return info;
    }

    public Map getMap() {
        Map<String, Object> info = new HashMap<String, Object>();
        info.put("NAME", Name);
        info.put("START_TIME", StartingTime);
        info.put("IMPORTANCE", Importance);
        info.put("IS_REPEAT", IsRepeat);
        info.put("PERIOD", Period);
        info.put("PLACE", Place);
        info.put("DESCRIPTION", Description);

        info.put("IS_FINISH", IsFinish);
        return info;
    }


    public void setFromCursor(Cursor cursor) {
        this.setId(cursor.getInt(cursor.getColumnIndexOrThrow("_id")));
        this.setName(cursor.getString(cursor.getColumnIndexOrThrow("NAME")));
        this.setStartingTime(cursor.getLong(cursor.getColumnIndexOrThrow("START_TIME")));
        this.setImportance(cursor.getInt(cursor.getColumnIndexOrThrow("IMPORTANCE")));
        this.setIsRepeat(cursor.getInt(cursor.getColumnIndexOrThrow("IS_REPEAT")));
        this.setPeriod(cursor.getInt(cursor.getColumnIndexOrThrow("PERIOD")));
        this.setPlace(cursor.getString(cursor.getColumnIndexOrThrow("PLACE")));
        this.setDescription(cursor.getString(cursor.getColumnIndexOrThrow("DESCRIPTION")));

        IsFinish = cursor.getInt(cursor.getColumnIndexOrThrow("IS_FINISH"));
    }


    public void setId(int schNo) {
        id = schNo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getIsRepeat() {
        return IsRepeat;
    }

    public void setIsRepeat(int is_repeat) {
        IsRepeat = is_repeat;
    }


    public long getStartingTime() {
        return StartingTime;
    }

    public void setStartingTime(long startingTime) {
        StartingTime = startingTime;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPlace() {
        return Place;
    }

    public void setPlace(String place) {
        Place = place;
    }

    public int getPeriod() {
        return Period;
    }

    public void setPeriod(int period) {
        Period = period;
    }

    public int isRepeat() {
        return IsRepeat;
    }

    public void setRepeat(int repeat) {
        IsRepeat = repeat;
    }

    public int getImportance() {
        return Importance;
    }

    public void setImportance(int importance) {
        Importance = importance;
    }


    public int getIsFinish() {
        return IsFinish;
    }

    public void setIsFinish(int isFinish) {
        IsFinish = isFinish;
    }

    public String getStringTodo() {
        String stringshare;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String timeText = format.format(StartingTime);
        stringshare = Name + "  " + timeText + "  ";
        if (Importance == 1) {
            stringshare += "一般" + "  ";
        }
        if (Importance == 2) {
            stringshare += "重要" + "  ";
        }
        if (Importance == 3) {
            stringshare += "很重要" + "  ";
        }
        if (IsRepeat == 1) {
            stringshare += "重复" + "  ";
        }
        if (IsRepeat == 0) {
            stringshare += "不重复" + "  ";
        }
        if (Period == 1) {
            stringshare += "每天" + "  ";
        }
        if (Period == 7) {
            stringshare += "每周" + "  ";
        }
        if (Period == 30) {
            stringshare += "每月" + "  ";
        }
        if (Period == 365) {
            stringshare += "每年" + "  ";
        }
        return stringshare;
    }

    public String getStringDeadline() {
        String stringshare;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String timeText = format.format(StartingTime);
        stringshare = Name + "  " + timeText + "  ";
        if (Importance == 1) {
            stringshare += "一般" + "  ";
        }
        if (Importance == 2) {
            stringshare += "重要" + "  ";
        }
        if (Importance == 3) {
            stringshare += "很重要" + "  ";
        }
        if (IsRepeat == 1) {
            stringshare += "重复" + "  ";
        }
        if (IsRepeat == 0) {
            stringshare += "不重复" + "  ";
        }
        if (Period == 1) {
            stringshare += "每天" + "  ";
        }
        if (Period == 7) {
            stringshare += "每周" + "  ";
        }
        if (Period == 30) {
            stringshare += "每月" + "  ";
        }
        if (Period == 365) {
            stringshare += "每年" + "  ";
        }
        return stringshare;
    }

    public String getStringMyschedule() {
        String stringshare;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String timeText = format.format(StartingTime);
        stringshare = Name + "  " + timeText;
        return stringshare;
    }

    public String getStringMyschedule2() {
        String stringshare = "";
        if (Importance == 1) {
            stringshare += "一般" + "  ";
        }
        if (Importance == 2) {
            stringshare += "重要" + "  ";
        }
        if (Importance == 3) {
            stringshare += "很重要" + "  ";
        }
        if (Importance == 4) {
            stringshare += "课程" + "  ";
        }
        if (IsRepeat == 1) {
            stringshare += "重复" + "  ";
        }
        if (IsRepeat == 0) {
            stringshare += "不重复" + "  ";
        }
        if (Period == 1) {
            stringshare += "每天" + "  ";
        }
        if (Period == 7) {
            stringshare += "每周" + "  ";
        }
        if (Period == 30) {
            stringshare += "每月" + "  ";
        }
        if (Period == 365) {
            stringshare += "每年" + "  ";
        }
        if (Importance == 4) {
            stringshare += Place + "  " + "老师:" + Description;
        } else {
            stringshare += Place + "  " + Description;
        }
        return stringshare;
    }

}


