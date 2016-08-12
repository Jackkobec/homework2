package com.jss;


public class Lesson {

    public String lessonName;
    public int lessonHourseAll;
    public int lessonHourseWorked;
    public float examPointer;


    public Lesson() {
        this("Не указано имя предмета", 48);
    }

    public Lesson(String lessonName, int lessonHourseAll) {
        this.lessonName = lessonName;
        this.lessonHourseAll = lessonHourseAll;
        this.lessonHourseWorked = 0;
        this.examPointer = 0;
    }


//
//    int lessonsCount = 3;
//    Lesson[] lessonsList = new Lesson[lessonsCount];

    public String lesonToString() {
        return String.format("LessonName: %s\nLessonHourseAll: %d\nLessonHourseWorked: %d\nExamPointer: %.2f",
                lessonName, lessonHourseAll, lessonHourseWorked, examPointer);
    }

    public static String listAllLesson(Lesson[] lesonList) {
        String resultString = "";
        for (int i = 0; i < lesonList.length; i++) {
            resultString += ("\n" + lesonList[i].lesonToString() + "\n");
        }
        return resultString;
    }


    public float takeAnExamination(Student student, Lesson leson) {
        examPointer = 5;

        return examPointer;
    }

    public float treturneExamPoiner(Student student, Lesson leson) {
        examPointer = leson.examPointer;

        return examPointer;
    }

    public void showLessonInfo() {
        System.out.println(String.format("lessonName: %s, lessonHourseAll: %d, lessonHourseWorked: %d, examPointer: %d",
                lessonName, lessonHourseAll, lessonHourseWorked, examPointer));
    }

    public float takeExamPointer(float examPointer) {
        this.examPointer = examPointer;
        return examPointer;
    }
}
