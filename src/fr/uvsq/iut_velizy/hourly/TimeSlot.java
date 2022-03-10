package src.fr.uvsq.iut_velizy.hourly;

public class TimeSlot {
    public final static int PERIOD_MIN = 60;
    private Hourly startHourly , endHourly;

    /**
     * Create new TimeSlot with 
     * @param pStartHourly --> The Start of the TimeSlot 
     * @param pEndHourly --> The End of the TimeSlot
     */
    public TimeSlot(Hourly pStartHourly, Hourly pEndHourly){
        startHourly = pStartHourly;
        endHourly = pEndHourly;
    }

    public String toString(){
        if(startHourly.getQuartHour() == 0 ) return startHourly.toString() + "0" + " - " + endHourly.toString() +  ", " + "Period : " + getPeriod() + "mn";
        else if(endHourly.getQuartHour() == 0 ) return startHourly.toString() + " - " + endHourly.toString() + "0" +  ", " + "Period : " + getPeriod() + "mn";
        else return startHourly.toString() + " - " + endHourly.toString() +  ", " + "Period : " + getPeriod() + "mn";
    }

    /**
     * getter for the Start Hourly of TimeSlot
     * @return startHourly;
     */
    public Hourly getStartHourly(){
        return startHourly;
    }

    /**
     * getter for the Start Hourly of TimeSlot
     * @return endHourly;
     */
    public Hourly getEndHourly(){
        return endHourly;
    }

    /**
     * getter for period of time slot in minutes
     * @return periodMinute 
     */
    public int getPeriodMinutes(){
        int lStartHourlyMin = startHourly.toMinutes();
        int lEndHourlyMin = endHourly.toMinutes();
        
        int lPeriodMinute = lEndHourlyMin - lStartHourlyMin;

        return lPeriodMinute;
    }
    /**
     * getter for period of time slot in hourly
     * @return period Hourly
     */
    public Hourly getPeriod(){
        int lStartHourlyMin = startHourly.toMinutes();
        int lEndHourlyMin = endHourly.toMinutes();

        int lMin = lEndHourlyMin - lStartHourlyMin;

        int lHour = lMin / 60;
        int lMinutes = lMin % 60;

        return new Hourly(lHour , lMinutes);
    }
    /**
     * Check if the Time slot is valid
     * @return the result
     */
    public Boolean isValid(){
        if (startHourly.isValid() && endHourly.isValid()){

            if (getPeriodMinutes() >= PERIOD_MIN){
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    /**
     * Compare if this is begin before or after pTimeSlot
     * @param pTimeSlot --> TimeSlot to compare 
     * @return -1 if time slot start before pTimeSlot <br/>
     *          1 if time slot start after pTimeSlot <br/>
     *          0 if time slot start in same time of pTimeSlot 
     */
    public int compareTo(TimeSlot pTimeSlot){
        if(endHourly.toMinutes() < pTimeSlot.getStartHourly().toMinutes()){
            return -1;
        }     
        else if (endHourly.toMinutes() > pTimeSlot.getStartHourly().toMinutes()){
            return 1;
        } 
        else {
            return 0;
        }
    }
}
