package com.jss;



/**
 *
 */
public class TestStudentsAndLessons {
    public static void main(String[] args) {
        Lesson algorithms = new Lesson("Algorithms", 32);
        Lesson javase = new Lesson("Java SE", 48);
        Lesson oop = new Lesson("OOP", 48);
        Lesson fraimworksjava = new Lesson("Fraimworks Java", 48);
        Lesson javaee = new Lesson("Java EE", 64);

        Lesson[] lesonList = new Lesson[5];
        lesonList[0] = algorithms;
        lesonList[1] = javase;
        lesonList[2] = oop;
        lesonList[3] = fraimworksjava;
        lesonList[4] = javaee;

        Lesson[] st1LesonList = new Lesson[2];
        st1LesonList[0] = algorithms;
        st1LesonList[1] = javase;

        Lesson[] st2LesonList = new Lesson[3];
        st2LesonList[0] = javase;
        st2LesonList[1] = oop;
        st2LesonList[2] = fraimworksjava;

        Lesson[] st3LesonList = new Lesson[4];
        st3LesonList[0] = javase;
        st3LesonList[1] = oop;
        st3LesonList[2] = fraimworksjava;
        st3LesonList[3] = javaee;
       // System.out.println(oop.lesonToString());
      //  System.out.println(listAllLesson(lesonList));


        Student st1 = new Student("Vasa", "Puskina 23/42");

        Student st2 = new Student();
        st2.name = "Inokentiy";
        st2.adress = "Pavlova str 20/50";
        st2.lessonsList = st2LesonList;

        Student st3 = new Student();

        Student[] stlist = new Student[3];
        stlist[0] = st1;
        stlist[1] = st2;
        stlist[2] = st3;

        System.out.println(st2.studentToString());
       //System.out.println(listAllStudents(stlist));
    }
}