package com.javarush.test.level27.lesson15.big01.statistic.event;

import java.util.Date;

/**
 * Created by Admin on 14.01.2017.
 */
public interface EventDataRow {
    EventType getType();
    Date getDate();
    int getTime();
}
