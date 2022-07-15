class Reservation implements Comparable<Reservation>{
    public String guest_name, note;
    public int guest_number,table_number;
    public Date date;

    public Reservation(String guest_name, String date, String time, String note, int guest_number, int table_number){
        this.guest_name = guest_name;
        this.guest_number = guest_number;
        this.date = new Date(date, time);
        this.note = note;
        this.guest_number = guest_number;
        this.table_number = table_number;
    }

    public int compareTo(Reservation r){
        if(this.date.compareTo(r.date) == -1){
            return -1;
        }
        else if(this.date.compareTo(r.date) == 1){
            return 1;
        }
        else{
            return 0;
        }
    }



}
