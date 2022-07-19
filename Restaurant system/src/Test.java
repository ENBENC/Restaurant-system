import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.*;
import pkg.SortedLinkedList;

class Test{

    public static void testDate(String dateString){
        /*
        Test function to test that date object is correctly made.

            Args: dateString(String)
            Return: None
        */
        String date = dateString.split(" ")[0];
        String time = dateString.split(" ")[1];

        Date testDate = new Date(date, time);

        System.out.println("Testing testDate...");
        assert testDate.toString().equals(dateString) != true;
        System.out.println("Test testDate done!" + "\n");
    }

    public static void testDateOrderSmallToLarge(String... dateStrings){
        /*
        Test function to test the compareTo method in date is correctly implemented.
        This test will get amount of dateString in format "YYYY/MM/DD HH:MM:SS",
        and create Date object. Then have them in a ArrayList where the smallest date at first place.
        EX: "1991/MM/DD HH:MM:SS"
            "2000/MM/DD HH:MM:SS"
            "2010/MM/DD HH:MM:SS"

            Args: dateStrings(String[])
            Return: None
        */
        ArrayList<Date> lst = makeDates(dateStrings);

        Collections.sort(lst);

        System.out.println("Testing testDateOrderSmallToLarge...");
        for(int i=0; i<dateStrings.length; i++){
            if(i-1 < 0){
                continue;
            }
            else{
                Date smallDate = lst.get(i-1);
                assert (smallDate.compareTo(lst.get(i))) == -1;
            }
        }
        System.out.println("Test testDateOrderSmallToLarge done!" + "\n");
    }

    public static void testSortedLinkedListWithReservation(String... dateStrings){
        /*
        Test Reservation and sortedList.
        Where create amont of Reservation and put them into the SortedLinkedList.
        Then take them out one by one.
        Since we remove the first element, therefor the element must be smaller
        or equal than element after it.

        Args: dateStrings(String[])
        Return: None
        */
        SortedLinkedList<Reservation> sortedList = new SortedLinkedList<Reservation>();
        ArrayList<Reservation> reservationLst = new ArrayList<Reservation>();

        for(String d : dateStrings){
            reservationLst.add(new Reservation("None",d,"None","None","None"));
        }

        for(Reservation r : reservationLst){
            sortedList.add(r);
        }
        assert sortedList.size() == reservationLst.size();

        int index = 0;
        Reservation currentReservation = null;
        for(int i=0;i<dateStrings.length;i++){
            if(index-1 < 0){
                currentReservation = sortedList.remove();
                index += 1;
            }
            else{
                Reservation tmp = sortedList.remove();
                assert (currentReservation.compareTo(tmp)) <= 0;
                currentReservation = tmp;
                index += 1;
            }
        }
        System.out.println(currentReservation);

        assert sortedList.size() == 0;
    }

    public static ArrayList<Date> makeDates(String[] dateStrings){
        /*
        A function that take a array of dateStrings, and make Date-objects.
        Then return it in a ArrayList of Date.

        Args: dateStrings (String[])
        Return: lst (ArrayList<Date>)
        */
        ArrayList<Date> lst = new ArrayList<Date>();
        for(String s : dateStrings){
            String date = s.split(" ")[0];
            String time = s.split(" ")[1];
            lst.add(new Date(date,time));
        }
        return lst;
    }



    public static void main(String[] args) {
    /*
       DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd");
       DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");

       LocalDateTime now = LocalDateTime.now();*/

       String dateString1 = "2014/04/25 13:43:52";
       String dateString2 = "2015/05/02 09:30:01";
       String dateString3 = "2017/05/07 07:21:51";
       String dateString4 = "2022/07/08 12:13:21";
       String dateString5 = "2022/07/08 12:13:21";
       String dateString6 = "2022/07/08 12:12:21";

       System.out.println("-----------------------------------------------------");
       System.out.println("Test Date-object..." + "\n");
       testDate(dateString1);
       testDate(dateString2);
       testDate(dateString3);

       testDateOrderSmallToLarge(dateString1,dateString2,dateString4,dateString3,dateString5,dateString6);
       System.out.println("All tests on Date-object done!" + "\n");

       System.out.println("-----------------------------------------------------");
       System.out.println("Test SortedLinkedList and Reservation..." + "\n");
       testSortedLinkedListWithReservation(dateString1,dateString2,dateString4,dateString3,dateString5,dateString6);
       System.out.println("All tests on SortedLinkedList and Reservation done!" + "\n");

       System.out.println("All test done!");
      }
}
