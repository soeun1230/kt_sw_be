// package kt.be.model.members;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.Table;
// import lombok.AllArgsConstructor;
// import lombok.Builder;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;

// @Getter
// @Setter
// @Entity
// @AllArgsConstructor
// @NoArgsConstructor
// @Builder
// @Table(name="service")
// public class ServiceMember {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY) 
//     public Long serviceId;

//     @Column
//     public Integer status;

//     @JoinColumn()
//     public UserMember user;

//     @JoinColumn
//     public PetSitterMember petSitterMember;

//     @Column
//     public String date;

//     @Column
//     public String petKind;

//     @Column
//     public Long cost;
// }
