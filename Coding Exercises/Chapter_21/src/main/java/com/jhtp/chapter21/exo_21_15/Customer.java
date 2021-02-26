package com.jhtp.chapter21.exo_21_15;

public class Customer {
   private int id;
   private int arrivalTime;
   private int serviceTime;

   public Customer (int id){
      this.id = id;
   }

   public int getId(){
      return id;
   }

   public int getArrivalTime(){
      return arrivalTime;
   }

   public void setArrivalTime(int newArrivalTime){
      this.arrivalTime = newArrivalTime;
   }

   public int getServiceTime(){
      return serviceTime;
   }

   public void setServiceTime(int newServiceTime){
      this.serviceTime = newServiceTime;
   }
}
