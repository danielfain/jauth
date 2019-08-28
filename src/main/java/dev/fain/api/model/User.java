package dev.fain.api.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(unique = true)
  private Long id;

  @Column(unique = true)
  private String email;

  @Column
  private String passwordHash;

  @Temporal(TemporalType.TIMESTAMP)
  @Column
  private Date createdAt;

  @PrePersist
  protected void onCreate() {
    createdAt = new Date();
  }

  // Used by JPA
  protected User() {}

  public User(String email, String passwordHash) {
    this.email = email;
    this.passwordHash = passwordHash;
  }

  @Override
  public String toString() {
    return String.format(
      "User[id=%d, email='%s', passwordHash='%s', createdAt='%tc']",
      id, email, passwordHash, createdAt);
  }

  public String getEmail() {
    return email;
  }

  public Long getId() {
    return id;
  }

  public String getPasswordHash() {
    return passwordHash;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

}