package com.javarush.test.level27.lesson15.big01.statistic.event;

import com.javarush.test.level27.lesson15.big01.ad.Advertisement;

import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 14.01.2017.
 */
public class VideoSelectedEventDataRow implements EventDataRow
{
    private Date currentDate;
    private List<Advertisement> optimalVideoSet;
    private long amount;
    private int totalDuration;

    public VideoSelectedEventDataRow(List<Advertisement> optimalVideoSet, long amount, int totalDuration)
    {
        this.optimalVideoSet = optimalVideoSet;
        this.amount = amount;
        this.totalDuration = totalDuration;
        this.currentDate = new Date();
    }

    public long getAmount() {
        return amount;
    }

    @Override
    public Date getDate() {
        return this.currentDate;
    }

    @Override
    public int getTime() {
        return this.totalDuration;
    }

    @Override
    public EventType getType() {
        return EventType.SELECTED_VIDEOS;
    }
}
