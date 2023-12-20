package project.user;

public interface InputChecks
{

    /**
     * checks if input equals to exit value to exit from function
     * @param input any input (e.g: email,name,password,etc..)
     * @return true if value equal to exit, the caller should handle what happens next
     */
    static boolean checkExit(String input)
    {
        return input.equalsIgnoreCase("exit"); //returns true if == exit
    }

    static boolean checkDelimiter(String input)
    {
        return input.contains(";");
    }

    static boolean validateEmail(String email)
    {
        // Basic email validation using a regular expression
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

     static boolean validatePhoneNumber(String phoneNumber) {
        // Check if the phone number contains only numbers
        if (!phoneNumber.matches("\\d+")) {
            return false;
        }

        // Check if the length is reasonable
        int minLength = 7;
        int maxLength = 15;
        int phoneNumberLength = phoneNumber.length();

        return phoneNumberLength >= minLength && phoneNumberLength <= maxLength;
    }


}
