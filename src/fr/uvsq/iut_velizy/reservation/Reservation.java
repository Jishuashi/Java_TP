package src.fr.uvsq.iut_velizy.reservation;

import src.fr.uvsq.iut_velizy.date.*;
import src.fr.uvsq.iut_velizy.hourly.*;

public class Reservation {
    private Date dateOfRes;
    private TimeSlot timeSlotOfRes;
    private String nameOfRes;
     
    /**
        * Create a reservation with
        * @param pName --> Name of the reservation 
        * @param pDate --> Date of the reservation 
        * @param pTimeSlot --> TimeSlot of the reservation  
    */
    public Reservation(String pName, Date pDate, TimeSlot pTimeSlot){
        dateOfRes = pDate;
        nameOfRes = pName;
        timeSlotOfRes = pTimeSlot;
    }

    /**
        * This method return the String() of Reservation  
        * @return String(nameOfRes + ", " + dateOfRes + ", " + timeSlotOfRes)
    */
    public String toString(){
       return nameOfRes + ", " + dateOfRes + ", " + timeSlotOfRes;
    }

    /**
     * Getter of Date of Reservation
     * @return Date object of Reservation
     */
    public Date getDate(){
        return dateOfRes;
    }

    /**
     * 
     * @return TimeSlot object of Reservation
     */
    public TimeSlot getTimeSlot(){
        return timeSlotOfRes;
    }

     /**
     * Compare if this is begin before or after pReservation
     * @param pReservation --> TimeSlot to compare 
     * @return -1 if reservation slot start before pReservation <br/>
     *          1 if reservation slot start after pReservation <br/>
     *          0 if reservation slot start in same time of pReservation 
     */
    public int compareTo(Reservation pReservation){
            if(dateOfRes.compareTo(pReservation.dateOfRes) > 0){
                return 1;
            }
            else if(dateOfRes.compareTo(pReservation.dateOfRes) == 0){
                if (timeSlotOfRes.compareTo(pReservation.timeSlotOfRes) > 0){
                    return 1;
                }
                else if(timeSlotOfRes.compareTo(pReservation.timeSlotOfRes) == 0){
                    return 0;
                }
                else {
                    return -1;
                }
            }
            else {
                return -1;
            }
    }
}
