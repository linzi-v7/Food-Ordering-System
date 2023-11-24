import project.user.User;

class Admin extends User
{

public String report;
public static int reportNumber;

       public Admin(String adminName,String adminPassword,String report)
       {
          super(adminName,adminPassword);
           reportNumber++;
           this.report=report;
       }

}
