package com.villacamp.hn.excellence.entity;

import com.villacamp.hn.excellence.utils.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "App_User", uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private LocalDateTime created = LocalDateTime.now();
    private LocalDateTime updated;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses;
    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        //ToDo
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //ToDo
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //ToDo
        return true;
    }

    @Override
    public boolean isEnabled() {
        //ToDo
        return true;
    }
}
