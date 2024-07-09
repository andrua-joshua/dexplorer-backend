package com.dhotels.hotelsbackend.modules;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Data
@Table(name = "NOTIFICATIONS")
@NoArgsConstructor
@Setter
@Getter
public class Notification {

    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String message;
    @ManyToOne
    @JoinColumn(name = "owner-id", referencedColumnName = "id")
    @JsonIgnore
    private User owner;
    private Date createdAt;


    public Notification(String title, String message,
                        User owner, Date createdAt) {
        this.title = title;
        this.message = message;
        this.owner = owner;
        this.createdAt = createdAt;
    }
}
