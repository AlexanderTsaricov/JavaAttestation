import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] filterIntSetting = new int[9];
        ArrayList<Notebook> notebookList = new ArrayList<Notebook>();
        Notebook pc1 = new Notebook();
        pc1.getRandomComputer();
        Notebook pc2 = new Notebook();
        pc2.getRandomComputer();
        notebookList.add(pc1);
        notebookList.add(pc2);
        mainMenu(notebookList, filterIntSetting);

    }
    public static void mainMenu (ArrayList<Notebook> notebooks, int[] filterIntSetting) {

        boolean flag = true;
        String mainMenuMessage = """
                Введите цифру для выполнения команды меню
                1. Добавить рандомный компьютер
                2. Показать весь список компьютеров
                3. Показать отфильтрованный список компьютеров
                4. Добавить компьютер
                5. Настройки фильтра
                6. Выход
                """;
        while (flag) {
            if (flag == false) {
                System.exit(0);
            }
            if (flag != false) {
                System.out.println(mainMenuMessage);
                System.out.print("Введите цифру: ");
                int enterMessage = getEnterMessage();
                switch (enterMessage) {
                    case 6:
                        flag = false;
                        System.exit(0);
                        break;
                    case 1:
                        notebooks.add(getRandomNotebook(notebooks));
                        break;
                    case 2:
                        getAllNotebook(notebooks, filterIntSetting);
                        break;
                    case 3:
                        getFiltredComputerList(notebooks, filterIntSetting);
                        break;
                    case 4:
                        addComputer(notebooks);
                        break;
                    case 5:
                        filterSetting(notebooks, filterIntSetting);
                        break;
                    default:
                        System.out.println("Не верная команда");
                        System.out.print("Введите цифру: ");
                        enterMessage = getEnterMessage();
                        break;
                }
            }
        }
    }

    public static int getEnterMessage () {
        while (true) {
            Scanner enter = new Scanner(System.in);
            int mess;
            if (!enter.hasNextInt()) {
                continue;
            }
            mess = enter.nextInt();
            return mess;
        }
    }

    public static void getAllNotebook (ArrayList<Notebook> notebooks, int[] filterIntSetting) {
        String menuMessage = """
                Введите цифру для выполнения команды меню
                1. Назад
                """;
        for (int i = 0; i < notebooks.size(); i++) {
            if (i == 0) {
                System.out.println("****************************************************************");
            }
            System.out.println(notebooks.get(i).getInformation());
            System.out.println("****************************************************************");
        }
        System.out.println(menuMessage);
        System.out.print("Введите цифру: ");
        int enterMessage = getEnterMessage();
        switch (enterMessage) {
            case 1:
                mainMenu(notebooks, filterIntSetting);
            break;

        }
    }
    public static Notebook getRandomNotebook (ArrayList<Notebook> notebooks) {
        Notebook pc1 = new Notebook();
        pc1.getRandomComputer();
        return pc1;
    }
    public static void getFiltredComputerList(ArrayList<Notebook> notebooks, int[] filterIntSetting) {
        String menuMessage = """
                Введите цифру для выполнения команды меню
                1. Назад
                """;
        for (int i = 0; i < notebooks.size(); i++) {
            Notebook tempNotebook =  new Notebook();
            Notebook computer = notebooks.get(i);
            if (filterIntSetting[0] != 0) {
                if (!tempNotebook.randomBrandList[filterIntSetting[0]-1].equals(computer.brand)) {
                    continue;
                }
            }
            if (filterIntSetting[1] != 0) {
                if (!tempNotebook.randomProcessorList[filterIntSetting[1]-1].equals(computer.processor)) {
                    continue;
                }
            }
            if (filterIntSetting[2] != 0) {
                if (!tempNotebook.randomVideoCardList[filterIntSetting[2]-1].equals(computer.videoCard)) {
                    continue;
                }
            }
            if (filterIntSetting[3] != 0) {
                if (tempNotebook.randomVideoCardMemoryList[filterIntSetting[3]-1] != (computer.videoCardMemory)) {
                    continue;
                }
            }
            if (filterIntSetting[4] != 0) {
                if (tempNotebook.randomRAMList[filterIntSetting[4]-1] != (computer.RAM)) {
                    continue;
                }
            }
            if (filterIntSetting[5] != 0) {
                if (!tempNotebook.randomHardDriveNameList[filterIntSetting[5]-1].equals(computer.hardDriveName)) {
                    continue;
                }
            }
            if (filterIntSetting[6] != 0) {
                if (tempNotebook.randomHardDriveMemory[filterIntSetting[6]-1] != (computer.hardDriveCount)) {
                    continue;
                }
            }
            if (filterIntSetting[7] != 0) {
                if (tempNotebook.randomDiagonalList[filterIntSetting[7]-1] != (computer.dysplayDiagonal)) {
                    continue;
                }
            }
            if (filterIntSetting[8] != 0) {
                if (!tempNotebook.randomColorList[filterIntSetting[8]-1].equals(computer.color)) {
                    continue;
                }
            }
            if (i == 0) {
                System.out.println("****************************************************************");
            }
            System.out.println(computer.getInformation());
            System.out.println("****************************************************************");
        }
        System.out.println(menuMessage);
        System.out.print("Введите цифру: ");
        int enterMessage = getEnterMessage();
        switch (enterMessage) {
            case 1:
                mainMenu(notebooks, filterIntSetting);
                break;

        }
    }
    public static void filterSetting(ArrayList<Notebook> notebooks, int[] filterIntSetting){

        String menuMessage = """
                Введите цифру для выполнения команды меню
                1. Назад
                2. Выбрать бренд компьютера
                3. Выбрать процессор
                4. Выбрать бренд видеокарты
                5. Выбрать память видеокарты
                6. Выбрать количество оперативной памяти
                7. Выбрать бренд жесткого диска
                8. Выбрать объем жесткого диска
                9. Выбрать диагональ монитора
                10. Выбрать цвет
                11. Очистить фильтр
                """;
        boolean flag = true;
        while (flag) {
            System.out.println(menuMessage);
            System.out.print("Введите цифру: ");
            int enterMessage = getEnterMessage();
            switch (enterMessage) {
                case 1:
                    flag = false;
                    mainMenu(notebooks, filterIntSetting);
                    break;
                case 2:
                    for (int i = 0; i < notebooks.get(0).randomBrandList.length; i++) {
                        String brand = notebooks.get(0).randomBrandList[i];
                        System.out.printf("%d) %s", i + 1, brand);
                        System.out.println("\n");
                    }
                    filterIntSetting[0] = getEnterMessage();
                    break;
                case 3:
                    for (int i = 0; i < notebooks.get(0).randomProcessorList.length; i++) {
                        String brand = notebooks.get(0).randomProcessorList[i];
                        System.out.printf("%d) %s", i + 1, brand);
                        System.out.println("\n");
                    }
                    filterIntSetting[1] = getEnterMessage();
                    break;
                case 4:
                    for (int i = 0; i < notebooks.get(0).randomVideoCardList.length; i++) {
                        String brand = notebooks.get(0).randomVideoCardList[i];
                        System.out.printf("%d) %s", i + 1, brand);
                        System.out.println("\n");
                    }
                    filterIntSetting[2] = getEnterMessage();
                    break;
                case 5:
                    for (int i = 0; i < notebooks.get(0).randomVideoCardMemoryList.length; i++) {
                        int brand = notebooks.get(0).randomVideoCardMemoryList[i];
                        System.out.printf("%d) %d", i + 1, brand);
                        System.out.println("\n");
                    }
                    filterIntSetting[3] = getEnterMessage();
                    break;
                case 6:
                    for (int i = 0; i < notebooks.get(0).randomRAMList.length; i++) {
                        int brand = notebooks.get(0).randomRAMList[i];
                        System.out.printf("%d) %d", i + 1, brand);
                        System.out.println("\n");
                    }
                    filterIntSetting[4] = getEnterMessage();
                    break;
                case 7:
                    for (int i = 0; i < notebooks.get(0).randomHardDriveNameList.length; i++) {
                        String brand = notebooks.get(0).randomHardDriveNameList[i];
                        System.out.printf("%d) %s", i + 1, brand);
                        System.out.println("\n");
                    }
                    filterIntSetting[5] = getEnterMessage();
                    System.out.println("\n");
                    break;
                case 8:
                    for (int i = 0; i < notebooks.get(0).randomHardDriveMemory.length; i++) {
                        int brand = notebooks.get(0).randomHardDriveMemory[i];
                        System.out.printf("%d) %d", i + 1, brand);
                        System.out.println("\n");
                    }
                    filterIntSetting[6] = getEnterMessage();
                    break;
                case 9:
                    for (int i = 0; i < notebooks.get(0).randomDiagonalList.length; i++) {
                        int brand = notebooks.get(0).randomDiagonalList[i];
                        System.out.printf("%d) %d", i + 1, brand);
                        System.out.println("\n");
                    }
                    filterIntSetting[7] = getEnterMessage();
                    break;
                case 10:
                    for (int i = 0; i < notebooks.get(0).randomColorList.length; i++) {
                        String brand = notebooks.get(0).randomColorList[i];
                        System.out.printf("%d) %s", i + 1, brand);
                        System.out.println("\n");
                    }
                    filterIntSetting[1] = getEnterMessage();
                    break;
                case 11:
                    filterIntSetting = new int[9];
                    break;
                default:
                    System.out.println("Не верная команда");

                    System.out.print("Введите цифру: ");
                    enterMessage = getEnterMessage();
            }
        }
    }
    public static void addComputer(ArrayList<Notebook> notebooks){
        Notebook firstComp = notebooks.get(0);
        Notebook comp = new Notebook();
        Scanner scan = new Scanner(System.in);

        System.out.print("Введите бренд: ");
        String brand = scan.nextLine();
        comp.brand = brand;
        firstComp.addNameToRandomStringList(brand, firstComp.randomBrandList);
        System.out.println("\n");

        System.out.print("Введите название процессора: ");
        String processor = scan.nextLine();
        comp.processor = processor;
        firstComp.addNameToRandomStringList(processor, firstComp.randomProcessorList);
        System.out.println("\n");

        System.out.print("Введите название видеокарты: ");
        String videoCard = scan.nextLine();
        comp.videoCard = videoCard;
        firstComp.addNameToRandomStringList(videoCard, firstComp.randomVideoCardList);
        System.out.println("\n");

        System.out.print("Введите количество памяти видеокарты: ");
        int videoCardMemory = scan.nextInt();
        comp.videoCardMemory = videoCardMemory;
        firstComp.addNameToRandomIntList(videoCardMemory, firstComp.randomVideoCardMemoryList);
        System.out.println("\n");

        System.out.print("Введите количество оперативной памяти: ");
        int RAM = scan.nextInt();
        comp.RAM = RAM;
        firstComp.addNameToRandomIntList(RAM, firstComp.randomRAMList);
        System.out.println("\n");

        System.out.print("Введите бренд жесткого диска: ");
        String hardDriveName = scan.next();
        comp.hardDriveName = hardDriveName;
        firstComp.addNameToRandomStringList(hardDriveName, firstComp.randomHardDriveNameList);
        System.out.println("\n");

        System.out.print("Введите количество памяти жесткого диска: ");
        int hardDriveCount = scan.nextInt();
        comp.hardDriveCount = hardDriveCount;
        firstComp.addNameToRandomIntList(hardDriveCount, firstComp.randomHardDriveMemory);
        System.out.println("\n");

        System.out.print("Введите размер диагонали монитора: ");
        int dysplayDiagonal = scan.nextInt();
        comp.dysplayDiagonal = dysplayDiagonal;
        firstComp.addNameToRandomIntList(dysplayDiagonal, firstComp.randomDiagonalList);
        System.out.println("\n");

        System.out.print("Введите цвет: ");
        String color = scan.next();
        comp.color = color;
        firstComp.addNameToRandomStringList(color, firstComp.randomColorList);
        System.out.println("\n");

        notebooks.add(comp);
        System.out.println("Компьютер со следующими параметрами добавлен");
        System.out.println(comp.getInformation());
    }
}