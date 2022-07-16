class Reservation implements Comparable<Reservation>{
    private String guest_name, note;
    private String guest_number,table_number;
    private Date date;
    private String[] info;

    public Reservation(String guest_name, String date, String time, String note, String guest_number, String table_number){
        this.guest_name = guest_name;
        this.guest_number = guest_number;
        this.date = new Date(date, time);
        this.note = note;
        this.guest_number = guest_number;
        this.table_number = table_number;

        this.info = new String[]{this.guest_name,this.guest_number,this.guest_number,this.table_number,this.date.toString()};
    }

    public int compareTo(Reservation r){
        if(this.getDate().compareTo(r.getDate()) == -1){
            return -1;
        }
        else if(this.getDate().compareTo(r.getDate()) == 1){
            return 1;
        }
        else{
            return 0;
        }
    }

    public Date getDate(){
        return date;
    }

    public String[] getReservationInfo(){
        return info;
    }
}
