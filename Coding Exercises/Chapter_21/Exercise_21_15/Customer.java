package Exercise_21_15;

public class Customer implements Comparable<Customer> {
    int id;
    int arrivalTime;
    int serviceTime;

    public Customer(int id){
        this.id = id;
    }

    public int getArrivalTime(){
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime){
        this.arrivalTime = arrivalTime;
    }

    public void setServiceTime(int serviceTime){
        this.serviceTime = serviceTime;
    }

    public int getServiceTime(){
        return serviceTime;
    }

    public String toString(){
        return "Customer " + this.id;
    }

    @Override
    public int compareTo(Customer customer) {
        return Integer.compare(this.id, customer.id);
    }
}
