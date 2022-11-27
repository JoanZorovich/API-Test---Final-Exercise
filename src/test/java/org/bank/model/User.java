package org.bank.model;

/**
 * Class that allows to create and manage the user object
 */
public class User {

    private int id;
    private String name;
    private String lastName;
    private int accountNumber;
    private double amount;
    private String transactionType;
    private String email;
    private boolean active;
    private String country;
    private String telephone;

    public User(){}

    /**
     * Constructor method for bank user object
     * @author joan.zorovich
     *
     * @param name: user name
     * @param lastName: user Last name
     * @param accountNumber: bank account number
     * @param amount: amount bank user
     * @param transactionType: "invoice","withdrawal","deposit","payment"
     * @param email: user email
     * @param active: true or false
     * @param country: user country
     * @param telephone: user phone number
     */

    public User(String name, String lastName, int accountNumber, double amount, String transactionType,
                String email, boolean active, String country, String telephone) {
        this.name = name;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.transactionType = transactionType;
        this.email = email;
        this.active = active;
        this.country = country;
        this.telephone = telephone;
    }


    /**
     * Getters
     *
     */

    /**
     * gets the user id, automatically created on the endpoint
     * @author joan.zorovich
     * @return id unique number
     */

    public int getId() {return id;}

    /**
     * Allow getting user name
     * @author joan.zorovich
     * @return user name
     */
    public String getName() {
        return name;
    }

    /**
     * Allow getting user Last name
     * @author joan.zorovich
     * @return user Last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Allow getting user account number
     * @author joan.zorovich
     * @return user account number
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * Allow getting amount bank
     * @author joan.zorovich
     * @return amount bank
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Allow getting the Transaction Type
     * @author joan.zorovich
     * @return Transaction Type
     */
    public String getTransactionType() {
        return transactionType;
    }

    /**
     * Allow getting user email
     * @author joan.zorovich
     * @return user email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Allow getting account status
     * @author joan.zorovich
     * @return true or false
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Allow getting user country
     * @author joan.zorovich
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Allow getting user telephone
     * @author joan.zorovich
     * @return telephone number
     */
    public String getTelephone() {
        return telephone;
    }




    /**
     * Setters
     */

    /**
     *Allows you to update user id
     * @author joan.zorovich
     * @param id: user id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *Allows you to update user name
     * @author joan.zorovich
     * @param name: user name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *Allows you to update user last name
     * @author joan.zorovich
     * @param lastName:user last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *Allows you to update user account number
     * @author joan.zorovich
     * @param accountNumber: user account number
     */
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     *Allows you to update user amount bank
     * @author joan.zorovich
     * @param amount: amount bank
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     *Allows you to update transaction type
     * @author joan.zorovich
     * @param transactionType: "invoice","withdrawal","deposit","payment"
     */
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    /**
     *Allows you to update use email
     * @author joan.zorovich
     * @param email: user email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *Allows you to update active status
     * @author joan.zorovich
     * @param active: true or false
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     *Allows you to update user country
     * @author joan.zorovich
     * @param country: user country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     *Allows you to update user phone number
     * @author joan.zorovich
     * @param telephone: user phone number
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    /**
     * This method is modified in order to be able to use the index of with the user object
     * @author joan.zorovich
     * @return true if the user id is equals to the current id
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Float.compare(user.id, id) == 0;
    }

}
