/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uop.Model;


public class Driver {
    private Long salary;
    private String membershipCard;
    private User user;
    public String getFullName()
    {
       
        
        return user.getName()+ " " +user.getSurname();
        
    }
    

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public String getMembershipCard() {
        return membershipCard;
    }

    public void setMembershipCard(String membershipCard) {
        this.membershipCard = membershipCard;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

  
}
