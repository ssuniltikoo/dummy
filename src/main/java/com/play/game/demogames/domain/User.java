package com.play.game.demogames.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String email;

   public User(String name, String email){
        this.name=name;
        this.email=email;
    }

    public User(){

    }
}
