package com.dhotels.hotelsbackend.modules;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Table(name = "PACKAGE_TYPES")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class PackagingType {

    @Id
    @GeneratedValue
    private Integer id;
    private String type;
    @OneToMany (cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "type")
    private List<Package> packages;

    public PackagingType(String type, List<Package> packages) {
        this.type = type;
        this.packages = packages;
    }
}
