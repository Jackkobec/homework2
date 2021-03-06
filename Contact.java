package homework2.contactlist;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
/**
 * Прошу не судить строго, программа написана по большей части в процедурном стиле
 * с использованием ооп. Имеет полностью рабочий и протестированный
 * функционал в соовествии с ТЗ. Писалась для практики и набития руки.
 * В результате были сделаны интересные открытия и понимание плюсов ООП по сравнению с
 * процедурной парадигмой, а так же ряд других инетерсных особенностей синтаксиса java.
 *
 *
 * Руководство пользователя програмой:
 * Список контактов представляет из себя массив контактов.
 * Список контактов можно выводить на экран, добавлять в него новый контакт,
 * находить контакт по номеру или имени, выводить киевстар или мтс контакты,
 * выводить первые и последние 5 контактов, удалять последний контакт,
 * удалять контакт по заданым критериям: имя или номер телефона, производить обновление
 * информации нужного контакта. Реализована валидация ввода проверкой регулярами.
 *
 *Добавлено интерактивное меню.
 */
/**
 * @autor   Jack:
 * email:   jackkobec@gmail.com
 * Skype:   skypejs77
 * @version 2.0
 */

/**
 * Класс Contact
 */
public class Contact {


    public String name;
    public String phoneNamber;


    /**
     * Конструктор контакта по умолчанию т.к. есть другой конструктор
     */
    Contact() {
    }

    /**
     * Конструктор контакта с инициализацией полей
     */
    Contact(String initName, String initPhoneNamber) {
        this.name = initName;
        this.phoneNamber = initPhoneNamber;
    }

    /**
     * Перегруженный метод, который показывает один контакт, переданный с аргументами
     */
    public void contactShow(String name, String phoneNamber) {
        this.name = name;
        this.phoneNamber = phoneNamber;
        String result = String.format("\nname: %s\nphoneNamber: %s", name, phoneNamber + "\n------------------------");
        System.out.println(result);

    }

    /**
     * Метод, который показывает один контакт
     */
    public String contactShow() {
        System.out.println(String.format("\nname: %s\nphoneNamber: %s ", name, phoneNamber
                + "\n------------------------"));
        return "";
    }


    /**
     * Метод для добавления контакта с консоли
     */
    public Contact contactAdd() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nДля записи имени используйте символы a-z, A-Z, 0-9, _\n" +
                "Длина имени от 3 до 15 символов с учетом пробелов. Пример: Vasa Pyatochkin");
        nameInput(sc);
        validatorName(name);

        System.out.println("\nДля записи номера используйте цифры 0-9.\n" +
                "Длина номера от 7 до 14 символов с учетом пробелов. Допускаются проблелы. Пример: 097 777 77 77");
        inputPhoneNamber(sc);
        validatorPhone(phoneNamber);

        return new Contact(name, phoneNamber);
    }

    /**
     * Метод для ввода имени контакта с консоли
     */
    public void nameInput(Scanner sc) {
        System.out.print("\n>>>Enter contact name: ");
        this.name = sc.nextLine();
    }
    /**
     * Метод для добавления номера телефона контакта с консоли
     */
    public void inputPhoneNamber(Scanner sc) {
        System.out.print("\n>>>Enter contact phone: ");
        this.phoneNamber = sc.nextLine();
    }

    /**
     * Валидатор имени символы a-z, A-Z, 0-9, длина 3-15
     */
    public void validatorName(String name) {
        Scanner sc = new Scanner(System.in);
        while (!checkName()) {
            System.out.println("Не правильно введено имя. Для записи имени используйте символы a-z, A-Z, 0-9, _\n" +
                    "Длина имени от 3 до 15 символов с учетом пробелов. Пример: Vasa Pyatochkin");
            nameInput(sc);
        }

    }
    /**
     * Валидатор иномера телефона символы -9, длина 7-14
     */
    public void validatorPhone(String phoneNamber) {
        Scanner sc = new Scanner(System.in);
        while (!checkPhoneNamber()) {
            System.out.println("Не правильно введен номер телефона. Для записи номера используйте цифры 0-9.\n" +
                    "Длина номера от 7 до 14 символов с учетом пробелов. Допускаются проблелы. Пример: 093 772 17 49");
            inputPhoneNamber(sc);
        }


    }
    /**
     * Патерн валидации имени
     */
    public boolean checkName() {
        Pattern p = Pattern.compile("^[\\sA-Za-z0-9_]{3,15}$");
        Matcher m = p.matcher(name);
        return m.matches();
    }
    /**
     * Патерн валидации номера телефона
     */
    public boolean checkPhoneNamber() {

        Pattern p = Pattern.compile("^[\\s0-9\\s]{7,14}$");
        Matcher m = p.matcher(phoneNamber);
        return m.matches();
    }



    /**
     * Метод, который отображает переданный как аргумент список контактов
     */
    public static void contactListShowAll(Contact[] contactlist) {

        for (int i = 0; i < contactlist.length; i++) {
            //  Contact contact = contactlist[i];

            System.out.println(contactlist[i].contactShow());
        }

    }

    /**
     * Метод для мультипоиска контакта по номеру телефона или имени
     */
    public static boolean findContactByNameOrPhone(String findParam, Contact[] contactList) {
        boolean res = true;

        for (int i = 0; i < contactList.length; i++) {
            if (contactList[i].name.contains(findParam) || contactList[i].phoneNamber.contains(findParam)) {
                System.out.println("По критерию " + findParam + " найден контакт:");
                contactList[i].contactShow();
            } else return false;


        }


        return res;

    }

    /**
     * Метод, который подсчитывает количество контактов с информацией,
     * Использовался чтобы определить сколько есть уже созданных контактов
     * и использовать это количество как длину масива контактов во избежание
     * null exeption при выводе
     */
    public static int contatcCoutnter(Contact[] contactList) {


        int newIndex = 0;
        for (int i = 0; i < contactList.length; i++)
            if (contactList[i].name != null || contactList[i].phoneNamber != null)
                newIndex++;
        System.out.println("Count of non-empty contacts: " + newIndex + "\n");
        return newIndex;
    }

    /**
     * Добавление контакта в контакт-лист методом увиличения его размера на 1
     */
    public static Contact[] addInContactList(Contact[] contactList) {
        // int extendedListIndex = contactList.length +1;
        Contact[] extContactlist = new Contact[(contactList.length + 1)];
        System.arraycopy(contactList, 0, extContactlist, 0, contactList.length);
        extContactlist[extContactlist.length - 1] = new Contact().contactAdd();

        contatcCoutnter(extContactlist);
        contactListShowAll(extContactlist);
        return extContactlist;
    }

    /**
     * CПоказывает первые 5 контактов
     */
    public static void showFirstFiveContacts(Contact[] contactlist) {
        for (int i = 0; i < 5; i++) {
            Contact contact = contactlist[i];

            System.out.println(contactlist[i].contactShow());
        }
    }

    /**
     * Показывает послежние 5 контактов
     */
    public static void showLastFiveContacts(Contact[] contactlist) {
        for (int i = (contactlist.length - 5); i < contactlist.length; i++) {
            Contact contact = contactlist[i];

            System.out.println(contactlist[i].contactShow());
        }
    }

    /**
     * Показывает только МТС контакты
     */
    public static void showMtsContacts(Contact[] contactlist) {
        for (int i = 0; i < contactlist.length; i++) {
            if (contactlist[i].phoneNamber.substring(0, 3).contains("095")) {
                System.out.println("MTC contact: ");
                contactlist[i].contactShow();
            }
        }

    }

    /**
     * Показывает тольлко Киевстар контакты
     */
    public static void showKievstarContacts(Contact[] contactlist) {
        for (int i = 0; i < contactlist.length; i++) {
            if (contactlist[i].phoneNamber.substring(0, 3).contains("097")) {
                System.out.println("Kievstar contact: ");
                contactlist[i].contactShow();
            }
        }

    }

    /**
     * Медод для удаления последнего контакта, возвращает контактлист без последнего контакта
     */
    public static Contact[] removeLastContact(Contact[] contactList) {
        Contact[] reducedContactList = new Contact[contactList.length - 1];
        System.arraycopy(contactList, 0, reducedContactList, 0, reducedContactList.length);
        return reducedContactList;
    }

    /**
     * Медод для обновления контакта по мультипараметру(updateParam) - имени или номеру контакта.
     * Совпавший по критериям контакт может находится в любом месте списка, он будет перезаписан,
     * а список контактов возвращен методом.
     */
    public static Contact[] updateContactByParam(Contact[] contactList, String updateParam) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < contactList.length; i++) {
            if (contactList[i].name.contains(updateParam) || contactList[i].phoneNamber.contains(updateParam)) {

                System.out.println("Введите новое имя для  " + contactList[i].name + ":");
                contactList[i].nameInput(sc);
                contactList[i].validatorName(contactList[i].name);
                System.out.println("ВВедите новый номер вместо " + contactList[i].phoneNamber + ":");
                contactList[i].inputPhoneNamber(sc);
                contactList[i].validatorPhone(contactList[i].phoneNamber);
                System.arraycopy(contactList, 0, contactList, 0, contactList.length);
            }
        }
        return contactList;
    }

    /**
     * Медод для удаления контакта по мультипараметру(delParam) - имени или номеру контакта.
     * Совпавший по критериям контакт может находится в любом месте списка, он будет удален,
     * а список склеен из оставшихся контактов и возвращен методом.
     *
     * !!!Работает только, если в соотвествии с параметром удаления будет найдено не более 2 контактов!!!!
     */
    public static Contact[] removeContactByParam(Contact[] contactList, String delParam) {

        Contact[] reducedContactList = new Contact[contactList.length - 1];
        for (int i = 0; i < contactList.length; i++) {
            if (contactList[i].name.contains(delParam) || contactList[i].phoneNamber.contains(delParam)) {
                int delElemetnIndex = i;
                System.arraycopy(contactList, 0, reducedContactList, 0, delElemetnIndex);
                System.arraycopy(contactList, delElemetnIndex + 1, reducedContactList, delElemetnIndex, (contactList.length - delElemetnIndex - 1));

            }


        }
        for (int i = 0; i < reducedContactList.length; i++) {
            if (reducedContactList[i].name.contains(delParam) || reducedContactList[i].phoneNamber.contains(delParam)) {
                Contact[] reducedContactList2 = new Contact[reducedContactList.length - 1];
                int delElemetnIndex = i;
                System.arraycopy(reducedContactList, 0, reducedContactList2, 0, delElemetnIndex);
                System.arraycopy(reducedContactList, delElemetnIndex + 1, reducedContactList2, delElemetnIndex, (reducedContactList2.length - delElemetnIndex));
                return reducedContactList2;
            }


        }
        return reducedContactList;
    }

}

