import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

class Test{
    public static void main(String[] args) {
       DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd");
       DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");

       LocalDateTime now = LocalDateTime.now();
       //System.out.println(date.format(now));
       //System.out.println(time.format(now));

       System.out.println(date.format(now).split("/")[1]);
      }
}
