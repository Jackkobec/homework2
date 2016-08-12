package homework2.contactlist;

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
 * Класс для инициализации начального контакт листа с точкой входа в программу
 */
public class ConTest {
    public static void main(String[] args) {
        Contact contact0 = new Contact();
        contact0.name = "Vasa";
        contact0.phoneNamber = "093 1232323";


        Contact contact1 = new Contact();
        contact1.name = "Kola";
        contact1.phoneNamber = "095 2323232";

        Contact contact2 = new Contact();
        contact2.name = "Petya";
        contact2.phoneNamber = "097 2323232";

        Contact contact3 = new Contact();
        contact3.name = "Anna";
        contact3.phoneNamber = "097 54545454";

        Contact contact4 = new Contact();
        contact4.name = "Lena";
        contact4.phoneNamber = "095 1111111";

        Contact contact5 = new Contact();
        contact5.name = "Lada";
        contact5.phoneNamber = "097 5555555";

        Contact contact6 = new Contact();
        contact6.name = "Nadia";
        contact6.phoneNamber = "095 1212121";

        Contact contact7 = new Contact();
        contact7.name = "Jack";
        contact7.phoneNamber = "095 7777777";

        Contact contact8 = new Contact();
        contact8.name = "Inokentiy";
        contact8.phoneNamber = "095 8888888";

        Contact contact9 = new Contact();
        contact9.name = "Djon";
        contact9.phoneNamber = "095 2323232";

        Contact contact10 = new Contact();
        contact10.name = "Inokentiy";
        contact10.phoneNamber = "097 2121212";

/**
 * Инициализация начального контакт листа
 */
        int listIndex = 11;
        Contact[] contactList = new Contact[listIndex];
        contactList[0] = contact0;
        contactList[1] = contact1;
        contactList[2] = contact2;
        contactList[3] = contact3;
        contactList[4] = contact4;
        contactList[5] = contact5;
        contactList[6] = contact6;
        contactList[7] = contact7;
        contactList[8] = contact8;
        contactList[9] = contact9;
        contactList[10] = contact10;

/**
 * Перезапись исходного контакт листа в новый, с которым будем работать все время в дальнейшем.
 * Подсчитывает количество контактов с заполненными полями.
 * На случай если васяны решили запихнуть пару контактов с нуливыми полями и вызвать NullPointerException
 */
        int newIndex = Contact.contatcCoutnter(contactList);
        Contact[] contactList2 = new Contact[newIndex];
        System.arraycopy(contactList, 0, contactList2, 0, contactList2.length);

        MainMenu.mainMenu(contactList2);


    }


}











