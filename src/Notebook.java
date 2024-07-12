import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class Notebook {
    public String[] randomBrandList = {"Asus", "Apple", "Lenovo", "HP", "Eurocom", "LG", "Razer", "VIT"};
    public String[] randomProcessorList = {"Altera", "AMD", "Apollo", "ARM", "Atmel", "AT&T", "Bell Labs", "Cyrix"};
    public String[] randomVideoCardList = {"NVIDIA", "AMD", "INTEL", "ASUS", "MSI", "GIGABYTE", "PALIT"};
    public int[] randomVideoCardMemoryList = {528, 1024, 2048, 4096, 8192};
    public int[] randomRAMList = {2, 4, 8, 16, 32, 64, 128};
    public String[] randomHardDriveNameList = {"Seagate Barracuda", "Toshiba", "Western Digital", "Seagate FireCuda"};
    public int[] randomHardDriveMemory = {528, 1024, 2048, 4096, 8192};
    public int[] randomDiagonalList = {10, 11, 12, 13, 14, 15, 17};
    public int id = generateId();
    public String brand = "No name";
    public String processor = "No name";
    public String videoCard = "No name";
    public int videoCardMemory = 0;
    public int RAM = 0;
    public String hardDriveName = "No name";
    public int hardDriveCount = 0;
    public int dysplayDiagonal = 0;

    public String getInformation () {
        String generalInformation = String.format("""
            ID: %d
            Название модели: %s
            Название процессора: %s
            Видеокарта: %s %d
            Оперативная память: %d Гб
            Жесткий диск: %s %d Гб
            Диагональ дисплея: %d дюймов
            """,id , brand, processor, videoCard, videoCardMemory, RAM, hardDriveName, hardDriveCount, dysplayDiagonal);
        return generalInformation;
    }
    private static int generateId () {
        Random rnd = new Random();
        String time = new SimpleDateFormat("HHmmss").format(Calendar.getInstance().getTime());
        return Integer.parseInt(time) + rnd.nextInt(1111, 9999);
    }
    public void getRandomComputer (){
        brand = getRandomStringParameter(randomBrandList);
        processor = getRandomStringParameter(randomProcessorList);
        videoCard = getRandomStringParameter(randomVideoCardList);
        videoCardMemory = getRandomIntegerParameter(randomVideoCardMemoryList);
        RAM = getRandomIntegerParameter(randomRAMList);
        hardDriveName = getRandomStringParameter(randomHardDriveNameList);
        hardDriveCount = getRandomIntegerParameter(randomHardDriveMemory);
        dysplayDiagonal = getRandomIntegerParameter(randomDiagonalList);


    }
    public String getRandomStringParameter (String[] stringParameter) {
        Random rnd = new Random();
        return stringParameter[rnd.nextInt(0, stringParameter.length-1)];
    }

    public int getRandomIntegerParameter (int[] integerParameter) {
        Random rnd = new Random();
        return integerParameter[rnd.nextInt(0, integerParameter.length-1)];
    }

    public void addNameToRandomList (String addName, String[] list) {
        String[] tempBrandList = list.clone();
        list = new String[list.length+1];
        for (int i = 0; i < tempBrandList.length; i++) {
            list[i] = tempBrandList[i];
        }
        list[list.length-1] = addName;
    }
}
