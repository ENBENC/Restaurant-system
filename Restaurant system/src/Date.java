class Date implements Comparable<Date>{
    private int[] date = new int[3], time = new int[3];
    public Date(String date, String time){
        //Convert string date and time into a array of intege, in format [yy,mm,dd] and [HH,mm,ss].
        for(int i=0;i<this.date.length;i++){
            this.date[i] = Integer.parseInt(date.split("/")[i]);
            this.time[i] = Integer.parseInt(time.split(":")[i]);
        }
    }

    public int compareTo(Date d){
        if(this.getYear() > d.getYear()){
            return 1;
        }
        else if(this.getYear() < d.getYear()){
            return -1;
        }

        if(this.getMonth() > d.getMonth()){
            return 1;
        }
        else if(this.getMonth() < d.getMonth()){
            return -1;
        }

        if(this.getDay() > d.getDay()){
            return 1;
        }
        else if(this.getDay() < d.getDay()){
            return -1;
        }

        if(this.getHour() > d.getHour()){
            return 1;
        }
        else if(this.getHour() < d.getHour()){
            return -1;
        }

        if(this.getMinute() > d.getMinute()){
            return 1;
        }
        else if(this.getMinute() < d.getMinute()){
            return -1;
        }

        if(this.getSecond() > d.getSecond()){
            return 1;
        }
        else if(this.getSecond() < d.getSecond()){
            return -1;
        }
        return 0;
    }

    public int getYear(){
        return date[0];
    }

    public int getMonth(){
        return date[1];
    }

    public int getDay(){
        return date[2];
    }

    public int getHour(){
        return time[0];
    }

    public int getMinute(){
        return time[1];
    }

    public int getSecond(){
        return time[0];
    }

    @Override
    public String toString(){
        /*
        Return a string with format "YYYY/MM/DD HH:MM:SS".
        If any number is in range 0-9, then add a 0 before.

        Args: None
        Return: s (String)
        */
        String s = "";

        if(getYear() < 10 && getYear() > -1){
            s += "0"+getYear()+"/";
        }
        else{
            s += getYear() + "/";
        }

        if(getMonth() < 10 && getMonth() > -1){
            s += "0"+getMonth()+"/";
        }
        else{
            s += getMonth() + "/";
        }

        if(getDay() < 10 && getDay() > -1){
            s += "0"+getDay() + " ";
        }
        else{
            s += getDay() + " ";
        }

        if(getHour() < 10 && getHour() > -1){
            s += "0"+getHour() + ":";
        }
        else{
            s += getHour() + ":";
        }

        if(getMinute() < 10 && getMinute() > -1){
            s += "0"+getMinute() + ":";
        }
        else{
            s += getMinute() + ":";
        }

        if(getSecond() < 10 && getSecond() > -1){
            s += "0"+getSecond();
        }
        else{
            s += getSecond();
        }
        return s;
    }
}
