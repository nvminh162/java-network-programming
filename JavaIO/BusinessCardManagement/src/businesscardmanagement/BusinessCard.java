/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesscardmanagement;

import java.io.Serializable;

/**
 *
 * @author nvmin
 */
public class BusinessCard implements Serializable{
    private String name;
    private String address;
    private String phone;
    private String email;
    private String avatar;

    public BusinessCard() {}

    public BusinessCard(String name, String address, String phone, String email, String avatar) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "BusinessCard{" + "name=" + name + ", address=" + address + ", phone=" + phone + ", email=" + email + ", avatar=" + avatar + '}';
    }

}
