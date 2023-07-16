package Exercise_21_15;

import com.deitel.datastructures.Queue;

import java.security.SecureRandom;

public class SupermarketSimulation {
    static SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        Queue<Customer> customers = new Queue<>();
        int queueSize = 0;
        int maxQueueSize = 0;
        int maxWaitTime = 0;

        int customerId = 1;
        Customer firstCustomer = new Customer(customerId);
        firstCustomer.setArrivalTime(arrivalInterval());
        System.out.printf("Customer 1 arrived at %d\n", firstCustomer.getArrivalTime());
        int serviceTime = serviceTime();
        firstCustomer.setServiceTime(firstCustomer.getArrivalTime() + serviceTime);
        System.out.printf("Servicing customer 1 for %d min\n", serviceTime);

        customerId++;
        Customer nextCustomer = new Customer(customerId);
        nextCustomer.setArrivalTime(firstCustomer.getArrivalTime() + arrivalInterval());
        Customer lastCustomer = firstCustomer;

        for(int t = firstCustomer.getArrivalTime() + 1; t <= 720; t++){

            System.out.printf("%d - ", t);
            customers.print();

            if(t == nextCustomer.getArrivalTime()) {
                System.out.printf("%s arrived at %d\n", nextCustomer, t);
                customers.enqueue(nextCustomer);
                queueSize++;
                maxQueueSize = queueSize > maxQueueSize ? queueSize : maxQueueSize;

                customerId++;
                nextCustomer = new Customer(customerId);
                nextCustomer.setArrivalTime(t + arrivalInterval());
            }

            if(t >= lastCustomer.getServiceTime()){
                System.out.printf("Service completed for %s at time %d\n", lastCustomer, lastCustomer.getServiceTime());

                if(!customers.isEmpty()) {
                    lastCustomer = customers.dequeue();
                    queueSize--;
                    serviceTime = serviceTime();
                    int lastCustomerWaitTime = t - lastCustomer.getArrivalTime();
                    maxWaitTime = lastCustomerWaitTime > maxWaitTime ? lastCustomerWaitTime: maxWaitTime;
                    lastCustomer.setServiceTime(t + serviceTime);
                    System.out.printf("Servicing %s for %d min\n", lastCustomer, serviceTime);
                }
            }
        }

        System.out.println();
        System.out.printf("Max Queue Size = %d\n", maxQueueSize);
        System.out.printf("Max Wait Time = %d\n", maxWaitTime);
    }

    private static int arrivalInterval(){
        return 1 + random.nextInt(4);
    }

    private static int serviceTime(){
        return 1 + random.nextInt(4);
    }
}
