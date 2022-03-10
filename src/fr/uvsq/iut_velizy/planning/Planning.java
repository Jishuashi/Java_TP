package src.fr.uvsq.iut_velizy.planning;

import src.fr.uvsq.iut_velizy.reservation.*;

public class Planning {
    public final int SIZE;
    private Reservation [] reservationArray;

    public Planning(int pSize){
        SIZE = pSize;
        reservationArray = new Reservation[SIZE];
    }

    public void addInPlanning(Reservation pReservation){
        for(int i = 0; i < SIZE; i++){
            if(reservationArray[i] == null){
                reservationArray[i] = pReservation;
                sortPlanning();
                return;
            }
            else if(reservationArray[i] != null){
                if(reservationArray[i].getDate().compareTo(pReservation.getDate()) == 0){
                    if (reservationArray[i].getTimeSlot().compareTo(pReservation.getTimeSlot()) == 0){  
                        return;
                    }
                    else{
                        int m = 0;

                        while (m < SIZE && reservationArray[m] != null){
                            m++;
                        }

                        reservationArray[m] = pReservation;
                        sortPlanning();
                        return;
                    }
                }
            }
            else {
                return;
            }
        }   
    }

    public String toString(){
        String lStr = new String();
        
        for (int i = 0; i < SIZE; i++){
            if(reservationArray[i] != null){
                lStr += reservationArray[i].toString() + "\n";
            }
        }
        return lStr;
    }


    private void sortPlanning(){
        int j = 0;
        int imin = 0;

        for (int i = 0; i < SIZE; i++){
            while (j < SIZE && reservationArray[j] != null && reservationArray[i] != null){
                
                if(reservationArray[j].getDate().compareTo(reservationArray[i].getDate()) < 0){
                    imin = j;
                }
                
                
                if (reservationArray[j].getDate().compareTo(reservationArray[i].getDate()) == 0){
                    if (reservationArray[j].getTimeSlot().compareTo(reservationArray[i].getTimeSlot()) < 0){  
                        imin = j;
                    }
                }
                else {
                    break;
                }

                j++;
            }

            Reservation lTempVar = reservationArray[i];
            reservationArray[i] = reservationArray[imin];
            reservationArray[imin] = lTempVar;
        }
    }
}


