package src.fr.uvsq.iut_velizy.hourly;

public class Hourly {
    private int hour;
    private int quartHour;

    /**
     * 
     * @param pHour
     * @param pQuartHour
     */

    public Hourly(int pHour, int pQuartHour){
        hour = pHour;
        quartHour = pQuartHour;
    }
    /**
     * The method 
     * @return The hour in minutes 
     */
    public int toMinutes(){
        return hour*60 + quartHour;
    }

    /**
     * To get hour of Hourly
     * @return hour 
     */
    public int getHour(){
        return hour;
    }

    /**
     * To get quart hour of Hourly
     * @return quartHour
     */
    public int getQuartHour(){
        return quartHour;
    }

    /**
     * Set the hour by the param
     * @param pHour --> new hour to set 
     */
    public void setHour(int pHour){
        hour = pHour;
    }
    /**
     * Set the Quart Hour by the param
     * @param pQuartHour --> new Quart Hour to set
     */
    public void setQuartHour(int pQuartHour){
        quartHour = pQuartHour;
    }

    public String toString(){
        return hour + "h" + quartHour;
    }


    /** 
     * This method check if the Hourly is Valid 
    */
    public Boolean isValid(){
        if (hour <= 24){
            if (quartHour % 15 == 0 && quartHour <= 60){
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
}
