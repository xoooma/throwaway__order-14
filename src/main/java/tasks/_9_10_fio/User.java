package tasks._9_10_fio;

import java.io.Serializable;

public record User(String firstName, String middleName, String lastName, int birthYear, String birthLocation) implements Serializable {
    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthYear=" + birthYear +
                ", birthLocation='" + birthLocation + '\'' +
                '}';
    }
}
