package project.user;

public interface Exit
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
}
