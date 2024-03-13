package com.jpa.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@AttributeOverrides(
//        @AttributeOverride(
//                name = "g_name",
//                column = @Column(name = "name")
//        )
//)
public class Guardian {

    private String name;
    private String email;
    private String mobile;
}
