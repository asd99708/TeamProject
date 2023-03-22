package com.wedogo.entity;

import com.wedogo.converter.ListStringConverter;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor(access = AccessLevel.PROTECTED)  // (1)
@Builder @Getter @ToString                                                                              // (1)
public class Account extends AuditingEntity {

    @Id @GeneratedValue
    @Column(name = "account_id")
    private Long id;                                                                                    // (2)

    @Column(unique = true)                                                                              // (3)
    private String email;

    @Column(unique = true)                                                                              // (3)
    private String nickname;

    private String password;

    private boolean isValid;

    private String emailToken;

    @Embedded                                                                                           // (4)
    private Profile profile;

    @Embedded                                                                                           // (4)
    private NotificationSetting notificationSetting;

    @Embeddable                                                                                         // (5)
    @NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder @Getter @ToString
    public static class Profile {
        private String bio;
        @Convert(converter = ListStringConverter.class)                                                 // (6)
        private List<String> url;
        private String job;
        private String location;
        private String company;
        @Lob @Basic(fetch = FetchType.EAGER)
        private String image;
    }

    @Embeddable                                                                                         // (5)
    @NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder @Getter @ToString
    public static class NotificationSetting {
        private boolean studyCreatedByEmail;
        private boolean studyCreatedByWeb;
        private boolean studyRegistrationResultByEmailByEmail;
        private boolean studyRegistrationResultByEmailByWeb;
        private boolean studyUpdatedByEmail;
        private boolean studyUpdatedByWeb;
    }
}