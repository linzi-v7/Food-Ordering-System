package project.main;

public class Role
{
    /*
        ROLES:
        NONE        |   0
        ADMIN       |   1
        RESTAURANT  |   2
        USER        |   3
     */

    public static final int ADMIN_IDENTIFIER = 1;
    public static final int RESTAURANT_IDENTIFIER = 2;
    public static final int USER_IDENTIFIER = 3;
    private static int roleIdentifier = 0;

    public static int getRoleIdentifier() {
        return roleIdentifier;
    }

    public static void setRoleIdentifier(int roleIdentifier) {
        Role.roleIdentifier = roleIdentifier;
    }
}
