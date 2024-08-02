package Primesniper.kafkaReactive.payload;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {

    private int id;
    private String firstname;
    private String lastname;
}