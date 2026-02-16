package com.sudheesh.springdemo.mvc;

import com.sudheesh.springdemo.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {

    private String firstName;

    @NotNull(message="is Required")
    @Size(min=1, message="is Required")
    private String lastName = "";

    @Min(value = 0, message = "must be grater than or equal to 0")
    @Max(value = 10, message = "must be less than or equal to 10")
    @NotNull(message="is Required")
    private Integer freePasses;
    
    @Pattern(regexp = "^[A-Za-z0-9]{5}", message = "Only 5 Character/digit allowed")
    private String postalCode;

    @CourseCode(value="LOL", message= "must Start with LOL")
    private String courseCode;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
