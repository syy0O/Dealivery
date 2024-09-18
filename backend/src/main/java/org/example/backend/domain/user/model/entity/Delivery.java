package org.example.backend.domain.user.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.backend.domain.user.model.dto.DeliveryDto;
import org.example.backend.domain.user.model.dto.UserDto;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String name;

    private Boolean isDefault;

    private String address;

    private String addressDetail;

    private String postNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx")
    private User user;

    public DeliveryDto.DeliveryResponse toDeliveryResponse(){
        return DeliveryDto.DeliveryResponse.builder()
                .idx(this.idx)
                .isDefault(this.isDefault)
                .address(this.address)
                .addressDetail(this.addressDetail)
                .postNumber(this.postNumber)
                .name(this.name)
                .build();
    }
}
