package com.jhtp.chapter21.exo_21_15;

import java.security.SecureRandom;

import com.jhtp.chapter21.datastructures.Queue;

/**
 * Simulates a checkout line at a supermarket.
 * Customers arrive at random interval of times and are serviced at random interval of times as well.
 */
public class SupermarketSimulator {

   private static final int NUMBER_OF_MINUTES = 720;

   public static void main(String[] args) {
      SecureRandom random = new SecureRandom();
      Queue<Customer> customerQueue = new Queue<>();
      int totalCustomerServiced = 0;
      int maxNumberOfCustomersInQueue = 0;
      int longestWaitTime = 0;
      int arrivalRate = 4;
      int serviceRate = 4;
      
      //first customer arrives and starts being serviced
      Customer currentCustomer = new Customer(1);
      currentCustomer.setArrivalTime(random.nextInt(arrivalRate) + 1);
      System.out.printf("%-3d\tcustomer %d arrived%n", currentCustomer.getArrivalTime(), currentCustomer.getId());
      currentCustomer.setServiceTime(random.nextInt(arrivalRate) + 1);
      System.out.printf("%-3d\tStarted servicing customer %d for %d min%n", 
                        currentCustomer.getArrivalTime(), currentCustomer.getId(), currentCustomer.getServiceTime());
      int currentCustomerServiceCompletionTime = currentCustomer.getArrivalTime() + currentCustomer.getServiceTime();
      
      //schedule for next customer
      int nextCustomerId = currentCustomer.getId() + 1;
      Customer nextCustomer = new Customer(nextCustomerId);
      nextCustomer.setArrivalTime(currentCustomer.getArrivalTime() + random.nextInt(arrivalRate) + 1);
      nextCustomer.setServiceTime(random.nextInt(serviceRate) + 1);
      
      int currentTime = currentCustomer.getArrivalTime();
      while (currentTime <= NUMBER_OF_MINUTES){
         //add incoming customers to the queue and schedule next one
         if (currentTime == nextCustomer.getArrivalTime()){
            System.out.printf("%-3d\tcustomer %d arrived%n", currentTime, nextCustomer.getId());
            customerQueue.enqueue(nextCustomer);
            nextCustomer = new Customer(++nextCustomerId);

            //tracking the maximum number of customers in the queue
            if (customerQueue.size() > maxNumberOfCustomersInQueue)
               maxNumberOfCustomersInQueue = customerQueue.size();

            nextCustomer.setArrivalTime(currentTime + random.nextInt(arrivalRate) + 1);
            nextCustomer.setServiceTime(random.nextInt(serviceRate) + 1);
         }
         
         //dequeue next customer to be serviced whenever customer service is done
         if (currentTime >= currentCustomerServiceCompletionTime){
            if(currentTime == currentCustomerServiceCompletionTime){
               System.out.printf("%-3d\tFinished servicing customer %d%n", currentTime, currentCustomer.getId());
               totalCustomerServiced++;
            }
            
            if (!customerQueue.isEmpty()){
               currentCustomer = customerQueue.dequeue();          
               currentCustomerServiceCompletionTime = currentTime + currentCustomer.getServiceTime();
               System.out.printf("%-3d\tStarted servicing customer %d for %d min%n", 
                                 currentTime, currentCustomer.getId(), currentCustomer.getServiceTime());

               //tracking the longest wait time
               if (currentTime - currentCustomer.getArrivalTime() > longestWaitTime)  
                  longestWaitTime = currentTime - currentCustomer.getArrivalTime();
            }
         }
         currentTime++;
      }
      
      System.out.printf("%nTotal customer serviced > %d%n", totalCustomerServiced);
      System.out.printf("Max number of customers in the queue > %d%n", maxNumberOfCustomersInQueue);
      System.out.printf("Longest wait time > %d min%n", longestWaitTime);
   }
}
