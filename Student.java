package com.jss;

import static com.jss.Lesson.*;


public class Student {
    public String name;
    public String adress;
    public Lesson[] lessonsList;

    public Student() {
    }

    public Student(String name, String adress, Lesson[] lessonsList) {
    }

    public Student(String name, String adress) {
        this.name = name;
        this.adress = adress;
    }

    public  String studentToString(Student student) {
        return String.format("name: %s\nadress: %s\nlessonsList: %s\n",
                student.name, student.adress, listAllLesson(student.lessonsList));
    }

    public String studentToString() {
        return String.format("Name: %s\nAdress: %s\n\nLessonsList: %s\n",
                name, adress,listAllLesson(lessonsList));
    }

    public static String listAllStudents(Student[] studentList) {
        String resultString = "";
        for (int i = 0; i < studentList.length; i++) {
            resultString += ( studentList[i].studentToString() + "\n");
        }
        return resultString;
    }


    public int toLern(Lesson lesson) {
        while (lesson.lessonHourseWorked <= lesson.lessonHourseAll) {
            lesson.lessonHourseWorked++;
        }
        return lesson.lessonHourseWorked;
    }

    public Lesson[] lessonAdd(Lesson[] lessonsList) {
        Lesson[] newLessonList = new Lesson[lessonsList.length + 1];
        System.arraycopy(lessonsList, 0, newLessonList, 0, newLessonList.length);
        newLessonList[newLessonList.length - 1] = new Lesson("ООП", 48);
        return newLessonList;
    }

    public Lesson[] removelastleson(Lesson[] lessonsList) {
        Lesson[] reduceLessonList = new Lesson[lessonsList.length - 1];
        System.arraycopy(lessonsList, 0, reduceLessonList, 0, reduceLessonList.length);

        return reduceLessonList;
    }

    //средний бал
    public float takeGPA(Lesson[] lessonsList) {
        float gpa = 0;

        for (int i = 0; i < lessonsList.length; i++) {
            gpa = lessonsList[i].examPointer + gpa;
        }
        return (gpa / lessonsList.length);
    }

}
