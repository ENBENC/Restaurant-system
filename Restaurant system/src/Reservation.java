class Reservation implements Comparable<Reservation>{
    private String guest_name, note;
    private String guest_number,table_number;
    private Date date;
    private String[] info;

    public Reservation(String guest_name, String dateString, String note, String guest_number, String table_number){
        this.guest_name = guest_name;
        this.note = note;
        this.guest_number = guest_number;
        this.table_number = table_number;

        //Create Date object based on the given dateString
        String d = dateString.split(" ")[0];
        String t = dateString.split(" ")[1];
        this.date = new Date(d,t);

        //Gather all information of Reservation-object into an array.
        this.info = new String[]{this.guest_name,this.guest_number,this.table_number,this.date.toString(),this.note};
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
    @Override
    public String toString(){
        /*
        Return a string in format of
        guest_name /+/ guest_number /+/ table_number /+/ YYYY/MM/DD HH:MM:SS /+/ note /+/
        */
        String string = "";
        for(String s : info){
            string += s + " /+/ ";
        }
        return string;
    }
}
