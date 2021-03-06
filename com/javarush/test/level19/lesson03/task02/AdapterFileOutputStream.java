package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
*/


import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter
{
    public static void main(String[] args)
    {

    }
    private FileOutputStream fileOutputStream;

    AdapterFileOutputStream(FileOutputStream stream)
    {
        this.fileOutputStream = stream;
    }

    @Override
    public void flush() throws IOException
    {
        this.fileOutputStream.flush();
    }

    public void writeString(String s) throws IOException
    {
        this.fileOutputStream.write(s.getBytes());
    }

    @Override
    public void close() throws IOException
    {
        this.fileOutputStream.close();
    }
}

