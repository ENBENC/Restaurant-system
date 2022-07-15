class Date implements Comparable<Date>{
    public int[] date = new int[3], time = new int[3];
    public Date(String date, String time){
        //Convert string date and time into a array of intege, in format [yy,mm,dd] and [HH,mm,ss].
        for(int i=0;i<this.date.length;i++){
            this.date[i] = Integer.parseInt(date.split("/")[i]);
            this.time[i] = Integer.parseInt(time.split("/")[i]);
        }
    }

    public int compareTo(Date d){
        if(date[0] < d.date[0] || date[1] < d.date[1] || date[2] < d.date[2] || time[0] < d.time[0] || time[1] < d.time[1] || time[2] < d.time[2]){
            return -1;
        }
        else if(date[0] > d.date[0] || date[1] > d.date[1] || date[2] > d.date[2] || time[0] > d.time[0] || time[1] > d.time[1] || time[2] > d.time[2]){
            return 1;
        }
        else{
            return 0;
        }
    }

    @Override
    public String toString(){
        return date[0]+"/"+date[1]+"/"+date[2] + " " + time[0]+":"+time[1]+":"+time[2];
    }
}
