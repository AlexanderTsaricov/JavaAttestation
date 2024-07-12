import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class Notebook {

    public int id = generateId();
    public String brand = "No name";
    public String processor = "No name";
    public String videoCard = "No name";
    public int RAM = 0;
    public String hardDriveName = "No name";
    public int hardDriveCount = 0;
    public int dysplayDiagonal = 0;
    public String generalInformation = String.format("Название модели: %s\n" +
            "Название процессора: %s\n" +
            "Видеокарта: %s %d\n" +
            "Оперативная память: %d Гб\n" +
            "");
    private static int generateId () {
        Random rnd = new Random();
        String time = new SimpleDateFormat("HHmmss").format(Calendar.getInstance().getTime());
        return Integer.parseInt(time) + rnd.nextInt(1111, 9999);
    }

}
