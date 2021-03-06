package com.javarush.test.level17.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception {



        try
        {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
       if(args[0].equals("-c"))

            {
                Person person = null;
                if ("м".equals(args[2]))
                    person = Person.createMale(args[1], simpleDateFormat.parse(args[3]));
                else
                    person = Person.createFemale(args[1], simpleDateFormat.parse(args[3]));
                allPeople.add(person);
                System.out.println(allPeople.indexOf(person));
            }
            else if (args[0].equals("-u"))
            {
                allPeople.get(Integer.parseInt(args[1])).setName(args[2]);
                allPeople.get(Integer.parseInt(args[1])).setSex(args[3].equals("м") ? Sex.MALE : Sex.FEMALE);
                allPeople.get(Integer.parseInt(args[1])).setBirthDay(simpleDateFormat.parse(args[4]));

            }
       else if (args[0].equals("-d"))
            {
                allPeople.get(Integer.parseInt(args[1])).setBirthDay(null);
            }
       else if (args[0].equals("-i"))
            {
                simpleDateFormat = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
                System.out.println(allPeople.get(Integer.parseInt(args[1])).getName() + " " +
                        (allPeople.get(Integer.parseInt(args[1])).getSex().equals(Sex.MALE) ? "м" : "ж" )  + " " +
                        simpleDateFormat.format(allPeople.get(Integer.parseInt(args[1])).getBirthDay()));
            }


        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
    }


        //start here - начни тут
    }
