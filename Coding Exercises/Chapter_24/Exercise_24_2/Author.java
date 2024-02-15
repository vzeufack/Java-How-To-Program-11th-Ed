public class Author {
    private int authorID;
    private String firstName;
    private String lastName;

    // constructor
    public Author() {}

    // constructor
    public Author(int authorID, String firstName, String lastName) {
        this.authorID = authorID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setAuthorID(int addressID) {this.authorID = authorID;}

    // returns the addressID
    public int getAuthorID() {return authorID;}

    // sets the firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // returns the first name
    public String getFirstName() {return firstName;}

    // sets the lastName
    public void setLastName(String lastName) {this.lastName = lastName;}

    // returns the last name
    public String getLastName() {return lastName;}

    // returns the string representation of the Author's name
    @Override
    public String toString()
    {return getAuthorID() + " - " + getLastName() + ", " + getFirstName();}
}


