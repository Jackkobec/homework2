package homework2.contactlist;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import static homework2.contactlist.Contact.updateContactByParam;
/**
 * @autor   Jack:
 * email:   jackkobec@gmail.com
 * Skype:   skypejs77
 * @version 2.0
 */
/**
 * Главное меню
 */
public class MainMenu {


    public static void mainMenu(Contact[] contactList2) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Добро пожаловать в интерактивный контакт - лист!");
        System.out.println(">>>>>>>MAIN MENU / ГЛАВНОЕ МЕНЮ<<<<<<<:");
        System.out.println("Выберите действие");
        System.out.println("\"0\" - Show All/Вывод на экран всех исходных контактов");
        System.out.println("\"1\" - Show first 5 contacts/Показать первые 5 контактов");
        System.out.println("\"2\" - Show last 5 contacts/Показать последние 5 контактов");
        System.out.println("\"3\" - Show all MTC contacts/Показать все МТС контакты");
        System.out.println("\"4\" - Show all Kievstar contacts/Показать все Киевстар контакты");
        System.out.println("\"5\" - Remove Last Contact and show without him/Удалить последний контакт и показать без него");
        System.out.println("\"6\" - Find contact by multiparameters(name or phone)/Поиск контакта по мультипараметру(имени или номеру)");
        System.out.println("\"7\" - Add to the contactList from console/Добавление в контакт лист нового контакта из консоли");
        System.out.println("\"8\" - Remove from contactList by multiparameters(name or phone) adn show contactList without him/\n" +
                "Удаление контакта по мультипараметру(имени или номеру) и отображение контакт - листа без него");
        System.out.println("\"9\" - Updating contact info. At first we find current contact by multiparameters(name or phone) and add new data\n" +
                "from console");
       // System.out.println("\"q\" - Exit from program/Выход из программы"); will be released later
        System.out.print("Сделайте выбор пункта меню: ");

//        System.out.println("=========================");

        String selection = sc.nextLine();
        String res = menuValidator(selection);

        int sel = Integer.parseInt(res);

        switch (sel) {
            case 0: {
                System.out.println("Все исходные контакты:");
                Contact.contactListShowAll(contactList2);
                subMenu(contactList2);
            }
            break;
            case 1: {
                System.out.println("Первые 5 контактов:");
                Contact.showFirstFiveContacts(contactList2);
                subMenu(contactList2);
            }
            break;
            case 2: {
                System.out.println("Последние 5 контактов:");
                Contact.showLastFiveContacts(contactList2);
                subMenu(contactList2);
            }
            break;
            case 3: {
                System.out.println("MTC contacts: \n");
                Contact.showMtsContacts(contactList2);
                subMenu(contactList2);
            }
            break;
            case 4: {
                System.out.println("Kievstar contacts: \n");
                Contact.showKievstarContacts(contactList2);
                subMenu(contactList2);
            }
            break;
            case 5: {
                System.out.println("Удаление последнего контакта и отображение без него:");
                Contact.contactListShowAll(Contact.removeLastContact(contactList2));
                subMenu(contactList2);
            }
            break;
            case 6: {
                System.out.println("Поиск контакта по мультипараметру(имени или номеру):");
                System.out.println(Contact.findContactByNameOrPhone("Vasa", contactList2) == true ? "По таким критериям контакты не найдены" : "");
                subMenu(contactList2);
            }
            break;
            case 7: {
                System.out.println("Добавление контакта в контакт-лист c консоли:");
                Contact.addInContactList(contactList2);
                subMenu(contactList2);
            }
            break;
            case 8: {
                System.out.println("Удаление контакта по мультипараметру(имени или номеру) и отображение контакт - листа без него");
                Contact.contactListShowAll(Contact.removeContactByParam(contactList2, "Inokentiy"));
                subMenu(contactList2);
            }
            break;
            case 9: {
                System.out.println("Обновление контакта, сначала находим его по мультипараметру поиска и вводлм новые данные с консоли");
                Contact.contactListShowAll(updateContactByParam(contactList2, "Vasa"));
                subMenu(contactList2);
            }
            break;
        }
    }
    /**
     * Подменю для возврата в главное меню по вводу 0
     */
    public static void subMenu(Contact[] contactList2) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Возврат в ГЛАВНОЕ МЕНЮ, нажмите \"0\"");
        System.out.println("\"0\" - Return to the MAIN MENU");

        int subSelect = sc.nextInt();
        while (subSelect != 0) {
            System.out.println("Incorrect Selection");
            subSelect = sc.nextInt();

        }
        mainMenu(contactList2);
    }
    /**
     * Валидатор вібора пункта меню
     */
    public static String menuValidator(String selection) {
        Scanner sc = new Scanner(System.in);
        while (!checkSelection(selection)) {
            System.out.println("Не правильно введен пункт меню. ВВедите число от 0 до 9. Пример: 7");
            selection = sc.nextLine();
        }
        return selection;
    }
    /**
     * Патерн валидации выбора пункта меню, число 0-9, один символ
     */
    public static boolean checkSelection(String selection) {

        Pattern p = Pattern.compile("^[0-9]{1}$");
        Matcher m = p.matcher(selection);
        return m.matches();
    }


}
