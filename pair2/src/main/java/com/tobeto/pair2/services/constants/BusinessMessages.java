package com.tobeto.pair2.services.constants;

public class BusinessMessages {

    public static class Car{
        public static final String SAME_PLATE_EXISTS = "Another car cannot be added with the same license plate.";

        public static final String MODEL_ID_MUST_EXISTS = "The ModelId must exist in the database.";

        public static final String COLOR_ID_MUST_EXISTS = "The ColorId must exist in the database.";

    }

    public static class Brand{
        public static final String SAME_BRAND_EXISTS = "This brand already exists in the database.";
    }

    public static class Color{
        public static final String SAME_COLOR_EXISTS = "This color already exists in the database.";

    }

    public static class Model{
        public static final String SAME_MODEL_NAME_EXISTS = "This model already exists in the database.";

        public static final String BRAND_ID_MUST_EXISTS = "The ModelId must exist in the database.";
    }

    public static class Rental{

        public static final String USER_ID_MUST_EXISTS = "The User must exist in the database.";
        public static final String CAR_ID_MUST_EXISTS = "The Car must exist in the database.";
        public static final String START_DATE_MUST_AFTER_TODAY = "The start date of the rental can not be earlier than today.";
        public static final String END_DATE_MUST_LATER_START_DATE = "The end date of the rental can not be later than the start date.";

        public static final String RENTAL_ID_MUST_EXISTS = "Rental must exists in the database.";

        public static String rentalDayLimit(){
            return "A car can be rented for " + BusinessRuleConstants.Rental.RENTAL_DAY_LIMIT + " days at most.";
        }
    }

    public static class User{
        public static final String SAME_EMAIL_EXISTS = "This email already exists in the database.";
    }



}
