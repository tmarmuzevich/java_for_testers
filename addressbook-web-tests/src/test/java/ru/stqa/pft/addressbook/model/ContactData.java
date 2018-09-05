package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id;
  private final String firstName;
  private final String lastName;
  private final String nickname;
  private final String company;
  private final String address;
  private final String mobile;
  private final String email;
  private final String byear;
  private String group;

  public ContactData(int id, String firstName, String lastName, String nickname,
                     String company, String address, String mobile, String email,
                     String byear, String group) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.nickname = nickname;
    this.company = company;
    this.address = address;
    this.mobile = mobile;
    this.email = email;
    this.byear = byear;
    this.group = group;
  }

  public ContactData(String firstName, String lastName, String nickname,
                     String company, String address, String mobile, String email,
                     String byear, String group) {
    this.id = Integer.MAX_VALUE;
    this.firstName = firstName;
    this.lastName = lastName;
    this.nickname = nickname;
    this.company = company;
    this.address = address;
    this.mobile = mobile;
    this.email = email;
    this.byear = byear;
    this.group = group;
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


  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firstName, that.firstName) &&
            Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName);
  }

  public int getId() {
    return id;
  }
}