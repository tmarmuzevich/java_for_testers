package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private  String firstName;
  private  String lastName;
  private  String nickname;
  private  String company;
  private  String address;
  private  String home;
  private  String mobile;
  private  String work;
  private  String email;
  private  String byear;
  private String group;





  private String allPhones;

  public int getId() {
    return id;
  }

    public ContactData withId(int id){
      this.id = id;
      return this;
    }
  public ContactData withFirstName(String firstName){
    this.firstName = firstName;
    return this;
  }
  public ContactData withLastName(String lastName){
    this.lastName = lastName;
    return this;
  }

  public ContactData withNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public ContactData withCompany(String company) {
    this.company = company;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public ContactData withHome(String home) {
    this.home = home;
    return this;
  }

  public ContactData withWork(String work) {
    this.work = work;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withByear(String byear) {
    this.byear = byear;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }
  public String getLastName() {
    return lastName;
  }
  public String getNickname() {
    return nickname;
  }
  public String getCompany() {
    return company;
  }
  public String getAddress() {
    return address;
  }
  public String getMobile() {
    return mobile;
  }
  public String getEmail() {
    return email;
  }
  public String getByear() {
    return byear;
  }
  public String getGroup() {
    return group;
  }
  public String getHome() {
    return home;
  }
  public String getWork() {
    return work;
  }
  public String getAllPhones() {
    return allPhones;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(firstName, that.firstName) &&
            Objects.equals(lastName, that.lastName);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }


}