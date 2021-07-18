package com.cg.ovms.util;

public class RentalConstants {
	
	public static final String CUSTOMER_NOT_FOUND="Customer Not Found, Enter valid Id";
	public static final String CUSTOMER_UPDATED="Customer data is updated successfully";
	public static final String FIRST_NAME_CANNOT_BE_EMPTY="Firstname cannot be empty and can have only alphabets";
	public static final String LAST_NAME_CANNOT_BE_EMPTY="Lastname cannot be empty and can have only alphabets";
	public static final String MOBILE_CANNOT_BE_EMPTY="Mobile number cannot be empty and can only be a 10-digit number";
	public static final String EMAIL_CANNOT_BE_EMPTY="Email cannot be empty and should be in correct format as xxx@xxx.com";
	public static final String ADDRESS_CANNOT_BE_EMPTY="Address cannot be empty, Enter a valid address";
	public static final String CUSTOMER_ADDED="Customer added successfully";
	public static final String CUSTOMER_REMOVED="Customer removed successfully";
	
	public static final String BOOKING_NOT_FOUND="Booking not found, Enter valid Id";
	public static final String VEHICLE_NOT_FOUND="Vehicle not Found, Enter valid Id";
	public static final String BOOKING_REMOVED="Booking removed successfully";
	public static final String BOOKING_ADDED="New Booking added successfully";
	public static final String BOOKING_UPDATED=" Booking updated successfully";
	public static final String LOCAL_DATE="Add a valid LocalDate";
	public static final String INVALID_DATE_PATTERN="Date must follow the pattern yyyy-MM-dd";
	public static final String BOOKING_ALREADY_EXISTS=" This is already Booked";
	public static final String PAYMENT_ALREADY_EXISTS=" This Payment already exists";
	public static final String CUSTOMER_ALREADY_EXISTS=" Customer already exists with another booking";
	public static final String VEHICLE_ALREADY_EXISTS=" This vehicle is already booked";
	public static final String DISTANCE_CANNOT_BE_ZERO=" Distance should be greater than 0";
	public static final String COST_CANNOT_BE_ZERO=" Cost should be greater than 0";
	public static final String BOOKING_DATE_INVALID="Booking date invalid as it has ended";
	
    public static final String BOOKING_DESC_MSG="Description should have min 1 and max 30 chars";
	public static final String DRIVER_NOT_FOUND="Driver not found, Enter valid Id";
	public static final String DRIVER_ADDED="Driver added successfully";
	public static final String DRIVER_REMOVED="Driver Removed Successfully";
	public static final String DRIVER_UPDATED="Driver Updated Successfully";
	public static final String CHARGES_PER_DAY_NUM="ChargesPerDay must be greater than 0";
	public static final String INVALID_LICENSENO="License Number should be alphanumeric";
	

	public static final String VEHICLE_ADDED="Vehicle Added Successfully";
	public static final String VEHICLE_REMOVED="Vehicle Removed Successfully";
	public static final String VEHICLE_UPDATED="Vehicle Updated Successfully";
	public static final String INVALID_VEHICLE_NUMBER="Invalid vehicle number Pattern, it should be as XX00XX0000";
	public static final String INVALID_VEHICLE_TYPE="Invalid vehicle type, it can be only a car or bus";
	public static final String INVALID_VEHICLE_CATEGORY="Invalid vehicle category, it can be ac or nonac";
	public static final String INVALID_VEHICLE_DESCRIPTION="Vehicle description must be alphanumeric";
	public static final String INVALID_VEHICLE_LOCATION="Invalid vehicle location and must be of only alphabets";
	public static final String INVALID_VEHICLE_CAPACITY="Capacity should be greater than zero";
	public static final String INVALID_VEHICLE_FX_CH="Fixed charges should be greater than zero";
	public static final String INVALID_VEHICLE_CH_KM="Charges per km should be greater than zero";
	
	public static final String PAYMENT_NOT_FOUND="Payment Not Found, Enter valid Id";
	public static final String PAYMENT_ADDED="New payment added successfully";
	public static final String PAYMENT_UPDATED="Payment updated succesfully";
	public static final String PAYMENT_REMOVED="Payment removed succesfully";	
	public static final String PAYMENT_MODE_CANNOT_BE_EMPTY="Payment mode cannot be empty and can be online or offline";
	public static final String PAYMENT_DONE_FOR_BOOKING="Payment has been done for this BookingID";
	public static final String PAYMENT_STATUS_INVALID ="Payment status can be pending or done only";
	public static final String PAYMENT_TYPE_INVALID ="Available modes of payment are : cash, card,UPI";
	public static final String INVALID_ROLE ="Role can only be admin or user";
	public static final String INVALID_PASSWORD ="Password can be alphanumeric with special char: #,*,@ only";
	public static final String INVALID_USERNAME ="User name can only be alphanumeric, cannot have special chracters";
	public static final String USER_ADDED ="User successfully registered";
	public static final String USER_REMOVED ="User is deleted";

}