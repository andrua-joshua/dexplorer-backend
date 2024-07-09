package com.dhotels.hotelsbackend.modules;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Table(name = "PACKAGES")
@NoArgsConstructor
@Setter
@Getter
public class Package {

    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "package-type-id", referencedColumnName = "id")
    @JsonIgnore
    private PackagingType type;
    private String title;
    private String description;
    @ManyToOne
    @JoinColumn(name = "room-id", referencedColumnName = "id")
    @JsonIgnore
    private Room room;

    public Package(PackagingType type, String title,
                   String description, Room room) {
        this.type = type;
        this.title = title;
        this.description = description;
        this.room = room;
    }
}
