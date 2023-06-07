package entity;

import base.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import javax.security.auth.callback.PasswordCallback;
import java.net.PasswordAuthentication;
import java.security.InvalidParameterException;
import java.security.KeyStore;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Users extends BaseEntity<Long> {
    private String firstname;
    private String lastname;
    private LocalDate dateOfBirth;
    private String username;
    private String password;



    public void setPassword(String password) {

        if (password.length() >= 8 && !password.contains("@") && !password.contains("#")
                && !password.contains("!") && !password.contains("~")
                && !password.contains("$") && !password.contains("%")
                && !password.contains("^") && !password.contains("&")
                && !password.contains("*") && !password.contains("(")
                && !password.contains(")") && !password.contains("-")
                && !password.contains("+") && !password.contains("/")
                && !password.contains(":") && !password.contains(".")
                && !password.contains(",") && !password.contains("<")
                && !password.contains(">") && !password.contains("?")
                && !password.contains(" ") && !password.contains("|") ) {
            this.password = password;
        }
        else {
            System.out.println(("just use A-Z or a-z or numbers and password length must be more than 8 characters"));
        }

    }
}
