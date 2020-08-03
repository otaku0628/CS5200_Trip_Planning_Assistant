package model;

import java.time.Instant;

/**
 * CREATE TABLE IF NOT EXISTS `trip_planning_assistant`.`user` (
 *   `user_id` VARCHAR(255) NOT NULL,
 *   `email` VARCHAR(255) NOT NULL,
 *   `password` VARCHAR(255) NOT NULL,
 *   `name` VARCHAR(255) NOT NULL,
 *   `member_since` TIMESTAMP NOT NULL,
 *   `review_count` INT NOT NULL,
 *   `useful` INT NOT NULL,
 *   PRIMARY KEY (`user_id`))
 */
public class User {

  private String userId;
  private String email;
  private String password;
  private String name;
  private Instant memberSince;
  private Integer reviewCount;
  private Integer useful;

  public User(String userId) {
    this.userId = userId;
  }

  public User(String userId, String email, String password, String name, Instant memberSince, Integer reviewCount, Integer useful) {
    this.userId = userId;
    this.email = email;
    this.password = password;
    this.name = name;
    this.memberSince = memberSince;
    this.reviewCount = reviewCount;
    this.useful = useful;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Instant getMemberSince() {
    return memberSince;
  }

  public void setMemberSince(Instant memberSince) {
    this.memberSince = memberSince;
  }

  public Integer getReviewCount() {
    return reviewCount;
  }

  public void setReviewCount(Integer reviewCount) {
    this.reviewCount = reviewCount;
  }

  public Integer getUseful() {
    return useful;
  }

  public void setUseful(Integer useful) {
    this.useful = useful;
  }

  @Override
  public String toString() {
    return "User{" +
            "userId='" + userId + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", name='" + name + '\'' +
            ", memberSince=" + memberSince +
            ", reviewCount=" + reviewCount +
            ", useful=" + useful +
            '}';
  }
}
